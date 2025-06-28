package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: source */
/* loaded from: classes.dex */
final class z extends zzafo {
    private final /* synthetic */ zzagp a;

    /* JADX INFO: Access modifiers changed from: private */
    z(zzagp zzagpVar) {
        this.a = zzagpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafp
    public final void a(zzaff zzaffVar, String str) {
        NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener;
        NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener2;
        NativeCustomTemplateAd a;
        onCustomClickListener = this.a.b;
        if (onCustomClickListener == null) {
            return;
        }
        onCustomClickListener2 = this.a.b;
        a = this.a.a(zzaffVar);
        onCustomClickListener2.a(a, str);
    }

    /* synthetic */ z(zzagp zzagpVar, x xVar) {
        this(zzagpVar);
    }
}
