package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwz implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbwp a;

    private zzbwz(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwz a(zzbwp zzbwpVar) {
        return new zzbwz(zzbwpVar);
    }

    public static Set<zzbxy<zzbtj>> b(zzbwp zzbwpVar) {
        return (Set) zzepl.a(zzbwpVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
