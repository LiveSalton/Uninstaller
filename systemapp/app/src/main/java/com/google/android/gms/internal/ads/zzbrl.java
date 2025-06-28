package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrl implements zzepf<String> {
    private final zzbrg a;
    private final zzeps<zzbpo> b;

    private zzbrl(zzbrg zzbrgVar, zzeps<zzbpo> zzepsVar) {
        this.a = zzbrgVar;
        this.b = zzepsVar;
    }

    public static zzbrl a(zzbrg zzbrgVar, zzeps<zzbpo> zzepsVar) {
        return new zzbrl(zzbrgVar, zzepsVar);
    }

    public static String a(zzbrg zzbrgVar, zzbpo zzbpoVar) {
        return (String) zzepl.a(zzbpoVar.i(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
