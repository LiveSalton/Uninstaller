package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdjf extends zzxf implements zzp, zzsc {

    @GuardedBy("this")
    protected zzblv a;
    private final zzbgm b;
    private final Context c;
    private final String e;
    private final zzdjd f;
    private final zzdir g;

    @GuardedBy("this")
    private zzbkv i;
    private AtomicBoolean d = new AtomicBoolean();

    @GuardedBy("this")
    private long h = -1;

    public zzdjf(zzbgm zzbgmVar, Context context, String str, zzdjd zzdjdVar, zzdir zzdirVar) {
        this.b = zzbgmVar;
        this.c = context;
        this.e = str;
        this.f = zzdjdVar;
        this.g = zzdirVar;
        zzdirVar.a(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() {
        return null;
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

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
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
    public final void a(zzvw zzvwVar) {
        this.f.a(zzvwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean a(zzvk zzvkVar) throws RemoteException {
        Preconditions.b("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.c) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            this.g.a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
            return false;
        }
        if (q()) {
            return false;
        }
        this.d = new AtomicBoolean();
        return this.f.a(zzvkVar, this.e, new agd(this), new agg(this));
    }

    public final void a(zzblv zzblvVar) {
        zzblvVar.a(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        switch (zzlVar) {
            case CUSTOM_CLOSE:
                a(zzblb.c);
                break;
            case BACK_BUTTON:
                a(zzblb.b);
                break;
            case CLOSE_BUTTON:
                a(zzblb.d);
                break;
            case OTHER:
                a(zzblb.f);
                break;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void f_() {
        if (this.a != null) {
            this.a.a(com.google.android.gms.ads.internal.zzp.j().b() - this.h, zzblb.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void t() {
        a(zzblb.c);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void e_() {
        if (this.a == null) {
            return;
        }
        this.h = com.google.android.gms.ads.internal.zzp.j().b();
        int a = this.a.a();
        if (a <= 0) {
            return;
        }
        this.i = new zzbkv(this.b.b(), com.google.android.gms.ads.internal.zzp.j());
        this.i.a(a, new Runnable(this) { // from class: com.google.android.gms.internal.ads.age
            private final zzdjf a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.s();
            }
        });
    }

    private final synchronized void a(int i) {
        if (this.d.compareAndSet(false, true)) {
            this.g.a();
            if (this.i != null) {
                com.google.android.gms.ads.internal.zzp.f().b(this.i);
            }
            if (this.a != null) {
                long j = -1;
                if (this.h != -1) {
                    j = com.google.android.gms.ads.internal.zzp.j().b() - this.h;
                }
                this.a.a(j, i);
            }
            b();
        }
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
        this.g.a(zzslVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzvn zzvnVar) {
        Preconditions.b("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean q() {
        return this.f.a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String n() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzyn m() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzvn j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void g() {
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

    final /* synthetic */ void s() {
        this.b.a().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.agc
            private final zzdjf a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.u();
            }
        });
    }

    final /* synthetic */ void u() {
        a(zzblb.e);
    }
}
