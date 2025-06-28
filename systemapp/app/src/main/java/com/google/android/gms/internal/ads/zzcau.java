package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcau implements zzepf<zzccl> {
    private final zzcap a;

    private zzcau(zzcap zzcapVar) {
        this.a = zzcapVar;
    }

    public static zzcau a(zzcap zzcapVar) {
        return new zzcau(zzcapVar);
    }

    public static zzccl b(zzcap zzcapVar) {
        return (zzccl) zzepl.a(zzcapVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
