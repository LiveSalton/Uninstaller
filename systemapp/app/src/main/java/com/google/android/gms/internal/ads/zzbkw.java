package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkw implements zzepf<JSONObject> {
    private final zzeps<zzdmu> a;

    private zzbkw(zzeps<zzdmu> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbkw a(zzeps<zzdmu> zzepsVar) {
        return new zzbkw(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return zzbkt.a(this.a.b());
    }
}
