package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpy implements zzepf<zzcpv> {
    private final zzeps<zzcqe> a;

    private zzcpy(zzeps<zzcqe> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcpy a(zzeps<zzcqe> zzepsVar) {
        return new zzcpy(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcpv(this.a.b());
    }
}
