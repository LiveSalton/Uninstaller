package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbro implements zzepf<zzbrp> {
    private final zzeps<zzdmu> a;
    private final zzeps<String> b;
    private final zzeps<zzcrg> c;

    private zzbro(zzeps<zzdmu> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzcrg> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbro a(zzeps<zzdmu> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzcrg> zzepsVar3) {
        return new zzbro(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbrp(this.a.b(), this.b.b(), this.c.b());
    }
}
