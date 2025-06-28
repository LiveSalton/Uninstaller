package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdaj implements zzepf<zzdae> {
    private final zzeps<zzdyz<String>> a;
    private final zzeps<Executor> b;

    private zzdaj(zzeps<zzdyz<String>> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdaj a(zzeps<zzdyz<String>> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzdaj(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdae(this.a.b(), this.b.b());
    }
}
