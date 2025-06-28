package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccc implements zzepf<zzcbz> {
    private final zzeps<zzcbr> a;

    private zzccc(zzeps<zzcbr> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzccc a(zzeps<zzcbr> zzepsVar) {
        return new zzccc(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcbz(this.a.b());
    }
}
