package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class cj implements zzazu<zzako> {
    final /* synthetic */ zzals a;

    cj(zzals zzalsVar) {
        this.a = zzalsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazu
    public final /* synthetic */ void a(zzako zzakoVar) {
        zzazj.e.execute(new Runnable(this, zzakoVar) { // from class: com.google.android.gms.internal.ads.ci
            private final cj a;
            private final zzako b;

            {
                this.a = this;
                this.b = zzakoVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.util.zzau zzauVar;
                cj cjVar = this.a;
                zzako zzakoVar3 = this.b;
                zzauVar = cjVar.a.b;
                zzauVar.a(zzakoVar3);
                zzakoVar3.a();
            }
        });
    }
}
