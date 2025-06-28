package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcne extends zzcnc {
    private static final Pattern f = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzcmd a;
    private final zzdzc b;
    private final zzdnn c;
    private final ScheduledExecutorService d;
    private final zzcpx e;

    zzcne(zzbuh zzbuhVar, zzdnn zzdnnVar, zzcmd zzcmdVar, zzdzc zzdzcVar, ScheduledExecutorService scheduledExecutorService, zzcpx zzcpxVar) {
        super(zzbuhVar);
        this.c = zzdnnVar;
        this.a = zzcmdVar;
        this.b = zzdzcVar;
        this.d = scheduledExecutorService;
        this.e = zzcpxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnc
    public final zzdyz<zzdnj> a(zzatl zzatlVar) throws zzcme {
        zzdyz<zzdnj> a = zzdyr.a(this.a.a(zzatlVar), new zzdyb(this) { // from class: com.google.android.gms.internal.ads.vn
            private final zzcne a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a((InputStream) obj);
            }
        }, this.b);
        if (((Boolean) zzwq.e().a(zzabf.cM)).booleanValue()) {
            a = zzdyr.a(zzdyr.a(a, ((Integer) zzwq.e().a(zzabf.cN)).intValue(), TimeUnit.SECONDS, this.d), TimeoutException.class, vp.a, zzazj.f);
        }
        zzdyr.a(a, new vo(this), zzazj.f);
        return a;
    }

    final /* synthetic */ zzdyz a(InputStream inputStream) throws Exception {
        return zzdyr.a(new zzdnj(new zzdne(this.c), zzdnh.a(new InputStreamReader(inputStream))));
    }
}
