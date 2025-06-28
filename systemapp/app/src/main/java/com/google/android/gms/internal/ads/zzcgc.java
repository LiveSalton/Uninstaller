package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgc implements zzepf<zzcfz> {
    private final zzeps<String> a;
    private final zzeps<zzcbt> b;
    private final zzeps<zzcce> c;

    private zzcgc(zzeps<String> zzepsVar, zzeps<zzcbt> zzepsVar2, zzeps<zzcce> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzcgc a(zzeps<String> zzepsVar, zzeps<zzcbt> zzepsVar2, zzeps<zzcce> zzepsVar3) {
        return new zzcgc(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcfz(this.a.b(), this.b.b(), this.c.b());
    }
}
