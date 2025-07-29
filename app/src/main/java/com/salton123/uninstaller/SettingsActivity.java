package com.salton123.uninstaller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.PreferenceManager;
import com.salton123.uninstaller.util.CacheManager;
import com.salton123.uninstaller.util.UpdateManager;
import com.salton123.uninstaller.util.UserManager;
import com.salton123.uninstaller.dialog.LogoutConfirmDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * 设置页面
 */
public class SettingsActivity extends AbsImmersionAtivity implements View.OnClickListener {

    private ImageButton btnBack;
    private View itemThemeMode;
    private View itemLanguage;
    private View itemClearCache;
    private View itemCheckUpdate;
    private View itemAbout;
    private View itemFeedback;
    private View itemLogout;
    
    private TextView tvThemeValue;
    private TextView tvLanguageValue;
    private TextView tvCacheSize;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        initViews();
        updateSettingsInfo();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        itemThemeMode = findViewById(R.id.item_theme_mode);
        itemLanguage = findViewById(R.id.item_language);
        itemClearCache = findViewById(R.id.item_clear_cache);
        itemCheckUpdate = findViewById(R.id.item_check_update);
        itemAbout = findViewById(R.id.item_about);
        itemFeedback = findViewById(R.id.item_feedback);
        itemLogout = findViewById(R.id.item_logout);
        
        tvThemeValue = findViewById(R.id.tv_theme_value);
        tvLanguageValue = findViewById(R.id.tv_language_value);
        tvCacheSize = findViewById(R.id.tv_cache_size);
        
        // 设置点击事件
        btnBack.setOnClickListener(this);
        itemThemeMode.setOnClickListener(this);
        itemLanguage.setOnClickListener(this);
        itemClearCache.setOnClickListener(this);
        itemCheckUpdate.setOnClickListener(this);
        itemAbout.setOnClickListener(this);
        itemFeedback.setOnClickListener(this);
        itemLogout.setOnClickListener(this);
    }
    
    private void updateSettingsInfo() {
        // 更新主题模式显示
        String themeMode = PreferenceManager.getThemeMode(this);
        if ("dark".equals(themeMode)) {
            tvThemeValue.setText(R.string.settings_theme_dark);
        } else if ("light".equals(themeMode)) {
            tvThemeValue.setText(R.string.settings_theme_light);
        } else {
            tvThemeValue.setText(R.string.settings_theme_system);
        }
        
        // 更新语言显示
        String language = PreferenceManager.getLanguage(this);
        if ("zh".equals(language)) {
            tvLanguageValue.setText(R.string.settings_language_chinese);
        } else if ("en".equals(language)) {
            tvLanguageValue.setText(R.string.settings_language_english);
        } else {
            tvLanguageValue.setText(R.string.settings_language_system);
        }
        
        // 更新缓存大小显示
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return CacheManager.getTotalCacheSize(SettingsActivity.this);
            }
            
            @Override
            protected void onPostExecute(String cacheSize) {
                tvCacheSize.setText(cacheSize);
            }
        }.execute();
    }
    
    /**
     * 清除缓存
     */
    private void clearCache() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.cache_size_calculating));
        progressDialog.setCancelable(false);
        progressDialog.show();
        
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... params) {
                return CacheManager.clearAllCache(SettingsActivity.this);
            }
            
            @Override
            protected void onPostExecute(Boolean success) {
                progressDialog.dismiss();
                if (success) {
                    Toast.makeText(SettingsActivity.this, R.string.clear_cache_success, Toast.LENGTH_SHORT).show();
                    // 更新显示的缓存大小
                    updateSettingsInfo();
                } else {
                    Toast.makeText(SettingsActivity.this, R.string.clear_cache_failed, Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
    
    /**
     * 检查应用更新
     */
    private void checkUpdate() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.update_checking));
        progressDialog.setCancelable(false);
        progressDialog.show();
        
        UpdateManager.checkUpdate(this, new UpdateManager.UpdateCheckListener() {
            @Override
            public void onCheckStart() {
                XLog.d("SettingsActivity", "Start checking update");
            }
            
            @Override
            public void onUpdateAvailable(UpdateManager.UpdateInfo updateInfo) {
                progressDialog.dismiss();
                // 显示更新对话框
                UpdateManager.showUpdateDialog(SettingsActivity.this, updateInfo);
            }
            
            @Override
            public void onNoUpdateAvailable() {
                progressDialog.dismiss();
                Toast.makeText(SettingsActivity.this, R.string.update_not_available, Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void onCheckFailed(String errorMsg) {
                progressDialog.dismiss();
                Toast.makeText(SettingsActivity.this, R.string.update_check_failed, Toast.LENGTH_SHORT).show();
                XLog.e("SettingsActivity", "Update check failed: " + errorMsg);
            }
        });
    }
    
    /**
     * 显示退出确认对话框
     */
    private void showLogoutConfirmDialog() {
        LogoutConfirmDialog dialog = new LogoutConfirmDialog(this);
        dialog.setOnConfirmListener(new LogoutConfirmDialog.OnConfirmListener() {
            @Override
            public void onConfirm() {
                // 执行退出登录操作
                logout();
            }
        });
        dialog.show();
    }
    
    /**
     * 执行退出登录操作
     */
    private void logout() {
        // 清除用户登录状态
        UserManager.logout(this);
        
        Toast.makeText(this, "已退出登录", Toast.LENGTH_SHORT).show();
        
        // 这里可以根据实际需求跳转到登录页面
        // 或者返回到主界面，这里我们简单返回
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        } else if (v == itemThemeMode) {
            // 跳转到主题设置页面
            ThemeSettingActivity.start(this);
        } else if (v == itemLanguage) {
            // 跳转到语言设置页面
            LanguageSettingActivity.start(this);
        } else if (v == itemClearCache) {
            // 清除缓存
            clearCache();
        } else if (v == itemCheckUpdate) {
            // 检查更新
            checkUpdate();
        } else if (v == itemAbout) {
            // 跳转到关于页面
            AboutActivity.start(this);
        } else if (v == itemFeedback) {
            // 跳转到反馈页面 (后续实现)
        } else if (v == itemLogout) {
            // 显示退出确认对话框
            showLogoutConfirmDialog();
        }
    }
    
    public static void start(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
} 