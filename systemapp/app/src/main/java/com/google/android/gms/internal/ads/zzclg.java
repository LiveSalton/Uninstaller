package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclg implements zzepf<Set<zzbxy<zzbru>>> {
    private final zzcld a;
    private final zzeps<zzcln> b;
    private final zzeps<Executor> c;

    private zzclg(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzcldVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzclg a(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzclg(zzcldVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(zzcld.e(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
