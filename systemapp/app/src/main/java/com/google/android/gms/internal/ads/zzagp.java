package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagp {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener a;
    private final NativeCustomTemplateAd.OnCustomClickListener b;
    private NativeCustomTemplateAd c;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.a = onCustomTemplateAdLoadedListener;
        this.b = onCustomClickListener;
    }

    public final zzafq a() {
        return new y(this);
    }

    public final zzafp b() {
        if (this.b == null) {
            return null;
        }
        return new z(this);
    }

    public final synchronized NativeCustomTemplateAd a(zzaff zzaffVar) {
        if (this.c != null) {
            return this.c;
        }
        zzafg zzafgVar = new zzafg(zzaffVar);
        this.c = zzafgVar;
        return zzafgVar;
    }
}
