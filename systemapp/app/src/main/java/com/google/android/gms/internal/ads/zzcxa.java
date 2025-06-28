package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxa implements zzepf<zzcwx> {
    private final zzeps<zzciq> a;

    private zzcxa(zzeps<zzciq> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcxa a(zzeps<zzciq> zzepsVar) {
        return new zzcxa(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcwx(this.a.b());
    }
}
