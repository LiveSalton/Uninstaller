package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzuo;

/* compiled from: source */
@TargetApi(26)
/* loaded from: classes.dex */
public class zzac extends zzz {
    @Override // com.google.android.gms.ads.internal.util.zzu
    public final zzuo a(Context context, TelephonyManager telephonyManager) {
        zzp.c();
        return zzm.a(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE : zzuo.ENUM_FALSE;
    }
}
