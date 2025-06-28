package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnb implements zzepf<zzcqz<zzbme>> {
    private final zzeps<Boolean> a;
    private final zzeps<zzcug> b;
    private final zzeps<zzcvy<zzbme, zzdoe, zzcst>> c;

    public zzbnb(zzeps<Boolean> zzepsVar, zzeps<zzcug> zzepsVar2, zzeps<zzcvy<zzbme, zzdoe, zzcst>> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        boolean booleanValue = this.a.b().booleanValue();
        Object obj = (zzcug) this.b.b();
        Object obj2 = (zzcvy) this.c.b();
        if (!booleanValue) {
            obj = obj2;
        }
        return (zzcqz) zzepl.a(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
