package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhi implements zzdfi<zzdhj> {
    private zzarr a;
    private ScheduledExecutorService b;
    private Context c;

    public zzdhi(zzarr zzarrVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.a = zzarrVar;
        this.b = scheduledExecutorService;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdhj> a() {
        return zzdyr.a(zzdyr.a(this.a.a(this.c), ((Long) zzwq.e().a(zzabf.bQ)).longValue(), TimeUnit.MILLISECONDS, this.b), afd.a, zzazj.a);
    }
}
