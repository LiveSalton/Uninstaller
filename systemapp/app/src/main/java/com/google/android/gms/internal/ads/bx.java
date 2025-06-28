package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class bx implements Runnable {
    private final /* synthetic */ zzals a;
    private final /* synthetic */ zzako b;
    private final /* synthetic */ zzalb c;

    bx(zzalb zzalbVar, zzals zzalsVar, zzako zzakoVar) {
        this.c = zzalbVar;
        this.a = zzalsVar;
        this.b = zzakoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.c.a;
        synchronized (obj) {
            if (this.a.e() != -1 && this.a.e() != 1) {
                this.a.d();
                zzdzc zzdzcVar = zzazj.e;
                zzako zzakoVar = this.b;
                zzakoVar.getClass();
                zzdzcVar.execute(ca.a(zzakoVar));
                zzd.a("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
