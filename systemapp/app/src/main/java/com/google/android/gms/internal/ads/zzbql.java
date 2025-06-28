package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbql implements zzepf<zzbxy<zzbtj>> {
    private final zzbpx a;
    private final zzeps<mo> b;

    private zzbql(zzbpx zzbpxVar, zzeps<mo> zzepsVar) {
        this.a = zzbpxVar;
        this.b = zzepsVar;
    }

    public static zzbql a(zzbpx zzbpxVar, zzeps<mo> zzepsVar) {
        return new zzbql(zzbpxVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
