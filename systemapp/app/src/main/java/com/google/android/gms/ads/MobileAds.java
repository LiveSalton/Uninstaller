package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzl;

/* compiled from: source */
/* loaded from: classes.dex */
public class MobileAds {

    /* compiled from: source */
    @Deprecated
    public static final class Settings {
        private final zzzl a = new zzzl();
    }

    private MobileAds() {
    }

    public static void a(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzzd.a().a(context, null, onInitializationCompleteListener);
    }
}
