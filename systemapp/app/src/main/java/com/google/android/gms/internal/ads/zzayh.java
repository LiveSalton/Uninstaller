package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzayh {
    private final long a;
    private final List<String> b = new ArrayList();
    private final List<String> c = new ArrayList();
    private final Map<String, zzanh> d = new HashMap();
    private String e;
    private String f;
    private JSONObject g;
    private boolean h;

    public zzayh(String str, long j) {
        JSONObject optJSONObject;
        this.h = false;
        this.f = str;
        this.a = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.g = new JSONObject(str);
            if (this.g.optInt("status", -1) != 1) {
                this.h = false;
                zzd.e("App settings could not be fetched successfully.");
                return;
            }
            this.h = true;
            this.e = this.g.optString("app_id");
            JSONArray optJSONArray = this.g.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("format");
                    String optString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if ("interstitial".equalsIgnoreCase(optString)) {
                            this.c.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.d.put(optString2, new zzanh(optJSONObject));
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = this.g.optJSONArray("persistable_banner_ad_unit_ids");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    this.b.add(optJSONArray2.optString(i2));
                }
            }
        } catch (JSONException e) {
            zzd.d("Exception occurred while processing app setting json", e);
            zzp.g().a(e, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long a() {
        return this.a;
    }

    public final boolean b() {
        return this.h;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final Map<String, zzanh> e() {
        return this.d;
    }

    public final JSONObject f() {
        return this.g;
    }
}
