package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class xz implements zzcaf {
    private final Context a;
    private final zzazh b;
    private final zzdyz<zzbln> c;
    private final zzdmu d;
    private final zzbdv e;
    private final zzdnn f;

    xz(Context context, zzazh zzazhVar, zzdyz<zzbln> zzdyzVar, zzdmu zzdmuVar, zzbdv zzbdvVar, zzdnn zzdnnVar) {
        this.a = context;
        this.b = zzazhVar;
        this.c = zzdyzVar;
        this.d = zzdmuVar;
        this.e = zzbdvVar;
        this.f = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void a(boolean z, Context context) {
        int i;
        zzbln zzblnVar = (zzbln) zzdyr.b(this.c);
        this.e.b(true);
        com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(true, true, false, 0.0f, -1, z, this.d.J, false);
        zzp.b();
        zzbzv j = zzblnVar.j();
        zzbdv zzbdvVar = this.e;
        if (this.d.L != -1) {
            i = this.d.L;
        } else {
            if (this.f.j != null) {
                if (this.f.j.a == 1) {
                    zzp.e();
                    i = 7;
                } else if (this.f.j.a == 2) {
                    zzp.e();
                    i = 6;
                }
            }
            zzd.b("Error setting app open orientation; no targeting orientation available.");
            i = this.d.L;
        }
        zzo.a(context, new AdOverlayInfoParcel((zzva) null, j, (com.google.android.gms.ads.internal.overlay.zzu) null, zzbdvVar, i, this.b, this.d.A, zziVar, this.d.r.b, this.d.r.a), true);
    }
}
