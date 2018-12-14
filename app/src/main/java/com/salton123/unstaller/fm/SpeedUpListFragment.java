package com.salton123.unstaller.fm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.salton123.log.XLog;
import com.salton123.unstaller.ActionCode;
import com.salton123.unstaller.PreloadCore;
import com.salton123.unstaller.R;
import com.salton123.unstaller.adapter.SpeedUpAdapter;
import com.salton123.unstaller.util.ScheduledTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 11:42 AM
 * ModifyTime: 11:42 AM
 * Description:
 */
public class SpeedUpListFragment extends BaseFragment implements PreloadCore.IWrapProgress {
    public static SpeedUpListFragment newInstance() {
        return new SpeedUpListFragment();
    }

    private ListView appListView;
    private SpeedUpAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.fm_installed_app, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appListView = view.findViewById(R.id.appListView);
        loadData();
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(mActivity);
        appListView.setAdapter(mAdapter);
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.getItem(position).isChecked = !mAdapter.getItem(position).isChecked;
            }
        });
        mAdapter.addAll(PreloadCore.INSTANCE.getInstalledPackages());
        Log.e("calc", "time app load =" + System.currentTimeMillis());
        PreloadCore.INSTANCE.wrapApplist(SpeedUpListFragment.this);
    }

    @Subscribe()
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
        EventBus.getDefault().unregister(this);
    }

    @SuppressLint("HandlerLeak")
    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    XLog.i(this, "current=" + msg.arg1 + ",total=" + msg.arg2);
                    mAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Override
    public void onProgress(int current, int total) {
        float split = current * 100f / total;
        if (split % 10 == 0) {
            XLog.i(this, "split=" + split);
            Message msg = Message.obtain();
            msg.what = 100;
            msg.arg1 = current;
            msg.arg2 = total;
            mHandler.sendMessage(msg);
        }
    }
}
