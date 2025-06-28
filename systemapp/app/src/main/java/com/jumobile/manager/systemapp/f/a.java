package com.jumobile.manager.systemapp.f;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static int a(Context context, String str, int i) {
        return context.getApplicationContext().getSharedPreferences("smart_pref", 0).getInt(str, i);
    }

    public static boolean b(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("smart_pref", 0).edit();
        edit.putInt(str, i);
        return edit.commit();
    }

    public static boolean a(Context context, String str, boolean z) {
        return context.getApplicationContext().getSharedPreferences("smart_pref", 0).getBoolean(str, z);
    }

    public static boolean b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("smart_pref", 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static String a(Context context, String str, String str2) {
        return context.getApplicationContext().getSharedPreferences("smart_pref", 0).getString(str, str2);
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("smart_pref", 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }
}
