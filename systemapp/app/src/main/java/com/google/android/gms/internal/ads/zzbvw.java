package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbvw implements zzepf<zzbvv> {
    private final zzeps<Set<zzbxy<zzbvz>>> a;

    private zzbvw(zzeps<Set<zzbxy<zzbvz>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbvw a(zzeps<Set<zzbxy<zzbvz>>> zzepsVar) {
        return new zzbvw(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbvv(this.a.b());
    }
}
