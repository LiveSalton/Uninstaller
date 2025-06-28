package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.location.Location;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcg implements zzdfi<zzdch> {
    zzdnn a;
    private zzamy b;
    private ScheduledExecutorService c;
    private zzf d;
    private ApplicationInfo e;

    public zzdcg(zzamy zzamyVar, ScheduledExecutorService scheduledExecutorService, zzf zzfVar, ApplicationInfo applicationInfo, zzdnn zzdnnVar) {
        this.b = zzamyVar;
        this.c = scheduledExecutorService;
        this.d = zzfVar;
        this.e = applicationInfo;
        this.a = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdch> a() {
        zzdyz a;
        if (!zzacq.a.a().booleanValue()) {
            a = zzdyr.a((Object) null);
        } else if (!this.d.f()) {
            a = zzdyr.a((Object) null);
        } else {
            a = zzdyr.a(zzdyr.a(this.b.a(this.e), ((Long) zzwq.e().a(zzabf.bL)).longValue(), TimeUnit.MILLISECONDS, this.c), Throwable.class, add.a, zzazj.f);
        }
        return zzdyr.a(zzdyr.a(a, new zzdvm(this) { // from class: com.google.android.gms.internal.ads.adb
            private final zzdcg a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                Location location = (Location) obj;
                return location != null ? location : this.a.a.d.k;
            }
        }, this.c), adc.a, zzazj.a);
    }
}
