package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwr implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzbwp a;

    private zzbwr(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwr a(zzbwp zzbwpVar) {
        return new zzbwr(zzbwpVar);
    }

    public static Set<zzbxy<zzbtj>> b(zzbwp zzbwpVar) {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
