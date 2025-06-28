package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmq implements zzepf<zzbme> {
    private final zzbmh a;
    private final zzeps<ls> b;

    public zzbmq(zzbmh zzbmhVar, zzeps<ls> zzepsVar) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
    }

    public static zzbme a(zzbmh zzbmhVar, Object obj) {
        return (zzbme) zzepl.a((ls) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
