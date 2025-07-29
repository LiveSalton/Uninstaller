package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 偏好设置管理类，用于保存和获取用户的设置选项
 */
public class PreferenceManager {
    private static final String PREF_NAME = "uninstaller_settings";
    
    // 主题模式相关常量
    private static final String KEY_THEME_MODE = "theme_mode";
    public static final String THEME_MODE_LIGHT = "light";
    public static final String THEME_MODE_DARK = "dark";
    public static final String THEME_MODE_SYSTEM = "system";
    
    // 语言相关常量
    private static final String KEY_LANGUAGE = "language";
    public static final String LANGUAGE_CHINESE = "zh";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_SYSTEM = "system";
    
    /**
     * 获取SharedPreferences实例
     */
    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    
    /**
     * 获取当前主题模式
     * @return "light", "dark", "system" 中的一种
     */
    public static String getThemeMode(Context context) {
        return getPreferences(context).getString(KEY_THEME_MODE, THEME_MODE_SYSTEM);
    }
    
    /**
     * 设置主题模式
     * @param themeMode 可选值为 THEME_MODE_LIGHT, THEME_MODE_DARK, THEME_MODE_SYSTEM
     */
    public static void setThemeMode(Context context, String themeMode) {
        getPreferences(context).edit().putString(KEY_THEME_MODE, themeMode).apply();
    }
    
    /**
     * 获取当前语言设置
     * @return "zh", "en", "system" 中的一种
     */
    public static String getLanguage(Context context) {
        return getPreferences(context).getString(KEY_LANGUAGE, LANGUAGE_SYSTEM);
    }
    
    /**
     * 设置语言
     * @param language 可选值为 LANGUAGE_CHINESE, LANGUAGE_ENGLISH, LANGUAGE_SYSTEM
     */
    public static void setLanguage(Context context, String language) {
        getPreferences(context).edit().putString(KEY_LANGUAGE, language).apply();
    }
} 