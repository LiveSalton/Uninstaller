package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbu implements zzepf<zzcbr> {
    private final zzeps<zzcce> a;

    private zzcbu(zzeps<zzcce> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcbu a(zzeps<zzcce> zzepsVar) {
        return new zzcbu(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcbr(this.a.b());
    }
}
