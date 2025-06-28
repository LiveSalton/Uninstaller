package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnw implements zzepf<zzbnt> {
    private final zzeps<zzdmu> a;
    private final zzeps<zzbsl> b;
    private final zzeps<zzbtn> c;

    private zzbnw(zzeps<zzdmu> zzepsVar, zzeps<zzbsl> zzepsVar2, zzeps<zzbtn> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbnw a(zzeps<zzdmu> zzepsVar, zzeps<zzbsl> zzepsVar2, zzeps<zzbtn> zzepsVar3) {
        return new zzbnw(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbnt(this.a.b(), this.b.b(), this.c.b());
    }
}
