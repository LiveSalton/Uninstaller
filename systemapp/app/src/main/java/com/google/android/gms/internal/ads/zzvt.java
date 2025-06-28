package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvt extends zzxn {
    private final AppEventListener a;

    public zzvt(AppEventListener appEventListener) {
        this.a = appEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxo
    public final void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public final AppEventListener a() {
        return this.a;
    }
}
