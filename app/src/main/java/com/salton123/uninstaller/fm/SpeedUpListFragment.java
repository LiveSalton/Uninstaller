package com.salton123.uninstaller.fm;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.salton123.uninstaller.ActionCode;
import com.salton123.uninstaller.PreloadCore;
import com.salton123.uninstaller.R;
import com.salton123.uninstaller.adapter.SpeedUpAdapter;
import com.salton123.uninstaller.entity.AppEntity;
import com.salton123.uninstaller.util.Utils;
import com.salton123.log.XLog;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.BackupActivity;
import com.salton123.uninstaller.util.SettingsManager;

import java.io.File;
import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
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
    private CheckBox checkboxSelectAll;
    public static String KEY = "";//全局搜索的关键
    private List<AppEntity> allEntity = new ArrayList<>();
    private LinearLayout rootView;
    private TextView titleText;
    
    // 统计信息显示
    private TextView summaryTotalText;
    private TextView summarySelectedText;
    
    // 设置相关
    private SettingsManager settingsManager;
    private PopupWindow currentPopupWindow; // 跟踪当前的PopupWindow

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
        
        // 初始化设置管理器
        settingsManager = new SettingsManager(getContext());
        appListView = view.findViewById(R.id.appListView);
        // mCheckBox = view.findViewById(R.id.checkbox_select_all);
        btnDelete = view.findViewById(R.id.btn_left);
        btnBackup = view.findViewById(R.id.btn_right);
        Button btnBackupManager = view.findViewById(R.id.btn_backup_manager);
        searchView = view.findViewById(R.id.searchView);
        rootView = view.findViewById(R.id.rootView);
        titleText = view.findViewById(R.id.title_text);
        
        // 初始化统计信息显示控件
        summaryTotalText = view.findViewById(R.id.summary_total);
        summarySelectedText = view.findViewById(R.id.summary_selected);
        
        // 初始化全选复选框
        checkboxSelectAll = view.findViewById(R.id.checkbox_select_all);
        
        // 设置按钮
        View btnSettings = view.findViewById(R.id.btn_settings);
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
        
        // 设置按钮点击事件
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSettingsDialog();
            }
        });
        
        // 设置全选复选框监听器
        checkboxSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckAll(isChecked);
            }
        });
        // 初始化搜索框
        initSearchView();
        
        // 应用初始设置
        applySettings();
        
        loadData();
    }
    
    /**
     * 初始化搜索框
     */
    private void initSearchView() {
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
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(mActivity);
        
        // 设置初始显示选项
        if (settingsManager != null) {
            mAdapter.setDisplayOptions(
                settingsManager.isShowTime(),
                settingsManager.isShowFilename(),
                settingsManager.isShowPath()
            );
            XLog.i("SpeedUpListFragment", "Set initial display options on adapter");
        }
        
        appListView.setAdapter(mAdapter);
        
        // 设置选择状态变化监听器
        mAdapter.setOnSelectionChangeListener(new SpeedUpAdapter.OnSelectionChangeListener() {
            @Override
            public void onSelectionChanged() {
                updateButtonStates();
            }
        });
        
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
            
            // 手动更新按钮状态（因为这个操作不会触发适配器的监听器）
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
        
        // 保持标题为固定文本
        if (titleText != null) {
            titleText.setText("应用管理");
        }
        
        // 更新统计信息显示
        updateSummaryInfo(totalCount, selectedCount);
        
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
     * 更新统计信息显示
     */
    private void updateSummaryInfo(int totalCount, int selectedCount) {
        XLog.i("SpeedUpListFragment", "updateSummaryInfo - 总数: " + totalCount + ", 已选择: " + selectedCount);
        
        if (summaryTotalText != null) {
            summaryTotalText.setText("总数: " + totalCount + "个");
        } else {
            XLog.w("SpeedUpListFragment", "summaryTotalText is null");
        }
        
        if (summarySelectedText != null) {
            if (selectedCount > 0) {
                summarySelectedText.setText("已选择: " + selectedCount + "个");
                summarySelectedText.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                summarySelectedText.setText("已选择: 0个");
                summarySelectedText.setTextColor(getResources().getColor(R.color.text_secondary));
            }
        } else {
            XLog.w("SpeedUpListFragment", "summarySelectedText is null");
        }
        
        // 更新全选复选框状态
        if (checkboxSelectAll != null) {
            // 暂时移除监听器以避免递归调用
            checkboxSelectAll.setOnCheckedChangeListener(null);
            
            if (totalCount > 0 && selectedCount == totalCount) {
                // 全部选中
                checkboxSelectAll.setChecked(true);
            } else {
                // 部分选中或未选中
                checkboxSelectAll.setChecked(false);
            }
            
            // 重新设置监听器
            checkboxSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    onCheckAll(isChecked);
                }
            });
        }
        
        XLog.i("SpeedUpListFragment", "统计信息更新完成");
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
                            Toast.makeText(mActivity, getString(R.string.start_backup_apps, selectedApps.size()), Toast.LENGTH_LONG).show();
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
                    XLog.d("SpeedUpListFragment", "选中的应用: " + app.mAppName);
                }
            }
        }
        XLog.i("SpeedUpListFragment", "总共选中 " + selectedApps.size() + " 个应用");
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
                            Toast.makeText(mActivity, getString(R.string.start_uninstall_apps, selectedApps.size()), Toast.LENGTH_LONG).show();
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
            
            String message = checked ? getString(R.string.select_all_apps, mAdapter.getCount()) : getString(R.string.unselect_all_apps);
            XLog.i("SpeedUpListFragment", message);
            
            if (mActivity != null) {
                Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        // 清理PopupWindow，防止内存泄漏
        if (currentPopupWindow != null && currentPopupWindow.isShowing()) {
            currentPopupWindow.dismiss();
        }
        currentPopupWindow = null;
        
        super.onDestroy();
        XLog.i("SpeedUpListFragment", "Fragment destroyed, PopupWindow cleaned up");
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
        updateButtonStates(); // 更新统计信息和按钮状态
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
    
    // ==================== 设置相关方法 ====================
    
    /**
     * 显示设置弹窗
     */
    private void showSettingsDialog() {
        if (getContext() == null || getActivity() == null) return;
        
        // 如果已有PopupWindow在显示，先关闭它
        if (currentPopupWindow != null && currentPopupWindow.isShowing()) {
            currentPopupWindow.dismiss();
            currentPopupWindow = null;
            XLog.i("SpeedUpListFragment", "Dismissed existing popup window");
            return; // 如果正在显示，点击就关闭，不创建新的
        }
        
        View popupView = LayoutInflater.from(getContext()).inflate(R.layout.popup_settings, null);
        
        // 获取屏幕宽度
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        
        // 创建 PopupWindow，宽度为屏幕的2/5
        int popupWidth = screenWidth * 2 / 5;
        currentPopupWindow = new PopupWindow(popupView, popupWidth, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        
        // 设置背景和动画
        currentPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.dialog_holo_light_frame));
        currentPopupWindow.setOutsideTouchable(true);
        currentPopupWindow.setFocusable(true);
        
        // 设置关闭监听器，清理引用
        currentPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                currentPopupWindow = null;
                XLog.i("SpeedUpListFragment", "PopupWindow dismissed and reference cleared");
            }
        });
        
        // 获取控件
        CheckBox cbShowTime = popupView.findViewById(R.id.cb_show_time);
        CheckBox cbShowFilename = popupView.findViewById(R.id.cb_show_filename);
        CheckBox cbShowPath = popupView.findViewById(R.id.cb_show_path);
        CheckBox cbShowSearch = popupView.findViewById(R.id.cb_show_search);
        RadioGroup rgSortOptions = popupView.findViewById(R.id.rg_sort_options);
        Button btnShareAppDetails = popupView.findViewById(R.id.btn_share_app_details);

        
        // 设置当前状态
        cbShowTime.setChecked(settingsManager.isShowTime());
        cbShowFilename.setChecked(settingsManager.isShowFilename());
        cbShowPath.setChecked(settingsManager.isShowPath());
        cbShowSearch.setChecked(settingsManager.isShowSearch());
        
        // 设置排序选项
        SettingsManager.SortType currentSort = settingsManager.getSortType();
        switch (currentSort) {
            case NAME:
                rgSortOptions.check(R.id.rb_sort_name);
                break;
            case SIZE:
                rgSortOptions.check(R.id.rb_sort_size);
                break;
            case TIME:
                rgSortOptions.check(R.id.rb_sort_time);
                break;
            case PATH:
                rgSortOptions.check(R.id.rb_sort_path);
                break;
        }
        
        // 设置即时生效的监听器
        cbShowTime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowTime(isChecked);
            applySettings();
            XLog.i("SpeedUpListFragment", "Show time: " + isChecked);
        });
        
        cbShowFilename.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowFilename(isChecked);
            applySettings();
            XLog.i("SpeedUpListFragment", "Show filename: " + isChecked);
        });
        
        cbShowPath.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowPath(isChecked);
            applySettings();
            XLog.i("SpeedUpListFragment", "Show path: " + isChecked);
        });
        
        cbShowSearch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            settingsManager.setShowSearch(isChecked);
            applySettings();
            XLog.i("SpeedUpListFragment", "Show search: " + isChecked);
        });
        
        // 排序选项即时生效监听器
        rgSortOptions.setOnCheckedChangeListener((group, checkedId) -> {
            SettingsManager.SortType newSortType = SettingsManager.SortType.NAME;
            if (checkedId == R.id.rb_sort_name) {
                newSortType = SettingsManager.SortType.NAME;
            } else if (checkedId == R.id.rb_sort_size) {
                newSortType = SettingsManager.SortType.SIZE;
            } else if (checkedId == R.id.rb_sort_time) {
                newSortType = SettingsManager.SortType.TIME;
            } else if (checkedId == R.id.rb_sort_path) {
                newSortType = SettingsManager.SortType.PATH;
            }
            settingsManager.setSortType(newSortType);
            applySettings();
            XLog.i("SpeedUpListFragment", "Sort type changed: " + newSortType.name());
        });
        
        // 分享应用APK按钮点击事件
        btnShareAppDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareSelectedAppApk();
                if (currentPopupWindow != null) {
                    currentPopupWindow.dismiss();
                }
            }
        });
        
        // 找到设置按钮并在其下方显示弹窗
        View btnSettings = getView().findViewById(R.id.btn_settings);
        if (btnSettings != null) {
            // 直接使用 showAsDropDown，自动计算最佳位置
            int xOffset = btnSettings.getWidth() - popupWidth; // 右对齐
            int yOffset = 0; // 紧贴按钮下方
            
            currentPopupWindow.showAsDropDown(btnSettings, xOffset, yOffset);
            XLog.i("SpeedUpListFragment", "PopupWindow shown at position: " + xOffset + ", " + yOffset);
        }
    }
    
    /**
     * 应用设置到界面
     */
    private void applySettings() {
        if (settingsManager == null) return;
        
        XLog.i("SpeedUpListFragment", "Applying settings - Time: " + settingsManager.isShowTime() + 
            ", Filename: " + settingsManager.isShowFilename() + ", Path: " + settingsManager.isShowPath() + 
            ", Search: " + settingsManager.isShowSearch());
        
        // 控制搜索框的显示
        if (searchView != null) {
            int visibility = settingsManager.isShowSearch() ? View.VISIBLE : View.GONE;
            searchView.setVisibility(visibility);
        }
        
        // 通知适配器更新显示选项（只更新显示选项，不重新排序）
        if (mAdapter != null) {
            mAdapter.setDisplayOptions(
                settingsManager.isShowTime(),
                settingsManager.isShowFilename(),
                settingsManager.isShowPath()
            );
            // 只刷新适配器显示，不重新排序
            mAdapter.notifyDataSetChanged();
            XLog.i("SpeedUpListFragment", "Adapter display options updated");
        }
    }
    
    /**
     * 根据设置进行排序并更新列表
     */
    private void updateSortWithSettings(List<AppEntity> entities) {
        if (entities == null || entities.isEmpty()) return;
        
        SettingsManager.SortType sortType = settingsManager.getSortType();
        
        switch (sortType) {
            case NAME:
                Collections.sort(entities, nameComparator);
                break;
            case SIZE:
                Collections.sort(entities, sizeComparator);
                break;
            case TIME:
                Collections.sort(entities, timeComparator);
                break;
            case PATH:
                Collections.sort(entities, pathComparator);
                break;
        }
        
        mAdapter.addAll(entities);
        mAdapter.notifyDataSetChanged();
        
        XLog.i("SpeedUpListFragment", "Sorted by " + sortType.name());
    }
    
    /**
     * 分享选中应用的APK文件
     */
    private void shareSelectedAppApk() {
        List<AppEntity> selectedApps = getSelectedApps();
        
        XLog.i("SpeedUpListFragment", "Selected apps count: " + selectedApps.size());
        
        if (selectedApps.isEmpty()) {
            Toast.makeText(getContext(), getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (selectedApps.size() > 1) {
            Toast.makeText(getContext(), getString(R.string.share_single_app_only), Toast.LENGTH_SHORT).show();
            return;
        }
        
        AppEntity app = selectedApps.get(0);
        String packageName = app.appInfo.packageName;
        String appName = app.mAppName;
        String apkPath = app.appInfo.applicationInfo.sourceDir;
        
        XLog.i("SpeedUpListFragment", "Sharing app: " + appName + " (" + packageName + ")");
        XLog.i("SpeedUpListFragment", "APK path: " + apkPath);
        
        File apkFile = new File(apkPath);
        
        if (!apkFile.exists()) {
            Toast.makeText(getContext(), getString(R.string.apk_file_not_found) + ": " + apkPath, Toast.LENGTH_LONG).show();
            XLog.e("SpeedUpListFragment", "APK file not found: " + apkPath);
            return;
        }
        
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/vnd.android.package-archive");
            
            Uri apkUri;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // Android 7.0+ 需要使用 FileProvider
                apkUri = FileProvider.getUriForFile(getContext(), 
                    getContext().getPackageName() + ".fileprovider", apkFile);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                apkUri = Uri.fromFile(apkFile);
            }
            
            shareIntent.putExtra(Intent.EXTRA_STREAM, apkUri);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, appName + ".apk");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "分享应用：" + appName + 
                " (包名：" + packageName + ", 版本：" + app.mVersionName + ")");
            
            startActivity(Intent.createChooser(shareIntent, "分享 " + appName));
            XLog.i("SpeedUpListFragment", "Successfully started sharing APK for: " + appName);
            
            Toast.makeText(getContext(), getString(R.string.sharing_app, appName), Toast.LENGTH_SHORT).show();
            
        } catch (Exception e) {
            XLog.e("SpeedUpListFragment", "Error sharing APK: " + e.getMessage());
            Toast.makeText(getContext(), getString(R.string.share_failed) + "：" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    
    /**
     * 分享应用详情
     */
    private void shareAppDetails() {
        List<AppEntity> selectedApps = getSelectedApps();
        
        if (selectedApps.isEmpty()) {
            Toast.makeText(getContext(), getString(R.string.select_apps_first), Toast.LENGTH_SHORT).show();
            return;
        }
        
        StringBuilder shareText = new StringBuilder();
        shareText.append("应用详情列表：\n\n");
        
        for (AppEntity app : selectedApps) {
            shareText.append("应用名称：").append(app.mAppName).append("\n");
            shareText.append("包名：").append(app.appInfo.packageName).append("\n");
            shareText.append("版本：").append(app.mVersionName).append("\n");
            
            if (settingsManager.isShowTime()) {
                shareText.append("安装时间：").append(app.getInstallTimeString()).append("\n");
            }
            
            if (settingsManager.isShowPath()) {
                shareText.append("路径：").append(app.appInfo.applicationInfo.sourceDir).append("\n");
            }
            
            shareText.append("大小：").append(app.getSizeString()).append("\n");
            shareText.append("\n");
        }
        
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText.toString());
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "应用详情分享");
        
        try {
            startActivity(Intent.createChooser(shareIntent, "分享应用详情"));
            XLog.i("SpeedUpListFragment", "Shared details for " + selectedApps.size() + " apps");
        } catch (Exception e) {
            XLog.e("SpeedUpListFragment", "Error sharing app details: " + e.getMessage());
            Toast.makeText(getContext(), getString(R.string.share_failed), Toast.LENGTH_SHORT).show();
        }
    }
    
    // ==================== 排序比较器 ====================
    
    // 大小比较器
    private final Comparator<AppEntity> sizeComparator = new Comparator<AppEntity>() {
        @Override
        public int compare(AppEntity lhs, AppEntity rhs) {
            long leftSize = lhs.getSize();
            long rightSize = rhs.getSize();
            return (asc == 1) ? Long.compare(leftSize, rightSize) : Long.compare(rightSize, leftSize);
        }
    };
    
    // 时间比较器
    private final Comparator<AppEntity> timeComparator = new Comparator<AppEntity>() {
        @Override
        public int compare(AppEntity lhs, AppEntity rhs) {
            long leftTime = lhs.getInstallTime();
            long rightTime = rhs.getInstallTime();
            return (asc == 1) ? Long.compare(leftTime, rightTime) : Long.compare(rightTime, leftTime);
        }
    };
    
    // 路径比较器
    private final Comparator<AppEntity> pathComparator = new Comparator<AppEntity>() {
        @Override
        public int compare(AppEntity lhs, AppEntity rhs) {
            String leftPath = lhs.appInfo.applicationInfo.sourceDir;
            String rightPath = rhs.appInfo.applicationInfo.sourceDir;
            return (asc == 1) ? leftPath.compareTo(rightPath) : rightPath.compareTo(leftPath);
        }
    };
}
