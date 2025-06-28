package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzctl implements zzcre<zzdoe, zzcst> {
    private final zzciq a;

    public zzctl(zzciq zzciqVar) {
        this.a = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzcrb<zzdoe, zzcst> a(String str, JSONObject jSONObject) throws zzdnr {
        zzdoe a = this.a.a(str, jSONObject);
        if (a == null) {
            return null;
        }
        return new zzcrb<>(a, new zzcst(), str);
    }
}
