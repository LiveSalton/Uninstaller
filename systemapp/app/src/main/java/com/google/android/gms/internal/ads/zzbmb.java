package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmb implements zzepf<zzbua> {
    private final zzeps<ScheduledExecutorService> a;
    private final zzeps<Clock> b;

    public zzbmb(zzeps<ScheduledExecutorService> zzepsVar, zzeps<Clock> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbua a(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbua) zzepl.a(new zzbua(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
