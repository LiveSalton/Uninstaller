package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdel implements zzdfj<Bundle> {
    private final String a;

    public zzdel(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("rtb", this.a);
    }
}
