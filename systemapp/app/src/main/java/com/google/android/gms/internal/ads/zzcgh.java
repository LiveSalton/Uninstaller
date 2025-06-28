package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgh {
    private final ta a;
    private final com.google.android.gms.ads.internal.zzb b;
    private final zzbed c;
    private final Context d;
    private final zzckq e;
    private final Executor f;
    private final zzef g;
    private final zzazh h;
    private final zzaif i;
    private final zzcqo j;
    private final zzdrz k;
    private zzdyz<zzbdv> l;

    zzcgh(zzcgu zzcguVar) {
        Context context;
        Executor executor;
        zzef zzefVar;
        zzazh zzazhVar;
        com.google.android.gms.ads.internal.zzb zzbVar;
        zzbed zzbedVar;
        zzcqo zzcqoVar;
        zzdrz zzdrzVar;
        zzckq zzckqVar;
        context = zzcguVar.c;
        this.d = context;
        executor = zzcguVar.f;
        this.f = executor;
        zzefVar = zzcguVar.g;
        this.g = zzefVar;
        zzazhVar = zzcguVar.h;
        this.h = zzazhVar;
        zzbVar = zzcguVar.a;
        this.b = zzbVar;
        this.a = new ta(null);
        zzbedVar = zzcguVar.b;
        this.c = zzbedVar;
        this.i = new zzaif();
        zzcqoVar = zzcguVar.e;
        this.j = zzcqoVar;
        zzdrzVar = zzcguVar.i;
        this.k = zzdrzVar;
        zzckqVar = zzcguVar.d;
        this.e = zzckqVar;
    }

    public final synchronized void a() {
        this.l = zzdyr.a(zzbed.a(this.d, this.h, (String) zzwq.e().a(zzabf.bz), this.g, this.b), new zzdvm(this) { // from class: com.google.android.gms.internal.ads.sv
            private final zzcgh a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                return this.a.a((zzbdv) obj);
            }
        }, this.f);
        zzazm.a(this.l, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void b() {
        if (this.l == null) {
            return;
        }
        zzdyr.a(this.l, new sx(this), this.f);
        this.l = null;
    }

    public final synchronized zzdyz<JSONObject> a(String str, JSONObject jSONObject) {
        if (this.l == null) {
            return zzdyr.a((Object) null);
        }
        return zzdyr.a(this.l, new zzdyb(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.su
            private final zzcgh a;
            private final String b;
            private final JSONObject c;

            {
                this.a = this;
                this.b = str;
                this.c = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (zzbdv) obj);
            }
        }, this.f);
    }

    public final synchronized void a(String str, zzahv<Object> zzahvVar) {
        if (this.l == null) {
            return;
        }
        zzdyr.a(this.l, new sw(this, str, zzahvVar), this.f);
    }

    public final synchronized void b(String str, zzahv<Object> zzahvVar) {
        if (this.l == null) {
            return;
        }
        zzdyr.a(this.l, new sz(this, str, zzahvVar), this.f);
    }

    public final synchronized void a(String str, Map<String, ?> map) {
        if (this.l == null) {
            return;
        }
        zzdyr.a(this.l, new sy(this, str, map), this.f);
    }

    public final synchronized void a(zzdmu zzdmuVar, zzdmz zzdmzVar) {
        if (this.l == null) {
            return;
        }
        zzdyr.a(this.l, new tb(this, zzdmuVar, zzdmzVar), this.f);
    }

    public final <T> void a(WeakReference<T> weakReference, String str, zzahv<T> zzahvVar) {
        a(str, new td(this, weakReference, str, zzahvVar, null));
    }

    final /* synthetic */ zzdyz a(String str, JSONObject jSONObject, zzbdv zzbdvVar) throws Exception {
        return this.i.a(zzbdvVar, str, jSONObject);
    }

    final /* synthetic */ zzbdv a(zzbdv zzbdvVar) {
        zzbdvVar.a("/result", this.i);
        zzbdvVar.z().a(null, this.a, this.a, this.a, this.a, false, null, new zza(this.d, null, null), null, null, this.j, this.k, this.e);
        return zzbdvVar;
    }
}
