package com.salton123.unstaller.fm;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.salton123.log.XLog;
import com.salton123.unstaller.ActionCode;
import com.salton123.unstaller.PreloadCore;
import com.salton123.unstaller.R;
import com.salton123.unstaller.adapter.AppListAdapter;
import com.salton123.unstaller.entity.AppInfo;
import com.salton123.unstaller.util.BackupManager;
import com.salton123.unstaller.util.ScheduledTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/8 8:20 PM
 * ModifyTime: 8:20 PM
 * Description:
 */
public class InstalledFragment extends BaseFragment implements BackupManager.IBackupProgress {
    private ProgressDialog mProgressDialog;
    private ListView appListView;
    private AppListAdapter mAdapter;

    public static InstalledFragment newInstance() {
        return new InstalledFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.fm_installed_app, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new AppListAdapter(mActivity);
        appListView = view.findViewById(R.id.appListView);
        appListView.setAdapter(mAdapter);
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AppInfo appInfo = (AppInfo) parent.getItemAtPosition(position);
                appInfo.isChecked = !appInfo.isChecked;
                mAdapter.notifyDataSetChanged();
            }
        });

        asyncGetAppList();
    }

    private void asyncGetAppList() {
        // XLog.e(this, "start = " + System.currentTimeMillis());
        // PackageManager pm = mActivity.getPackageManager();//获取包管理者
        // List<PackageInfo> pList = PreloadCore.INSTANCE.getInstalledPackages();
        // XLog.e(this, "fetch = " + System.currentTimeMillis());
        // pList = pList.subList(0, 10);
        // // 循环遍历
        // for (int i = 0; i < pList.size(); i++) {
        //     PackageInfo packageInfo = pList.get(i);// 获取每一个应用的信息
        //     // 不能包含本应用(不删除自己)
        //     if (!packageInfo.packageName.equals(mActivity.getPackageName())) {
        //         // 从右边装到左边
        //         AppInfo appInfo = new AppInfo();
        //         appInfo.mPackageName = packageInfo.packageName;
        //         appInfo.mVersionName = packageInfo.versionName;
        //         appInfo.mVersionCode = packageInfo.versionCode;
        //         appInfo.mFirstInstallTime = packageInfo.firstInstallTime;
        //         appInfo.mLastUpdateTime = packageInfo.lastUpdateTime;
        //         // 程序名称
        //         appInfo.mAppName = ((String) packageInfo.applicationInfo.loadLabel(pm)).trim();
        //         // 过渡
        //         appInfo.mApplicationInfo = packageInfo.applicationInfo;
        //         // 这行代码在运行时解除注释
        //         // appInfo.mIcon = packageInfo.mApplicationInfo.loadIcon(pm);
        //         //publicSourceDir 是app的安装路径（文件夹）
        //         String dir = packageInfo.applicationInfo.publicSourceDir;
        //         appInfo.mPath = dir;
        //         // 计算应用的空间
        //         // long mByteSize = new File(dir).length();
        //         // 1024*1024 Byte字节
        //         // appInfo.mByteSize = mByteSize;
        //         // 1MB
        //         // appInfo.mSize = getSize(mByteSize);
        //         mAdapter.add(appInfo);
        //         XLog.e(this, "add = " + System.currentTimeMillis());
        //     }
        //     mAdapter.notifyDataSetChanged();
        // }
        // XLog.e(this, "end = " + System.currentTimeMillis());
    }

    @Subscribe()
    public void onAction(Integer actionCode) {
        if (actionCode == ActionCode.CODE_CHECK) {
            onCheckAll(true);
        } else if (actionCode == ActionCode.CODE_UNCHECK) {
            onCheckAll(false);
        } else if (actionCode == ActionCode.CODE_BACKUP) {
            startBackupTask();
        } else if (actionCode == ActionCode.CODE_DELETE) {
            deleteAll();
        }
    }

    private void startBackupTask() {
        List<AppInfo> backupList = new ArrayList<>();
        for (AppInfo item : mAdapter.getList()) {
            if (item.isChecked) {
                backupList.add(item);
            }
        }
        BackupManager.toBackup(backupList, this);
    }

    private void deleteAll() {

    }

    private void onCheckAll(boolean isChecked) {
        if (mAdapter.getList() != null) {
            for (AppInfo item : mAdapter.getList()) {
                item.isChecked = isChecked;
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onProgress(final int current, final int total, final boolean isSuccess) {
        ScheduledTask.getInstance().scheduledDelayed(new Runnable() {
            @Override
            public void run() {
                if (mProgressDialog == null) {
                    mProgressDialog = new ProgressDialog(mActivity);
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    mProgressDialog.show();
                } else {
                    if (!mProgressDialog.isShowing()) {
                        mProgressDialog.show();
                    }
                    mProgressDialog.setTitle("应用备份中");
                    mProgressDialog.setMessage(current + "/" + total + "正在备份");
                    if (current == total) {
                        mProgressDialog.dismiss();
                    }
                }
            }
        }, 0);

    }

    // 显示一个环形进度框
    public void showProgressDialog(String title, String message) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        // 实例化
        mProgressDialog = new ProgressDialog(mActivity);
        // "旋转"风格
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();// 显示
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissProgressDialog();
        EventBus.getDefault().unregister(this);
    }
}

