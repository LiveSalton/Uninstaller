package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmv implements zzepf<zzbxy<zzqu>> {
    private final zzbmh a;
    private final zzeps<zzbnx> b;
    private final zzeps<Executor> c;

    public zzbmv(zzbmh zzbmhVar, zzeps<zzbnx> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
