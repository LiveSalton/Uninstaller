package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclh implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzcld a;
    private final zzeps<zzcln> b;
    private final zzeps<Executor> c;

    private zzclh(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzcldVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzclh a(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzclh(zzcldVar, zzepsVar, zzepsVar2);
    }

    public static Set<zzbxy<zzbtj>> a(zzcld zzcldVar, zzcln zzclnVar, Executor executor) {
        return (Set) zzepl.a(zzcld.c(zzclnVar, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b(), this.c.b());
    }
}
