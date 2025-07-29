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

import com.hjq.language.MultiLanguages;
import com.salton123.log.XLog;

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
            boolean restart = false;
            if (checkedId == R.id.rb_language_chinese) {
                // 设置为中文
                restart = MultiLanguages.setAppLanguage(this, Locale.SIMPLIFIED_CHINESE);
            } else if (checkedId == R.id.rb_language_english) {
                // 设置为英文
                restart = MultiLanguages.setAppLanguage(this, Locale.ENGLISH);
            } else {
                // 跟随系统
                restart = MultiLanguages.clearAppLanguage(this);
            }
            
            if (restart) {
                // 重启Activity以应用语言设置
                recreateActivity();
            }
        });
    }
    
    private void updateSelectedLanguage() {
        Locale locale = MultiLanguages.getAppLanguage(this);
        boolean isSystemLanguage = MultiLanguages.isSystemLanguage(this);
        
        if (isSystemLanguage) {
            rbSystem.setChecked(true);
        } else if (locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.getLanguage().equals("zh")) {
            rbChinese.setChecked(true);
        } else if (locale.equals(Locale.ENGLISH) || locale.getLanguage().equals("en")) {
            rbEnglish.setChecked(true);
        } else {
            rbSystem.setChecked(true);
        }
    }
    
    private void recreateActivity() {
        // 重启整个应用以应用语言设置
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        // 设置平滑的过渡动画
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