package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdaf implements zzepf<zzdac> {
    private final zzeps<zzdnn> a;

    private zzdaf(zzeps<zzdnn> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdaf a(zzeps<zzdnn> zzepsVar) {
        return new zzdaf(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdac(this.a.b());
    }
}
