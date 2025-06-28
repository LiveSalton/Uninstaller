package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class ai implements zzahv<zzbdv> {
    ai() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        if (zzbdvVar2.O() != null) {
            zzbdvVar2.O().t();
        }
        zze v = zzbdvVar2.v();
        if (v != null) {
            v.a();
            return;
        }
        zze w = zzbdvVar2.w();
        if (w != null) {
            w.a();
        } else {
            zzd.e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
