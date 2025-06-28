package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdlf extends AdMetadataListener implements zzbru, zzbrz, zzbsi, zzbtj, zzbub, zzdki {
    private final zzdpa a;
    private final AtomicReference<AdMetadataListener> b = new AtomicReference<>();
    private final AtomicReference<zzavp> c = new AtomicReference<>();
    private final AtomicReference<zzavi> d = new AtomicReference<>();
    private final AtomicReference<zzaup> e = new AtomicReference<>();
    private final AtomicReference<zzavq> f = new AtomicReference<>();
    private final AtomicReference<zzaug> g = new AtomicReference<>();
    private final AtomicReference<zzym> h = new AtomicReference<>();
    private zzdlf i = null;

    public zzdlf(zzdpa zzdpaVar) {
        this.a = zzdpaVar;
    }

    public static zzdlf a(zzdlf zzdlfVar) {
        zzdlf zzdlfVar2 = new zzdlf(zzdlfVar.a);
        zzdlfVar2.a((zzdki) zzdlfVar);
        return zzdlfVar2;
    }

    public final void a(zzavp zzavpVar) {
        this.c.set(zzavpVar);
    }

    public final void a(zzavi zzaviVar) {
        this.d.set(zzaviVar);
    }

    public final void a(zzavq zzavqVar) {
        this.f.set(zzavqVar);
    }

    public final void a(AdMetadataListener adMetadataListener) {
        this.b.set(adMetadataListener);
    }

    public final void a(zzym zzymVar) {
        this.h.set(zzymVar);
    }

    @Deprecated
    public final void a(zzaup zzaupVar) {
        this.e.set(zzaupVar);
    }

    @Deprecated
    public final void a(zzaug zzaugVar) {
        this.g.set(zzaugVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void a() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.c, ahd.a);
        zzdkb.a(zzdlfVar.e, ahf.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        int i = zzveVar.a;
        zzdkb.a(zzdlfVar.c, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.aho
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzavp) obj).a(this.a);
            }
        });
        zzdkb.a(zzdlfVar.c, new zzdka(i) { // from class: com.google.android.gms.internal.ads.ahr
            private final int a;

            {
                this.a = i;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzavp) obj).a(this.a);
            }
        });
        zzdkb.a(zzdlfVar.e, new zzdka(i) { // from class: com.google.android.gms.internal.ads.ahq
            private final int a;

            {
                this.a = i;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzaup) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.d, aht.a);
        zzdkb.a(zzdlfVar.e, ahs.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdlfVar.a.a();
        zzdkb.a(zzdlfVar.d, ahv.a);
        zzdkb.a(zzdlfVar.e, ahu.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.e, ahw.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.e, ahe.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.d, new zzdka(zzaufVar) { // from class: com.google.android.gms.internal.ads.ahh
            private final zzauf a;

            {
                this.a = zzaufVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                zzauf zzaufVar2 = this.a;
                ((zzavi) obj).a(new zzawd(zzaufVar2.a(), zzaufVar2.b()));
            }
        });
        zzdkb.a(zzdlfVar.f, new zzdka(zzaufVar, str, str2) { // from class: com.google.android.gms.internal.ads.ahg
            private final zzauf a;
            private final String b;
            private final String c;

            {
                this.a = zzaufVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                zzauf zzaufVar2 = this.a;
                ((zzavq) obj).a(new zzawd(zzaufVar2.a(), zzaufVar2.b()), this.b, this.c);
            }
        });
        zzdkb.a(zzdlfVar.e, new zzdka(zzaufVar) { // from class: com.google.android.gms.internal.ads.ahj
            private final zzauf a;

            {
                this.a = zzaufVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzaup) obj).a(this.a);
            }
        });
        zzdkb.a(zzdlfVar.g, new zzdka(zzaufVar, str, str2) { // from class: com.google.android.gms.internal.ads.ahi
            private final zzauf a;
            private final String b;
            private final String c;

            {
                this.a = zzaufVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzaug) obj).a(this.a, this.b, this.c);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.e, ahl.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final void a(zzve zzveVar) {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.d, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.ahk
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzavi) obj).a(this.a);
            }
        });
        zzdkb.a(zzdlfVar.d, new zzdka(zzveVar) { // from class: com.google.android.gms.internal.ads.ahn
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzavi) obj).a(this.a.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void k_() {
        if (this.i != null) {
            this.i.k_();
        } else {
            zzdkb.a(this.b, ahm.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbub
    public final void a(zzvp zzvpVar) {
        zzdlf zzdlfVar = this;
        while (zzdlfVar.i != null) {
            zzdlfVar = zzdlfVar.i;
        }
        zzdkb.a(zzdlfVar.h, new zzdka(zzvpVar) { // from class: com.google.android.gms.internal.ads.ahp
            private final zzvp a;

            {
                this.a = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzym) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdki
    public final void a(zzdki zzdkiVar) {
        this.i = (zzdlf) zzdkiVar;
    }
}
