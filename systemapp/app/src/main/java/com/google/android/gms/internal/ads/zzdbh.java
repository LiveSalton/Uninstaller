package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbh implements zzdfj<Bundle> {
    private final boolean a = false;
    private final boolean b = false;
    private final boolean c;

    public zzdbh(boolean z, boolean z2, boolean z3) {
        this.c = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("c_pcbg", false);
        bundle2.putBoolean("c_phbg", false);
        bundle2.putBoolean("ar_lr", this.c);
    }
}
