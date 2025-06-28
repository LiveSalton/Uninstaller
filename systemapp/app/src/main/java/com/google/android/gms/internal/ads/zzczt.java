package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczt implements zzepf<zzdyz<zzczx>> {
    private final zzeps<zzdro> a;
    private final zzeps<zzczs> b;
    private final zzeps<zzbqz> c;

    public zzczt(zzeps<zzdro> zzepsVar, zzeps<zzczs> zzepsVar2, zzeps<zzbqz> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdyz) zzepl.a(this.a.b().a((zzdro) zzdrl.GENERATE_SIGNALS, (zzdyz) this.c.b().b()).a((zzdyb<I, O2>) this.b.b()).a(((Integer) zzwq.e().a(zzabf.cN)).intValue(), TimeUnit.SECONDS).a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
