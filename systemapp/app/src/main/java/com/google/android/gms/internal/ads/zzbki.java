package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbki implements zzp, zzbsm, zzbsp, zzqu {
    private final zzbjz a;
    private final zzbkg b;
    private final zzamx<JSONObject, JSONObject> d;
    private final Executor e;
    private final Clock f;
    private final Set<zzbdv> c = new HashSet();
    private final AtomicBoolean g = new AtomicBoolean(false);

    @GuardedBy("this")
    private final zzbkk h = new zzbkk();
    private boolean i = false;
    private WeakReference<?> j = new WeakReference<>(this);

    public zzbki(zzamq zzamqVar, zzbkg zzbkgVar, Executor executor, zzbjz zzbjzVar, Clock clock) {
        this.a = zzbjzVar;
        this.d = zzamqVar.a("google.afma.activeView.handleUpdate", zzamg.a, zzamg.a);
        this.b = zzbkgVar;
        this.e = executor;
        this.f = clock;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
    }

    public final synchronized void a() {
        if (!(this.j.get() != null)) {
            e();
            return;
        }
        if (!this.i && this.g.get()) {
            try {
                this.h.c = this.f.b();
                JSONObject a = this.b.a(this.h);
                Iterator<zzbdv> it = this.c.iterator();
                while (it.hasNext()) {
                    this.e.execute(new Runnable(it.next(), a) { // from class: com.google.android.gms.internal.ads.lj
                        private final zzbdv a;
                        private final JSONObject b;

                        {
                            this.a = zzbdvVar;
                            this.b = a;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a("AFMA_updateActiveView", this.b);
                        }
                    });
                }
                zzazm.b(this.d.a((zzamx<JSONObject, JSONObject>) a), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzd.a("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void g() {
        Iterator<zzbdv> it = this.c.iterator();
        while (it.hasNext()) {
            this.a.b(it.next());
        }
        this.a.a();
    }

    public final synchronized void e() {
        g();
        this.i = true;
    }

    public final synchronized void a(zzbdv zzbdvVar) {
        this.c.add(zzbdvVar);
        this.a.a(zzbdvVar);
    }

    public final void a(Object obj) {
        this.j = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void a(zzqv zzqvVar) {
        this.h.a = zzqvVar.j;
        this.h.e = zzqvVar;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final synchronized void a(Context context) {
        this.h.b = true;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final synchronized void b(Context context) {
        this.h.b = false;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final synchronized void c(Context context) {
        this.h.d = "u";
        a();
        g();
        this.i = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void b_() {
        this.h.b = true;
        a();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void g_() {
        this.h.b = false;
        a();
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void b() {
        if (this.g.compareAndSet(false, true)) {
            this.a.a(this);
            a();
        }
    }
}
