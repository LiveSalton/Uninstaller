package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdob {
    public static void a(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzd.d(sb.toString());
        zzd.a(str, th);
        if (i == 3) {
            return;
        }
        zzp.g().b(th, str);
    }

    public static void a(Context context, boolean z) {
        if (z) {
            zzd.d("This request is sent from a test device.");
            return;
        }
        zzwq.a();
        String a = zzayr.a(context);
        StringBuilder sb = new StringBuilder(101 + String.valueOf(a).length());
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(a);
        sb.append("\") to get test ads on this device.");
        zzd.d(sb.toString());
    }
}
