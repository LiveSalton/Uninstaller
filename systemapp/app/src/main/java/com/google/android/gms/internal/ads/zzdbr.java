package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbr implements zzdfj<Bundle> {
    private final double a;
    private final boolean b;

    public zzdbr(double d, boolean z) {
        this.a = d;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle a = zzdnx.a(bundle2, "device");
        bundle2.putBundle("device", a);
        Bundle a2 = zzdnx.a(a, "battery");
        a.putBundle("battery", a2);
        a2.putBoolean("is_charging", this.b);
        a2.putDouble("battery_level", this.a);
    }
}
