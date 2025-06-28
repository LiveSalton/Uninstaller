package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzamd;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzdyr;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzwq;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zze {
    private Context a;
    private long b = 0;

    public final void a(Context context, zzazh zzazhVar, String str, Runnable runnable) {
        a(context, zzazhVar, true, null, str, null, runnable);
    }

    public final void a(Context context, zzazh zzazhVar, String str, zzayh zzayhVar) {
        a(context, zzazhVar, false, zzayhVar, zzayhVar != null ? zzayhVar.d() : null, str, null);
    }

    @VisibleForTesting
    private final void a(Context context, zzazh zzazhVar, boolean z, zzayh zzayhVar, String str, String str2, Runnable runnable) {
        if (zzp.j().b() - this.b < 5000) {
            zzd.e("Not retrying to fetch app settings");
            return;
        }
        this.b = zzp.j().b();
        boolean z2 = true;
        if (zzayhVar != null) {
            if (!(zzp.j().a() - zzayhVar.a() > ((Long) zzwq.e().a(zzabf.bP)).longValue()) && zzayhVar.b()) {
                z2 = false;
            }
        }
        if (z2) {
            if (context == null) {
                zzd.e("Context not provided to fetch application settings");
                return;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                zzd.e("App settings could not be fetched. Required parameters missing");
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.a = applicationContext;
            zzamd a = zzp.p().b(this.a, zzazhVar).a("google.afma.config.fetchAppSettings", zzamg.a, zzamg.a);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzdyz b = a.b(jSONObject);
                zzdyz a2 = zzdyr.a(b, a.a, zzazj.f);
                if (runnable != null) {
                    b.a(runnable, zzazj.f);
                }
                zzazm.a(a2, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                zzd.c("Error requesting application settings", e);
            }
        }
    }
}
