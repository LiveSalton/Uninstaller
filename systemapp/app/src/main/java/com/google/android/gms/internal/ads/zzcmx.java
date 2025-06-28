package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmx {
    private final ScheduledExecutorService a;
    private final zzdzc b;
    private final zzcnw c;
    private final zzeoz<zzcou> d;

    public zzcmx(ScheduledExecutorService scheduledExecutorService, zzdzc zzdzcVar, zzcnw zzcnwVar, zzeoz<zzcou> zzeozVar) {
        this.a = scheduledExecutorService;
        this.b = zzdzcVar;
        this.c = zzcnwVar;
        this.d = zzeozVar;
    }

    public final zzdyz<InputStream> a(zzatl zzatlVar) {
        zzdyz<InputStream> a;
        String str = zzatlVar.d;
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.e(str)) {
            a = zzdyr.a((Throwable) new zzcoh(zzdok.INTERNAL_ERROR));
        } else {
            a = this.c.a(zzatlVar);
        }
        return zzdyi.c((zzdyz) a).a(((Integer) zzwq.e().a(zzabf.cN)).intValue(), TimeUnit.SECONDS, this.a).a(Throwable.class, new zzdyb(this, zzatlVar, Binder.getCallingUid()) { // from class: com.google.android.gms.internal.ads.vl
            private final zzcmx a;
            private final zzatl b;
            private final int c;

            {
                this.a = this;
                this.b = zzatlVar;
                this.c = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (Throwable) obj);
            }
        }, this.b);
    }

    final /* synthetic */ zzdyz a(zzatl zzatlVar, int i, Throwable th) throws Exception {
        return this.d.b().c(zzatlVar, i);
    }
}
