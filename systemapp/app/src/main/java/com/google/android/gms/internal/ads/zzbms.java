package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbms implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbmh a;
    private final zzeps<zzbnt> b;

    public zzbms(zzbmh zzbmhVar, zzeps<zzbnt> zzepsVar) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
    }

    public static Set<zzbxy<zzbtj>> a(zzbmh zzbmhVar, zzbnt zzbntVar) {
        return (Set) zzepl.a(Collections.singleton(new zzbxy(zzbntVar, zzazj.f)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
