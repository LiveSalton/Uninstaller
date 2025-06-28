package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcws implements zzepf<zzcwq> {
    private final zzcwq a;

    private zzcws(zzcwq zzcwqVar) {
        this.a = zzcwqVar;
    }

    public static zzcws a(zzcwq zzcwqVar) {
        return new zzcws(zzcwqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzcwq zzcwqVar = this.a;
        if (zzcwqVar == null) {
            throw null;
        }
        return (zzcwq) zzepl.a(zzcwqVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
