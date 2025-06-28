package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrw implements zzcqz<zzbme> {
    private final zzbna a;
    private final Context b;
    private final zzchp c;
    private final zzdnn d;
    private final Executor e;
    private final zzdvm<zzdmu, com.google.android.gms.ads.internal.util.zzag> f;

    public zzcrw(zzbna zzbnaVar, Context context, Executor executor, zzchp zzchpVar, zzdnn zzdnnVar, zzdvm<zzdmu, com.google.android.gms.ads.internal.util.zzag> zzdvmVar) {
        this.b = context;
        this.a = zzbnaVar;
        this.e = executor;
        this.c = zzchpVar;
        this.d = zzdnnVar;
        this.f = zzdvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbme> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.yd
            private final zzcrw a;
            private final zzdnj b;
            private final zzdmu c;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, obj);
            }
        }, this.e);
    }

    final /* synthetic */ void a(zzbdv zzbdvVar) {
        zzbdvVar.t();
        zzbep d = zzbdvVar.d();
        if (this.d.b == null || d == null) {
            return;
        }
        d.a(this.d.b);
    }

    final /* synthetic */ zzdyz a(zzdnj zzdnjVar, zzdmu zzdmuVar, Object obj) throws Exception {
        View zzcigVar;
        zzvn a = zzdns.a(this.b, zzdmuVar.t);
        zzbdv a2 = this.c.a(a, zzdmuVar, zzdnjVar.b.b, zzdmuVar.T);
        a2.f(zzdmuVar.Q);
        if (((Boolean) zzwq.e().a(zzabf.ec)).booleanValue() && zzdmuVar.ac) {
            zzcigVar = zzbns.a(this.b, a2.getView(), zzdmuVar);
        } else {
            zzcigVar = new zzcig(this.b, a2.getView(), this.f.a(zzdmuVar));
        }
        zzbna zzbnaVar = this.a;
        zzbos zzbosVar = new zzbos(zzdnjVar, zzdmuVar, null);
        a2.getClass();
        zzbmd a3 = zzbnaVar.a(zzbosVar, new zzbmh(zzcigVar, a2, yf.a(a2), zzdns.a(a)));
        a3.i().a(a2, false);
        a3.d().a(new zzbsm(a2) { // from class: com.google.android.gms.internal.ads.ye
            private final zzbdv a;

            {
                this.a = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzbsm
            public final void b() {
                zzbdv zzbdvVar = this.a;
                if (zzbdvVar.z() != null) {
                    zzbdvVar.z().h();
                }
            }
        }, zzazj.f);
        a3.i();
        zzdyz<?> a4 = zzchr.a(a2, zzdmuVar.r.b, zzdmuVar.r.a);
        if (zzdmuVar.H) {
            a2.getClass();
            a4.a(yh.a(a2), this.e);
        }
        a4.a(new Runnable(this, a2) { // from class: com.google.android.gms.internal.ads.yg
            private final zzcrw a;
            private final zzbdv b;

            {
                this.a = this;
                this.b = a2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        }, this.e);
        return zzdyr.a(a4, new zzdvm(a3) { // from class: com.google.android.gms.internal.ads.yi
            private final zzbmd a;

            {
                this.a = a3;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj2) {
                return this.a.h();
            }
        }, zzazj.f);
    }
}
