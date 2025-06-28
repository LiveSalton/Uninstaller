package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbg implements zzdfi<zzdbh> {
    private final Context a;
    private final ScheduledExecutorService b;
    private final Executor c;

    public zzdbg(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = context;
        this.b = scheduledExecutorService;
        this.c = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdbh> a() {
        if (!((Boolean) zzwq.e().a(zzabf.dx)).booleanValue()) {
            return zzdyr.a((Object) null);
        }
        zzazq zzazqVar = new zzazq();
        try {
            new zzdux(zzazqVar) { // from class: com.google.android.gms.internal.ads.acu
                private final zzazq a;

                {
                    this.a = zzazqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdux
                public final void a(boolean z) {
                    this.a.b(false);
                }
            }.a(false);
        } catch (Throwable unused) {
            zzd.c("ArCoreApk is not ready.");
            zzazqVar.b(false);
        }
        return zzdyr.a(zzdyr.a(zzdyr.a(zzazqVar, 200L, TimeUnit.MILLISECONDS, this.b), new zzdvm(this) { // from class: com.google.android.gms.internal.ads.act
            private final zzdbg a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return new zzdbh(false, false, ((Boolean) obj).booleanValue());
            }
        }, this.c), Throwable.class, acv.a, this.c);
    }
}
