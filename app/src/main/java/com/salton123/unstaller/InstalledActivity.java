package com.salton123.unstaller;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.salton123.unstaller.adapter.SpeedUpAdapter;

/**
 * User: newSalton@outlook.com
 * Date: 2018/12/14 2:54 PM
 * ModifyTime: 2:54 PM
 * Description:
 */
@Deprecated
public class InstalledActivity extends AbsImmersionAtivity {
    private ListView appListView;
    private SpeedUpAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_installed_app);
        appListView = findViewById(R.id.appListView);
        loadData();
    }

    private void loadData() {
        mAdapter = new SpeedUpAdapter(getApplicationContext());
        appListView.setAdapter(mAdapter);
        appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        mAdapter.addAll(PreloadCore.INSTANCE.getInstalledPackages());
    }

}
