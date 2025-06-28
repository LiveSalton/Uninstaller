package com.google.android.gms.ads.nonagon.transaction.omid;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public class OmidSettings {
    private final JSONObject a;

    public OmidSettings(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public OmidMediaType a() {
        switch (this.a.optInt("media_type", -1)) {
            case 0:
                return OmidMediaType.DISPLAY;
            case 1:
                return OmidMediaType.VIDEO;
            default:
                return OmidMediaType.UNKNOWN;
        }
    }

    public String b() {
        if (a.a[a().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
