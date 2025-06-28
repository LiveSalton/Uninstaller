package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhx implements zzdfj<JSONObject> {
    private final Map<String, Object> a;

    public zzdhx(Map<String, Object> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", zzp.c().a(this.a));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzd.a(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
