package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxg implements zzepf<zzbwp> {
    private final zzbwp a;

    private zzbxg(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxg a(zzbwp zzbwpVar) {
        return new zzbxg(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzbwp zzbwpVar = this.a;
        if (zzbwpVar == null) {
            throw null;
        }
        return (zzbwp) zzepl.a(zzbwpVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
