package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsq implements zzcqz<zzbme> {
    private final zzbna a;
    private final zzcrw b;
    private final zzdzc c;
    private final zzbrx d;
    private final ScheduledExecutorService e;

    public zzcsq(zzbna zzbnaVar, zzcrw zzcrwVar, zzbrx zzbrxVar, ScheduledExecutorService scheduledExecutorService, zzdzc zzdzcVar) {
        this.a = zzbnaVar;
        this.b = zzcrwVar;
        this.d = zzbrxVar;
        this.e = scheduledExecutorService;
        this.c = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return zzdnjVar.a.a.a() != null && this.b.a(zzdnjVar, zzdmuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbme> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return this.c.submit(new Callable(this, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.yp
            private final zzcsq a;
            private final zzdnj b;
            private final zzdmu c;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.c(this.b, this.c);
            }
        });
    }

    final /* synthetic */ zzbme c(zzdnj zzdnjVar, zzdmu zzdmuVar) throws Exception {
        return this.a.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzbno(zzdnjVar.a.a.a(), new Runnable(this, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.yr
            private final zzcsq a;
            private final zzdnj b;
            private final zzdmu c;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(this.b, this.c);
            }
        })).a();
    }

    final /* synthetic */ void d(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzdyr.a(zzdyr.a(this.b.b(zzdnjVar, zzdmuVar), zzdmuVar.M, TimeUnit.SECONDS, this.e), new yq(this), this.c);
    }
}
