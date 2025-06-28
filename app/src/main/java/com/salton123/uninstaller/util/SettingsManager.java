package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 设置管理类
 * 用于保存和获取用户的各种设置选项
 */
public class SettingsManager {
    private static final String PREF_NAME = "app_settings";
    
    // 显示选项
    private static final String KEY_SHOW_TIME = "show_time";
    private static final String KEY_SHOW_FILENAME = "show_filename";
    private static final String KEY_SHOW_PATH = "show_path";
    
    // 排序选项
    private static final String KEY_SORT_TYPE = "sort_type";
    
    // 其他选项
    private static final String KEY_SHOW_SEARCH = "show_search";
    
    public enum SortType {
        NAME(0), SIZE(1), TIME(2), PATH(3);
        
        private final int value;
        
        SortType(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
        
        public static SortType fromValue(int value) {
            for (SortType type : values()) {
                if (type.value == value) {
                    return type;
                }
            }
            return NAME; // 默认返回按名称排序
        }
    }
    
    private SharedPreferences preferences;
    
    public SettingsManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    
    // 显示选项的设置和获取
    public void setShowTime(boolean show) {
        preferences.edit().putBoolean(KEY_SHOW_TIME, show).apply();
    }
    
    public boolean isShowTime() {
        return preferences.getBoolean(KEY_SHOW_TIME, false);
    }
    
    public void setShowFilename(boolean show) {
        preferences.edit().putBoolean(KEY_SHOW_FILENAME, show).apply();
    }
    
    public boolean isShowFilename() {
        return preferences.getBoolean(KEY_SHOW_FILENAME, false);
    }
    
    public void setShowPath(boolean show) {
        preferences.edit().putBoolean(KEY_SHOW_PATH, show).apply();
    }
    
    public boolean isShowPath() {
        return preferences.getBoolean(KEY_SHOW_PATH, false);
    }
    
    // 排序选项的设置和获取
    public void setSortType(SortType sortType) {
        preferences.edit().putInt(KEY_SORT_TYPE, sortType.getValue()).apply();
    }
    
    public SortType getSortType() {
        int value = preferences.getInt(KEY_SORT_TYPE, SortType.NAME.getValue());
        return SortType.fromValue(value);
    }
    
    // 其他选项的设置和获取
    public void setShowSearch(boolean show) {
        preferences.edit().putBoolean(KEY_SHOW_SEARCH, show).apply();
    }
    
    public boolean isShowSearch() {
        return preferences.getBoolean(KEY_SHOW_SEARCH, true);
    }
} 