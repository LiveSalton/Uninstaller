package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class aq implements zzahv<zzbdv> {
    aq() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        if (map.keySet().contains("start")) {
            zzbdvVar2.e(true);
        }
        if (map.keySet().contains("stop")) {
            zzbdvVar2.e(false);
        }
    }
}
