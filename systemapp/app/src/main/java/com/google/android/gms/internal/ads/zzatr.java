package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzatr {
    private final List<String> a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final String f;
    private final String g;
    private String h;
    private final int i;
    private final boolean j;
    private final JSONObject k;
    private final String l;
    private final boolean m;
    private final String n;

    public zzatr(JSONObject jSONObject) {
        this.h = jSONObject.optString("url");
        this.b = jSONObject.optString("base_uri");
        this.c = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        this.e = optString != null && (optString.equals("1") || optString.equals("true"));
        this.f = jSONObject.optString("request_id");
        this.d = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.a = optString2 == null ? null : Arrays.asList(optString2.split(","));
        this.i = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.g = jSONObject.optString("fetched_ad");
        this.j = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.k = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.l = jSONObject.optString("analytics_query_ad_event_id");
        this.m = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.n = jSONObject.optString("pool_key");
    }

    public final int a() {
        return this.i;
    }

    public final List<String> b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.h;
    }

    public final boolean f() {
        return this.e;
    }

    public final JSONObject g() {
        return this.k;
    }

    public final String h() {
        return this.n;
    }
}
