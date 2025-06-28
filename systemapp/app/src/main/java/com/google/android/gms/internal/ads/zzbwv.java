package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwv implements zzepf<Set<zzbxy<zzbrz>>> {
    private final zzbwp a;

    private zzbwv(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwv a(zzbwp zzbwpVar) {
        return new zzbwv(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
