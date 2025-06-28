package com.google.android.gms.ads.formats;

/* compiled from: source */
/* loaded from: classes.dex */
public interface NativeCustomTemplateAd {

    /* compiled from: source */
    public interface DisplayOpenMeasurement {
    }

    /* compiled from: source */
    public interface OnCustomClickListener {
        void a(NativeCustomTemplateAd nativeCustomTemplateAd, String str);
    }

    /* compiled from: source */
    public interface OnCustomTemplateAdLoadedListener {
        void a(NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    String a();
}
