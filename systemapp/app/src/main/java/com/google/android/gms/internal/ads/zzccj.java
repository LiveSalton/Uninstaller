package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccj implements zzepf<zzcch> {
    private final zzeps<zzdmu> a;
    private final zzeps<JSONObject> b;

    public zzccj(zzeps<zzdmu> zzepsVar, zzeps<JSONObject> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcch(this.a.b(), this.b.b());
    }
}
