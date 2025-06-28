package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhj implements zzdfj<JSONObject> {
    private Bundle a;

    public zzdhj(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.a != null) {
            try {
                com.google.android.gms.ads.internal.util.zzbk.a(com.google.android.gms.ads.internal.util.zzbk.a(jSONObject2, "device"), "play_store").put("parental_controls", zzp.c().a(this.a));
            } catch (JSONException unused) {
                zzd.a("Failed putting parental controls bundle.");
            }
        }
    }
}
