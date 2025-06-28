package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzciv {
    public static String a(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray;
        if (!((Boolean) zzwq.e().a(zzabf.aN)).booleanValue() || jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str2)) == null) {
            return "";
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("including");
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("excluding");
                if (a(optJSONArray2, str) && !a(optJSONArray3, str)) {
                    return optJSONObject.optString("effective_ad_unit_id", "");
                }
            }
        }
        return "";
    }

    private static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray == null || str == null) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
            } catch (PatternSyntaxException e) {
                zzp.g().a(e, "RtbAdapterMap.hasAtleastOneRegexMatch");
            }
            if (Pattern.compile(jSONArray.optString(i)).matcher(str).lookingAt()) {
                return true;
            }
        }
        return false;
    }
}
