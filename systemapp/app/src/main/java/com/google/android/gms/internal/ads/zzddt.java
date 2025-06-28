package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddt implements zzdfj<Bundle> {
    private final String a;

    public static boolean b(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public zzddt(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        zzdnx.a(bundle, "omid_v", this.a);
    }
}
