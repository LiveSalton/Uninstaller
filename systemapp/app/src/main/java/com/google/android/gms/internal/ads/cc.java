package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class cc implements zzazs {
    private final /* synthetic */ zzals a;
    private final /* synthetic */ zzalb b;

    cc(zzalb zzalbVar, zzals zzalsVar) {
        this.b = zzalbVar;
        this.a = zzalsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void a() {
        Object obj;
        obj = this.b.a;
        synchronized (obj) {
            this.b.h = 1;
            zzd.a("Failed loading new engine. Marking new engine destroyable.");
            this.a.c();
        }
    }
}
