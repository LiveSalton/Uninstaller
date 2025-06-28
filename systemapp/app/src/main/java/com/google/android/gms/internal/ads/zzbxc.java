package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxc implements zzepf<Set<zzbxy<AdMetadataListener>>> {
    private final zzbwp a;

    private zzbxc(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxc a(zzbwp zzbwpVar) {
        return new zzbxc(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.e(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
