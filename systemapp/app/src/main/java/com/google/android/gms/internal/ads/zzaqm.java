package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqm {
    private final zzbdv a;
    private final boolean b;
    private final String c;

    public zzaqm(zzbdv zzbdvVar, Map<String, String> map) {
        this.a = zzbdvVar;
        this.c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.b = true;
        }
    }

    public final void a() {
        int b;
        if (this.a == null) {
            zzd.e("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.c)) {
            zzp.e();
            b = 7;
        } else if ("landscape".equalsIgnoreCase(this.c)) {
            zzp.e();
            b = 6;
        } else {
            b = this.b ? -1 : zzp.e().b();
        }
        this.a.setRequestedOrientation(b);
    }
}
