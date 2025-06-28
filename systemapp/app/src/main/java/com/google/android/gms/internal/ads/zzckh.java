package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckh implements zzepf<zzbxy<zzbrz>> {
    private final zzeps<zzckg> a;
    private final zzeps<Executor> b;

    private zzckh(zzeps<zzckg> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzckh a(zzeps<zzckg> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzckh(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.a.b(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
