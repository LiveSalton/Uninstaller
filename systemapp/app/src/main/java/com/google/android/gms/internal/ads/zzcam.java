package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcam implements zzepf<zzcaj> {
    private final zzeps<zzbso> a;

    private zzcam(zzeps<zzbso> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcam a(zzeps<zzbso> zzepsVar) {
        return new zzcam(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcaj(this.a.b());
    }
}
