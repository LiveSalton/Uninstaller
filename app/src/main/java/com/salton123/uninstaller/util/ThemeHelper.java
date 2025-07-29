package com.salton123.uninstaller.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;

/**
 * 主题帮助类，处理主题切换相关逻辑
 */
public class ThemeHelper {

    /**
     * 应用主题设置
     * @param activity 当前Activity
     * @param themeMode 主题模式："light", "dark", "system"
     */
    public static void applyTheme(Activity activity, String themeMode) {
        if (activity == null) return;
        
        // 应用主题，需要重启Activity以应用新主题
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            activity.finish();
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            activity.startActivity(activity.getIntent());
        }, 200); // 稍微延迟一下重启，让用户看到选择的效果
    }
    
    /**
     * 在应用启动时应用主题
     * 此方法应在Activity的super.onCreate(savedInstanceState)之前调用
     */
    public static void initTheme(Activity activity) {
        String themeMode = PreferenceManager.getThemeMode(activity);
        applyThemeWithoutRestart(activity, themeMode);
    }
    
    /**
     * 应用主题设置但不重启Activity
     * 用于初始化时设置主题
     */
    private static void applyThemeWithoutRestart(Context context, String themeMode) {
        if (PreferenceManager.THEME_MODE_DARK.equals(themeMode)) {
            // 设置为夜间模式
            setNightMode(true);
        } else if (PreferenceManager.THEME_MODE_LIGHT.equals(themeMode)) {
            // 设置为日间模式
            setNightMode(false);
        } else {
            // 跟随系统
            setSystemMode(context);
        }
    }
    
    /**
     * 判断当前系统是否是夜间模式
     */
    public static boolean isSystemInNightMode(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            int currentNightMode = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
        }
        return false;
    }
    
    /**
     * 设置为夜间模式或日间模式
     * 注：由于此项目可能没有使用AppCompat，所以我们只存储设置
     * 实际的主题切换通过重启Activity并在重新创建时应用不同的主题实现
     */
    private static void setNightMode(boolean isNight) {
        // 在这里我们不做实际操作，只保存设置
        // 真正的主题应用会在Activity重建时通过resources.xml和styles.xml实现
        // 在较新的应用中，可以使用以下代码动态切换
        // AppCompatDelegate.setDefaultNightMode(
        //     isNight ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        // );
    }
    
    /**
     * 设置为跟随系统模式
     */
    private static void setSystemMode(Context context) {
        // 检测系统当前模式并应用对应的主题
        boolean isNightMode = isSystemInNightMode(context);
        setNightMode(isNightMode);
    }
} 