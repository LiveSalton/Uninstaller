package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwi implements zzepf<zzbwd> {
    private final zzeps<Set<zzbxy<zzbwl>>> a;

    private zzbwi(zzeps<Set<zzbxy<zzbwl>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbwi a(zzeps<Set<zzbxy<zzbwl>>> zzepsVar) {
        return new zzbwi(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbwd(this.a.b());
    }
}
