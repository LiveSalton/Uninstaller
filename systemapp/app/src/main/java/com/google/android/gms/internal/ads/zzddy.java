package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddy implements zzepf<zzddz> {
    private final zzeps<ApplicationInfo> a;
    private final zzeps<PackageInfo> b;

    private zzddy(zzeps<ApplicationInfo> zzepsVar, zzeps<PackageInfo> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzddy a(zzeps<ApplicationInfo> zzepsVar, zzeps<PackageInfo> zzepsVar2) {
        return new zzddy(zzepsVar, zzepsVar2);
    }

    public static zzddz a(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzddz(applicationInfo, packageInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
