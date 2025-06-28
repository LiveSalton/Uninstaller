package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zza;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzchr {
    private final zzbrt a;
    private final zzbsu b;
    private final zzbti c;
    private final zzbtr d;
    private final zzbvy e;
    private final Executor f;
    private final zzbxx g;
    private final zzbki h;
    private final zza i;
    private final zzbso j;
    private final zzawq k;
    private final zzef l;
    private final zzbvr m;
    private final zzcqo n;
    private final zzdrz o;
    private final zzckq p;

    public zzchr(zzbrt zzbrtVar, zzbsu zzbsuVar, zzbti zzbtiVar, zzbtr zzbtrVar, zzbvy zzbvyVar, Executor executor, zzbxx zzbxxVar, zzbki zzbkiVar, zza zzaVar, zzbso zzbsoVar, zzawq zzawqVar, zzef zzefVar, zzbvr zzbvrVar, zzcqo zzcqoVar, zzdrz zzdrzVar, zzckq zzckqVar) {
        this.a = zzbrtVar;
        this.b = zzbsuVar;
        this.c = zzbtiVar;
        this.d = zzbtrVar;
        this.e = zzbvyVar;
        this.f = executor;
        this.g = zzbxxVar;
        this.h = zzbkiVar;
        this.i = zzaVar;
        this.j = zzbsoVar;
        this.k = zzawqVar;
        this.l = zzefVar;
        this.m = zzbvrVar;
        this.n = zzcqoVar;
        this.o = zzdrzVar;
        this.p = zzckqVar;
    }

    public final void a(zzbdv zzbdvVar, boolean z) {
        zzdv a;
        zzbdvVar.z().a(new zzva(this) { // from class: com.google.android.gms.internal.ads.tl
            private final zzchr a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzva
            public final void e() {
                this.a.b();
            }
        }, this.c, this.d, new zzaha(this) { // from class: com.google.android.gms.internal.ads.tk
            private final zzchr a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaha
            public final void a(String str, String str2) {
                this.a.a(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzu(this) { // from class: com.google.android.gms.internal.ads.tn
            private final zzchr a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzu
            public final void a() {
                this.a.a();
            }
        }, z, null, this.i, new tt(this), this.k, this.n, this.o, this.p);
        zzbdvVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.tm
            private final zzchr a;

            {
                this.a = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.a(view, motionEvent);
            }
        });
        zzbdvVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.tp
            private final zzchr a;

            {
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a(view);
            }
        });
        if (((Boolean) zzwq.e().a(zzabf.bi)).booleanValue() && (a = this.l.a()) != null) {
            a.a(zzbdvVar.getView());
        }
        this.g.a(zzbdvVar, this.f);
        this.g.a(new zzqu(zzbdvVar) { // from class: com.google.android.gms.internal.ads.to
            private final zzbdv a;

            {
                this.a = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void a(zzqv zzqvVar) {
                this.a.z().a(zzqvVar.d.left, zzqvVar.d.top, false);
            }
        }, this.f);
        this.g.a(zzbdvVar.getView());
        zzbdvVar.a("/trackActiveViewUnit", new zzahv(this, zzbdvVar) { // from class: com.google.android.gms.internal.ads.ts
            private final zzchr a;
            private final zzbdv b;

            {
                this.a = this;
                this.b = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a(this.b, (zzbdv) obj, map);
            }
        });
        this.h.a((Object) zzbdvVar);
        if (((Boolean) zzwq.e().a(zzabf.al)).booleanValue()) {
            return;
        }
        zzbso zzbsoVar = this.j;
        zzbdvVar.getClass();
        zzbsoVar.a(tq.a(zzbdvVar), this.f);
    }

    public static zzdyz<?> a(zzbdv zzbdvVar, String str, String str2) {
        zzazq zzazqVar = new zzazq();
        zzbdvVar.z().a(new zzbfj(zzazqVar) { // from class: com.google.android.gms.internal.ads.tu
            private final zzazq a;

            {
                this.a = zzazqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbfj
            public final void a(boolean z) {
                zzazq zzazqVar2 = this.a;
                if (z) {
                    zzazqVar2.b(null);
                } else {
                    zzazqVar2.a(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbdvVar.a(str, str2, (String) null);
        return zzazqVar;
    }

    final /* synthetic */ void a(zzbdv zzbdvVar, zzbdv zzbdvVar2, Map map) {
        this.h.a(zzbdvVar);
    }

    final /* synthetic */ void a(View view) {
        this.i.a();
        if (this.k != null) {
            this.k.c();
        }
    }

    final /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        this.i.a();
        if (this.k == null) {
            return false;
        }
        this.k.c();
        return false;
    }

    final /* synthetic */ void a() {
        this.b.b();
    }

    final /* synthetic */ void a(String str, String str2) {
        this.e.a(str, str2);
    }

    final /* synthetic */ void b() {
        this.a.e();
    }
}
