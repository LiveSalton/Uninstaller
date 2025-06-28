package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzdfd;
import com.google.android.gms.internal.ads.zzvk;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: source */
/* loaded from: classes.dex */
final class f {
    private final Context a;
    private final String b;
    private final Map<String, String> c = new TreeMap();
    private String d;
    private String e;

    public f(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    public final String a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.c;
    }

    public final void a(zzvk zzvkVar, zzazh zzazhVar) {
        this.d = zzvkVar.j.a;
        Bundle bundle = zzvkVar.m != null ? zzvkVar.m.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle == null) {
            return;
        }
        String a = zzacr.c.a();
        for (String str : bundle.keySet()) {
            if (a.equals(str)) {
                this.e = bundle.getString(str);
            } else if (str.startsWith("csa_")) {
                this.c.put(str.substring(4), bundle.getString(str));
            }
        }
        this.c.put("SDKVersion", zzazhVar.a);
        if (zzacr.a.a().booleanValue()) {
            try {
                Bundle a2 = zzdfd.a(this.a, new JSONArray(zzacr.b.a()));
                for (String str2 : a2.keySet()) {
                    this.c.put(str2, a2.get(str2).toString());
                }
            } catch (JSONException e) {
                zzd.c("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
            }
        }
    }
}
