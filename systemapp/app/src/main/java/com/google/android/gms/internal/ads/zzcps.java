package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcps implements zzepf<zzcpp> {
    private final zzeps<Context> a;

    private zzcps(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcps a(zzeps<Context> zzepsVar) {
        return new zzcps(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcpp(this.a.b());
    }
}
