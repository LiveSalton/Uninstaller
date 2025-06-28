package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccw implements zzepf<zzcce> {
    private final zzccq a;

    private zzccw(zzccq zzccqVar) {
        this.a = zzccqVar;
    }

    public static zzccw a(zzccq zzccqVar) {
        return new zzccw(zzccqVar);
    }

    public static zzcce b(zzccq zzccqVar) {
        return (zzcce) zzepl.a(zzccqVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
