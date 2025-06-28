package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdny implements zzepf<zzdnv> {
    private final zzeps<zzcqo> a;
    private final zzeps<zzdrz> b;
    private final zzeps<zzdmu> c;
    private final zzeps<zzdmz> d;

    private zzdny(zzeps<zzcqo> zzepsVar, zzeps<zzdrz> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzdmz> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzdny a(zzeps<zzcqo> zzepsVar, zzeps<zzdrz> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzdmz> zzepsVar4) {
        return new zzdny(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdnv(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
