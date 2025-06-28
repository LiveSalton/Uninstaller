package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvu implements zzcre<zzapo, zzcst> {
    private final zzcwx a;

    public zzcvu(zzcwx zzcwxVar) {
        this.a = zzcwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzcrb<zzapo, zzcst> a(String str, JSONObject jSONObject) throws zzdnr {
        zzapo b = this.a.b(str);
        if (b == null) {
            return null;
        }
        return new zzcrb<>(b, new zzcst(), str);
    }
}
