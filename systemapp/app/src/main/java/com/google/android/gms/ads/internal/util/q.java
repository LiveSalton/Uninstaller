package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class q implements Callable<String> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Context b;

    q(zzbt zzbtVar, Context context, Context context2) {
        this.a = context;
        this.b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.a != null) {
            zzd.a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.a.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzd.a("Attempting to read user agent from local cache.");
            sharedPreferences = this.b.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzd.a("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.b);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzd.a("Persisting user agent.");
            }
        }
        return string;
    }
}
