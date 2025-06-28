package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxa implements zzepf<Set<zzbxy<zzbru>>> {
    private final zzbwp a;

    private zzbxa(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxa a(zzbwp zzbwpVar) {
        return new zzbxa(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
