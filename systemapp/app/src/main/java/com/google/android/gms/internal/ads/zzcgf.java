package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgf implements zzepf<zzcgg> {
    private final zzeps<String> a;
    private final zzeps<zzcbt> b;
    private final zzeps<zzcce> c;

    private zzcgf(zzeps<String> zzepsVar, zzeps<zzcbt> zzepsVar2, zzeps<zzcce> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzcgf a(zzeps<String> zzepsVar, zzeps<zzcbt> zzepsVar2, zzeps<zzcce> zzepsVar3) {
        return new zzcgf(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcgg(this.a.b(), this.b.b(), this.c.b());
    }
}
