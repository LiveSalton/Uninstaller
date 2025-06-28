package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwt implements zzepf<Set<zzbxy<zzbvs>>> {
    private final zzbwp a;

    private zzbwt(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwt a(zzbwp zzbwpVar) {
        return new zzbwt(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
