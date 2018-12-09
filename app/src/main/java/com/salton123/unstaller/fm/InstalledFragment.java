package com.salton123.unstaller.fm;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.salton123.unstaller.ActionCode;
import com.salton123.unstaller.R;
import com.salton123.unstaller.adapter.AppListAdapter;
import com.salton123.unstaller.entity.AppInfo;
import com.salton123.unstaller.util.BackupManager;
import com.salton123.unstaller.util.ScheduledTask;
import com.salton123.unstaller.util.Utils;

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
    private List<AppInfo> mAppInfos;
    private volatile boolean isStartAsyncTask = false;

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
        asyncGetAppList();
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
        if (!isStartAsyncTask) {
            asyncGetAppList();
        }
    }

    private void asyncGetAppList() {
        new GetAppAsyncTask().execute();
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
        for (AppInfo item : mAppInfos) {
            if (item.isChecked) {
                backupList.add(item);
            }
        }
        BackupManager.toBackup(backupList, this);
    }

    private void deleteAll() {

    }

    private void onCheckAll(boolean isChecked) {
        if (mAppInfos != null) {
            for (AppInfo item : mAppInfos) {
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


    private class GetAppAsyncTask extends AsyncTask<Void, Void, List<AppInfo>> {

        @Override
        protected List<AppInfo> doInBackground(Void... voids) {
            return Utils.getAppList(mActivity);
        }

        @Override
        protected void onPostExecute(List<AppInfo> appInfos) {
            super.onPostExecute(appInfos);
            dismissProgressDialog();
            mAppInfos = appInfos;
            updateListView();
            isStartAsyncTask = false;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog("系统信息", "正在加载应用列表,请耐心等待...");
            isStartAsyncTask = true;
        }
    }

    private void updateListView() {
        if (mAppInfos != null) {
            mAdapter.setList(mAppInfos);
            mAdapter.notifyDataSetChanged();
        }
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

