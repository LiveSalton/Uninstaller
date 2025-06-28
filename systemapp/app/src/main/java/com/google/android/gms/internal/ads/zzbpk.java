package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpk implements zzepf<zzbxy<zzbsm>> {
    private final zzbpf a;
    private final zzeps<zzbpo> b;

    private zzbpk(zzbpf zzbpfVar, zzeps<zzbpo> zzepsVar) {
        this.a = zzbpfVar;
        this.b = zzepsVar;
    }

    public static zzbpk a(zzbpf zzbpfVar, zzeps<zzbpo> zzepsVar) {
        return new zzbpk(zzbpfVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
