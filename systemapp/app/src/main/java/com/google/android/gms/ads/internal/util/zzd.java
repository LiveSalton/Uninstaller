package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzaza;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzd extends zzaza {
    public static void a(String str) {
        if (a()) {
            Log.v("Ads", str);
        }
    }

    public static void a(String str, Throwable th) {
        if (a()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean a() {
        return a(2) && zzada.a.a().booleanValue();
    }
}
