package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzabj {
    private String a = zzacu.b.a();
    private Map<String, String> b = new LinkedHashMap();
    private Context c;
    private String d;

    public zzabj(Context context, String str) {
        this.c = null;
        this.d = null;
        this.c = context;
        this.d = str;
        this.b.put("s", "gmob_sdk");
        this.b.put("v", "3");
        this.b.put("os", Build.VERSION.RELEASE);
        this.b.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.b;
        zzp.c();
        map.put("device", com.google.android.gms.ads.internal.util.zzm.b());
        this.b.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.b;
        zzp.c();
        map2.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzm.j(context) ? "1" : "0");
        Future<zzatq> a = zzp.n().a(this.c);
        try {
            this.b.put("network_coarse", Integer.toString(a.get().j));
            this.b.put("network_fine", Integer.toString(a.get().k));
        } catch (Exception e) {
            zzp.g().a(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    final String a() {
        return this.a;
    }

    final Context b() {
        return this.c;
    }

    final String c() {
        return this.d;
    }

    final Map<String, String> d() {
        return this.b;
    }
}
