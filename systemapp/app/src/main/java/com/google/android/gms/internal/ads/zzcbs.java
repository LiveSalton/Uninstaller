package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbs implements zzepf<zzbkr> {
    private final zzeps<zzqr> a;
    private final zzeps<Executor> b;
    private final zzeps<Context> c;
    private final zzeps<Clock> d;

    public zzcbs(zzeps<zzqr> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<Clock> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzqr b = this.a.b();
        Executor b2 = this.b.b();
        Context b3 = this.c.b();
        return (zzbkr) zzepl.a(new zzbkr(b2, new zzbkg(b3, b), this.d.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
