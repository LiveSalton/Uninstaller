package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmu implements zzepf<PackageInfo> {
    private final zzeps<Context> a;
    private final zzeps<ApplicationInfo> b;

    private zzcmu(zzeps<Context> zzepsVar, zzeps<ApplicationInfo> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcmu a(zzeps<Context> zzepsVar, zzeps<ApplicationInfo> zzepsVar2) {
        return new zzcmu(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return zzcmk.a(this.a.b(), this.b.b());
    }
}
