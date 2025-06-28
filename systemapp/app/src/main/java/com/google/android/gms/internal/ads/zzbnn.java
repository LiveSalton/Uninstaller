package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnn implements zzepf<Runnable> {
    private final zzbno a;

    public zzbnn(zzbno zzbnoVar) {
        this.a = zzbnoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Runnable) zzepl.a(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
