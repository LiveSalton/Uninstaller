package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmu implements zzepf<zzbxy<zzbtj>> {
    private final zzbmh a;
    private final zzeps<zzbnr> b;

    public zzbmu(zzbmh zzbmhVar, zzeps<zzbnr> zzepsVar) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
    }

    public static zzbxy<zzbtj> a(zzbmh zzbmhVar, zzbnr zzbnrVar) {
        return (zzbxy) zzepl.a(new zzbxy(zzbnrVar, zzazj.e), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
