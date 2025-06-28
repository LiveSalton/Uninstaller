package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbps implements zzepf<zzbxy<zzbru>> {
    private final zzeps<zzbjv> a;
    private final zzeps<Executor> b;

    private zzbps(zzeps<zzbjv> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbps a(zzeps<zzbjv> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzbps(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.a.b(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
