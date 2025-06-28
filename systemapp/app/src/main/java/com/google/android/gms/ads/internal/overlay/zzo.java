package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzo {
    public static void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.k == 4 && adOverlayInfoParcel.c == null) {
            if (adOverlayInfoParcel.b != null) {
                adOverlayInfoParcel.b.e();
            }
            com.google.android.gms.ads.internal.zzp.a();
            zza.a(context, adOverlayInfoParcel.a, adOverlayInfoParcel.i);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.m.d);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.a(intent, adOverlayInfoParcel);
        if (!PlatformVersion.g()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.google.android.gms.ads.internal.zzp.c();
        zzm.a(context, intent);
    }
}
