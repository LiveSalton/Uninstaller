package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfw implements zzdfi<zzdfx> {
    private final zzayc a;
    private final Context b;
    private final ScheduledExecutorService c;
    private final Executor d;

    public zzdfw(zzayc zzaycVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = zzaycVar;
        this.b = context;
        this.c = scheduledExecutorService;
        this.d = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfx> a() {
        if (((Boolean) zzwq.e().a(zzabf.as)).booleanValue()) {
            return zzdyi.c((zzdyz) this.a.a(this.b)).a(aeo.a, this.d).a(((Long) zzwq.e().a(zzabf.at)).longValue(), TimeUnit.MILLISECONDS, this.c).a(Throwable.class, new zzdvm(this) { // from class: com.google.android.gms.internal.ads.aen
                private final zzdfw a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdvm
                public final Object a(Object obj) {
                    return this.a.a((Throwable) obj);
                }
            }, this.d);
        }
        return zzdyr.a((Throwable) new Exception("Did not ad Ad ID into query param."));
    }

    final /* synthetic */ zzdfx a(Throwable th) {
        zzwq.a();
        return new zzdfx(null, zzayr.b(this.b));
    }
}
