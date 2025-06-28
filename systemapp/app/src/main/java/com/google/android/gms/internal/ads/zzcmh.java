package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmh implements zzepf<zzcmd> {
    private final zzeps<zzdzc> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzcns> c;
    private final zzeps<zzcou> d;

    private zzcmh(zzeps<zzdzc> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcns> zzepsVar3, zzeps<zzcou> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzcmh a(zzeps<zzdzc> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcns> zzepsVar3, zzeps<zzcou> zzepsVar4) {
        return new zzcmh(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcmd(this.a.b(), this.b.b(), this.c.b(), zzepg.b(this.d));
    }
}
