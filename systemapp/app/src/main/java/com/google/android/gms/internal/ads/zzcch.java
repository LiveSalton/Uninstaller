package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcch extends zzcci {
    private final JSONObject b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public zzcch(zzdmu zzdmuVar, JSONObject jSONObject) {
        super(zzdmuVar);
        this.b = com.google.android.gms.ads.internal.util.zzbk.a(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.c = com.google.android.gms.ads.internal.util.zzbk.a(false, jSONObject, "allow_pub_owned_ad_view");
        this.d = com.google.android.gms.ads.internal.util.zzbk.a(false, jSONObject, "attribution", "allow_pub_rendering");
        this.e = com.google.android.gms.ads.internal.util.zzbk.a(false, jSONObject, "enable_omid");
        if (jSONObject != null && jSONObject.optJSONObject("overlay") != null) {
            z = true;
        }
        this.f = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final JSONObject a() {
        if (this.b != null) {
            return this.b;
        }
        try {
            return new JSONObject(this.a.y);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean c() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean d() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean e() {
        return this.d;
    }
}
