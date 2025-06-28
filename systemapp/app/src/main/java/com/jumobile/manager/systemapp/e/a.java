package com.jumobile.manager.systemapp.e;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str) {
        return null;
    }

    public static boolean a(Context context, String str, boolean z) {
        String a = a(context, str);
        return TextUtils.isEmpty(a) ? z : "true".equals(a);
    }
}
