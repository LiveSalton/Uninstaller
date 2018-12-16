package com.salton123.unstaller.fm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import com.salton123.unstaller.ActionCode;
import com.salton123.unstaller.PreloadCore;
import com.salton123.unstaller.R;
import com.salton123.unstaller.adapter.SpeedUpAdapter;
import com.salton123.unstaller.entity.AppEntity;
import com.salton123.unstaller.util.Utils;

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
                // mAdapter.getItem(position).isChecked = !mAdapter.getItem(position).isChecked;
                AppEntity entity = mAdapter.getItem(position);
                Utils.uninstallApk(mActivity, entity.appInfo.packageName, 0);
            }
        });
        allEntity.addAll(PreloadCore.INSTANCE.getInstalledPackages());
        updateSort(allEntity);//重新排序事件

        Log.e("calc", "time app load =" + System.currentTimeMillis());
        // PreloadCore.INSTANCE.wrapApplist(SpeedUpListFragment.this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 接收窗体返回值
        if (requestCode == 0) {
            // 刷新列表
            allEntity.addAll(PreloadCore.INSTANCE.preloadAppList());
            updateSort(allEntity);//重新排序事件
        }
    }

    public void onAction(Integer actionCode) {
        if (actionCode == ActionCode.CODE_CHECK) {
            // onCheckAll(true);
        } else if (actionCode == ActionCode.CODE_UNCHECK) {
            // onCheckAll(false);
        } else if (actionCode == ActionCode.CODE_BACKUP) {
            // startBackupTask();
        } else if (actionCode == ActionCode.CODE_DELETE) {
            // deleteAll();
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
}
