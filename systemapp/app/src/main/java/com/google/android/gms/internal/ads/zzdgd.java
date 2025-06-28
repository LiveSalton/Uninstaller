package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgd implements zzdfj<JSONObject> {
    private final String a;

    public zzdgd(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.a);
        } catch (JSONException e) {
            zzd.a("Failed putting Ad ID.", e);
        }
    }
}
