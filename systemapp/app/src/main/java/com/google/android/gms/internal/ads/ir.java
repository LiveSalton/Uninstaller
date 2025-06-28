package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ir implements Runnable {
    private final /* synthetic */ zzbeg a;

    ir(zzbeg zzbegVar) {
        this.a = zzbegVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdv zzbdvVar;
        zzbdvVar = this.a.a;
        zzbdvVar.destroy();
    }
}
