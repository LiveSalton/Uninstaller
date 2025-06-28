package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgk implements zzdfi<zzdgl> {
    private final zzayc a;
    private final int b;
    private final Context c;
    private final zzayg d;
    private final ScheduledExecutorService e;
    private final Executor f;

    public zzdgk(zzayc zzaycVar, int i, Context context, zzayg zzaygVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = zzaycVar;
        this.b = i;
        this.c = context;
        this.d = zzaygVar;
        this.e = scheduledExecutorService;
        this.f = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdgl> a() {
        return zzdyi.c(zzdyr.a(new zzdxz(this) { // from class: com.google.android.gms.internal.ads.aeu
            private final zzdgk a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdxz
            public final zzdyz a() {
                return this.a.b();
            }
        }, this.f)).a(aet.a, this.f).a(((Long) zzwq.e().a(zzabf.at)).longValue(), TimeUnit.MILLISECONDS, this.e).a(Exception.class, new zzdvm(this) { // from class: com.google.android.gms.internal.ads.aev
            private final zzdgk a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return this.a.a((Exception) obj);
            }
        }, zzdzb.a());
    }

    final /* synthetic */ zzdgl a(Exception exc) {
        this.d.a(exc, "AttestationTokenSignal");
        return null;
    }

    final /* synthetic */ zzdyz b() throws Exception {
        return this.a.a(this.c, this.b);
    }
}
