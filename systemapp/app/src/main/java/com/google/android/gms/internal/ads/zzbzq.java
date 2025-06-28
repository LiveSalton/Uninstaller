package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzq implements zzepf<zzbxy<zzbru>> {
    private final zzbzc a;
    private final zzeps<zzcal> b;
    private final zzeps<Executor> c;

    private zzbzq(zzbzc zzbzcVar, zzeps<zzcal> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzbzq a(zzbzc zzbzcVar, zzeps<zzcal> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzbzq(zzbzcVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
