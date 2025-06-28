package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagz implements zzahv<Object> {
    private final zzagy a;

    public zzagz(zzagy zzagyVar) {
        this.a = zzagyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        if (this.a == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            zzd.d("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundle = null;
        if (map.containsKey("info")) {
            try {
                bundle = com.google.android.gms.ads.internal.util.zzbk.a(new JSONObject(map.get("info")));
            } catch (JSONException e) {
                zzd.c("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundle == null) {
            zzd.c("Failed to convert ad metadata to Bundle.");
        } else {
            this.a.a(str, bundle);
        }
    }
}
