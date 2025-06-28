package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcih implements zzepf<zzcii> {
    private final zzeps<zzbdv> a;

    private zzcih(zzeps<zzbdv> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcih a(zzeps<zzbdv> zzepsVar) {
        return new zzcih(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcii(this.a.b());
    }
}
