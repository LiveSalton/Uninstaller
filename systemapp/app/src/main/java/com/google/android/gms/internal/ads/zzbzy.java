package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbzy implements zzepf<zzbzv> {
    private final zzeps<zzbtr> a;
    private final zzeps<zzbxu> b;

    private zzbzy(zzeps<zzbtr> zzepsVar, zzeps<zzbxu> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbzy a(zzeps<zzbtr> zzepsVar, zzeps<zzbxu> zzepsVar2) {
        return new zzbzy(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbzv(this.a.b(), this.b.b());
    }
}
