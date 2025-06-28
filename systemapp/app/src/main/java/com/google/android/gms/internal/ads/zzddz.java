package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddz implements zzdfi<zzdfj<Bundle>>, zzdfj<Bundle> {
    private final ApplicationInfo a;
    private final PackageInfo b;

    zzddz(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.a = applicationInfo;
        this.b = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        return zzdyr.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.a.packageName;
        Integer valueOf = this.b == null ? null : Integer.valueOf(this.b.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwq.e().a(zzabf.dd)).booleanValue()) {
            String str2 = this.b != null ? this.b.versionName : null;
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}
