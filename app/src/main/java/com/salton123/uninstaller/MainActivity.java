package com.salton123.uninstaller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.salton123.log.XLog;
import com.salton123.uninstaller.fm.SpeedUpListFragment;
import com.salton123.uninstaller.util.FragmentUtil;

public class MainActivity extends AbsImmersionAtivity {

    private static final int REQUEST_PERMISSIONS = 1001;
    private SpeedUpListFragment mInstalledFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        XLog.i(this, "MainActivity onCreate");
        
        // 检查权限
        if (checkAndRequestPermissions()) {
            initFragment();
        }
    }

    private boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

            boolean allGranted = true;
            for (String permission : permissions) {
                if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }

            if (!allGranted) {
                requestPermissions(permissions, REQUEST_PERMISSIONS);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }
            
            if (allGranted) {
                initFragment();
            } else {
                XLog.e(this, "权限被拒绝");
            }
        }
    }

    private void initFragment() {
        mInstalledFragment = SpeedUpListFragment.newInstance();
        FragmentUtil.addOrReplaceFragment(getFragmentManager(), mInstalledFragment, R.id.flAppList);
    }
}