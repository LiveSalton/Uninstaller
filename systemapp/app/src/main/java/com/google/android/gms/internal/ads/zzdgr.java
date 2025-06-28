package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgr implements zzdfj<JSONObject> {
    private JSONObject a;

    public zzdgr(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.a);
        } catch (JSONException unused) {
            zzd.a("Unable to get cache_state");
        }
    }
}
