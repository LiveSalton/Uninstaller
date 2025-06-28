package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdpv<AdT extends zzboc> {
    private final zzdpa a;

    @GuardedBy("this")
    private zzdqb b;

    @GuardedBy("this")
    private zzdzh<zzdpn<AdT>> c;

    @GuardedBy("this")
    private zzdyz<zzdpn<AdT>> d;
    private final zzdpd f;
    private final zzdqc<AdT> g;

    @GuardedBy("this")
    private int e = ajg.a;
    private final zzdyo<zzdpn<AdT>> i = new aje(this);
    private final LinkedList<zzdqb> h = new LinkedList<>();

    public zzdpv(zzdpd zzdpdVar, zzdpa zzdpaVar, zzdqc<AdT> zzdqcVar) {
        this.f = zzdpdVar;
        this.a = zzdpaVar;
        this.g = zzdqcVar;
        this.a.a(new zzdoz(this) { // from class: com.google.android.gms.internal.ads.ajb
            private final zzdpv a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdoz
            public final void a() {
                this.a.a();
            }
        });
    }

    public final void a(zzdqb zzdqbVar) {
        this.h.add(zzdqbVar);
    }

    public final synchronized zzdyz<zzdpz<AdT>> b(zzdqb zzdqbVar) {
        if (b()) {
            return null;
        }
        this.e = ajg.c;
        if (this.b.b() != null && zzdqbVar.b() != null && this.b.b().equals(zzdqbVar.b())) {
            this.e = ajg.b;
            return zzdyr.a(this.c, new zzdyb(this) { // from class: com.google.android.gms.internal.ads.ajc
                private final zzdpv a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    return this.a.a((zzdpn) obj);
                }
            }, zzdqbVar.a());
        }
        return null;
    }

    public final void c(zzdqb zzdqbVar) {
        while (b()) {
            if (zzdqbVar == null && this.h.isEmpty()) {
                return;
            }
            if (zzdqbVar == null) {
                zzdqbVar = this.h.remove();
            }
            if (zzdqbVar.b() != null && this.f.b(zzdqbVar.b())) {
                this.b = zzdqbVar.c();
                this.c = zzdzh.h();
                this.d = this.g.a(this.b);
                zzdyr.a(this.d, this.i, zzdqbVar.a());
                return;
            }
            zzdqbVar = null;
        }
        if (zzdqbVar != null) {
            this.h.add(zzdqbVar);
        }
    }

    private final boolean b() {
        return this.d == null || this.d.isDone();
    }

    final /* synthetic */ void a() {
        synchronized (this) {
            c(this.b);
        }
    }

    final /* synthetic */ zzdyz a(zzdpn zzdpnVar) throws Exception {
        zzdyz a;
        synchronized (this) {
            a = zzdyr.a(new zzdpz(zzdpnVar, this.b));
        }
        return a;
    }
}
