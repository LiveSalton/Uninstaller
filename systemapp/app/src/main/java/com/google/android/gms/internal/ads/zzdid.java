package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdid extends zzxf implements com.google.android.gms.ads.internal.overlay.zzz, zzbto, zzsc {

    @GuardedBy("this")
    protected zzbll a;
    private final zzbgm b;
    private final Context c;
    private final ViewGroup d;
    private final String f;
    private final zzdib g;
    private final zzdir h;
    private final zzazh i;
    private zzbkv k;
    private AtomicBoolean e = new AtomicBoolean();
    private long j = -1;

    public zzdid(zzbgm zzbgmVar, Context context, String str, zzdib zzdibVar, zzdir zzdirVar, zzazh zzazhVar) {
        this.d = new FrameLayout(context);
        this.b = zzbgmVar;
        this.c = context;
        this.f = str;
        this.g = zzdibVar;
        this.h = zzdirVar;
        zzdirVar.a(this);
        this.i = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxj zzxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() {
        Preconditions.b("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.a(this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) {
        this.g.a(zzvwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean a(zzvk zzvkVar) throws RemoteException {
        Preconditions.b("loadAd must be called on the main UI thread.");
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.c) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            this.h.a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
            return false;
        }
        if (q()) {
            return false;
        }
        this.e = new AtomicBoolean();
        return this.g.a(zzvkVar, this.f, new afj(this), new afl(this));
    }

    public final com.google.android.gms.ads.internal.overlay.zzr b(zzbll zzbllVar) {
        boolean f = zzbllVar.f();
        int intValue = ((Integer) zzwq.e().a(zzabf.cs)).intValue();
        com.google.android.gms.ads.internal.overlay.zzq zzqVar = new com.google.android.gms.ads.internal.overlay.zzq();
        zzqVar.e = 50;
        zzqVar.a = f ? intValue : 0;
        zzqVar.b = f ? 0 : intValue;
        zzqVar.c = 0;
        zzqVar.d = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzr(this.c, zzqVar, this);
    }

    public static RelativeLayout.LayoutParams c(zzbll zzbllVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbllVar.f() ? 11 : 9);
        return layoutParams;
    }

    public final void d(zzbll zzbllVar) {
        zzbllVar.a(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzz
    public final void j_() {
        a(zzblb.d);
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void t() {
        a(zzblb.c);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s() {
        if (this.a == null) {
            return;
        }
        this.j = zzp.j().b();
        int c = this.a.c();
        if (c <= 0) {
            return;
        }
        this.k = new zzbkv(this.b.b(), zzp.j());
        this.k.a(c, new Runnable(this) { // from class: com.google.android.gms.internal.ads.afk
            private final zzdid a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.u();
            }
        });
    }

    private final synchronized void a(int i) {
        if (this.e.compareAndSet(false, true)) {
            if (this.a != null && this.a.h() != null) {
                this.h.a(this.a.h());
            }
            this.h.a();
            this.d.removeAllViews();
            if (this.k != null) {
                zzp.f().b(this.k);
            }
            if (this.a != null) {
                long j = -1;
                if (this.j != -1) {
                    j = zzp.j().b() - this.j;
                }
                this.a.a(j, i);
            }
            b();
        }
    }

    public final zzvn w() {
        return zzdns.a(this.c, (List<zzdmx>) Collections.singletonList(this.a.a()));
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void b() {
        Preconditions.b("destroy must be called on the main UI thread.");
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void d() {
        Preconditions.b("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void e() {
        Preconditions.b("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) {
        this.h.a(zzslVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzvn j() {
        Preconditions.b("getAdSize must be called on the main UI thread.");
        if (this.a == null) {
            return null;
        }
        return zzdns.a(this.c, (List<zzdmx>) Collections.singletonList(this.a.a()));
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzvn zzvnVar) {
        Preconditions.b("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String k() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String l() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzyn m() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean q() {
        return this.g.a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String n() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void i() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzxu zzxuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzys r() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzaak zzaakVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzacb zzacbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final Bundle f() {
        return new Bundle();
    }

    final /* synthetic */ void u() {
        zzwq.a();
        if (zzayr.b()) {
            a(zzblb.e);
        } else {
            this.b.a().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.afi
                private final zzdid a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v();
                }
            });
        }
    }

    final /* synthetic */ void v() {
        a(zzblb.e);
    }
}
