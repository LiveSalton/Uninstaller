package com.salton123.uninstaller;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salton123.log.XLog;

/**
 * 关于页面
 */
public class AboutActivity extends AbsImmersionAtivity implements View.OnClickListener {

    private static final String TAG = "AboutActivity";
    
    private ImageButton btnBack;
    private TextView tvVersionName;
    private LinearLayout itemGithub;
    private LinearLayout itemBlog;
    private ImageView ivAppLogo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        
        initViews();
        updateVersionInfo();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        tvVersionName = findViewById(R.id.tv_version_name);
        itemGithub = findViewById(R.id.item_github);
        itemBlog = findViewById(R.id.item_blog);
        ivAppLogo = findViewById(R.id.iv_app_logo);
        
        btnBack.setOnClickListener(this);
        itemGithub.setOnClickListener(this);
        itemBlog.setOnClickListener(this);
        ivAppLogo.setOnClickListener(this);
    }
    
    private void updateVersionInfo() {
        try {
            String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            tvVersionName.setText(getString(R.string.about_version, versionName));
        } catch (PackageManager.NameNotFoundException e) {
            XLog.e(TAG, "Failed to get version info");
            tvVersionName.setText(getString(R.string.about_version, "Unknown"));
        }
    }
    
    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        } else if (v == itemGithub) {
            openUrl("https://github.com/LiveSalton/Uninstaller");
        } else if (v == itemBlog) {
            openUrl("https://github.com/LiveSalton");
        } else if (v == ivAppLogo) {
            // 彩蛋：点击应用图标10次显示特殊信息
        }
    }
    
    private void openUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            XLog.e(TAG, "Failed to open URL: " + url);
        }
    }
    
    public static void start(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }
} 