package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtd implements zzepf<zzbsu> {
    private final zzeps<Set<zzbxy<zzbru>>> a;

    private zzbtd(zzeps<Set<zzbxy<zzbru>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbtd a(zzeps<Set<zzbxy<zzbru>>> zzepsVar) {
        return new zzbtd(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbsu(this.a.b());
    }
}
