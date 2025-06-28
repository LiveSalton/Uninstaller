package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddg implements zzdfj<Bundle> {
    private final zzdms a;

    public zzddg(zzdms zzdmsVar) {
        this.a = zzdmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.a != null) {
            bundle2.putBoolean("render_in_browser", this.a.a());
            bundle2.putBoolean("disable_ml", this.a.b());
        }
    }
}
