package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkz implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbkx a;
    private final zzeps<zzbnt> b;

    public zzbkz(zzbkx zzbkxVar, zzeps<zzbnt> zzepsVar) {
        this.a = zzbkxVar;
        this.b = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.singleton(new zzbxy(this.b.b(), zzazj.f)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
