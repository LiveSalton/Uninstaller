package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import com.salton123.log.XLog;

import java.util.Locale;

/**
 * 语言帮助类，处理多语言切换相关逻辑
 */
public class LocaleHelper {

    private static final String TAG = "LocaleHelper";

    /**
     * 设置应用语言
     * @param context 上下文
     * @param language 语言代码，例如 "zh", "en", "system"
     */
    public static void setLocale(Context context, String language) {
        if (context == null) return;
        
        Locale locale;
        Resources res = context.getResources();
        Configuration config = res.getConfiguration();
        
        if (PreferenceManager.LANGUAGE_CHINESE.equals(language)) {
            locale = Locale.SIMPLIFIED_CHINESE;
            XLog.d(TAG, "Setting language to Chinese");
        } else if (PreferenceManager.LANGUAGE_ENGLISH.equals(language)) {
            locale = Locale.ENGLISH;
            XLog.d(TAG, "Setting language to English");
        } else {
            // 使用系统默认语言
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Resources.getSystem().getConfiguration().locale;
            }
            XLog.d(TAG, "Setting language to system default: " + locale.getLanguage());
        }
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            config.setLocales(localeList);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    /**
     * 在应用启动时初始化语言设置
     * @param context 上下文
     */
    public static void initLocale(Context context) {
        String language = PreferenceManager.getLanguage(context);
        setLocale(context, language);
    }
} 