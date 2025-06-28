package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class zv implements zzcaf {
    private final Context a;
    private final zzchp b;
    private final zzdnn c;
    private final zzazh d;
    private final zzdmu e;
    private final zzdyz<zzche> f;
    private final zzbdv g;

    /* JADX INFO: Access modifiers changed from: private */
    zv(Context context, zzchp zzchpVar, zzdnn zzdnnVar, zzazh zzazhVar, zzdmu zzdmuVar, zzdyz<zzche> zzdyzVar, zzbdv zzbdvVar) {
        this.a = context;
        this.b = zzchpVar;
        this.c = zzdnnVar;
        this.d = zzazhVar;
        this.e = zzdmuVar;
        this.f = zzdyzVar;
        this.g = zzbdvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void a(boolean z, Context context) {
        zzbdv zzbdvVar;
        zzbdv zzbdvVar2;
        zzche zzcheVar = (zzche) zzdyr.b(this.f);
        try {
            zzdmu zzdmuVar = this.e;
            if (!this.g.P()) {
                zzbdvVar2 = this.g;
            } else {
                if (!((Boolean) zzwq.e().a(zzabf.ak)).booleanValue()) {
                    zzbdvVar2 = this.g;
                } else {
                    zzbdv a = this.b.a(this.c.e);
                    zzaig.a(a, zzcheVar.k());
                    zzcif zzcifVar = new zzcif();
                    zzcifVar.a(this.a, a.getView());
                    zzcheVar.l().a(a, true);
                    a.z().a(new zzbfj(zzcifVar, a) { // from class: com.google.android.gms.internal.ads.zu
                        private final zzcif a;
                        private final zzbdv b;

                        {
                            this.a = zzcifVar;
                            this.b = a;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbfj
                        public final void a(boolean z2) {
                            zzcif zzcifVar2 = this.a;
                            zzbdv zzbdvVar3 = this.b;
                            zzcifVar2.a();
                            zzbdvVar3.t();
                            zzbdvVar3.z().h();
                        }
                    });
                    zzbfg z2 = a.z();
                    a.getClass();
                    z2.a(zw.a(a));
                    a.a(zzdmuVar.r.b, zzdmuVar.r.a, (String) null);
                    zzbdvVar = a;
                    zzbdvVar.b(true);
                    zzp.c();
                    com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(false, com.google.android.gms.ads.internal.util.zzm.m(this.a), false, 0.0f, -1, z, this.e.J, this.e.K);
                    zzp.b();
                    zzo.a(context, new AdOverlayInfoParcel((zzva) null, zzcheVar.j(), (com.google.android.gms.ads.internal.overlay.zzu) null, zzbdvVar, this.e.L, this.d, this.e.A, zziVar, this.e.r.b, this.e.r.a), true);
                }
            }
            zzbdvVar = zzbdvVar2;
            zzbdvVar.b(true);
            zzp.c();
            com.google.android.gms.ads.internal.zzi zziVar2 = new com.google.android.gms.ads.internal.zzi(false, com.google.android.gms.ads.internal.util.zzm.m(this.a), false, 0.0f, -1, z, this.e.J, this.e.K);
            zzp.b();
            zzo.a(context, new AdOverlayInfoParcel((zzva) null, zzcheVar.j(), (com.google.android.gms.ads.internal.overlay.zzu) null, zzbdvVar, this.e.L, this.d, this.e.A, zziVar2, this.e.r.b, this.e.r.a), true);
        } catch (zzbeh e) {
            zzaza.c("", e);
        }
    }

    /* synthetic */ zv(Context context, zzchp zzchpVar, zzdnn zzdnnVar, zzazh zzazhVar, zzdmu zzdmuVar, zzdyz zzdyzVar, zzbdv zzbdvVar, zs zsVar) {
        this(context, zzchpVar, zzdnnVar, zzazhVar, zzdmuVar, zzdyzVar, zzbdvVar);
    }
}
