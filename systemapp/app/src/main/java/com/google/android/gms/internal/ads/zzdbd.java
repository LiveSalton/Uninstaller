package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbd implements zzepf<zzday> {
    private final zzeps<Executor> a;
    private final zzeps<zzayg> b;

    private zzdbd(zzeps<Executor> zzepsVar, zzeps<zzayg> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdbd a(zzeps<Executor> zzepsVar, zzeps<zzayg> zzepsVar2) {
        return new zzdbd(zzepsVar, zzepsVar2);
    }

    public static zzday a(Executor executor, zzayg zzaygVar) {
        return new zzday(executor, zzaygVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
