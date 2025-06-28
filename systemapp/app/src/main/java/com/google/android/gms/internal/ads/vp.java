package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class vp implements zzdyb {
    static final zzdyb a = new vp();

    private vp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz a(Object obj) {
        return zzdyr.a((Throwable) new zzcme(zzdok.NETWORK_ERROR, "Timed out waiting for ad response."));
    }
}
