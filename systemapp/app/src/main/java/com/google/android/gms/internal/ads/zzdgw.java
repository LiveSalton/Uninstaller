package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgw implements zzdfj<JSONObject> {
    private String a;
    private String b;

    public zzdgw(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "pii");
            a.put("doritos", this.a);
            a.put("doritos_v2", this.b);
        } catch (JSONException unused) {
            zzd.a("Failed putting doritos string.");
        }
    }
}
