package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class an implements zzahv<zzbdv> {
    an() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        if (map.keySet().contains("start")) {
            zzbdvVar2.z().i();
        } else if (map.keySet().contains("stop")) {
            zzbdvVar2.z().j();
        } else if (map.keySet().contains("cancel")) {
            zzbdvVar2.z().k();
        }
    }
}
