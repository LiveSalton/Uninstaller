package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcij implements zzepf<zzbxy<zzbsp>> {
    private final zzcik a;
    private final zzeps<zzcii> b;

    private zzcij(zzcik zzcikVar, zzeps<zzcii> zzepsVar) {
        this.a = zzcikVar;
        this.b = zzepsVar;
    }

    public static zzcij a(zzcik zzcikVar, zzeps<zzcii> zzepsVar) {
        return new zzcij(zzcikVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.e), "Cannot return null from a non-@Nullable @Provides method");
    }
}
