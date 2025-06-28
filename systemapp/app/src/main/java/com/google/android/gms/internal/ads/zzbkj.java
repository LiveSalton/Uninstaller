package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkj implements zzepf<zzbki> {
    private final zzeps<zzamq> a;
    private final zzeps<zzbkg> b;
    private final zzeps<Executor> c;
    private final zzeps<zzbjz> d;
    private final zzeps<Clock> e;

    private zzbkj(zzeps<zzamq> zzepsVar, zzeps<zzbkg> zzepsVar2, zzeps<Executor> zzepsVar3, zzeps<zzbjz> zzepsVar4, zzeps<Clock> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzbkj a(zzeps<zzamq> zzepsVar, zzeps<zzbkg> zzepsVar2, zzeps<Executor> zzepsVar3, zzeps<zzbjz> zzepsVar4, zzeps<Clock> zzepsVar5) {
        return new zzbkj(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbki(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
