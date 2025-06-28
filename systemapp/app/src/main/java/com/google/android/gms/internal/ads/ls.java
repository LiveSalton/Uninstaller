package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class ls extends zzbme {
    private final Context c;
    private final View d;
    private final zzbdv e;
    private final zzdmx f;
    private final zzbnz g;
    private final zzccl h;
    private final zzbyc i;
    private final zzeoz<zzcxi> j;
    private final Executor k;
    private zzvn l;

    ls(zzbob zzbobVar, Context context, zzdmx zzdmxVar, View view, zzbdv zzbdvVar, zzbnz zzbnzVar, zzccl zzcclVar, zzbyc zzbycVar, zzeoz<zzcxi> zzeozVar, Executor executor) {
        super(zzbobVar);
        this.c = context;
        this.d = view;
        this.e = zzbdvVar;
        this.f = zzdmxVar;
        this.g = zzbnzVar;
        this.h = zzcclVar;
        this.i = zzbycVar;
        this.j = zzeozVar;
        this.k = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final View a() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void a(ViewGroup viewGroup, zzvn zzvnVar) {
        if (viewGroup == null || this.e == null) {
            return;
        }
        this.e.a(zzbfn.a(zzvnVar));
        viewGroup.setMinimumHeight(zzvnVar.c);
        viewGroup.setMinimumWidth(zzvnVar.f);
        this.l = zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzys c() {
        try {
            return this.g.a();
        } catch (zzdnr unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzdmx d() {
        boolean z;
        if (this.l != null) {
            return zzdns.a(this.l);
        }
        if (this.b.X) {
            Iterator<String> it = this.b.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdmx(this.d.getWidth(), this.d.getHeight(), false);
            }
        }
        return zzdns.a(this.b.q, this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final zzdmx e() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final int f() {
        if (((Boolean) zzwq.e().a(zzabf.ec)).booleanValue() && this.b.ac) {
            if (!((Boolean) zzwq.e().a(zzabf.ed)).booleanValue()) {
                return 0;
            }
        }
        return this.a.b.b.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void g() {
        this.i.a();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void d_() {
        this.k.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.lr
            private final ls a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i();
            }
        });
        super.d_();
    }

    final /* synthetic */ void i() {
        if (this.h.d() != null) {
            try {
                this.h.d().a(this.j.b(), ObjectWrapper.a(this.c));
            } catch (RemoteException e) {
                zzd.c("RemoteException when notifyAdLoad is called", e);
            }
        }
    }
}
