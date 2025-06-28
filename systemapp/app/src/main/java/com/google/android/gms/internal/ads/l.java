package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: source */
/* loaded from: classes.dex */
final class l implements zzadp {
    private final /* synthetic */ zzabb a;

    l(zzabb zzabbVar) {
        this.a = zzabbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final Boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.a.e;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final Long a(String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        try {
            sharedPreferences2 = this.a.e;
            return Long.valueOf(sharedPreferences2.getLong(str, j));
        } catch (ClassCastException unused) {
            sharedPreferences = this.a.e;
            return Long.valueOf(sharedPreferences.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final Double a(String str, double d) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.a.e;
        return Double.valueOf(sharedPreferences.getFloat(str, (float) d));
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final String a(String str, String str2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.a.e;
        return sharedPreferences.getString(str, str2);
    }
}
