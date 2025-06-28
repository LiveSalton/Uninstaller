package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddx<S extends zzdfj<?>> implements zzdfi<S> {
    private final zzdfi<S> a;
    private final long b;
    private final ScheduledExecutorService c;

    public zzddx(zzdfi<S> zzdfiVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.a = zzdfiVar;
        this.b = j;
        this.c = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<S> a() {
        zzdyz<S> a = this.a.a();
        if (this.b > 0) {
            a = zzdyr.a(a, this.b, TimeUnit.MILLISECONDS, this.c);
        }
        return zzdyr.a(a, Throwable.class, ads.a, zzazj.f);
    }
}
