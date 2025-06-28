package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbww implements zzepf<Set<zzbxy<zzva>>> {
    private final zzbwp a;

    private zzbww(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbww a(zzbwp zzbwpVar) {
        return new zzbww(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
