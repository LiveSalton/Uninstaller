package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzacv;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzrk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzi implements zzf {
    private boolean b;
    private zzdyz<?> d;

    @GuardedBy("lock")
    private SharedPreferences f;

    @GuardedBy("lock")
    private SharedPreferences.Editor g;

    @GuardedBy("lock")
    private String j;

    @GuardedBy("lock")
    private String k;
    private final Object a = new Object();
    private final List<Runnable> c = new ArrayList();

    @GuardedBy("lock")
    private zzrk e = null;

    @GuardedBy("lock")
    private boolean h = false;

    @GuardedBy("lock")
    private boolean i = true;

    @GuardedBy("lock")
    private boolean l = false;

    @GuardedBy("lock")
    private String m = "";

    @GuardedBy("lock")
    private long n = 0;

    @GuardedBy("lock")
    private long o = 0;

    @GuardedBy("lock")
    private long p = 0;

    @GuardedBy("lock")
    private int q = -1;

    @GuardedBy("lock")
    private int r = 0;

    @GuardedBy("lock")
    private Set<String> s = Collections.emptySet();

    @GuardedBy("lock")
    private JSONObject t = new JSONObject();

    @GuardedBy("lock")
    private boolean u = true;

    @GuardedBy("lock")
    private boolean v = true;

    @GuardedBy("lock")
    private String w = null;

    @GuardedBy("lock")
    private int x = -1;

    public final void a(Context context, String str, boolean z) {
        String concat;
        synchronized (this.a) {
            if (this.f != null) {
                return;
            }
            if (str == null) {
                concat = "admob";
            } else {
                String valueOf = String.valueOf("admob__");
                String valueOf2 = String.valueOf(str);
                concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            }
            this.d = zzazj.a.submit(new Runnable(this, context, concat) { // from class: com.google.android.gms.ads.internal.util.v
                private final zzi a;
                private final Context b;
                private final String c;

                {
                    this.a = this;
                    this.b = context;
                    this.c = concat;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b, this.c);
                }
            });
            this.b = z;
        }
    }

    private final void o() {
        if (this.d == null || this.d.isDone()) {
            return;
        }
        try {
            this.d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzd.d("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzd.c("Fail to initialize AdSharedPreferenceManager.", e2);
        }
    }

    private final void p() {
        zzazj.a.execute(new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.w
            private final zzi a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final zzrk a() {
        if (!this.b) {
            return null;
        }
        if ((b() && d()) || !zzacv.b.a().booleanValue()) {
            return null;
        }
        synchronized (this.a) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.e == null) {
                this.e = new zzrk();
            }
            this.e.a();
            zzd.d("start fetching content...");
            return this.e;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(boolean z) {
        o();
        synchronized (this.a) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            if (this.g != null) {
                this.g.putBoolean("content_url_opted_out", z);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean b() {
        boolean z;
        o();
        synchronized (this.a) {
            z = this.u;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(String str) {
        o();
        synchronized (this.a) {
            if (str != null) {
                try {
                    if (!str.equals(this.j)) {
                        this.j = str;
                        if (this.g != null) {
                            this.g.putString("content_url_hashes", str);
                            this.g.apply();
                        }
                        p();
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String c() {
        String str;
        o();
        synchronized (this.a) {
            str = this.j;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void b(boolean z) {
        o();
        synchronized (this.a) {
            if (this.v == z) {
                return;
            }
            this.v = z;
            if (this.g != null) {
                this.g.putBoolean("content_vertical_opted_out", z);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean d() {
        boolean z;
        o();
        synchronized (this.a) {
            z = this.v;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void b(String str) {
        o();
        synchronized (this.a) {
            if (str != null) {
                try {
                    if (!str.equals(this.k)) {
                        this.k = str;
                        if (this.g != null) {
                            this.g.putString("content_vertical_hashes", str);
                            this.g.apply();
                        }
                        p();
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String e() {
        String str;
        o();
        synchronized (this.a) {
            str = this.k;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean f() {
        boolean z;
        o();
        synchronized (this.a) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(int i) {
        o();
        synchronized (this.a) {
            if (this.r == i) {
                return;
            }
            this.r = i;
            if (this.g != null) {
                this.g.putInt("version_code", i);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int g() {
        int i;
        o();
        synchronized (this.a) {
            i = this.r;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void c(String str) {
        o();
        synchronized (this.a) {
            long a = zzp.j().a();
            this.n = a;
            if (str != null && !str.equals(this.m)) {
                this.m = str;
                if (this.g != null) {
                    this.g.putString("app_settings_json", str);
                    this.g.putLong("app_settings_last_update_ms", a);
                    this.g.apply();
                }
                p();
                Iterator<Runnable> it = this.c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final zzayh h() {
        zzayh zzayhVar;
        o();
        synchronized (this.a) {
            zzayhVar = new zzayh(this.m, this.n);
        }
        return zzayhVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(Runnable runnable) {
        this.c.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(long j) {
        o();
        synchronized (this.a) {
            if (this.o == j) {
                return;
            }
            this.o = j;
            if (this.g != null) {
                this.g.putLong("app_last_background_time_ms", j);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long i() {
        long j;
        o();
        synchronized (this.a) {
            j = this.o;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void b(int i) {
        o();
        synchronized (this.a) {
            if (this.q == i) {
                return;
            }
            this.q = i;
            if (this.g != null) {
                this.g.putInt("request_in_session_count", i);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int j() {
        int i;
        o();
        synchronized (this.a) {
            i = this.q;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void b(long j) {
        o();
        synchronized (this.a) {
            if (this.p == j) {
                return;
            }
            this.p = j;
            if (this.g != null) {
                this.g.putLong("first_ad_req_time_ms", j);
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long k() {
        long j;
        o();
        synchronized (this.a) {
            j = this.p;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void a(String str, String str2, boolean z) {
        o();
        synchronized (this.a) {
            JSONArray optJSONArray = this.t.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzp.j().a());
                optJSONArray.put(length, jSONObject);
                this.t.put(str, optJSONArray);
            } catch (JSONException e) {
                zzd.d("Could not update native advanced settings", e);
            }
            if (this.g != null) {
                this.g.putString("native_advanced_settings", this.t.toString());
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final JSONObject l() {
        JSONObject jSONObject;
        o();
        synchronized (this.a) {
            jSONObject = this.t;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void m() {
        o();
        synchronized (this.a) {
            this.t = new JSONObject();
            if (this.g != null) {
                this.g.remove("native_advanced_settings");
                this.g.apply();
            }
            p();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String n() {
        String str;
        o();
        synchronized (this.a) {
            str = this.w;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void d(String str) {
        o();
        synchronized (this.a) {
            if (TextUtils.equals(this.w, str)) {
                return;
            }
            this.w = str;
            if (this.g != null) {
                this.g.putString("display_cutout", str);
                this.g.apply();
            }
            p();
        }
    }

    final /* synthetic */ void a(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.a) {
            this.f = sharedPreferences;
            this.g = edit;
            if (PlatformVersion.h() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.h = z;
            this.i = this.f.getBoolean("use_https", this.i);
            this.u = this.f.getBoolean("content_url_opted_out", this.u);
            this.j = this.f.getString("content_url_hashes", this.j);
            this.l = this.f.getBoolean("auto_collect_location", this.l);
            this.v = this.f.getBoolean("content_vertical_opted_out", this.v);
            this.k = this.f.getString("content_vertical_hashes", this.k);
            this.r = this.f.getInt("version_code", this.r);
            this.m = this.f.getString("app_settings_json", this.m);
            this.n = this.f.getLong("app_settings_last_update_ms", this.n);
            this.o = this.f.getLong("app_last_background_time_ms", this.o);
            this.q = this.f.getInt("request_in_session_count", this.q);
            this.p = this.f.getLong("first_ad_req_time_ms", this.p);
            this.s = this.f.getStringSet("never_pool_slots", this.s);
            this.w = this.f.getString("display_cutout", this.w);
            this.x = this.f.getInt("app_measurement_npa", this.x);
            try {
                this.t = new JSONObject(this.f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzd.d("Could not convert native advanced settings to json object", e);
            }
            p();
        }
    }
}
