package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpt implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<zzbjv> a;
    private final zzeps<Executor> b;

    private zzbpt(zzeps<zzbjv> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbpt a(zzeps<zzbjv> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzbpt(zzepsVar, zzepsVar2);
    }

    public static zzbxy<zzbtj> a(zzbjv zzbjvVar, Executor executor) {
        return (zzbxy) zzepl.a(new zzbxy(zzbjvVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
