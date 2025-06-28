package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhe implements zzdfi<zzdhf> {
    private zzamy a;
    private ScheduledExecutorService b;
    private boolean c;
    private ApplicationInfo d;

    public zzdhe(zzamy zzamyVar, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.a = zzamyVar;
        this.b = scheduledExecutorService;
        this.c = z;
        this.d = applicationInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdhf> a() {
        if (!zzacq.b.a().booleanValue()) {
            return zzdyr.a((Throwable) new Exception("Auto Collect Location by gms is disabled."));
        }
        if (!this.c) {
            return zzdyr.a((Throwable) new Exception("Auto Collect Location is false."));
        }
        return zzdyr.a(zzdyr.a(this.a.a(this.d), ((Long) zzwq.e().a(zzabf.bL)).longValue(), TimeUnit.MILLISECONDS, this.b), afc.a, zzazj.a);
    }
}
