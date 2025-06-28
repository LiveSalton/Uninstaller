package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class wr implements zzdqv {
    static final zzdqv a = new wr();

    private wr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdqv
    public final Object a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzd.a("Ad request signals:");
        zzd.a(jSONObject.toString(2));
        return jSONObject;
    }
}
