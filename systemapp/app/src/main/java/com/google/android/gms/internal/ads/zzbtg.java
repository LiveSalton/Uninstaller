package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtg implements zzepf<zzbte> {
    private final zzeps<Set<zzbxy<zzbtj>>> a;

    private zzbtg(zzeps<Set<zzbxy<zzbtj>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbtg a(zzeps<Set<zzbxy<zzbtj>>> zzepsVar) {
        return new zzbtg(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbte(this.a.b());
    }
}
