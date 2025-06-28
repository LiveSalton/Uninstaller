package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class LoadAdError extends AdError {
    private final ResponseInfo a;

    public LoadAdError(int i, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.a = responseInfo;
    }

    public final ResponseInfo f() {
        if (((Boolean) zzwq.e().a(zzabf.ez)).booleanValue()) {
            return this.a;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject e() throws JSONException {
        JSONObject e = super.e();
        ResponseInfo f = f();
        if (f == null) {
            e.put("Response Info", "null");
        } else {
            e.put("Response Info", f.c());
        }
        return e;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return e().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
