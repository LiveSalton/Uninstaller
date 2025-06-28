package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxb implements zzepf<Set<zzbxy<zzbto>>> {
    private final zzbwp a;

    private zzbxb(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxb a(zzbwp zzbwpVar) {
        return new zzbxb(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.i(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
