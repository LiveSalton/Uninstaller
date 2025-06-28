package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdoo implements zzepf<zzbxy<zzbrz>> {
    private final zzdol a;
    private final zzeps<zzdon> b;

    private zzdoo(zzdol zzdolVar, zzeps<zzdon> zzepsVar) {
        this.a = zzdolVar;
        this.b = zzepsVar;
    }

    public static zzdoo a(zzdol zzdolVar, zzeps<zzdon> zzepsVar) {
        return new zzdoo(zzdolVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
