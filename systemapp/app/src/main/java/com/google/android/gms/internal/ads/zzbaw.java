package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbaw extends zzbao {
    @Override // com.google.android.gms.internal.ads.zzbao
    public final zzbap a(Context context, zzbbe zzbbeVar, int i, boolean z, zzabs zzabsVar, zzbbf zzbbfVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        zzbbh zzbbhVar = new zzbbh(context, zzbbeVar.m(), zzbbeVar.getRequestId(), zzabsVar, zzbbeVar.f());
        if (i == 2) {
            return new zzbbl(context, zzbbhVar, zzbbeVar, z, a(zzbbeVar), zzbbfVar);
        }
        return new zzbac(context, zzbbeVar, z, a(zzbbeVar), zzbbfVar, new zzbbh(context, zzbbeVar.m(), zzbbeVar.getRequestId(), zzabsVar, zzbbeVar.f()));
    }
}
