package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhf implements zzdfj<JSONObject> {
    private final Location a;

    public zzdhf(Location location) {
        this.a = location;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.a != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float valueOf = Float.valueOf(this.a.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.a.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.a.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.a.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", valueOf);
                jSONObject3.put("lat", valueOf3);
                jSONObject3.put("long", valueOf4);
                jSONObject3.put("time", valueOf2);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e) {
            zzd.a("Failed adding location to the request JSON.", e);
        }
    }
}
