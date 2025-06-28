package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcqb implements zzepf<zzcqc> {
    private final zzeps<zzcpx> a;

    private zzcqb(zzeps<zzcpx> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcqb a(zzeps<zzcpx> zzepsVar) {
        return new zzcqb(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcqc(this.a.b());
    }
}
