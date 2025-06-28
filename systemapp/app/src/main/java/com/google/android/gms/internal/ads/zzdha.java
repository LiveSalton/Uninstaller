package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdha implements zzdfj<JSONObject> {
    private List<String> a;

    public zzdha(List<String> list) {
        this.a = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.a));
        } catch (JSONException unused) {
            zzd.a("Failed putting experiment ids.");
        }
    }
}
