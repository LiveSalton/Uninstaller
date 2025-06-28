package com.salton123.uninstaller;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.gyf.barlibrary.ImmersionBar;
import com.salton123.uninstaller.util.Utils;

public abstract class AbsImmersionAtivity extends Activity {
    private ImmersionBar mImmersionBar;
    private int requestCode = 0x101;
    
    // 修复权限数组定义错误
    private String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE, 
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .transparentBar().transparentNavigationBar();
        mImmersionBar.init();
        super.onCreate(savedInstanceState);
        
        // 检查并请求存储权限
        checkAndRequestStoragePermissions();
    }

    private void checkAndRequestStoragePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android 6.0 及以上版本需要动态请求权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                // Android 13 (API 33) 及以上版本使用新的媒体权限
                String[] newPermissions = new String[]{
                        Manifest.permission.READ_MEDIA_IMAGES,
                        Manifest.permission.READ_MEDIA_VIDEO,
                        Manifest.permission.READ_MEDIA_AUDIO
                };
                if (!hasAllPermissions(newPermissions)) {
                    requestPermissions(newPermissions, requestCode);
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // Android 11 (API 30) 及以上版本，可能需要MANAGE_EXTERNAL_STORAGE权限
                if (!Utils.canWriteStorage(this)) {
                    requestPermissions(permissions, requestCode);
                }
            } else {
                // Android 6.0 到 Android 10
                if (!Utils.canWriteStorage(this)) {
                    requestPermissions(permissions, requestCode);
                }
            }
        }
    }

    /**
     * 检查是否拥有所有指定权限
     */
    private boolean hasAllPermissions(String[] permissions) {
        for (String permission : permissions) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.requestCode) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }
            
            if (!allGranted) {
                Toast.makeText(getApplicationContext(),
                        "需要存储权限才能正常使用应用功能",
                        Toast.LENGTH_LONG).show();
                // 可以选择不直接finish，给用户再次授权的机会
                // finish();
            } else {
                Toast.makeText(getApplicationContext(),
                        "权限授予成功",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}