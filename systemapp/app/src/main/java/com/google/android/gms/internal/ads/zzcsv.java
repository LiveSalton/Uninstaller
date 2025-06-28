package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsv implements zzcqz<zzbyx> {
    private final Context a;
    private final zzchp b;
    private final zzbzx c;
    private final zzdnn d;
    private final Executor e;
    private final zzazh f;

    public zzcsv(Context context, zzazh zzazhVar, zzdnn zzdnnVar, Executor executor, zzbzx zzbzxVar, zzchp zzchpVar) {
        this.a = context;
        this.d = zzdnnVar;
        this.c = zzbzxVar;
        this.e = executor;
        this.f = zzazhVar;
        this.b = zzchpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return (zzdmuVar.r == null || zzdmuVar.r.a == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<zzbyx> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzcif zzcifVar = new zzcif();
        zzdyz<zzbyx> a = zzdyr.a(zzdyr.a((Object) null), new zzdyb(this, zzdmuVar, zzdnjVar, zzcifVar) { // from class: com.google.android.gms.internal.ads.yt
            private final zzcsv a;
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
        a.a(ys.a(zzcifVar), this.e);
        return a;
    }

    final /* synthetic */ zzdyz a(zzdmu zzdmuVar, zzdnj zzdnjVar, zzcif zzcifVar, Object obj) throws Exception {
        zzdyz<?> a;
        zzbdv a2 = this.b.a(this.d.e, zzdmuVar, zzdnjVar.b.b, zzdmuVar.T);
        a2.f(zzdmuVar.Q);
        zzcifVar.a(this.a, a2.getView());
        zzazq zzazqVar = new zzazq();
        zzbyz a3 = this.c.a(new zzbos(zzdnjVar, zzdmuVar, null), new zzbzc(new yx(this.a, this.f, zzazqVar, zzdmuVar, a2), a2));
        zzazqVar.b(a3);
        a3.d().a(new zzbsm(a2) { // from class: com.google.android.gms.internal.ads.yw
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
        a3.k().a(a2, true);
        if (((Boolean) zzwq.e().a(zzabf.dx)).booleanValue() && zzdmuVar.T) {
            a = zzdyr.a((Object) null);
        } else {
            a3.k();
            a = zzchr.a(a2, zzdmuVar.r.b, zzdmuVar.r.a);
        }
        return zzdyr.a(a, new zzdvm(this, a2, zzdmuVar, a3) { // from class: com.google.android.gms.internal.ads.yu
            private final zzcsv a;
            private final zzbdv b;
            private final zzdmu c;
            private final zzbyz d;

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
                zzbyz zzbyzVar = this.d;
                if (zzdmuVar2.H) {
                    zzbdvVar.N();
                }
                zzbdvVar.t();
                if (((Boolean) zzwq.e().a(zzabf.ai)).booleanValue()) {
                    zzp.e();
                    com.google.android.gms.ads.internal.util.zzu.a(zzbdvVar);
                }
                return zzbyzVar.h();
            }
        }, this.e);
    }
}
