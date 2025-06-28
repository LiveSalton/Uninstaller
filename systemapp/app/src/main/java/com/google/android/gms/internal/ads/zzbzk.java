package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzk implements zzepf<zzbxy<zzbtj>> {
    private final zzbzc a;
    private final zzeps<zzcah> b;

    private zzbzk(zzbzc zzbzcVar, zzeps<zzcah> zzepsVar) {
        this.a = zzbzcVar;
        this.b = zzepsVar;
    }

    public static zzbzk a(zzbzc zzbzcVar, zzeps<zzcah> zzepsVar) {
        return new zzbzk(zzbzcVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.e), "Cannot return null from a non-@Nullable @Provides method");
    }
}
