package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbul extends AdMetadataListener implements AppEventListener, zzp, zzbru, zzbsi, zzbsm, zzbto, zzbub, zzva {
    private final zzbvn a = new zzbvn(this);

    @Nullable
    private zzcxq b;

    @Nullable
    private zzcyd c;

    @Nullable
    private zzdir d;

    @Nullable
    private zzdlf e;

    public final zzbvn i() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        a(this.b, (oz<zzcxq>) nx.a);
        a(this.e, (oz<zzdlf>) nz.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
        a(this.b, (oz<zzcxq>) oi.a);
        a(this.e, (oz<zzdlf>) os.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
        a(this.b, (oz<zzcxq>) or.a);
        a(this.e, (oz<zzdlf>) ou.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
        a(this.b, (oz<zzcxq>) ot.a);
        a(this.e, (oz<zzdlf>) ow.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
        a(this.b, (oz<zzcxq>) new oz(zzaufVar, str, str2) { // from class: com.google.android.gms.internal.ads.ov
            private final zzauf a;
            private final String b;
            private final String c;

            {
                this.a = zzaufVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
            }
        });
        a(this.e, (oz<zzdlf>) new oz(zzaufVar, str, str2) { // from class: com.google.android.gms.internal.ads.oy
            private final zzauf a;
            private final String b;
            private final String c;

            {
                this.a = zzaufVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzdlf) obj).a(this.a, this.b, this.c);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
        a(this.b, (oz<zzcxq>) ny.a);
        a(this.e, (oz<zzdlf>) ob.a);
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        a(this.b, (oz<zzcxq>) oa.a);
        a(this.c, (oz<zzcyd>) od.a);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void a(String str, String str2) {
        a(this.b, (oz<zzcxq>) new oz(str, str2) { // from class: com.google.android.gms.internal.ads.oc
            private final String a;
            private final String b;

            {
                this.a = str;
                this.b = str2;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzcxq) obj).a(this.a, this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbub
    public final void a(zzvp zzvpVar) {
        a(this.b, (oz<zzcxq>) new oz(zzvpVar) { // from class: com.google.android.gms.internal.ads.of
            private final zzvp a;

            {
                this.a = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzcxq) obj).a(this.a);
            }
        });
        a(this.e, (oz<zzdlf>) new oz(zzvpVar) { // from class: com.google.android.gms.internal.ads.oe
            private final zzvp a;

            {
                this.a = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzdlf) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        a(this.b, (oz<zzcxq>) oh.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s() {
        a(this.d, (oz<zzdir>) og.a);
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void k_() {
        a(this.e, (oz<zzdlf>) oj.a);
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final void a(zzve zzveVar) {
        a(this.e, (oz<zzdlf>) new oz(zzveVar) { // from class: com.google.android.gms.internal.ads.ol
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzdlf) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        a(this.d, (oz<zzdir>) ok.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        a(this.d, (oz<zzdir>) new oz(zzlVar) { // from class: com.google.android.gms.internal.ads.oo
            private final com.google.android.gms.ads.internal.overlay.zzl a;

            {
                this.a = zzlVar;
            }

            @Override // com.google.android.gms.internal.ads.oz
            public final void a(Object obj) {
                ((zzdir) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
        a(this.d, (oz<zzdir>) on.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
        a(this.d, (oz<zzdir>) oq.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
        a(this.d, (oz<zzdir>) op.a);
    }

    private static <T> void a(T t, oz<T> ozVar) {
        if (t != null) {
            ozVar.a(t);
        }
    }
}
