package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gr implements Runnable {
    private zzbar a;
    private boolean b = false;

    gr(zzbar zzbarVar) {
        this.a = zzbarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b) {
            return;
        }
        this.a.o();
        c();
    }

    public final void a() {
        this.b = true;
        this.a.o();
    }

    public final void b() {
        this.b = false;
        c();
    }

    private final void c() {
        com.google.android.gms.ads.internal.util.zzm.a.removeCallbacks(this);
        com.google.android.gms.ads.internal.util.zzm.a.postDelayed(this, 250L);
    }
}
