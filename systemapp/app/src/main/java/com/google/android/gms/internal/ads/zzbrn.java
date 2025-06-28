package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrn implements zzepf<zzdnn> {
    private final zzbrg a;

    private zzbrn(zzbrg zzbrgVar) {
        this.a = zzbrgVar;
    }

    public static zzbrn a(zzbrg zzbrgVar) {
        return new zzbrn(zzbrgVar);
    }

    public static zzdnn b(zzbrg zzbrgVar) {
        return (zzdnn) zzepl.a(zzbrgVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
