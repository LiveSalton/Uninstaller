package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqf implements zzepf<zzbxy<zzp>> {
    private final zzbpx a;
    private final zzeps<zzbov> b;

    private zzbqf(zzbpx zzbpxVar, zzeps<zzbov> zzepsVar) {
        this.a = zzbpxVar;
        this.b = zzepsVar;
    }

    public static zzbqf a(zzbpx zzbpxVar, zzeps<zzbov> zzepsVar) {
        return new zzbqf(zzbpxVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
