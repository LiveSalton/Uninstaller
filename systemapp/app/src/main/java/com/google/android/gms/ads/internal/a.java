package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class a implements zzdyb {
    static final zzdyb a = new a();

    private a() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzp.g().h().c(jSONObject.getString("appSettingsJson"));
        }
        return zzdyr.a((Object) null);
    }
}
