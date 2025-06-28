package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class xb implements zzame<zzcpi> {
    xb() {
    }

    @Override // com.google.android.gms.internal.ads.zzame
    public final /* synthetic */ JSONObject a(zzcpi zzcpiVar) throws JSONException {
        zzcpi zzcpiVar2 = zzcpiVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcpiVar2.c.c());
        jSONObject2.put("signals", zzcpiVar2.b);
        jSONObject3.put("body", zzcpiVar2.a.c);
        jSONObject3.put("headers", zzp.c().a(zzcpiVar2.a.b));
        jSONObject3.put("response_code", zzcpiVar2.a.a);
        jSONObject3.put("latency", zzcpiVar2.a.d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcpiVar2.c.g());
        return jSONObject;
    }
}
