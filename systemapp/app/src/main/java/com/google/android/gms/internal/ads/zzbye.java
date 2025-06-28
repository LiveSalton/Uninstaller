package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbye implements zzepf<zzbyc> {
    private final zzeps<Set<zzbxy<zzbyd>>> a;

    private zzbye(zzeps<Set<zzbxy<zzbyd>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbye a(zzeps<Set<zzbxy<zzbyd>>> zzepsVar) {
        return new zzbye(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbyc(this.a.b());
    }
}
