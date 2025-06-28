package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class aff implements zzdfj {
    static final zzdfj a = new aff();

    private aff() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final void a(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
