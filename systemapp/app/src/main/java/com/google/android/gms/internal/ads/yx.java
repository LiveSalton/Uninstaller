package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class yx implements zzcaf {
    private final Context a;
    private final zzazh b;
    private final zzdyz<zzbyz> c;
    private final zzdmu d;
    private final zzbdv e;

    /* JADX INFO: Access modifiers changed from: private */
    yx(Context context, zzazh zzazhVar, zzdyz<zzbyz> zzdyzVar, zzdmu zzdmuVar, zzbdv zzbdvVar) {
        this.a = context;
        this.b = zzazhVar;
        this.c = zzdyzVar;
        this.d = zzdmuVar;
        this.e = zzbdvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void a(boolean z, Context context) {
        zzbyz zzbyzVar = (zzbyz) zzdyr.b(this.c);
        this.e.b(true);
        zzp.c();
        com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(false, com.google.android.gms.ads.internal.util.zzm.m(this.a), false, 0.0f, -1, z, this.d.J, false);
        zzp.b();
        zzo.a(context, new AdOverlayInfoParcel((zzva) null, zzbyzVar.j(), (com.google.android.gms.ads.internal.overlay.zzu) null, this.e, this.d.L, this.b, this.d.A, zziVar, this.d.r.b, this.d.r.a), true);
    }

    /* synthetic */ yx(Context context, zzazh zzazhVar, zzdyz zzdyzVar, zzdmu zzdmuVar, zzbdv zzbdvVar, yy yyVar) {
        this(context, zzazhVar, zzdyzVar, zzdmuVar, zzbdvVar);
    }
}
