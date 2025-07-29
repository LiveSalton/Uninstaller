package com.salton123.uninstaller.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.salton123.log.XLog;

/**
 * 用户管理工具类，处理登录状态和退出登录
 */
public class UserManager {

    private static final String TAG = "UserManager";
    private static final String PREF_NAME = "user_prefs";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_ID = "user_id";

    /**
     * 保存登录状态
     * @param context 上下文
     * @param isLoggedIn 是否登录
     */
    public static void setLoggedIn(Context context, boolean isLoggedIn) {
        if (context == null) return;
        getSharedPreferences(context).edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply();
    }

    /**
     * 获取当前登录状态
     * @param context 上下文
     * @return 是否已登录
     */
    public static boolean isLoggedIn(Context context) {
        if (context == null) return false;
        return getSharedPreferences(context).getBoolean(KEY_IS_LOGGED_IN, false);
    }

    /**
     * 保存用户信息
     * @param context 上下文
     * @param username 用户名
     * @param userId 用户ID
     */
    public static void saveUserInfo(Context context, String username, String userId) {
        if (context == null) return;
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_ID, userId);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    /**
     * 获取用户名
     * @param context 上下文
     * @return 用户名
     */
    public static String getUsername(Context context) {
        if (context == null) return "";
        return getSharedPreferences(context).getString(KEY_USERNAME, "");
    }

    /**
     * 获取用户ID
     * @param context 上下文
     * @return 用户ID
     */
    public static String getUserId(Context context) {
        if (context == null) return "";
        return getSharedPreferences(context).getString(KEY_USER_ID, "");
    }

    /**
     * 退出登录，清除用户信息
     * @param context 上下文
     */
    public static void logout(Context context) {
        if (context == null) return;
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
        XLog.i(TAG, "User logged out");
    }

    /**
     * 获取SharedPreferences
     */
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
} 