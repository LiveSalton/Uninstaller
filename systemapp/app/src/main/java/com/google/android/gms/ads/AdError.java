package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzve;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class AdError {
    private final int a;
    private final String b;
    private final String c;
    private final AdError d;

    public AdError(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = null;
    }

    public AdError(int i, String str, String str2, AdError adError) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = adError;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public final zzve d() {
        return new zzve(this.a, this.b, this.c, this.d == null ? null : new zzve(this.d.a, this.d.b, this.d.c, null, null), null);
    }

    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.a);
        jSONObject.put("Message", this.b);
        jSONObject.put("Domain", this.c);
        if (this.d == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", this.d.e());
        }
        return jSONObject;
    }

    public String toString() {
        try {
            return e().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
