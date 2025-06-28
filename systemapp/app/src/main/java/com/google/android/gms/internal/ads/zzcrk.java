package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrk implements zzcqz<zzblv> {
    private final zzblp a;
    private final Context b;
    private final zzchp c;
    private final zzdnn d;
    private final Executor e;
    private final zzazh f;

    public zzcrk(zzblp zzblpVar, Context context, Executor executor, zzchp zzchpVar, zzdnn zzdnnVar, zzazh zzazhVar) {
        this.b = context;
        this.a = zzblpVar;
        this.e = executor;
        this.c = zzchpVar;
        this.d = zzdnnVar;
        this.f = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzblv> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzcif zzcifVar = new zzcif();
        zzdyz<zzblv> a = zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, zzdmuVar, zzdnjVar, zzcifVar) { // from class: com.google.android.gms.internal.ads.xv
            private final zzcrk a;
            private final zzdmu b;
            private final zzdnj c;
            private final zzcif d;

            {
                this.a = this;
                this.b = zzdmuVar;
                this.c = zzdnjVar;
                this.d = zzcifVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, this.d, obj);
            }
        }, this.e);
        zzcifVar.getClass();
        a.a(xx.a(zzcifVar), this.e);
        return a;
    }

    final /* synthetic */ zzdyz a(zzdmu zzdmuVar, zzdnj zzdnjVar, zzcif zzcifVar, Object obj) throws Exception {
        zzdyz<?> a;
        zzbdv a2 = this.c.a(this.d.e, zzdmuVar, zzdnjVar.b.b, zzdmuVar.T);
        a2.f(zzdmuVar.Q);
        zzcifVar.a(this.b, a2.getView());
        zzazq zzazqVar = new zzazq();
        zzbln a3 = this.a.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzbzc(new xz(this.b, this.f, zzazqVar, zzdmuVar, a2, this.d), a2), new zzblq(zzdmuVar.V));
        a3.i().a(a2, false);
        zzazqVar.b(a3);
        a3.d().a(new zzbsm(a2) { // from class: com.google.android.gms.internal.ads.xw
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
        if (((Boolean) zzwq.e().a(zzabf.dx)).booleanValue() && zzdmuVar.T) {
            a = zzdyr.a((Object) null);
        } else {
            a3.i();
            a = zzchr.a(a2, zzdmuVar.r.b, zzdmuVar.r.a);
        }
        return zzdyr.a(a, new zzdvm(this, a2, zzdmuVar, a3) { // from class: com.google.android.gms.internal.ads.xy
            private final zzcrk a;
            private final zzbdv b;
            private final zzdmu c;
            private final zzbln d;

            {
                this.a = this;
                this.b = a2;
                this.c = zzdmuVar;
                this.d = a3;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj2) {
                zzbdv zzbdvVar = this.b;
                zzdmu zzdmuVar2 = this.c;
                zzbln zzblnVar = this.d;
                if (zzdmuVar2.H) {
                    zzbdvVar.N();
                }
                zzbdvVar.t();
                if (((Boolean) zzwq.e().a(zzabf.ai)).booleanValue()) {
                    zzp.e();
                    com.google.android.gms.ads.internal.util.zzu.a(zzbdvVar);
                }
                return zzblnVar.h();
            }
        }, this.e);
    }
}
