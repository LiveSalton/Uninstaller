package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzanh {
    public final List<zzane> a;
    private final long b;
    private final List<String> c;
    private final List<String> d;
    private final List<String> e;
    private final List<String> f;
    private final List<String> g;
    private final boolean h;
    private final String i;
    private final long j;
    private final String k;
    private final int l;
    private final int m;
    private final long n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private int s;
    private int t;
    private boolean u;

    public zzanh(JSONObject jSONObject) throws JSONException {
        if (zzd.a(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzd.a(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzane zzaneVar = new zzane(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzaneVar.c)) {
                    this.u = true;
                }
                arrayList.add(zzaneVar);
                if (i < 0) {
                    Iterator<String> it = zzaneVar.a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.s = i;
        this.t = jSONArray.length();
        this.a = Collections.unmodifiableList(arrayList);
        this.i = jSONObject.optString("qdata");
        this.m = jSONObject.optInt("fs_model_type", -1);
        this.n = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject == null) {
            this.b = -1L;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.j = -1L;
            this.k = null;
            this.l = 0;
            this.o = false;
            this.h = false;
            this.p = false;
            this.q = false;
            this.r = false;
            return;
        }
        this.b = optJSONObject.optLong("ad_network_timeout_millis", -1L);
        zzp.u();
        this.c = zzang.a(optJSONObject, "click_urls");
        zzp.u();
        this.d = zzang.a(optJSONObject, "imp_urls");
        zzp.u();
        this.e = zzang.a(optJSONObject, "downloaded_imp_urls");
        zzp.u();
        this.f = zzang.a(optJSONObject, "nofill_urls");
        zzp.u();
        this.g = zzang.a(optJSONObject, "remote_ping_urls");
        this.h = optJSONObject.optBoolean("render_in_browser", false);
        long optLong = optJSONObject.optLong("refresh", -1L);
        this.j = optLong > 0 ? 1000 * optLong : -1L;
        zzava a = zzava.a(optJSONObject.optJSONArray("rewards"));
        if (a == null) {
            this.k = null;
            this.l = 0;
        } else {
            this.k = a.a;
            this.l = a.b;
        }
        this.o = optJSONObject.optBoolean("use_displayed_impression", false);
        this.p = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        this.q = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
        this.r = optJSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
