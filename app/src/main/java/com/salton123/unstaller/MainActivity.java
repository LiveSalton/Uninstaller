package com.salton123.unstaller;

import android.os.Bundle;
import android.widget.SearchView;

import com.salton123.unstaller.fm.SpeedUpListFragment;
import com.salton123.unstaller.util.FragmentUtil;

public class MainActivity extends AbsImmersionAtivity {

    private SpeedUpListFragment mInstalledFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstalledFragment = SpeedUpListFragment.newInstance();
        setContentView(R.layout.activity_main);
        FragmentUtil.addOrReplaceFragment(
                getFragmentManager(),
                mInstalledFragment,
                R.id.flAppList);
    }
}