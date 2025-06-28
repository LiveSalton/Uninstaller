package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrv implements zzepf<zzbrt> {
    private final zzeps<Set<zzbxy<zzva>>> a;

    private zzbrv(zzeps<Set<zzbxy<zzva>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbrv a(zzeps<Set<zzbxy<zzva>>> zzepsVar) {
        return new zzbrv(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbrt(this.a.b());
    }
}
