package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdav implements zzepf<zzdat> {
    private final zzeps<String> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzciq> c;

    private zzdav(zzeps<String> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzciq> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdav a(zzeps<String> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzciq> zzepsVar3) {
        return new zzdav(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdat(this.a.b(), this.b.b(), this.c.b());
    }
}
