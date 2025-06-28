package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class ah implements zzahv<zzbdv> {
    ah() {
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        JSONObject b;
        zzbdv zzbdvVar2 = zzbdvVar;
        zzadx L = zzbdvVar2.L();
        if (L == null || (b = L.b()) == null) {
            zzbdvVar2.b("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzbdvVar2.b("nativeAdViewSignalsReady", b);
        }
    }
}
