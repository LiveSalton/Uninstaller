package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgl implements zzdfj<JSONObject> {
    private String a;

    public zzdgl(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "pii");
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            a.put("attok", this.a);
        } catch (JSONException e) {
            zzd.a("Failed putting attestation token.", e);
        }
    }
}
