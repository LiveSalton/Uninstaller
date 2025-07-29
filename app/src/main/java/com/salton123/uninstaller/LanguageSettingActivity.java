package com.salton123.uninstaller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.salton123.log.XLog;
import com.salton123.uninstaller.util.LocaleHelper;
import com.salton123.uninstaller.util.PreferenceManager;

import java.util.Locale;

/**
 * 语言设置页面
 */
public class LanguageSettingActivity extends AbsImmersionAtivity implements View.OnClickListener {

    private ImageButton btnBack;
    private RadioGroup rgLanguageOptions;
    private RadioButton rbSystem;
    private RadioButton rbChinese;
    private RadioButton rbEnglish;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_setting);
        
        initViews();
        updateSelectedLanguage();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        rgLanguageOptions = findViewById(R.id.rg_language_options);
        rbSystem = findViewById(R.id.rb_language_system);
        rbChinese = findViewById(R.id.rb_language_chinese);
        rbEnglish = findViewById(R.id.rb_language_english);
        
        btnBack.setOnClickListener(this);
        
        rgLanguageOptions.setOnCheckedChangeListener((group, checkedId) -> {
            String language;
            if (checkedId == R.id.rb_language_chinese) {
                language = PreferenceManager.LANGUAGE_CHINESE;
            } else if (checkedId == R.id.rb_language_english) {
                language = PreferenceManager.LANGUAGE_ENGLISH;
            } else {
                language = PreferenceManager.LANGUAGE_SYSTEM;
            }
            
            // 保存语言设置
            PreferenceManager.setLanguage(this, language);
            
            // 应用语言变更
            LocaleHelper.setLocale(this, language);
            
            // 重新启动Activity以应用语言设置
            recreateActivity();
        });
    }
    
    private void updateSelectedLanguage() {
        String currentLanguage = PreferenceManager.getLanguage(this);
        if (PreferenceManager.LANGUAGE_CHINESE.equals(currentLanguage)) {
            rbChinese.setChecked(true);
        } else if (PreferenceManager.LANGUAGE_ENGLISH.equals(currentLanguage)) {
            rbEnglish.setChecked(true);
        } else {
            rbSystem.setChecked(true);
        }
    }
    
    private void recreateActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        }
    }
    
    public static void start(Context context) {
        Intent intent = new Intent(context, LanguageSettingActivity.class);
        context.startActivity(intent);
    }
} 