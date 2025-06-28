package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcko {
    private ConcurrentHashMap<String, String> a;
    private final zzayq b;

    public zzcko(zzckv zzckvVar, zzayq zzayqVar) {
        this.a = new ConcurrentHashMap<>(zzckvVar.a);
        this.b = zzayqVar;
    }

    public final void a(zzdnj zzdnjVar) {
        if (zzdnjVar.b.a.size() > 0) {
            switch (zzdnjVar.b.a.get(0).b) {
                case 1:
                    this.a.put("ad_format", "banner");
                    break;
                case 2:
                    this.a.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.a.put("ad_format", "native_express");
                    break;
                case 4:
                    this.a.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.a.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.a.put("ad_format", "app_open_ad");
                    this.a.put("as", this.b.c() ? "1" : "0");
                    break;
                default:
                    this.a.put("ad_format", "unknown");
                    break;
            }
        }
        if (TextUtils.isEmpty(zzdnjVar.b.b.b)) {
            return;
        }
        this.a.put("gqi", zzdnjVar.b.b.b);
    }

    public final void a(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.a.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.a.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> a() {
        return this.a;
    }
}
