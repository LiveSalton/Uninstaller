package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbor implements zzepf<zzdmu> {
    private final zzbos a;

    private zzbor(zzbos zzbosVar) {
        this.a = zzbosVar;
    }

    public static zzbor a(zzbos zzbosVar) {
        return new zzbor(zzbosVar);
    }

    public static zzdmu b(zzbos zzbosVar) {
        return (zzdmu) zzepl.a(zzbosVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
