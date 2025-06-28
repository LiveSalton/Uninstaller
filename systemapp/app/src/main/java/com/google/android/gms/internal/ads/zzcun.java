package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcun implements zzepf<zzcuo> {
    private final zzeps<zzdoa> a;
    private final zzeps<zzcil> b;
    private final zzeps<zzckq> c;

    private zzcun(zzeps<zzdoa> zzepsVar, zzeps<zzcil> zzepsVar2, zzeps<zzckq> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzcun a(zzeps<zzdoa> zzepsVar, zzeps<zzcil> zzepsVar2, zzeps<zzckq> zzepsVar3) {
        return new zzcun(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcuo(this.a.b(), this.b.b(), this.c.b());
    }
}
