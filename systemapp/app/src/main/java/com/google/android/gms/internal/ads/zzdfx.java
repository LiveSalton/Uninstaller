package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfx implements zzdfj<JSONObject> {
    private final AdvertisingIdClient.Info a;
    private final String b;

    public zzdfx(AdvertisingIdClient.Info info, String str) {
        this.a = info;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject a = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "pii");
            if (this.a != null && !TextUtils.isEmpty(this.a.getId())) {
                a.put("rdid", this.a.getId());
                a.put("is_lat", this.a.isLimitAdTrackingEnabled());
                a.put("idtype", "adid");
            } else {
                a.put("pdid", this.b);
                a.put("pdidtype", "ssaid");
            }
        } catch (JSONException e) {
            zzd.a("Failed putting Ad ID.", e);
        }
    }
}
