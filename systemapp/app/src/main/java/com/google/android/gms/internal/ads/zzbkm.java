package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkm implements zzepf<zzbjz> {
    private final zzeps<zzqr> a;
    private final zzeps<zzamq> b;
    private final zzeps<Executor> c;

    private zzbkm(zzeps<zzqr> zzepsVar, zzeps<zzamq> zzepsVar2, zzeps<Executor> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbkm a(zzeps<zzqr> zzepsVar, zzeps<zzamq> zzepsVar2, zzeps<Executor> zzepsVar3) {
        return new zzbkm(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzqr b = this.a.b();
        return (zzbjz) zzepl.a(new zzbjz(b.d(), this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
