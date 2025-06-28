package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class yh implements Runnable {
    private final zzbdv a;

    private yh(zzbdv zzbdvVar) {
        this.a = zzbdvVar;
    }

    static Runnable a(zzbdv zzbdvVar) {
        return new yh(zzbdvVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.N();
    }
}
