package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxi implements zzepf<Set<zzbxy<zzbyd>>> {
    private final zzbwp a;

    private zzbxi(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxi a(zzbwp zzbwpVar) {
        return new zzbxi(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
