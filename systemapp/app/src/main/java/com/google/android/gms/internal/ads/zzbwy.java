package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwy implements zzepf<Set<zzbxy<zzbsi>>> {
    private final zzbwp a;

    private zzbwy(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwy a(zzbwp zzbwpVar) {
        return new zzbwy(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
