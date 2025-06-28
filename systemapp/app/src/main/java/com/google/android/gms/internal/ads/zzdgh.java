package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgh implements zzdfj<JSONObject> {
    private final JSONObject a;

    public zzdgh(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "content_info");
            JSONObject jSONObject2 = this.a;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzd.a("Failed putting app indexing json.");
        }
    }
}
