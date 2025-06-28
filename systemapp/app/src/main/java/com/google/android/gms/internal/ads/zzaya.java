package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaya implements zzayc {
    @Override // com.google.android.gms.internal.ads.zzayc
    public final zzdyz<String> a(String str, PackageInfo packageInfo) {
        return zzdyr.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzayc
    public final zzdyz<AdvertisingIdClient.Info> a(Context context) {
        zzazq zzazqVar = new zzazq();
        zzwq.a();
        if (zzayr.c(context)) {
            zzazj.a.execute(new fa(this, context, zzazqVar));
        }
        return zzazqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzayc
    public final zzdyz<String> a(Context context, int i) {
        return zzdyr.a((Object) null);
    }
}
