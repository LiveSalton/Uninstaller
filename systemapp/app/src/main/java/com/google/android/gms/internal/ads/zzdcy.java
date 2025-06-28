package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcy implements zzdfj<Bundle> {
    private final Boolean a;

    public zzdcy(Boolean bool) {
        this.a = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.a != null) {
            bundle2.putBoolean("hw_accel", this.a.booleanValue());
        }
    }
}
