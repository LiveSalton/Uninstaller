package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwq implements zzepf<zzbrx> {
    private final zzbwp a;
    private final zzeps<Set<zzbxy<zzbrz>>> b;

    private zzbwq(zzbwp zzbwpVar, zzeps<Set<zzbxy<zzbrz>>> zzepsVar) {
        this.a = zzbwpVar;
        this.b = zzepsVar;
    }

    public static zzbwq a(zzbwp zzbwpVar, zzeps<Set<zzbxy<zzbrz>>> zzepsVar) {
        return new zzbwq(zzbwpVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbrx) zzepl.a(this.a.a(this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
