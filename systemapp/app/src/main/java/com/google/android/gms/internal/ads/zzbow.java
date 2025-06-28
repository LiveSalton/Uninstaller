package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbow implements zzepf<zzdnj> {
    private final zzbos a;

    private zzbow(zzbos zzbosVar) {
        this.a = zzbosVar;
    }

    public static zzbow a(zzbos zzbosVar) {
        return new zzbow(zzbosVar);
    }

    public static zzdnj b(zzbos zzbosVar) {
        return (zzdnj) zzepl.a(zzbosVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
