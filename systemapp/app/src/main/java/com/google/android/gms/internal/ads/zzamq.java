package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzamq {
    private zzalb a;
    private zzdyz<zzalz> b;

    zzamq(zzalb zzalbVar) {
        this.a = zzalbVar;
    }

    private final void a() {
        if (this.b == null) {
            zzazq zzazqVar = new zzazq();
            this.b = zzazqVar;
            this.a.b((zzef) null).a(new zzazu(zzazqVar) { // from class: com.google.android.gms.internal.ads.cs
                private final zzazq a;

                {
                    this.a = zzazqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzazu
                public final void a(Object obj) {
                    this.a.b((zzalz) obj);
                }
            }, new zzazs(zzazqVar) { // from class: com.google.android.gms.internal.ads.cr
                private final zzazq a;

                {
                    this.a = zzazqVar;
                }

                @Override // com.google.android.gms.internal.ads.zzazs
                public final void a() {
                    this.a.a(new zzama("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final <I, O> zzamx<I, O> a(String str, zzame<I> zzameVar, zzamf<O> zzamfVar) {
        a();
        return new zzamx<>(this.b, str, zzameVar, zzamfVar);
    }

    public final void a(String str, zzahv<? super zzalz> zzahvVar) {
        a();
        this.b = zzdyr.a(this.b, new zzdyb(str, zzahvVar) { // from class: com.google.android.gms.internal.ads.cu
            private final String a;
            private final zzahv b;

            {
                this.a = str;
                this.b = zzahvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                zzalz zzalzVar = (zzalz) obj;
                zzalzVar.a(this.a, this.b);
                return zzdyr.a(zzalzVar);
            }
        }, zzazj.f);
    }

    public final void b(String str, zzahv<? super zzalz> zzahvVar) {
        this.b = zzdyr.a(this.b, new zzdvm(str, zzahvVar) { // from class: com.google.android.gms.internal.ads.ct
            private final String a;
            private final zzahv b;

            {
                this.a = str;
                this.b = zzahvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                zzalz zzalzVar = (zzalz) obj;
                zzalzVar.b(this.a, this.b);
                return zzalzVar;
            }
        }, zzazj.f);
    }
}
