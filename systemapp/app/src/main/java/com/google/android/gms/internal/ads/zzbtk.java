package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtk implements zzepf<zzbti> {
    private final zzeps<Set<zzbxy<AdMetadataListener>>> a;

    private zzbtk(zzeps<Set<zzbxy<AdMetadataListener>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbtk a(zzeps<Set<zzbxy<AdMetadataListener>>> zzepsVar) {
        return new zzbtk(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbti(this.a.b());
    }
}
