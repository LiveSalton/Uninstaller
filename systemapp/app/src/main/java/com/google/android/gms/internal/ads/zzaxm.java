package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaxm {
    public static String a(String str, Context context, boolean z) {
        String e;
        if ((((Boolean) zzwq.e().a(zzabf.ac)).booleanValue() && !z) || !zzp.A().a(context) || TextUtils.isEmpty(str) || (e = zzp.A().e(context)) == null) {
            return str;
        }
        if (((Boolean) zzwq.e().a(zzabf.U)).booleanValue()) {
            String str2 = (String) zzwq.e().a(zzabf.V);
            if (str.contains(str2)) {
                if (zzp.c().c(str)) {
                    zzp.A().d(context, e);
                    return a(str, context).replace(str2, e);
                }
                if (zzp.c().d(str)) {
                    zzp.A().e(context, e);
                    return a(str, context).replace(str2, e);
                }
            }
        } else if (!str.contains("fbs_aeid")) {
            if (zzp.c().c(str)) {
                zzp.A().d(context, e);
                return a(a(str, context), "fbs_aeid", e).toString();
            }
            if (zzp.c().d(str)) {
                zzp.A().e(context, e);
                return a(a(str, context), "fbs_aeid", e).toString();
            }
        }
        return str;
    }

    private static String a(String str, Context context) {
        String c = zzp.A().c(context);
        String d = zzp.A().d(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(c)) {
            str = a(str, "gmp_app_id", c).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(d)) ? str : a(str, "fbs_aiid", d).toString();
    }

    public static String a(Uri uri, Context context) {
        if (!zzp.A().a(context)) {
            return uri.toString();
        }
        String e = zzp.A().e(context);
        if (e == null) {
            return uri.toString();
        }
        if (((Boolean) zzwq.e().a(zzabf.U)).booleanValue()) {
            String str = (String) zzwq.e().a(zzabf.V);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzp.A().d(context, e);
                return a(uri2, context).replace(str, e);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = a(a(uri.toString(), context), "fbs_aeid", e).toString();
            zzp.A().d(context, e);
            return uri3;
        }
        return uri.toString();
    }

    @VisibleForTesting
    private static Uri a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }
}
