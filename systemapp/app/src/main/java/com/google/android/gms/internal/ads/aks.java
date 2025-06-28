package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class aks implements akr {
    private static final zzcf.zza a = (zzcf.zza) ((zzekh) zzcf.zza.h().c("E").g());

    aks() {
    }

    @Override // com.google.android.gms.internal.ads.akr
    public final zzcf.zza a(Context context) throws PackageManager.NameNotFoundException {
        return zzdsp.a(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    @Override // com.google.android.gms.internal.ads.akr
    public final zzcf.zza a() {
        return a;
    }
}
