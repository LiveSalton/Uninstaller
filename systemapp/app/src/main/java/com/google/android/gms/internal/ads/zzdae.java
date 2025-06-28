package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdae implements zzdfi<Object> {
    private final zzdyz<String> a;
    private final Executor b;

    public zzdae(zzdyz<String> zzdyzVar, Executor executor) {
        this.a = zzdyzVar;
        this.b = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<Object> a() {
        return zzdyr.a(this.a, aci.a, this.b);
    }
}
