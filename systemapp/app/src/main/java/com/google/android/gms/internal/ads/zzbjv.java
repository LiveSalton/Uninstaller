package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjv implements zzbru, zzbsi, zzbsm, zzbtj, zzva {
    private final Context a;
    private final Executor b;
    private final ScheduledExecutorService c;
    private final zzdnj d;
    private final zzdmu e;
    private final zzdrx f;
    private final zzdnv g;
    private final zzef h;
    private final zzacg i;
    private final zzacl j;
    private final View k;

    @GuardedBy("this")
    private boolean l;

    @GuardedBy("this")
    private boolean m;

    public zzbjv(Context context, Executor executor, ScheduledExecutorService scheduledExecutorService, zzdnj zzdnjVar, zzdmu zzdmuVar, zzdrx zzdrxVar, zzdnv zzdnvVar, View view, zzef zzefVar, zzacg zzacgVar, zzacl zzaclVar) {
        this.a = context;
        this.b = executor;
        this.c = scheduledExecutorService;
        this.d = zzdnjVar;
        this.e = zzdmuVar;
        this.f = zzdrxVar;
        this.g = zzdnvVar;
        this.h = zzefVar;
        this.k = view;
        this.i = zzacgVar;
        this.j = zzaclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final synchronized void a() {
        if (this.l) {
            ArrayList arrayList = new ArrayList(this.e.d);
            arrayList.addAll(this.e.f);
            this.g.a(this.f.a(this.d, this.e, true, null, null, arrayList));
        } else {
            this.g.a(this.f.a(this.d, this.e, this.e.m));
            this.g.a(this.f.a(this.d, this.e, this.e.f));
        }
        this.l = true;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if ((((Boolean) zzwq.e().a(zzabf.ae)).booleanValue() && this.d.b.b.g) || !zzacy.a.a().booleanValue()) {
            zzdnv zzdnvVar = this.g;
            List<String> a = this.f.a(this.d, this.e, this.e.c);
            zzp.c();
            zzdnvVar.a(a, com.google.android.gms.ads.internal.util.zzm.p(this.a) ? zzcql.b : zzcql.a);
            return;
        }
        zzdyr.a(zzdyi.c((zzdyz) this.j.a(this.a, this.i.a(), this.i.b())).a(((Long) zzwq.e().a(zzabf.at)).longValue(), TimeUnit.MILLISECONDS, this.c), new le(this), this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final synchronized void b() {
        if (!this.m) {
            String a = ((Boolean) zzwq.e().a(zzabf.bv)).booleanValue() ? this.h.a().a(this.a, this.k, (Activity) null) : null;
            if (!(((Boolean) zzwq.e().a(zzabf.ae)).booleanValue() && this.d.b.b.g) && zzacy.b.a().booleanValue()) {
                zzdyr.a(zzdyi.c((zzdyz) this.j.a(this.a)).a(((Long) zzwq.e().a(zzabf.at)).longValue(), TimeUnit.MILLISECONDS, this.c), new ld(this, a), this.b);
                this.m = true;
            }
            this.g.a(this.f.a(this.d, this.e, false, a, null, this.e.d));
            this.m = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
        this.g.a(this.f.a(this.e, this.e.h, zzaufVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
        this.g.a(this.f.a(this.d, this.e, this.e.g));
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
        this.g.a(this.f.a(this.d, this.e, this.e.i));
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final void a(zzve zzveVar) {
        if (((Boolean) zzwq.e().a(zzabf.aP)).booleanValue()) {
            this.g.a(this.f.a(this.d, this.e, zzdrx.a(2, zzveVar.a, this.e.n)));
        }
    }
}
