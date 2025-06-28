package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzchk implements zzepf<zzcqz<zzchc>> {
    private final zzeps<zzcvy<zzchc, zzdoe, zzcsw>> a;
    private final zzeps<zzcvy<zzchc, zzdoe, zzcst>> b;
    private final zzeps<zzdnn> c;

    public zzchk(zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzepsVar, zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzepsVar2, zzeps<zzdnn> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzcvy<zzchc, zzdoe, zzcsw> b;
        zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzepsVar = this.a;
        zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzepsVar2 = this.b;
        if (tg.a[this.c.b().n.a - 1] == 1) {
            b = zzepsVar.b();
        } else {
            b = zzepsVar2.b();
        }
        return (zzcqz) zzepl.a(b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
