package com.salton123.uninstaller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.PreferenceManager;
import com.salton123.uninstaller.util.CacheManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * 设置页面
 */
public class SettingsActivity extends AbsImmersionAtivity implements View.OnClickListener {

    private ImageButton btnBack;
    private View itemLanguage;
    private View itemClearCache;
    private View itemCheckUpdate;
    private View itemAbout;
    private View itemFeedback;
    private View itemPrivacyPolicy;
    private View itemTermsOfServices;
    
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
        itemLanguage = findViewById(R.id.item_language);
        itemClearCache = findViewById(R.id.item_clear_cache);
        itemCheckUpdate = findViewById(R.id.item_check_update);
        itemAbout = findViewById(R.id.item_about);
        itemFeedback = findViewById(R.id.item_feedback);
        itemPrivacyPolicy = findViewById(R.id.item_privacy_policy);
        itemTermsOfServices = findViewById(R.id.item_terms_of_services);
        
        tvLanguageValue = findViewById(R.id.tv_language_value);
        tvCacheSize = findViewById(R.id.tv_cache_size);
        
        // 设置点击事件
        btnBack.setOnClickListener(this);
        itemLanguage.setOnClickListener(this);
        itemClearCache.setOnClickListener(this);
        itemCheckUpdate.setOnClickListener(this);
        itemAbout.setOnClickListener(this);
        itemFeedback.setOnClickListener(this);
        itemPrivacyPolicy.setOnClickListener(this);
        itemTermsOfServices.setOnClickListener(this);
    }
    
    private void updateSettingsInfo() {
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
     * 打开Google Play商店页面查看应用更新
     */
    private void openGooglePlayForUpdate() {
        try {
            // 尝试直接打开Google Play商店应用页面
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            // 如果无法打开Play商店应用，尝试在浏览器中打开
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, 
                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } catch (Exception ex) {
                // 如果两种方式都失败，显示提示信息
                Toast.makeText(this, "无法打开Google Play商店", Toast.LENGTH_SHORT).show();
                XLog.e("SettingsActivity", "无法打开Google Play商店: " + ex.getMessage());
            }
        }
    }
    
    /**
     * 打开Google Play商店页面给应用评分
     */
    private void openGooglePlayForRating() {
        try {
            // 尝试直接打开Google Play商店应用页面
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            // 如果无法打开Play商店应用，尝试在浏览器中打开
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, 
                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } catch (Exception ex) {
                // 如果两种方式都失败，显示提示信息
                Toast.makeText(this, "无法打开Google Play商店", Toast.LENGTH_SHORT).show();
                XLog.e("SettingsActivity", "无法打开Google Play商店: " + ex.getMessage());
            }
        }
    }
    
    /**
     * 打开隐私政策页面
     */
    private void openPrivacyPolicy() {
        Intent intent = new Intent(this, PolicyActivity.class);
        intent.putExtra("url", "https://www.salton123.com/privacy-policy");
        intent.putExtra("title", getString(R.string.privacy_policy));
        startActivity(intent);
    }
    
    /**
     * 打开使用条款页面
     */
    private void openTermsOfServices() {
        Intent intent = new Intent(this, PolicyActivity.class);
        intent.putExtra("url", "https://www.salton123.com/terms-of-services");
        intent.putExtra("title", getString(R.string.terms_of_services));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        } else if (v == itemLanguage) {
            // 跳转到语言设置页面
            LanguageSettingActivity.start(this);
        } else if (v == itemClearCache) {
            // 清除缓存
            clearCache();
        } else if (v == itemCheckUpdate) {
            // 跳转到Google Play商店查看更新
            openGooglePlayForUpdate();
        } else if (v == itemAbout) {
            // 跳转到关于页面
            AboutActivity.start(this);
        } else if (v == itemFeedback) {
            // 跳转到Google Play商店给好评
            openGooglePlayForRating();
        } else if (v == itemPrivacyPolicy) {
            // 打开隐私政策页面
            openPrivacyPolicy();
        } else if (v == itemTermsOfServices) {
            // 打开使用条款页面
            openTermsOfServices();
        }
    }
    
    public static void start(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
}