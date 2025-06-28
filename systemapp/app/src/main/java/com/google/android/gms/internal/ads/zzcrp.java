package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrp implements zzcqz<zzbll> {
    private final zzblg a;
    private final Context b;
    private final zzchp c;
    private final Executor d;

    public zzcrp(zzblg zzblgVar, Context context, Executor executor, zzchp zzchpVar) {
        this.b = context;
        this.a = zzblgVar;
        this.d = executor;
        this.c = zzchpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbll> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, zzdnjVar, zzdmuVar) { // from class: com.google.android.gms.internal.ads.yb
            private final zzcrp a;
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
        }, this.d);
    }

    final /* synthetic */ zzdyz a(zzdnj zzdnjVar, zzdmu zzdmuVar, Object obj) throws Exception {
        zzvn a = zzdns.a(this.b, zzdmuVar.t);
        zzbdv a2 = this.c.a(a, zzdmuVar, zzdnjVar.b.b, zzdmuVar.T);
        zzbky a3 = this.a.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzbkx(a2.getView(), a2, zzdns.a(a), zzdmuVar.V, zzdmuVar.Z, zzdmuVar.J));
        a3.i().a(a2, false);
        a3.d().a(new zzbsm(a2) { // from class: com.google.android.gms.internal.ads.ya
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
        return zzdyr.a(zzchr.a(a2, zzdmuVar.r.b, zzdmuVar.r.a), new zzdvm(a3) { // from class: com.google.android.gms.internal.ads.yc
            private final zzbky a;

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
