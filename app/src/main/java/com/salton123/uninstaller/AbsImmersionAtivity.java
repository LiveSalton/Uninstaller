package com.salton123.uninstaller;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.gyf.barlibrary.ImmersionBar;
import com.hjq.language.MultiLanguages;
import com.salton123.uninstaller.util.Utils;

public abstract class AbsImmersionAtivity extends Activity {
    private ImmersionBar mImmersionBar;
    private int requestCode = 0x101;

    // 修复权限数组定义错误
    private String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void attachBaseContext(Context newBase) {
        // 绑定语种
        super.attachBaseContext(MultiLanguages.attach(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(false).statusBarColor(R.color.title_bar_background).transparentNavigationBar();
        mImmersionBar.init();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }
}