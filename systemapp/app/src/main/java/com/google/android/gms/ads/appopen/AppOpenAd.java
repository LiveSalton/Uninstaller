package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzsm;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zzxg;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class AppOpenAd {

    /* compiled from: source */
    public static abstract class AppOpenAdLoadCallback {
        @Deprecated
        public void a(int i) {
        }

        public void a(LoadAdError loadAdError) {
        }

        public void a(AppOpenAd appOpenAd) {
        }
    }

    /* compiled from: source */
    public @interface AppOpenAdOrientation {
    }

    protected abstract zzxg a();

    public abstract void a(Activity activity, FullScreenContentCallback fullScreenContentCallback);

    protected abstract void a(zzsm zzsmVar);

    public static void a(Context context, String str, AdRequest adRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.a(context, "Context cannot be null.");
        Preconditions.a(str, (Object) "adUnitId cannot be null.");
        Preconditions.a(adRequest, "AdRequest cannot be null.");
        new zzsv(context, str, adRequest.a(), i, appOpenAdLoadCallback).a();
    }
}
