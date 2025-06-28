package com.salton123.uninstaller;

import android.os.Bundle;

import com.salton123.uninstaller.fm.SpeedUpListFragment;
import com.salton123.uninstaller.util.FragmentUtil;

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