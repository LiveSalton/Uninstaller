package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzr implements zzepf<zzbxy<zzbvs>> {
    private final zzbzc a;
    private final zzeps<Executor> b;

    private zzbzr(zzbzc zzbzcVar, zzeps<Executor> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzr a(zzbzc zzbzcVar, zzeps<Executor> zzepsVar) {
        return new zzbzr(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(this.a.a(this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
