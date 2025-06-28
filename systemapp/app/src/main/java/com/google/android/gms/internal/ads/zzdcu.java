package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcu implements zzdfj<Bundle> {
    private final String a;
    private final boolean b;

    public zzdcu(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.a);
        if (this.b) {
            bundle2.putString("de", "1");
        }
    }
}
