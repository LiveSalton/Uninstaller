package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class bz implements zzazu<zzako> {
    private final /* synthetic */ zzals a;
    private final /* synthetic */ zzalb b;

    bz(zzalb zzalbVar, zzals zzalsVar) {
        this.b = zzalbVar;
        this.a = zzalsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazu
    public final /* synthetic */ void a(zzako zzakoVar) {
        Object obj;
        zzals zzalsVar;
        zzals zzalsVar2;
        zzals zzalsVar3;
        obj = this.b.a;
        synchronized (obj) {
            this.b.h = 0;
            zzalsVar = this.b.g;
            if (zzalsVar != null) {
                zzals zzalsVar4 = this.a;
                zzalsVar2 = this.b.g;
                if (zzalsVar4 != zzalsVar2) {
                    zzd.a("New JS engine is loaded, marking previous one as destroyable.");
                    zzalsVar3 = this.b.g;
                    zzalsVar3.c();
                }
            }
            this.b.g = this.a;
        }
    }
}
