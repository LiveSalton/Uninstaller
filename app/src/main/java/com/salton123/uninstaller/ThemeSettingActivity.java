package com.salton123.uninstaller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.salton123.uninstaller.util.PreferenceManager;
import com.salton123.uninstaller.util.ThemeHelper;

/**
 * 主题设置页面
 */
public class ThemeSettingActivity extends AbsImmersionAtivity implements View.OnClickListener {

    private ImageButton btnBack;
    private RadioGroup rgThemeOptions;
    private RadioButton rbSystem;
    private RadioButton rbDark;
    private RadioButton rbLight;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_setting);
        
        initViews();
        updateSelectedTheme();
    }
    
    private void initViews() {
        btnBack = findViewById(R.id.btn_back);
        rgThemeOptions = findViewById(R.id.rg_theme_options);
        rbSystem = findViewById(R.id.rb_theme_system);
        rbDark = findViewById(R.id.rb_theme_dark);
        rbLight = findViewById(R.id.rb_theme_light);
        
        btnBack.setOnClickListener(this);
        
        rgThemeOptions.setOnCheckedChangeListener((group, checkedId) -> {
            String themeMode;
            if (checkedId == R.id.rb_theme_dark) {
                themeMode = PreferenceManager.THEME_MODE_DARK;
            } else if (checkedId == R.id.rb_theme_light) {
                themeMode = PreferenceManager.THEME_MODE_LIGHT;
            } else {
                themeMode = PreferenceManager.THEME_MODE_SYSTEM;
            }
            
            // 保存主题设置
            PreferenceManager.setThemeMode(this, themeMode);
            
            // 应用主题变更
            ThemeHelper.applyTheme(this, themeMode);
        });
    }
    
    private void updateSelectedTheme() {
        String currentTheme = PreferenceManager.getThemeMode(this);
        if (PreferenceManager.THEME_MODE_DARK.equals(currentTheme)) {
            rbDark.setChecked(true);
        } else if (PreferenceManager.THEME_MODE_LIGHT.equals(currentTheme)) {
            rbLight.setChecked(true);
        } else {
            rbSystem.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack) {
            finish();
        }
    }
    
    public static void start(Context context) {
        Intent intent = new Intent(context, ThemeSettingActivity.class);
        context.startActivity(intent);
    }
} 