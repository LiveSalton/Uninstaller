package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class aey implements zzdfi<zzdfj<JSONObject>> {
    private final JSONObject a;

    aey(Context context) {
        this.a = zzatx.a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<JSONObject>> a() {
        return zzdyr.a(new zzdfj(this) { // from class: com.google.android.gms.internal.ads.aex
            private final aey a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj) {
                this.a.a((JSONObject) obj);
            }
        });
    }

    final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.a);
        } catch (JSONException unused) {
            zzd.a("Failed putting version constants.");
        }
    }
}
