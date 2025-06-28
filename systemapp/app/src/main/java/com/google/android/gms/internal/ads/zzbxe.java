package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxe implements zzepf<Set<zzbxy<zzbub>>> {
    private final zzbwp a;

    private zzbxe(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxe a(zzbwp zzbwpVar) {
        return new zzbxe(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.j(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
