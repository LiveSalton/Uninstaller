package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbwu implements zzepf<Set<zzbxy<zzp>>> {
    private final zzbwp a;

    private zzbwu(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbwu a(zzbwp zzbwpVar) {
        return new zzbwu(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.k(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
