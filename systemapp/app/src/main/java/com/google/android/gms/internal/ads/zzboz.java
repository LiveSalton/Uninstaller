package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzboz<T> {
    private final zzcne a;
    private final zzcno b;
    private final zzdnn c;
    private final zzdro d;
    private final zzbjo e;
    private final zzcup<T> f;
    private final zzbwd g;
    private final zzdnj h;
    private final zzcok i;
    private final zzbqz j;
    private final Executor k;
    private final zzcod l;
    private final zzcrg m;

    zzboz(zzcne zzcneVar, zzcno zzcnoVar, zzdnn zzdnnVar, zzdro zzdroVar, zzbjo zzbjoVar, zzcup<T> zzcupVar, zzbwd zzbwdVar, zzdnj zzdnjVar, zzcok zzcokVar, zzbqz zzbqzVar, Executor executor, zzcod zzcodVar, zzcrg zzcrgVar) {
        this.a = zzcneVar;
        this.b = zzcnoVar;
        this.c = zzdnnVar;
        this.d = zzdroVar;
        this.e = zzbjoVar;
        this.f = zzcupVar;
        this.g = zzbwdVar;
        this.h = zzdnjVar;
        this.i = zzcokVar;
        this.j = zzbqzVar;
        this.k = executor;
        this.l = zzcodVar;
        this.m = zzcrgVar;
    }

    private final zzdyz<zzdnj> b(zzdyz<zzatl> zzdyzVar) {
        if (this.h != null) {
            return this.d.a((zzdro) zzdrl.SERVER_TRANSACTION).a(zzdyr.a(this.h)).a();
        }
        zzp.i().a();
        if (this.c.d.s != null) {
            return this.d.a((zzdro) zzdrl.SERVER_TRANSACTION).a(this.b.a()).a();
        }
        if (((Boolean) zzwq.e().a(zzabf.es)).booleanValue()) {
            zzdrg<I> a = this.d.a((zzdro) zzdrl.SERVER_TRANSACTION, (zzdyz) zzdyzVar);
            zzcod zzcodVar = this.l;
            zzcodVar.getClass();
            return a.a((zzdyb<I, O2>) mi.a(zzcodVar)).a();
        }
        return this.d.a((zzdro) zzdrl.SERVER_TRANSACTION, (zzdyz) zzdyzVar).a((zzdyb<I, O2>) this.a).a();
    }

    public final zzdyz<zzdnj> a(zzatl zzatlVar) {
        return b(zzdyr.a(zzatlVar));
    }

    public final zzdyz<zzdnj> a() {
        return b(this.j.b());
    }

    public final zzdyz<T> a(zzdyz<zzdnj> zzdyzVar) {
        if (((Boolean) zzwq.e().a(zzabf.cM)).booleanValue()) {
            return this.d.a((zzdro) zzdrl.RENDERER, (zzdyz) zzdyzVar).a((zzdyb<I, O2>) this.e).a((zzdyb) this.f).a();
        }
        return this.d.a((zzdro) zzdrl.RENDERER, (zzdyz) zzdyzVar).a((zzdyb<I, O2>) this.e).a((zzdyb) this.f).a(((Integer) zzwq.e().a(zzabf.cN)).intValue(), TimeUnit.SECONDS).a();
    }

    public final zzdyz<T> b(zzatl zzatlVar) {
        return a(a(zzatlVar));
    }

    public final zzdyz<T> b() {
        return a(a());
    }

    public final zzbwd c() {
        return this.g;
    }

    public final zzdyz<zzatl> a(zzdpk zzdpkVar) {
        zzdqx a = this.d.a((zzdro) zzdrl.GET_CACHE_KEY, (zzdyz) this.j.b()).a((zzdyb<I, O2>) new zzdyb(this, zzdpkVar) { // from class: com.google.android.gms.internal.ads.mh
            private final zzboz a;
            private final zzdpk b;

            {
                this.a = this;
                this.b = zzdpkVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, (zzatl) obj);
            }
        }).a();
        zzdyr.a(a, new mk(this), this.k);
        return a;
    }

    public final zzdyz<Void> c(zzatl zzatlVar) {
        zzdqx a = this.d.a((zzdro) zzdrl.NOTIFY_CACHE_HIT, (zzdyz) this.i.b(zzatlVar)).a();
        zzdyr.a(a, new mj(this), this.k);
        return a;
    }

    public final zzve a(Throwable th) {
        return zzdoi.a(th, this.m);
    }

    final /* synthetic */ zzdyz a(zzdpk zzdpkVar, zzatl zzatlVar) throws Exception {
        zzatlVar.j = zzdpkVar;
        return this.i.a(zzatlVar);
    }
}
