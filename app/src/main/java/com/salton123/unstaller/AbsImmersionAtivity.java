package com.salton123.unstaller;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.salton123.unstaller.util.Utils;

public abstract class AbsImmersionAtivity extends Activity {
    private ImmersionBar mImmersionBar;
    private int requestCode = 0x101;
    private String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mImmersionBar = ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .transparentBar().transparentNavigationBar();
        mImmersionBar.init();
        super.onCreate(savedInstanceState);
        if (!Utils.canWriteStorage(this)) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(permissions, requestCode);
            }
        }
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
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(),
                        "请授予读写权限",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}