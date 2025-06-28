package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdir implements zzp, zzbrz, zzbto, zzdki {
    private final zzdpa a;
    private final AtomicReference<zzsl> b = new AtomicReference<>();
    private final AtomicReference<zzsm> c = new AtomicReference<>();
    private final AtomicReference<zzsq> d = new AtomicReference<>();
    private final AtomicReference<zzbto> e = new AtomicReference<>();
    private final AtomicReference<zzp> f = new AtomicReference<>();
    private zzdir g = null;

    public zzdir(zzdpa zzdpaVar) {
        this.a = zzdpaVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
    }

    public static zzdir a(zzdir zzdirVar) {
        zzdir zzdirVar2 = new zzdir(zzdirVar.a);
        zzdirVar2.a((zzdki) zzdirVar);
        return zzdirVar2;
    }

    public final void a(zzsl zzslVar) {
        this.b.set(zzslVar);
    }

    public final void a(zzsm zzsmVar) {
        this.c.set(zzsmVar);
    }

    public final void a(zzsq zzsqVar) {
        this.d.set(zzsqVar);
    }

    public final void a(zzbto zzbtoVar) {
        this.e.set(zzbtoVar);
    }

    public final void a(zzp zzpVar) {
        this.f.set(zzpVar);
    }

    public final void a(zzsg zzsgVar) {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.b, new zzdka(zzsgVar) { // from class: com.google.android.gms.internal.ads.afr
            private final zzsg a;

            {
                this.a = zzsgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzsl) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.b, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.aft
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzsl) obj).a(this.a);
            }
        });
        zzdkb.a(zzdirVar.b, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.afs
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzsl) obj).a(this.a.a);
            }
        });
    }

    public final void a() {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdirVar.a.a();
        zzdkb.a(zzdirVar.c, afv.a);
        zzdkb.a(zzdirVar.d, afu.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s() {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.e, afx.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.f, afw.a);
        zzdkb.a(zzdirVar.d, afz.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.f, new zzdka(zzlVar) { // from class: com.google.android.gms.internal.ads.afy
            private final com.google.android.gms.ads.internal.overlay.zzl a;

            {
                this.a = zzlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzp) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
        zzdir zzdirVar = this;
        while (zzdirVar.g != null) {
            zzdirVar = zzdirVar.g;
        }
        zzdkb.a(zzdirVar.f, agb.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdki
    public final void a(zzdki zzdkiVar) {
        this.g = (zzdir) zzdkiVar;
    }
}
