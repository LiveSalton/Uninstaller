package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class ao implements zzahv<zzbdv> {
    ao() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        zzbdv zzbdvVar2 = zzbdvVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbdvVar2.a();
        } else if ("resume".equals(str)) {
            zzbdvVar2.b();
        }
    }
}
