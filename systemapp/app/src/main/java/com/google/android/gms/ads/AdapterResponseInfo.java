package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzvr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class AdapterResponseInfo {
    private final zzvr a;
    private final AdError b;

    private AdapterResponseInfo(zzvr zzvrVar) {
        this.a = zzvrVar;
        this.b = zzvrVar.c == null ? null : zzvrVar.c.a();
    }

    public static AdapterResponseInfo a(zzvr zzvrVar) {
        if (zzvrVar != null) {
            return new AdapterResponseInfo(zzvrVar);
        }
        return null;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.a.a);
        jSONObject.put("Latency", this.a.b);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.a.d.keySet()) {
            jSONObject2.put(str, this.a.d.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        if (this.b == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", this.b.e());
        }
        return jSONObject;
    }

    public final String toString() {
        try {
            return a().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
