package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwx implements zzepf<Set<zzbxy<zzbsm>>> {
    private final zzbwp a;

    private zzbwx(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwx a(zzbwp zzbwpVar) {
        return new zzbwx(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.h(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
