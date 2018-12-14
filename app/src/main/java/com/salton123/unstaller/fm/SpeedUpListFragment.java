package com.salton123.unstaller.fm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.salton123.unstaller.PreloadCore;
import com.salton123.unstaller.R;
import com.salton123.unstaller.adapter.SpeedUpAdapter;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 11:42 AM
 * ModifyTime: 11:42 AM
 * Description:
 */
public class SpeedUpListFragment extends BaseFragment {
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
        loadData();
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(mActivity);
        appListView.setAdapter(mAdapter);
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mAdapter.addAll(PreloadCore.INSTANCE.getInstalledPackages());
        Log.e("calc","time app load ="+ System.currentTimeMillis());
    }


}
