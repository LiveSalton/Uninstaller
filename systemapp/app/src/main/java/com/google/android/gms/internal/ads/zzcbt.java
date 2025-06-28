package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbt extends zzboc {
    private final Executor c;
    private final zzcce d;
    private final zzccm e;
    private final zzcda f;
    private final zzcci g;
    private final zzccl h;
    private final zzeoz<zzcfz> i;
    private final zzeoz<zzcfx> j;
    private final zzeoz<zzcgg> k;
    private final zzeoz<zzcft> l;
    private final zzeoz<zzcgb> m;
    private zzcdy n;
    private boolean o;
    private boolean p;
    private final zzawu q;
    private final zzef r;
    private final zzazh s;
    private final Context t;
    private final zzcbz u;
    private final zzcyb v;

    public zzcbt(zzbob zzbobVar, Executor executor, zzcce zzcceVar, zzccm zzccmVar, zzcda zzcdaVar, zzcci zzcciVar, zzccl zzcclVar, zzeoz<zzcfz> zzeozVar, zzeoz<zzcfx> zzeozVar2, zzeoz<zzcgg> zzeozVar3, zzeoz<zzcft> zzeozVar4, zzeoz<zzcgb> zzeozVar5, zzawu zzawuVar, zzef zzefVar, zzazh zzazhVar, Context context, zzcbz zzcbzVar, zzcyb zzcybVar) {
        super(zzbobVar);
        this.p = false;
        this.c = executor;
        this.d = zzcceVar;
        this.e = zzccmVar;
        this.f = zzcdaVar;
        this.g = zzcciVar;
        this.h = zzcclVar;
        this.i = zzeozVar;
        this.j = zzeozVar2;
        this.k = zzeozVar3;
        this.l = zzeozVar4;
        this.m = zzeozVar5;
        this.q = zzawuVar;
        this.r = zzefVar;
        this.s = zzazhVar;
        this.t = context;
        this.u = zzcbzVar;
        this.v = zzcybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void d_() {
        this.c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qu
            private final zzcbt a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.p();
            }
        });
        if (this.d.a() != 7) {
            Executor executor = this.c;
            zzccm zzccmVar = this.e;
            zzccmVar.getClass();
            executor.execute(qt.a(zzccmVar));
        }
        super.d_();
    }

    public final synchronized void a(String str) {
        this.e.a(str);
    }

    public final synchronized void a() {
        if (this.o) {
            return;
        }
        this.e.c();
    }

    public final synchronized void a(Bundle bundle) {
        this.e.a(bundle);
    }

    public final synchronized boolean b(Bundle bundle) {
        if (this.o) {
            return true;
        }
        boolean c = this.e.c(bundle);
        this.o = c;
        return c;
    }

    public final synchronized void c(Bundle bundle) {
        this.e.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final synchronized void b() {
        this.c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.qw
            private final zzcbt a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.o();
            }
        });
        super.b();
    }

    public final synchronized void a(zzcdy zzcdyVar) {
        zzdv a;
        this.n = zzcdyVar;
        this.f.a(zzcdyVar);
        this.e.a(zzcdyVar.c(), zzcdyVar.f(), zzcdyVar.g(), zzcdyVar, zzcdyVar);
        if (((Boolean) zzwq.e().a(zzabf.bi)).booleanValue() && (a = this.r.a()) != null) {
            a.a(zzcdyVar.c());
        }
        if (zzcdyVar.d() != null) {
            zzcdyVar.d().a(this.q);
        }
    }

    public final synchronized void b(zzcdy zzcdyVar) {
        this.e.a(zzcdyVar.c(), zzcdyVar.e());
        if (zzcdyVar.b() != null) {
            zzcdyVar.b().setClickable(false);
            zzcdyVar.b().removeAllViews();
        }
        if (zzcdyVar.d() != null) {
            zzcdyVar.d().b(this.q);
        }
        this.n = null;
    }

    public final synchronized void a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.f.b(this.n);
        this.e.a(view, view2, map, map2, z);
        if (this.p) {
            if (((Boolean) zzwq.e().a(zzabf.bD)).booleanValue() && this.d.v() != null) {
                this.d.v().a("onSdkAdUserInteractionClick", new androidx.b.a());
            }
        }
    }

    public final synchronized void a(View view, MotionEvent motionEvent, View view2) {
        this.e.a(view, motionEvent, view2);
    }

    public final synchronized void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.o) {
            return;
        }
        if (z) {
            this.f.c(this.n);
            this.e.b(view, map, map2);
            this.o = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzwq.e().a(zzabf.bJ)).booleanValue() && map != null) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null && b(view2)) {
                        this.f.c(this.n);
                        this.e.b(view, map, map2);
                        this.o = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized JSONObject a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.e.a(view, map, map2);
    }

    public final synchronized void a(View view) {
        this.e.a(view);
    }

    public final synchronized void a(zzage zzageVar) {
        this.e.a(zzageVar);
    }

    public final synchronized void c() {
        this.e.d();
    }

    public final synchronized void a(zzyd zzydVar) {
        this.e.a(zzydVar);
    }

    public final synchronized void a(zzxz zzxzVar) {
        this.e.a(zzxzVar);
    }

    public final synchronized void d() {
        this.e.a();
    }

    public final synchronized void e() {
        if (this.n == null) {
            zzd.b("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.c.execute(new Runnable(this, this.n instanceof zzccv) { // from class: com.google.android.gms.internal.ads.qv
                private final zzcbt a;
                private final boolean b;

                {
                    this.a = this;
                    this.b = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b);
                }
            });
        }
    }

    public final synchronized boolean f() {
        return this.e.b();
    }

    public static boolean b(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final boolean g() {
        return this.g.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.a(java.lang.String, boolean):void");
    }

    public final boolean i() {
        return this.g.d();
    }

    public final void c(View view) {
        IObjectWrapper x = this.d.x();
        boolean z = this.d.w() != null;
        if (!this.g.d() || x == null || !z || view == null) {
            return;
        }
        zzp.r().a(x, view);
    }

    public final void d(View view) {
        IObjectWrapper x = this.d.x();
        if (!this.g.d() || x == null || view == null) {
            return;
        }
        zzp.r().b(x, view);
    }

    public final zzcbz n() {
        return this.u;
    }

    public final synchronized void a(zzym zzymVar) {
        this.v.a(zzymVar);
    }

    final /* synthetic */ void a(boolean z) {
        this.e.a(this.n.c(), this.n.e(), this.n.f(), z);
    }

    final /* synthetic */ void o() {
        this.e.g();
        this.d.C();
    }

    final /* synthetic */ void p() {
        try {
            switch (this.d.a()) {
                case 1:
                    if (this.h.a() != null) {
                        a("Google", true);
                        this.h.a().a(this.i.b());
                        break;
                    }
                    break;
                case 2:
                    if (this.h.b() != null) {
                        a("Google", true);
                        this.h.b().a(this.j.b());
                        break;
                    }
                    break;
                case 3:
                    if (this.h.a(this.d.u()) != null) {
                        if (this.d.v() != null) {
                            a("Google", true);
                        }
                        this.h.a(this.d.u()).a(this.m.b());
                        break;
                    }
                    break;
                case 4:
                case 5:
                default:
                    zzd.c("Wrong native template id!");
                    break;
                case 6:
                    if (this.h.c() != null) {
                        a("Google", true);
                        this.h.c().a(this.k.b());
                        break;
                    }
                    break;
                case 7:
                    if (this.h.e() != null) {
                        this.h.e().a(this.l.b());
                        break;
                    }
                    break;
            }
        } catch (RemoteException e) {
            zzd.c("RemoteException when notifyAdLoad is called", e);
        }
    }
}
