package com.jumobile.manager.systemapp.inappbilling.util;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    String a;
    String b;
    String c;
    String d;
    long e;
    int f;
    String g;
    String h;
    String i;
    String j;
    boolean k;

    public e(String str, String str2, String str3) throws JSONException {
        this.a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.b = jSONObject.optString("orderId");
        this.c = jSONObject.optString("packageName");
        this.d = jSONObject.optString("productId");
        this.e = jSONObject.optLong("purchaseTime");
        this.f = jSONObject.optInt("purchaseState");
        this.g = jSONObject.optString("developerPayload");
        this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.k = jSONObject.optBoolean("autoRenewing");
        this.j = str3;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.a + "):" + this.i;
    }
}
