package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclm implements zzepf<Set<zzbxy<zzva>>> {
    private final zzcld a;
    private final zzeps<zzcln> b;
    private final zzeps<Executor> c;

    private zzclm(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzcldVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzclm a(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzclm(zzcldVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(zzcld.g(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
