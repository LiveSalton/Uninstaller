package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class agt<R extends zzbre<? extends zzboc>> {
    private final zzdpd a;
    private final zzdkk b;
    private final zzdkn<R> c;
    private final Executor d;
    private zzdkj e;

    public agt(zzdpd zzdpdVar, zzdkk zzdkkVar, zzdkn<R> zzdknVar, Executor executor) {
        this.a = zzdpdVar;
        this.b = zzdkkVar;
        this.c = zzdknVar;
        this.d = executor;
    }

    public final zzdyz<zzdkj> a() {
        zzdyz a;
        if (this.e != null) {
            return zzdyr.a(this.e);
        }
        if (!zzadf.a.a().booleanValue()) {
            this.e = new zzdkj(null, b(), null);
            a = zzdyr.a(this.e);
        } else {
            a = zzdyi.c((zzdyz) this.c.a(this.b).a(new zzdjv(this.a.a().f)).b().c().a(this.a.a())).a(new agu(this), this.d).a(zzcoh.class, new agv(this), this.d);
        }
        return zzdyr.a(a, ags.a, this.d);
    }

    @Deprecated
    public final zzdpq b() {
        zzdnn a = this.c.a(this.b).b().a();
        return this.a.a(a.d, a.f, a.j);
    }
}
