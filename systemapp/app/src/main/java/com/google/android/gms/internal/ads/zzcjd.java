package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcjd implements zzepf<zzbxy<zzbui>> {
    private final zzeps<zzcjj> a;
    private final zzeps<Executor> b;

    private zzcjd(zzeps<zzcjj> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcjd a(zzeps<zzcjj> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzcjd(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.a.b(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
