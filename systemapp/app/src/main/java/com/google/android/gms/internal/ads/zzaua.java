package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaua implements zzatp {
    private zzamd<JSONObject, JSONObject> a;
    private zzamd<JSONObject, JSONObject> b;

    public zzaua(Context context) {
        this.a = zzp.p().a(context, zzazh.a()).a("google.afma.request.getAdDictionary", zzamg.a, zzamg.a);
        this.b = zzp.p().a(context, zzazh.a()).a("google.afma.sdkConstants.getSdkConstants", zzamg.a, zzamg.a);
    }

    @Override // com.google.android.gms.internal.ads.zzatp
    public final zzamd<JSONObject, JSONObject> a() {
        return this.b;
    }
}
