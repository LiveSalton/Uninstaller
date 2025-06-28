package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzal {
    private final Object a = new Object();

    @GuardedBy("lock")
    private String b = "";

    @GuardedBy("lock")
    private String c = "";

    @GuardedBy("lock")
    private boolean d = false;

    @VisibleForTesting
    private String e = "";

    public final void a(Context context, String str, String str2) {
        if (!b(context, str, str2)) {
            a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.e)) {
            zzd.b("Creative is not pushed for this device.");
            a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.e)) {
            zzd.b("The app is not linked for creative preview.");
            e(context, str, str2);
        } else if ("0".equals(this.e)) {
            zzd.b("Device is linked for in app preview.");
            a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void a(Context context, String str, String str2, String str3) {
        boolean b = b();
        if (c(context, str, str2)) {
            if (!b && !TextUtils.isEmpty(str3)) {
                c(context, str2, str3, str);
            }
            zzd.b("Device is linked for debug signals.");
            a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        e(context, str, str2);
    }

    @VisibleForTesting
    private final boolean b(Context context, String str, String str2) {
        String d = d(context, d(context, (String) zzwq.e().a(zzabf.ck), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzd.b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(d.trim());
            String optString = jSONObject.optString("gct");
            this.e = jSONObject.optString("status");
            synchronized (this.a) {
                this.c = optString;
            }
            return true;
        } catch (JSONException e) {
            zzd.d("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean c(Context context, String str, String str2) {
        String d = d(context, d(context, (String) zzwq.e().a(zzabf.cl), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzd.b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(d.trim()).optString("debug_mode"));
            synchronized (this.a) {
                this.d = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzd.d("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String d(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzp.c().b(context, str2));
        zzdyz<String> a = new zzax(context).a(str, hashMap);
        try {
            return a.get(((Integer) zzwq.e().a(zzabf.cn)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(str);
            zzd.c(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e);
            a.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String valueOf2 = String.valueOf(str);
            zzd.c(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e2);
            a.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzd.c(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void e(Context context, String str, String str2) {
        zzp.c();
        zzm.b(context, d(context, (String) zzwq.e().a(zzabf.cj), str, str2));
    }

    public final boolean b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzp.m().b()) {
            return false;
        }
        zzd.b("Sending troubleshooting signals to the server.");
        c(context, str, str2, str3);
        return true;
    }

    private final void c(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = d(context, (String) zzwq.e().a(zzabf.cm), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzp.c();
        zzm.a(context, str, buildUpon.build().toString());
    }

    private final Uri d(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String a(Context context) {
        String str;
        synchronized (this.a) {
            if (TextUtils.isEmpty(this.b)) {
                zzp.c();
                this.b = zzm.c(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.b)) {
                    zzp.c();
                    this.b = zzm.a();
                    zzp.c();
                    zzm.b(context, "debug_signals_id.txt", this.b);
                }
            }
            str = this.b;
        }
        return str;
    }

    public final String a() {
        String str;
        synchronized (this.a) {
            str = this.c;
        }
        return str;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.d;
        }
        return z;
    }

    @VisibleForTesting
    private final void a(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzd.d("Can not create dialog without Activity Context");
        } else {
            zzm.a.post(new i(this, context, str, z, z2));
        }
    }
}
