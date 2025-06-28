package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzj implements zzepf<zzbxy<zzp>> {
    private final zzbzc a;
    private final zzeps<zzcah> b;

    private zzbzj(zzbzc zzbzcVar, zzeps<zzcah> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzj a(zzbzc zzbzcVar, zzeps<zzcah> zzepsVar) {
        return new zzbzj(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.e), "Cannot return null from a non-@Nullable @Provides method");
    }
}
