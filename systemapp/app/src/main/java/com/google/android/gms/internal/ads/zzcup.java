package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcup<AdT> implements zzdyb<zzdnj, AdT> {
    private final zzdro a;
    private final zzbrx b;
    private final zzdrx c;
    private final zzdrz d;
    private final Executor e;
    private final ScheduledExecutorService f;
    private final zzbod<AdT> g;
    private final zzcum h;
    private final zzcrg i;

    public zzcup(zzdro zzdroVar, zzcum zzcumVar, zzbrx zzbrxVar, zzdrx zzdrxVar, zzdrz zzdrzVar, zzbod<AdT> zzbodVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrg zzcrgVar) {
        this.a = zzdroVar;
        this.h = zzcumVar;
        this.b = zzbrxVar;
        this.c = zzdrxVar;
        this.d = zzdrzVar;
        this.g = zzbodVar;
        this.e = executor;
        this.f = scheduledExecutorService;
        this.i = zzcrgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final /* synthetic */ zzdyz a(zzdnj zzdnjVar) throws Exception {
        boolean z;
        int i;
        zzdnj zzdnjVar2 = zzdnjVar;
        String str = "No ad config.";
        int i2 = zzdnjVar2.b.b.e;
        if (i2 != 0) {
            if (i2 < 200 || i2 >= 300) {
                if (i2 < 300 || i2 >= 400) {
                    StringBuilder sb = new StringBuilder(46);
                    sb.append("Received error HTTP response code: ");
                    sb.append(i2);
                    str = sb.toString();
                } else {
                    str = "No location header to follow redirect or too many redirects.";
                }
            } else if (!((Boolean) zzwq.e().a(zzabf.cL)).booleanValue()) {
                str = "No fill.";
            }
        }
        zzdmw zzdmwVar = zzdnjVar2.b.b.h;
        if (zzdmwVar != null) {
            str = zzdmwVar.a();
        }
        if (((Boolean) zzwq.e().a(zzabf.ey)).booleanValue() && ((i = zzdnjVar2.b.b.e) < 200 || i >= 300)) {
            return zzdyr.a((Throwable) new zzcuq(zzdok.NO_FILL, str));
        }
        zzdqx a = this.a.a((zzdro) zzdrl.RENDER_CONFIG_INIT).a(zzdyr.a((Throwable) new zzcuq(zzdok.NO_FILL, str))).a();
        this.b.a(new zzbjw(zzdnjVar2, this.d, this.c), this.e);
        int i3 = 0;
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            for (zzdmu zzdmuVar : zzdnjVar2.b.a) {
                this.i.a(zzdmuVar);
                Iterator<String> it = zzdmuVar.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    zzcqz<AdT> a2 = this.g.a(zzdmuVar.b, it.next());
                    if (a2 != null && a2.a(zzdnjVar2, zzdmuVar)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.i.a(zzdmuVar, 0L, zzdoi.a(zzdok.INTERNAL_ERROR, null, null));
                }
            }
        }
        for (zzdmu zzdmuVar2 : zzdnjVar2.b.a) {
            Iterator<String> it2 = zzdmuVar2.a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                zzcqz<AdT> a3 = this.g.a(zzdmuVar2.b, next);
                if (a3 != null && a3.a(zzdnjVar2, zzdmuVar2)) {
                    zzdrg<I> a4 = this.a.a((zzdro) zzdrl.RENDER_CONFIG_WATERFALL, (zzdyz) a);
                    StringBuilder sb2 = new StringBuilder(26 + String.valueOf(next).length());
                    sb2.append("render-config-");
                    sb2.append(i3);
                    sb2.append("-");
                    sb2.append(next);
                    a = a4.a(sb2.toString()).a(Throwable.class, new zzdyb(this, zzdnjVar2, zzdmuVar2, a3) { // from class: com.google.android.gms.internal.ads.zl
                        private final zzcup a;
                        private final zzdnj b;
                        private final zzdmu c;
                        private final zzcqz d;

                        {
                            this.a = this;
                            this.b = zzdnjVar2;
                            this.c = zzdmuVar2;
                            this.d = a3;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdyb
                        public final zzdyz a(Object obj) {
                            return this.a.a(this.b, this.c, this.d, (Throwable) obj);
                        }
                    }).a();
                    break;
                }
            }
            i3++;
        }
        return a;
    }

    final /* synthetic */ zzdyz a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcqz zzcqzVar, Throwable th) throws Exception {
        return this.h.a(zzdnjVar.b.b, zzdmuVar, zzdyr.a(zzcqzVar.b(zzdnjVar, zzdmuVar), zzdmuVar.M, TimeUnit.MILLISECONDS, this.f));
    }
}
