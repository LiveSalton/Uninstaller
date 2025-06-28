package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzu implements zzepf<View> {
    private final zzbzc a;

    private zzbzu(zzbzc zzbzcVar) {
        this.a = zzbzcVar;
    }

    public static zzbzu a(zzbzc zzbzcVar) {
        return new zzbzu(zzbzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return this.a.c();
    }
}
