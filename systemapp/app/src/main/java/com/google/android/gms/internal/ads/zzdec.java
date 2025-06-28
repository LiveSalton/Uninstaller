package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdec implements zzepf<zzdea> {
    private final zzeps<zzdzc> a;
    private final zzeps<Bundle> b;

    private zzdec(zzeps<zzdzc> zzepsVar, zzeps<Bundle> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdec a(zzeps<zzdzc> zzepsVar, zzeps<Bundle> zzepsVar2) {
        return new zzdec(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdea(this.a.b(), this.b.b());
    }
}
