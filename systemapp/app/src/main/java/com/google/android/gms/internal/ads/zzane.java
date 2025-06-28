package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzane {
    public final List<String> a;
    public final String b;
    public final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final List<String> h;
    private final List<String> i;
    private final List<String> j;
    private final List<String> k;
    private final List<String> l;
    private final List<String> m;
    private final List<String> n;
    private final List<String> o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final List<String> u;
    private final String v;
    private final long w;

    public zzane(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.e = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.a = Collections.unmodifiableList(arrayList);
        this.f = jSONObject.optString("allocation_id", null);
        zzp.u();
        this.h = zzang.a(jSONObject, "clickurl");
        zzp.u();
        this.i = zzang.a(jSONObject, "imp_urls");
        zzp.u();
        this.j = zzang.a(jSONObject, "downloaded_imp_urls");
        zzp.u();
        this.l = zzang.a(jSONObject, "fill_urls");
        zzp.u();
        this.m = zzang.a(jSONObject, "video_start_urls");
        zzp.u();
        this.o = zzang.a(jSONObject, "video_complete_urls");
        zzp.u();
        this.n = zzang.a(jSONObject, "video_reward_urls");
        this.p = jSONObject.optString("transaction_id");
        this.q = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzp.u();
            list = zzang.a(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.k = list;
        this.d = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.b = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.g = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.r = jSONObject.optString("html_template", null);
        this.s = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.t = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzp.u();
        this.u = zzang.a(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.v = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.c = jSONObject.optString("response_type", null);
        this.w = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
