package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbiu extends zzxv {
    private final Context a;
    private final zzazh b;
    private final zzciq c;
    private final zzcre<zzdoe, zzcsw> d;
    private final zzcwz e;
    private final zzclp f;
    private final zzawx g;
    private final zzcis h;

    @GuardedBy("this")
    private boolean i = false;

    zzbiu(Context context, zzazh zzazhVar, zzciq zzciqVar, zzcre<zzdoe, zzcsw> zzcreVar, zzcwz zzcwzVar, zzclp zzclpVar, zzawx zzawxVar, zzcis zzcisVar) {
        this.a = context;
        this.b = zzazhVar;
        this.c = zzciqVar;
        this.d = zzcreVar;
        this.e = zzcwzVar;
        this.f = zzclpVar;
        this.g = zzawxVar;
        this.h = zzcisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized void a() {
        if (this.i) {
            zzd.e("Mobile ads is initialized already.");
            return;
        }
        zzabf.a(this.a);
        zzp.g().a(this.a, this.b);
        zzp.i().a(this.a);
        this.i = true;
        this.f.b();
        if (((Boolean) zzwq.e().a(zzabf.aM)).booleanValue()) {
            this.e.a();
        }
        if (((Boolean) zzwq.e().a(zzabf.bN)).booleanValue()) {
            this.h.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized void a(float f) {
        zzp.h().a(f);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized float b() {
        return zzp.h().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized void a(boolean z) {
        zzp.h().a(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized boolean c() {
        return zzp.h().b();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final synchronized void a(String str) {
        zzabf.a(this.a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwq.e().a(zzabf.bM)).booleanValue()) {
                zzp.k().a(this.a, this.b, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzd.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        if (context == null) {
            zzd.c("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzag zzagVar = new com.google.android.gms.ads.internal.util.zzag(context);
        zzagVar.a(str);
        zzagVar.b(this.b.a);
        zzagVar.a();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(String str, IObjectWrapper iObjectWrapper) {
        zzabf.a(this.a);
        String str2 = "";
        if (((Boolean) zzwq.e().a(zzabf.bO)).booleanValue()) {
            zzp.c();
            str2 = com.google.android.gms.ads.internal.util.zzm.n(this.a);
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean booleanValue = ((Boolean) zzwq.e().a(zzabf.bM)).booleanValue() | ((Boolean) zzwq.e().a(zzabf.an)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzwq.e().a(zzabf.an)).booleanValue()) {
            booleanValue = true;
            runnable = new Runnable(this, (Runnable) ObjectWrapper.a(iObjectWrapper)) { // from class: com.google.android.gms.internal.ads.kv
                private final zzbiu a;
                private final Runnable b;

                {
                    this.a = this;
                    this.b = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzbiu zzbiuVar = this.a;
                    final Runnable runnable3 = this.b;
                    zzazj.e.execute(new Runnable(zzbiuVar, runnable3) { // from class: com.google.android.gms.internal.ads.kw
                        private final zzbiu a;
                        private final Runnable b;

                        {
                            this.a = zzbiuVar;
                            this.b = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a(this.b);
                        }
                    });
                }
            };
        }
        if (booleanValue) {
            zzp.k().a(this.a, this.b, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final String d() {
        return this.b.a;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void b(String str) {
        this.e.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzani zzaniVar) throws RemoteException {
        this.c.a(zzaniVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzajc zzajcVar) throws RemoteException {
        this.f.a(zzajcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final List<zzaiz> e() throws RemoteException {
        return this.f.c();
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzaae zzaaeVar) throws RemoteException {
        this.g.a(this.a, zzaaeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void f() {
        this.f.a();
    }

    final /* synthetic */ void a(Runnable runnable) {
        Preconditions.b("Adapters must be initialized on the main thread.");
        Map<String, zzanh> e = zzp.g().h().h().e();
        if (e == null || e.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzd.d("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.c.a()) {
            HashMap hashMap = new HashMap();
            Iterator<zzanh> it = e.values().iterator();
            while (it.hasNext()) {
                for (zzane zzaneVar : it.next().a) {
                    String str = zzaneVar.b;
                    for (String str2 : zzaneVar.a) {
                        if (!hashMap.containsKey(str2)) {
                            hashMap.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) hashMap.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzcrb<zzdoe, zzcsw> a = this.d.a(str3, jSONObject);
                    if (a != null) {
                        zzdoe zzdoeVar = a.b;
                        if (!zzdoeVar.g() && zzdoeVar.j()) {
                            zzdoeVar.a(this.a, a.c, (List<String>) entry.getValue());
                            String valueOf = String.valueOf(str3);
                            zzd.b(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (zzdnr e2) {
                    StringBuilder sb = new StringBuilder(56 + String.valueOf(str3).length());
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzd.d(sb.toString(), e2);
                }
            }
        }
    }
}
