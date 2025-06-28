package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bdu implements Runnable {
    private final zzaa a;
    private final zzaj b;
    private final Runnable c;

    public bdu(zzaa zzaaVar, zzaj zzajVar, Runnable runnable) {
        this.a = zzaaVar;
        this.b = zzajVar;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h();
        if (this.b.a()) {
            this.a.a((zzaa) this.b.a);
        } else {
            this.a.a(this.b.c);
        }
        if (this.b.d) {
            this.a.b("intermediate-response");
        } else {
            this.a.c("done");
        }
        if (this.c != null) {
            this.c.run();
        }
    }
}
