package com.salton123.uninstaller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.BackupManager;
import com.salton123.uninstaller.util.Utils;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * APK详情页面
 * 显示备份APK的详细信息
 */
public class ApkInfoActivity extends AbsImmersionAtivity implements View.OnClickListener {

    public static final String EXTRA_BACKUP_INFO = "backup_info";

    private ImageButton btnBack;
    private ImageView appIcon;
    private TextView appName;
    private TextView appPackage;
    private TextView appVersion;
    private TextView appSize;
    private TextView installTime;
    private TextView apkPath;
    private Button btnInstall;
    private Button btnDelete;

    private BackupManager.BackupInfo backupInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apk_info);
        
        XLog.d("ApkInfoActivity", "开始创建APK详情页面");
        
        // 获取传递的备份信息
        backupInfo = (BackupManager.BackupInfo) getIntent().getSerializableExtra("backup_info");
        XLog.d("ApkInfoActivity", "接收到的备份信息: " + (backupInfo != null ? backupInfo.toString() : "null"));
        
        if (backupInfo == null) {
            XLog.e("ApkInfoActivity", "备份信息为空，结束Activity");
            Toast.makeText(this, R.string.error_invalid_backup_info, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        
        XLog.d("ApkInfoActivity", "备份文件名: " + backupInfo.backupFileName);
        XLog.d("ApkInfoActivity", "备份文件大小: " + backupInfo.fileSize);
        XLog.d("ApkInfoActivity", "备份时间: " + backupInfo.backupTime);
        XLog.d("ApkInfoActivity", "应用名称: " + backupInfo.appName);
        XLog.d("ApkInfoActivity", "包名: " + backupInfo.packageName);
        XLog.d("ApkInfoActivity", "版本名: " + backupInfo.versionName);
        
        initViews();
        displayApkInfo();
    }

    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        appIcon = findViewById(R.id.app_icon);
        appName = findViewById(R.id.app_name);
        appPackage = findViewById(R.id.app_package);
        appVersion = findViewById(R.id.app_version);
        appSize = findViewById(R.id.app_size);
        installTime = findViewById(R.id.install_time);
        apkPath = findViewById(R.id.apk_path);
        btnInstall = findViewById(R.id.btn_install);
        btnDelete = findViewById(R.id.btn_delete);

        btnBack.setOnClickListener(this);
        btnInstall.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void displayApkInfo() {
        XLog.d("ApkInfoActivity", "开始显示APK信息");
        
        // 显示应用图标（如果可以加载）
        try {
            if (backupInfo.backupFile != null && backupInfo.backupFile.exists()) {
                XLog.d("ApkInfoActivity", "备份文件存在，尝试加载应用图标");
                PackageManager pm = getPackageManager();
                PackageInfo packageInfo = pm.getPackageArchiveInfo(backupInfo.backupFile.getAbsolutePath(),
                    PackageManager.GET_ACTIVITIES);
                if (packageInfo != null) {
                    XLog.d("ApkInfoActivity", "成功获取PackageInfo，加载应用图标");
                    appIcon.setImageDrawable(packageInfo.applicationInfo.loadIcon(pm));
                } else {
                    XLog.d("ApkInfoActivity", "无法获取PackageInfo");
                }
            } else {
                XLog.d("ApkInfoActivity", "备份文件不存在: " + (backupInfo.backupFile != null ? backupInfo.backupFile.getAbsolutePath() : "null"));
            }
        } catch (Exception e) {
            XLog.e("ApkInfoActivity", "加载应用图标失败: " + e.getMessage());
        }

        // 显示应用名称
        if (backupInfo.appName != null && !backupInfo.appName.isEmpty()) {
            appName.setText(backupInfo.appName);
            XLog.d("ApkInfoActivity", "设置应用名称: " + backupInfo.appName);
        } else if (backupInfo.packageName != null) {
            appName.setText(backupInfo.packageName);
            XLog.d("ApkInfoActivity", "设置应用名称为包名: " + backupInfo.packageName);
        } else {
            appName.setText(getString(R.string.app_name));
            XLog.d("ApkInfoActivity", "设置默认应用名称");
        }

        // 显示包名
        appPackage.setText(backupInfo.packageName != null ? backupInfo.packageName : "unknown");
        if (backupInfo.packageName != null) {
            XLog.d("ApkInfoActivity", "设置包名: " + backupInfo.packageName);
        }

        // 显示版本信息
        appVersion.setText(backupInfo.versionName != null ? backupInfo.versionName : 
            getString(R.string.backup_version_unknown));
        if (backupInfo.versionName != null) {
            XLog.d("ApkInfoActivity", "设置版本信息: " + backupInfo.versionName);
        } else {
            XLog.d("ApkInfoActivity", "设置未知版本信息");
        }

        // 显示文件大小
        String fileSizeStr = Utils.getSize2(backupInfo.fileSize);
        appSize.setText(fileSizeStr);
        XLog.d("ApkInfoActivity", "设置文件大小: " + fileSizeStr + " (原始大小: " + backupInfo.fileSize + " bytes)");

        // 显示备份时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String backupTimeStr = sdf.format(backupInfo.backupTime);
        installTime.setText(backupTimeStr);
        XLog.d("ApkInfoActivity", "设置备份时间: " + backupTimeStr);

        // 显示文件路径
        apkPath.setText(backupInfo.backupFile.getAbsolutePath());
        if (backupInfo.backupFile != null) {
            XLog.d("ApkInfoActivity", "设置文件路径: " + backupInfo.backupFile.getAbsolutePath());
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        } else if (v == btnInstall) {
            installApk();
        } else if (v == btnDelete) {
            deleteApk();
        }
    }

    private void installApk() {
        if (backupInfo == null || !backupInfo.backupFile.exists()) {
            Toast.makeText(this, getString(R.string.apk_file_not_found), Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri apkUri = Utils.getUriForFile(this, backupInfo.backupFile);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.backup_restore_failed, e.getMessage()), 
                Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteApk() {
        if (backupInfo == null) {
            return;
        }

        boolean result = BackupManager.deleteBackup(backupInfo);
        if (result) {
            Toast.makeText(this, getString(R.string.backup_delete_success), Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, getString(R.string.backup_delete_failed), Toast.LENGTH_SHORT).show();
        }
    }

    public static void start(Activity activity, BackupManager.BackupInfo backupInfo) {
        Intent intent = new Intent(activity, ApkInfoActivity.class);
        intent.putExtra(EXTRA_BACKUP_INFO, (Serializable) backupInfo);
        activity.startActivity(intent);
    }
}