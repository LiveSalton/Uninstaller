package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxf implements zzepf<Set<zzbxy<zzqu>>> {
    private final zzbwp a;

    private zzbxf(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxf a(zzbwp zzbwpVar) {
        return new zzbxf(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
