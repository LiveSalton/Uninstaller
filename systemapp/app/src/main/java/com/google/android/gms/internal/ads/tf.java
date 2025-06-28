package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class tf implements Runnable {
    private final zzbdv a;

    private tf(zzbdv zzbdvVar) {
        this.a = zzbdvVar;
    }

    static Runnable a(zzbdv zzbdvVar) {
        return new tf(zzbdvVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.destroy();
    }
}
