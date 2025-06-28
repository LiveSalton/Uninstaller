package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckk implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<zzckg> a;
    private final zzeps<Executor> b;

    private zzckk(zzeps<zzckg> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzckk a(zzeps<zzckg> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzckk(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.a.b(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
