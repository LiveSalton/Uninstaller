package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbj implements zzepf<JSONObject> {
    private final zzcbh a;

    public zzcbj(zzcbh zzcbhVar) {
        this.a = zzcbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (JSONObject) zzepl.a(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
