package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzeoe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzawh implements zzawq {
    private static List<Future<Void>> a = Collections.synchronizedList(new ArrayList());

    @GuardedBy("lock")
    private final zzeoe.zzb.C0067zzb b;

    @GuardedBy("lock")
    private final LinkedHashMap<String, zzeoe.zzb.zzh.C0073zzb> c;
    private final Context f;
    private final zzaws g;
    private boolean h;
    private final zzawp i;
    private final eh j;

    @GuardedBy("lock")
    private final List<String> d = new ArrayList();

    @GuardedBy("lock")
    private final List<String> e = new ArrayList();
    private final Object k = new Object();
    private HashSet<String> l = new HashSet<>();
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;

    public zzawh(Context context, zzazh zzazhVar, zzawp zzawpVar, String str, zzaws zzawsVar) {
        Preconditions.a(zzawpVar, "SafeBrowsing config is not present.");
        this.f = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = new LinkedHashMap<>();
        this.g = zzawsVar;
        this.i = zzawpVar;
        Iterator<String> it = this.i.e.iterator();
        while (it.hasNext()) {
            this.l.add(it.next().toLowerCase(Locale.ENGLISH));
        }
        this.l.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzeoe.zzb.C0067zzb d = zzeoe.zzb.d();
        d.a(zzeoe.zzb.zzg.OCTAGON_AD);
        d.a(str);
        d.b(str);
        zzeoe.zzb.zza.C0066zza a2 = zzeoe.zzb.zza.a();
        if (this.i.a != null) {
            a2.a(this.i.a);
        }
        d.a((zzeoe.zzb.zza) ((zzekh) a2.g()));
        zzeoe.zzb.zzi.zza a3 = zzeoe.zzb.zzi.a().a(Wrappers.a(this.f).a());
        if (zzazhVar.a != null) {
            a3.a(zzazhVar.a);
        }
        long b = GoogleApiAvailabilityLight.a().b(this.f);
        if (b > 0) {
            a3.a(b);
        }
        d.a((zzeoe.zzb.zzi) ((zzekh) a3.g()));
        this.b = d;
        this.j = new eh(this.f, this.i.h, this);
    }

    static final /* synthetic */ Void d(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final zzawp a() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void a(String str) {
        synchronized (this.k) {
            try {
                if (str == null) {
                    this.b.j();
                } else {
                    this.b.c(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final boolean b() {
        return PlatformVersion.e() && this.i.c && !this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void a(View view) {
        if (this.i.c && !this.n) {
            zzp.c();
            Bitmap b = com.google.android.gms.ads.internal.util.zzm.b(view);
            if (b == null) {
                zzawr.a("Failed to capture the webview bitmap.");
            } else {
                this.n = true;
                com.google.android.gms.ads.internal.util.zzm.a(new Runnable(this, b) { // from class: com.google.android.gms.internal.ads.ec
                    private final zzawh a;
                    private final Bitmap b;

                    {
                        this.a = this;
                        this.b = b;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void a(String str, Map<String, String> map, int i) {
        synchronized (this.k) {
            if (i == 3) {
                try {
                    this.o = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.c.containsKey(str)) {
                if (i == 3) {
                    this.c.get(str).a(zzeoe.zzb.zzh.zza.a(i));
                }
                return;
            }
            zzeoe.zzb.zzh.C0073zzb c = zzeoe.zzb.zzh.c();
            zzeoe.zzb.zzh.zza a2 = zzeoe.zzb.zzh.zza.a(i);
            if (a2 != null) {
                c.a(a2);
            }
            c.a(this.c.size());
            c.a(str);
            zzeoe.zzb.zzd.C0069zzb a3 = zzeoe.zzb.zzd.a();
            if (this.l.size() > 0 && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.l.contains(key.toLowerCase(Locale.ENGLISH))) {
                        a3.a((zzeoe.zzb.zzc) ((zzekh) zzeoe.zzb.zzc.a().a(zzeiu.a(key)).b(zzeiu.a(value)).g()));
                    }
                }
            }
            c.a((zzeoe.zzb.zzd) ((zzekh) a3.g()));
            this.c.put(str, c);
        }
    }

    final void b(String str) {
        synchronized (this.k) {
            this.d.add(str);
        }
    }

    final void c(String str) {
        synchronized (this.k) {
            this.e.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final String[] a(String[] strArr) {
        return (String[]) this.j.a(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void c() {
        this.m = true;
    }

    private final zzeoe.zzb.zzh.C0073zzb e(String str) {
        zzeoe.zzb.zzh.C0073zzb c0073zzb;
        synchronized (this.k) {
            c0073zzb = this.c.get(str);
        }
        return c0073zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzawq
    public final void d() {
        synchronized (this.k) {
            zzdyz a2 = zzdyr.a(this.g.a(this.f, this.c.keySet()), new zzdyb(this) { // from class: com.google.android.gms.internal.ads.ee
                private final zzawh a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    return this.a.a((Map) obj);
                }
            }, zzazj.f);
            zzdyz a3 = zzdyr.a(a2, 10L, TimeUnit.SECONDS, zzazj.d);
            zzdyr.a(a2, new ef(this, a3), zzazj.f);
            a.add(a3);
        }
    }

    private final zzdyz<Void> g() {
        zzdyz<Void> a2;
        if (!((this.h && this.i.g) || (this.o && this.i.f) || (!this.h && this.i.d))) {
            return zzdyr.a((Object) null);
        }
        synchronized (this.k) {
            Iterator<zzeoe.zzb.zzh.C0073zzb> it = this.c.values().iterator();
            while (it.hasNext()) {
                this.b.a((zzeoe.zzb.zzh) ((zzekh) it.next().g()));
            }
            this.b.a(this.d);
            this.b.b(this.e);
            if (zzawr.a()) {
                String a3 = this.b.a();
                String i = this.b.i();
                StringBuilder sb = new StringBuilder(53 + String.valueOf(a3).length() + String.valueOf(i).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(a3);
                sb.append("\n  clickUrl: ");
                sb.append(i);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzeoe.zzb.zzh zzhVar : this.b.h()) {
                    sb2.append("    [");
                    sb2.append(zzhVar.b());
                    sb2.append("] ");
                    sb2.append(zzhVar.a());
                }
                zzawr.a(sb2.toString());
            }
            zzdyz<String> a4 = new zzax(this.f).a(1, this.i.b, null, ((zzeoe.zzb) ((zzekh) this.b.g())).l());
            if (zzawr.a()) {
                a4.a(ed.a, zzazj.a);
            }
            a2 = zzdyr.a(a4, eg.a, zzazj.f);
        }
        return a2;
    }

    final /* synthetic */ zzdyz a(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.k) {
                            int length = optJSONArray.length();
                            zzeoe.zzb.zzh.C0073zzb e = e(str);
                            if (e == null) {
                                String valueOf = String.valueOf(str);
                                zzawr.a(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                for (int i = 0; i < length; i++) {
                                    e.b(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                this.h = (length > 0) | this.h;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (zzadh.a.a().booleanValue()) {
                    zzd.b("Failed to get SafeBrowsing metadata", e2);
                }
                return zzdyr.a((Throwable) new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.h) {
            synchronized (this.k) {
                this.b.a(zzeoe.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return g();
    }

    final /* synthetic */ void a(Bitmap bitmap) {
        zzejh h = zzeiu.h();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, h);
        synchronized (this.k) {
            this.b.a((zzeoe.zzb.zzf) ((zzekh) zzeoe.zzb.zzf.a().a(h.a()).a("image/png").a(zzeoe.zzb.zzf.zza.TYPE_CREATIVE).g()));
        }
    }
}
