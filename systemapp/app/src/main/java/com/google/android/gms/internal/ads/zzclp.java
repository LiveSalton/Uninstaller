package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclp {
    private final Context e;
    private final WeakReference<Context> f;
    private final zzciq g;
    private final Executor h;
    private final Executor i;
    private final ScheduledExecutorService j;
    private final zzckz k;
    private final zzazh l;
    private boolean a = false;
    private boolean b = false;
    private final zzazq<Boolean> d = new zzazq<>();
    private Map<String, zzaiz> m = new ConcurrentHashMap();
    private boolean n = true;
    private final long c = zzp.j().b();

    public zzclp(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzciq zzciqVar, ScheduledExecutorService scheduledExecutorService, zzckz zzckzVar, zzazh zzazhVar) {
        this.g = zzciqVar;
        this.e = context;
        this.f = weakReference;
        this.h = executor2;
        this.j = scheduledExecutorService;
        this.i = executor;
        this.k = zzckzVar;
        this.l = zzazhVar;
        a("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public final void a() {
        this.n = false;
    }

    public final void a(zzajc zzajcVar) {
        this.d.a(new Runnable(this, zzajcVar) { // from class: com.google.android.gms.internal.ads.ut
            private final zzclp a;
            private final zzajc b;

            {
                this.a = this;
                this.b = zzajcVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b);
            }
        }, this.i);
    }

    public final void b() {
        if (((Boolean) zzwq.e().a(zzabf.aS)).booleanValue() && !zzadc.a.a().booleanValue()) {
            if (this.l.c >= ((Integer) zzwq.e().a(zzabf.aT)).intValue() && this.n) {
                if (this.a) {
                    return;
                }
                synchronized (this) {
                    if (this.a) {
                        return;
                    }
                    this.k.a();
                    this.d.a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.us
                        private final zzclp a;

                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f();
                        }
                    }, this.h);
                    this.a = true;
                    zzdyz<String> g = g();
                    this.j.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.uu
                        private final zzclp a;

                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e();
                        }
                    }, ((Long) zzwq.e().a(zzabf.aV)).longValue(), TimeUnit.SECONDS);
                    zzdyr.a(g, new vb(this), this.h);
                    return;
                }
            }
        }
        if (this.a) {
            return;
        }
        a("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.d.b(false);
        this.a = true;
    }

    public final List<zzaiz> c() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.m.keySet()) {
            zzaiz zzaizVar = this.m.get(str);
            arrayList.add(new zzaiz(str, zzaizVar.b, zzaizVar.c, zzaizVar.d));
        }
        return arrayList;
    }

    private final synchronized zzdyz<String> g() {
        String c = zzp.g().h().h().c();
        if (!TextUtils.isEmpty(c)) {
            return zzdyr.a(c);
        }
        zzazq zzazqVar = new zzazq();
        zzp.g().h().a(new Runnable(this, zzazqVar) { // from class: com.google.android.gms.internal.ads.uv
            private final zzclp a;
            private final zzazq b;

            {
                this.a = this;
                this.b = zzazqVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b);
            }
        });
        return zzazqVar;
    }

    public final void a(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzazq zzazqVar = new zzazq();
                zzdyz a = zzdyr.a(zzazqVar, ((Long) zzwq.e().a(zzabf.aU)).longValue(), TimeUnit.SECONDS, this.j);
                this.k.a(next);
                long b = zzp.j().b();
                Iterator<String> it = keys;
                a.a(new Runnable(this, obj, zzazqVar, next, b) { // from class: com.google.android.gms.internal.ads.ux
                    private final zzclp a;
                    private final Object b;
                    private final zzazq c;
                    private final String d;
                    private final long e;

                    {
                        this.a = this;
                        this.b = obj;
                        this.c = zzazqVar;
                        this.d = next;
                        this.e = b;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(this.b, this.c, this.d, this.e);
                    }
                }, this.h);
                arrayList.add(a);
                vc vcVar = new vc(this, obj, next, b, zzazqVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajj(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                a(next, false, "", 0);
                try {
                    try {
                        this.i.execute(new Runnable(this, this.g.a(next, new JSONObject()), vcVar, arrayList2, next) { // from class: com.google.android.gms.internal.ads.uz
                            private final zzclp a;
                            private final zzdoe b;
                            private final zzajb c;
                            private final List d;
                            private final String e;

                            {
                                this.a = this;
                                this.b = a2;
                                this.c = vcVar;
                                this.d = arrayList2;
                                this.e = next;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.a(this.b, this.c, this.d, this.e);
                            }
                        });
                    } catch (zzdnr unused2) {
                        vcVar.a("Failed to create Adapter.");
                    }
                } catch (RemoteException e) {
                    zzaza.c("", e);
                }
                keys = it;
            }
            zzdyr.b(arrayList).a(new Callable(this) { // from class: com.google.android.gms.internal.ads.uw
                private final zzclp a;

                {
                    this.a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.d();
                }
            }, this.h);
        } catch (JSONException e2) {
            zzd.a("Malformed CLD response", e2);
        }
    }

    public final void a(String str, boolean z, String str2, int i) {
        this.m.put(str, new zzaiz(str, z, i, str2));
    }

    final /* synthetic */ void a(zzdoe zzdoeVar, zzajb zzajbVar, List list, String str) {
        try {
            Context context = this.f.get();
            if (context == null) {
                context = this.e;
            }
            zzdoeVar.a(context, zzajbVar, (List<zzajj>) list);
        } catch (zzdnr unused) {
            try {
                StringBuilder sb = new StringBuilder(74 + String.valueOf(str).length());
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzajbVar.a(sb.toString());
            } catch (RemoteException e) {
                zzaza.c("", e);
            }
        }
    }

    final /* synthetic */ Object d() throws Exception {
        this.d.b(true);
        return null;
    }

    final /* synthetic */ void a(Object obj, zzazq zzazqVar, String str, long j) {
        synchronized (obj) {
            if (!zzazqVar.isDone()) {
                a(str, false, "Timeout.", (int) (zzp.j().b() - j));
                this.k.a(str, "timeout");
                zzazqVar.b(false);
            }
        }
    }

    final /* synthetic */ void e() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            a("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzp.j().b() - this.c));
            this.d.a(new Exception());
        }
    }

    final /* synthetic */ void a(zzazq zzazqVar) {
        this.h.execute(new Runnable(this, zzazqVar) { // from class: com.google.android.gms.internal.ads.uy
            private final zzclp a;
            private final zzazq b;

            {
                this.a = this;
                this.b = zzazqVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzazq zzazqVar2 = this.b;
                String c = zzp.g().h().h().c();
                if (TextUtils.isEmpty(c)) {
                    zzazqVar2.a(new Exception());
                } else {
                    zzazqVar2.b(c);
                }
            }
        });
    }

    final /* synthetic */ void f() {
        this.k.b();
    }

    final /* synthetic */ void b(zzajc zzajcVar) {
        try {
            zzajcVar.a(c());
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }

    static /* synthetic */ boolean a(zzclp zzclpVar, boolean z) {
        zzclpVar.b = true;
        return true;
    }
}
