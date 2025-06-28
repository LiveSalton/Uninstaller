package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsu extends zzbwk<zzbru> {
    public zzbsu(Set<zzbxy<zzbru>> set) {
        super(set);
    }

    public final void a() {
        a(ne.a);
    }

    public final void b() {
        a(nd.a);
    }

    public final void c() {
        a(ng.a);
    }

    public final void d() {
        a(nf.a);
    }

    public final void a(zzauf zzaufVar, String str, String str2) {
        a(new zzbwm(zzaufVar, str, str2) { // from class: com.google.android.gms.internal.ads.ni
            private final zzauf a;
            private final String b;
            private final String c;

            {
                this.a = zzaufVar;
                this.b = str;
                this.c = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbru) obj).a(this.a, this.b, this.c);
            }
        });
    }

    public final void e() {
        a(nh.a);
    }
}
