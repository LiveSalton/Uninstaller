package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbws implements zzepf<Set<zzbxy<zzbsp>>> {
    private final zzbwp a;

    private zzbws(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbws a(zzbwp zzbwpVar) {
        return new zzbws(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
