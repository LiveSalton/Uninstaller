package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcoe implements zzepf<wb> {
    private final zzeps<Context> a;
    private final zzeps<zzawx> b;

    private zzcoe(zzeps<Context> zzepsVar, zzeps<zzawx> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcoe a(zzeps<Context> zzepsVar, zzeps<zzawx> zzepsVar2) {
        return new zzcoe(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new wb(this.a.b(), this.b.b());
    }
}
