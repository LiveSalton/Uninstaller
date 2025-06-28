package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdft implements zzdfj<Bundle> {
    private final String a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;

    public zzdft(String str, int i, int i2, int i3, boolean z, int i4) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdnx.a(bundle2, "carrier", this.a, !TextUtils.isEmpty(this.a));
        zzdnx.a(bundle2, "cnt", Integer.valueOf(this.b), this.b != -2);
        bundle2.putInt("gnt", this.c);
        bundle2.putInt("pt", this.d);
        Bundle a = zzdnx.a(bundle2, "device");
        bundle2.putBundle("device", a);
        Bundle a2 = zzdnx.a(a, "network");
        a.putBundle("network", a2);
        a2.putInt("active_network_state", this.f);
        a2.putBoolean("active_network_metered", this.e);
    }
}
