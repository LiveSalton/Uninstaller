package com.salton123.uninstaller.fm;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.salton123.uninstaller.ActionCode;
import com.salton123.uninstaller.PreloadCore;
import com.salton123.uninstaller.R;
import com.salton123.uninstaller.adapter.SpeedUpAdapter;
import com.salton123.uninstaller.entity.AppEntity;
import com.salton123.uninstaller.util.Utils;
import com.salton123.log.XLog;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.BackupActivity;

import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 11:42 AM
 * ModifyTime: 11:42 AM
 * Description:
 */
public class SpeedUpListFragment extends BaseFragment implements SearchView.OnQueryTextListener {
    private Button btnDelete, btnBackup;
    private SearchView searchView;
    // private CheckBox mCheckBox;
    public static String KEY = "";//全局搜索的关键
    private List<AppEntity> allEntity = new ArrayList<>();
    private LinearLayout rootView;

    public static SpeedUpListFragment newInstance() {
        return new SpeedUpListFragment();
    }

    private ListView appListView;
    private SpeedUpAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_installed_app, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appListView = view.findViewById(R.id.appListView);
        // mCheckBox = view.findViewById(R.id.checkbox_select_all);
        btnDelete = view.findViewById(R.id.btn_left);
        btnBackup = view.findViewById(R.id.btn_right);
        Button btnBackupManager = view.findViewById(R.id.btn_backup_manager);
        searchView = view.findViewById(R.id.searchView);
        rootView = view.findViewById(R.id.rootView);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAction(ActionCode.CODE_DELETE);
            }
        });
        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAction(ActionCode.CODE_BACKUP);
            }
        });
        
        // 备份管理按钮点击事件
        btnBackupManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackupManager();
            }
        });
        // mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        //     @Override
        //     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //         if (isChecked) {
        //             onAction(ActionCode.CODE_CHECK);
        //         } else {
        //             onAction(ActionCode.CODE_UNCHECK);
        //         }
        //     }
        // });
        searchView.onActionViewExpanded();
        Class<?> c = searchView.getClass();
        try {
            Field f = c.getDeclaredField("mSearchPlate");//通过反射，获得类对象的一个属性对象
            f.setAccessible(true);//设置此私有属性是可访问的
            View v = (View) f.get(searchView);//获得属性的值
            v.setBackgroundColor(Color.WHITE);//设置此view的背景
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchView.setOnQueryTextListener(this);//关联提交事件
        loadData();
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(mActivity);
        appListView.setAdapter(mAdapter);
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppEntity entity = mAdapter.getItem(position);
                // 切换选中状态，而不是直接卸载
                toggleAppSelection(entity);
                // 刷新视图以更新复选框状态
                mAdapter.notifyDataSetChanged();
            }
        });
        
        // 异步加载应用列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                allEntity.clear();
                allEntity.addAll(PreloadCore.INSTANCE.preloadAppList());
                
                // 在主线程更新UI
                if (mActivity != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateSort(allEntity);
                            updateButtonStates(); // 初始化按钮状态
                            XLog.i("SpeedUpListFragment", "Loaded " + allEntity.size() + " apps");
                        }
                    });
                }
            }
        }).start();
    }

    /**
     * 切换应用的选中状态
     */
    private void toggleAppSelection(AppEntity entity) {
        if (entity != null) {
            entity.isChecked = !entity.isChecked;
            String status = entity.isChecked ? "选中" : "取消选中";
            XLog.i("SpeedUpListFragment", status + "应用: " + entity.mAppName);
            
            // 显示简短的Toast提示
            if (mActivity != null) {
                Toast.makeText(mActivity, status + ": " + entity.mAppName, Toast.LENGTH_SHORT).show();
            }
            
            // 更新按钮状态
            updateButtonStates();
        }
    }

    /**
     * 更新按钮状态和文本
     */
    private void updateButtonStates() {
        if (mAdapter == null) return;
        
        int selectedCount = getSelectedApps().size();
        int totalCount = mAdapter.getCount();
        
        // 更新按钮文本显示选中数量
        if (btnDelete != null) {
            if (selectedCount > 0) {
                btnDelete.setText("删除(" + selectedCount + ")");
                btnDelete.setEnabled(true);
            } else {
                btnDelete.setText("删除");
                btnDelete.setEnabled(false);
            }
        }
        
        if (btnBackup != null) {
            if (selectedCount > 0) {
                btnBackup.setText("备份(" + selectedCount + ")");
                btnBackup.setEnabled(true);
            } else {
                btnBackup.setText("备份");
                btnBackup.setEnabled(false);
            }
        }
    }

    /**
     * 卸载单个应用
     */
    private void uninstallApp(AppEntity entity) {
        if (entity == null || entity.appInfo == null) {
            return;
        }
        
        try {
            Uri packageURI = Uri.parse("package:" + entity.appInfo.packageName);
            Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivityForResult(intent, 0x101);
            XLog.i("SpeedUpListFragment", "Uninstalling: " + entity.mAppName);
        } catch (Exception e) {
            XLog.e("SpeedUpListFragment", "Error uninstalling app: " + e.getMessage());
        }
    }

    /**
     * 开始备份任务
     */
    private void startBackupTask() {
        List<AppEntity> selectedApps = getSelectedApps();
        if (selectedApps.isEmpty()) {
            XLog.w("SpeedUpListFragment", "No apps selected for backup");
            if (mActivity != null) {
                Toast.makeText(mActivity, "请先选择要备份的应用", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        XLog.i("SpeedUpListFragment", "Starting backup for " + selectedApps.size() + " apps");
        
        if (mActivity != null) {
            Toast.makeText(mActivity, "开始备份 " + selectedApps.size() + " 个应用...", Toast.LENGTH_LONG).show();
        }
        
        BackupManager.toBackup(selectedApps, new BackupManager.IBackupProgress() {
            @Override
            public void onProgress(int current, int total, boolean isSuccess, String appName) {
                if (mActivity != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String status = isSuccess ? "成功" : "失败";
                            XLog.i("SpeedUpListFragment", 
                                "备份进度: " + current + "/" + total + " - " + appName + " " + status);
                        }
                    });
                }
            }

            @Override
            public void onBackupComplete(boolean success, String message) {
                if (mActivity != null) {
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            XLog.i("SpeedUpListFragment", "备份完成: " + message);
                            Toast.makeText(mActivity, message, Toast.LENGTH_LONG).show();
                            
                            // 备份完成后取消选中状态
                            onCheckAll(false);
                        }
                    });
                }
            }
        });
    }

    /**
     * 获取选中的应用列表
     */
    private List<AppEntity> getSelectedApps() {
        List<AppEntity> selectedApps = new ArrayList<>();
        if (mAdapter != null) {
            for (AppEntity app : mAdapter.getList()) {
                if (app.isChecked) {
                    selectedApps.add(app);
                }
            }
        }
        return selectedApps;
    }

    /**
     * 批量卸载选中的应用
     */
    private void deleteSelectedApps() {
        List<AppEntity> selectedApps = getSelectedApps();
        
        if (selectedApps.isEmpty()) {
            XLog.w("SpeedUpListFragment", "No apps selected for deletion");
            if (mActivity != null) {
                Toast.makeText(mActivity, "请先选择要删除的应用", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        
        if (mActivity != null) {
            Toast.makeText(mActivity, "开始卸载 " + selectedApps.size() + " 个应用", Toast.LENGTH_LONG).show();
        }
        
        XLog.i("SpeedUpListFragment", "Deleting " + selectedApps.size() + " apps");
        for (AppEntity app : selectedApps) {
            uninstallApp(app);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0x101) {
            // 刷新列表
            allEntity.clear();
            allEntity.addAll(PreloadCore.INSTANCE.preloadAppList());
            updateSort(allEntity);//重新排序事件
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void onAction(Integer actionCode) {
        if (actionCode == ActionCode.CODE_CHECK) {
            // 全选
            onCheckAll(true);
        } else if (actionCode == ActionCode.CODE_UNCHECK) {
            // 取消全选
            onCheckAll(false);
        } else if (actionCode == ActionCode.CODE_BACKUP) {
            // 备份选中的应用
            startBackupTask();
        } else if (actionCode == ActionCode.CODE_DELETE) {
            // 批量删除
            deleteSelectedApps();
        }
    }

    /**
     * 全选/取消全选
     */
    private void onCheckAll(boolean checked) {
        if (mAdapter != null) {
            for (AppEntity app : mAdapter.getList()) {
                app.isChecked = checked;
            }
            mAdapter.notifyDataSetChanged();
            updateButtonStates();
            
            String message = checked ? "已全选 " + mAdapter.getCount() + " 个应用" : "已取消全选";
            XLog.i("SpeedUpListFragment", message);
            
            if (mActivity != null) {
                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    int asc = 1; // 可以帮助在正序和倒序之间进行切换
    // 应用名比较器
    Comparator<AppEntity> nameComparator = new Comparator<AppEntity>() {
        @Override
        public int compare(AppEntity lhs, AppEntity rhs) {
            // 为了适应汉字的比较
            Collator c = Collator.getInstance(Locale.CHINA);
            return (asc == 1) ? c.compare(lhs.mAppName, rhs.mAppName)
                    : c.compare(rhs.mAppName, lhs.mAppName);
        }
    };

    // 带排序的更新
    private void updateSort(List<AppEntity> entities) {
        // Collections.sort(entities, nameComparator);// 这里才是排序的操作
        mAdapter.addAll(entities);
        mAdapter.notifyDataSetChanged();// 刷新视图
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        Utils.KEY = query.trim();
        updateSort(Utils.getSearchResult(mAdapter.getList(), query));//重新排序事件
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Utils.KEY = newText.trim();
        updateSort(Utils.getSearchResult(allEntity, newText.trim()));//重新排序事件
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        rootView.setFocusable(true);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
    }

    /**
     * 打开备份管理界面
     */
    private void openBackupManager() {
        Intent intent = new Intent(mActivity, BackupActivity.class);
        startActivity(intent);
    }
}
