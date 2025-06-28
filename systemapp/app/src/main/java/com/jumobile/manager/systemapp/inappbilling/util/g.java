package com.jumobile.manager.systemapp.inappbilling.util;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class g {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    public g(String str, String str2) throws JSONException {
        this.a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.b = jSONObject.optString("productId");
        this.c = jSONObject.optString("type");
        this.d = jSONObject.optString("price");
        this.e = jSONObject.optLong("price_amount_micros");
        this.f = jSONObject.optString("price_currency_code");
        this.g = jSONObject.optString("title");
        this.h = jSONObject.optString("description");
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public String toString() {
        return "SkuDetails:" + this.i;
    }
}
