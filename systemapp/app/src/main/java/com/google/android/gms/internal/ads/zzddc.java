package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddc implements zzdfj<Bundle> {
    private final Bundle a;

    public zzddc(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle a = zzdnx.a(bundle2, "device");
        a.putBundle("android_mem_info", this.a);
        bundle2.putBundle("device", a);
    }
}
