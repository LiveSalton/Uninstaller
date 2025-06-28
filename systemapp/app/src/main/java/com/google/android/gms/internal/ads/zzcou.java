package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcou extends zzatb {
    private final Context a;
    private final Executor b;
    private final zzaty c;
    private final zzatz d;
    private final zzbjl e;
    private final HashMap<String, zzcpf> f;

    public zzcou(Context context, Executor executor, zzaty zzatyVar, zzbjl zzbjlVar, zzatz zzatzVar, HashMap<String, zzcpf> hashMap) {
        zzabf.a(context);
        this.a = context;
        this.b = executor;
        this.c = zzatyVar;
        this.d = zzatzVar;
        this.e = zzbjlVar;
        this.f = hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final zzasu a(zzass zzassVar) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(zzass zzassVar, zzatd zzatdVar) throws RemoteException {
    }

    public final zzdyz<InputStream> a(zzatl zzatlVar, int i) {
        zzaml a = zzp.p().a(this.a, zzazh.a());
        zzdga a2 = this.e.a(zzatlVar, i);
        zzamd a3 = a.a("google.afma.response.normalize", zzcpi.d, zzamg.b);
        zzcpj zzcpjVar = new zzcpj(this.a, zzatlVar.b.a, this.c, zzatlVar.g, i);
        zzdro c = a2.c();
        zzcpf zzcpfVar = null;
        if (!zzadf.a.a().booleanValue()) {
            if (zzatlVar.k != null && !zzatlVar.k.isEmpty()) {
                zzd.a("Request contained a PoolKey but split request is disabled.");
            }
        } else if (zzatlVar.k != null && !zzatlVar.k.isEmpty()) {
            zzcpf remove = this.f.remove(zzatlVar.k);
            if (remove == null) {
                zzd.a("Request contained a PoolKey but no matching parameters were found.");
            }
            zzcpfVar = remove;
        }
        if (zzcpfVar == null) {
            zzdyz<JSONObject> a4 = a(zzatlVar, c, a2);
            zzdyz<zzatr> a5 = a(a4, c, a);
            zzdqx a6 = c.a((zzdro) zzdrl.HTTP, a5, a4).a(new Callable(a4, a5) { // from class: com.google.android.gms.internal.ads.wo
                private final zzdyz a;
                private final zzdyz b;

                {
                    this.a = a4;
                    this.b = a5;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcpm((JSONObject) this.a.get(), (zzatr) this.b.get());
                }
            }).a((zzdqv) zzcpjVar).a();
            return c.a((zzdro) zzdrl.PRE_PROCESS, a4, a5, a6).a(new Callable(a6, a4, a5) { // from class: com.google.android.gms.internal.ads.wq
                private final zzdyz a;
                private final zzdyz b;
                private final zzdyz c;

                {
                    this.a = a6;
                    this.b = a4;
                    this.c = a5;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzcpi((zzcpl) this.a.get(), (JSONObject) this.b.get(), (zzatr) this.c.get());
                }
            }).a((zzdyb) a3).a();
        }
        zzdqx a7 = c.a((zzdro) zzdrl.HTTP, zzdyr.a(new zzcpm(zzcpfVar.b, zzcpfVar.a))).a((zzdqv<I, O2>) zzcpjVar).a();
        zzdyz<?> a8 = zzdyr.a(zzcpfVar);
        return c.a((zzdro) zzdrl.PRE_PROCESS, a7, a8).a(new Callable(a7, a8) { // from class: com.google.android.gms.internal.ads.wp
            private final zzdyz a;
            private final zzdyz b;

            {
                this.a = a7;
                this.b = a8;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdyz zzdyzVar = this.a;
                zzdyz zzdyzVar2 = this.b;
                return new zzcpi((zzcpl) zzdyzVar.get(), ((zzcpf) zzdyzVar2.get()).b, ((zzcpf) zzdyzVar2.get()).a);
            }
        }).a((zzdyb) a3).a();
    }

    private static zzdyz<JSONObject> a(zzatl zzatlVar, zzdro zzdroVar, zzdga zzdgaVar) {
        zzdyb zzdybVar = new zzdyb(zzdgaVar) { // from class: com.google.android.gms.internal.ads.ws
            private final zzdga a;

            {
                this.a = zzdgaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a().a(zzp.c().a((Bundle) obj));
            }
        };
        return zzdroVar.a((zzdro) zzdrl.GMS_SIGNALS, zzdyr.a(zzatlVar.a)).a((zzdyb<I, O2>) zzdybVar).a(wr.a).a();
    }

    private static zzdyz<zzatr> a(zzdyz<JSONObject> zzdyzVar, zzdro zzdroVar, zzaml zzamlVar) {
        return zzdroVar.a((zzdro) zzdrl.BUILD_URL, (zzdyz) zzdyzVar).a((zzdyb<I, O2>) zzamlVar.a("AFMA_getAdDictionary", zzamg.a, wv.a)).a();
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(zzatl zzatlVar, zzatf zzatfVar) {
        zzdyz<InputStream> a = a(zzatlVar, Binder.getCallingUid());
        a(a, zzatfVar);
        a.a(new Runnable(this) { // from class: com.google.android.gms.internal.ads.wt
            private final zzcou a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }, this.b);
    }

    public final zzdyz<InputStream> b(zzatl zzatlVar, int i) {
        if (!zzadf.a.a().booleanValue()) {
            return zzdyr.a((Throwable) new Exception("Split request is disabled."));
        }
        if (zzatlVar.j == null) {
            return zzdyr.a((Throwable) new Exception("Pool configuration missing from request."));
        }
        if (zzatlVar.j.c == 0 || zzatlVar.j.d == 0) {
            return zzdyr.a((Throwable) new Exception("Caching is disabled."));
        }
        zzaml a = zzp.p().a(this.a, zzazh.a());
        zzdga a2 = this.e.a(zzatlVar, i);
        zzdro c = a2.c();
        zzdyz<JSONObject> a3 = a(zzatlVar, c, a2);
        zzdyz<zzatr> a4 = a(a3, c, a);
        return c.a((zzdro) zzdrl.GET_URL_AND_CACHE_KEY, a3, a4).a(new Callable(this, a4, a3) { // from class: com.google.android.gms.internal.ads.wx
            private final zzcou a;
            private final zzdyz b;
            private final zzdyz c;

            {
                this.a = this;
                this.b = a4;
                this.c = a3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.a(this.b, this.c);
            }
        }).a();
    }

    public final zzdyz<InputStream> a(String str) {
        if (!zzadf.a.a().booleanValue()) {
            return zzdyr.a((Throwable) new Exception("Split request is disabled."));
        }
        wy wyVar = new wy(this);
        if (this.f.remove(str) == null) {
            String valueOf = String.valueOf(str);
            return zzdyr.a((Throwable) new Exception(valueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(valueOf) : new String("URL to be removed not found for cache key: ")));
        }
        return zzdyr.a(wyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void c(zzatl zzatlVar, zzatf zzatfVar) {
        a(b(zzatlVar, Binder.getCallingUid()), zzatfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(String str, zzatf zzatfVar) {
        a(a(str), zzatfVar);
    }

    public final zzdyz<InputStream> c(zzatl zzatlVar, int i) {
        zzaml a = zzp.p().a(this.a, zzazh.a());
        if (!zzadl.a.a().booleanValue()) {
            return zzdyr.a((Throwable) new Exception("Signal collection disabled."));
        }
        zzdga a2 = this.e.a(zzatlVar, i);
        zzdfl<JSONObject> b = a2.b();
        return a2.c().a((zzdro) zzdrl.GET_SIGNALS, zzdyr.a(zzatlVar.a)).a((zzdyb<I, O2>) new zzdyb(b) { // from class: com.google.android.gms.internal.ads.ww
            private final zzdfl a;

            {
                this.a = b;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(zzp.c().a((Bundle) obj));
            }
        }).a((zzdrg) zzdrl.JS_SIGNALS).a((zzdyb) a.a("google.afma.request.getSignals", zzamg.a, zzamg.b)).a();
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void b(zzatl zzatlVar, zzatf zzatfVar) {
        a(c(zzatlVar, Binder.getCallingUid()), zzatfVar);
    }

    private final void a(zzdyz<InputStream> zzdyzVar, zzatf zzatfVar) {
        zzdyr.a(zzdyr.a(zzdyzVar, new zzdyb(this) { // from class: com.google.android.gms.internal.ads.wz
            private final zzcou a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return zzdyr.a(zzdog.a((InputStream) obj));
            }
        }, zzazj.a), new xa(this, zzatfVar), zzazj.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream a(zzdyz zzdyzVar, zzdyz zzdyzVar2) throws Exception {
        String h = ((zzatr) zzdyzVar.get()).h();
        this.f.put(h, new zzcpf((zzatr) zzdyzVar.get(), (JSONObject) zzdyzVar2.get()));
        return new ByteArrayInputStream(h.getBytes(zzdvk.a));
    }

    final /* synthetic */ void a() {
        zzazm.a(this.d.a(), "persistFlags");
    }
}
