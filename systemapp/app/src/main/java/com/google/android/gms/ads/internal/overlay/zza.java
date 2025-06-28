package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zza {
    public static boolean a(Context context, zzb zzbVar, zzu zzuVar) {
        int i;
        if (zzbVar == null) {
            zzd.e("No intent data for launcher overlay.");
            return false;
        }
        zzabf.a(context);
        if (zzbVar.f != null) {
            return a(context, zzbVar.f, zzuVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzbVar.a)) {
            zzd.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzbVar.b)) {
            intent.setDataAndType(Uri.parse(zzbVar.a), zzbVar.b);
        } else {
            intent.setData(Uri.parse(zzbVar.a));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzbVar.c)) {
            intent.setPackage(zzbVar.c);
        }
        if (!TextUtils.isEmpty(zzbVar.d)) {
            String[] split = zzbVar.d.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzbVar.d);
                zzd.e(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzbVar.e;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzd.e("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzwq.e().a(zzabf.cf)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwq.e().a(zzabf.ce)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.c();
                zzm.b(context, intent);
            }
        }
        return a(context, intent, zzuVar);
    }

    private static boolean a(Context context, Intent intent, zzu zzuVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzd.a(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzp.c();
            zzm.a(context, intent);
            if (zzuVar == null) {
                return true;
            }
            zzuVar.a();
            return true;
        } catch (ActivityNotFoundException e) {
            zzd.e(e.getMessage());
            return false;
        }
    }
}
