package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdov implements zzepf<zzdor> {
    private final zzdot a;
    private final zzeps<zzdop> b;
    private final zzeps<String> c;

    private zzdov(zzdot zzdotVar, zzeps<zzdop> zzepsVar, zzeps<String> zzepsVar2) {
        this.a = zzdotVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzdov a(zzdot zzdotVar, zzeps<zzdop> zzepsVar, zzeps<String> zzepsVar2) {
        return new zzdov(zzdotVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdor) zzepl.a(this.b.b().a(this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
