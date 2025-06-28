package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gm implements Runnable {
    private final /* synthetic */ zzbar a;

    gm(zzbar zzbarVar) {
        this.a = zzbarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b("surfaceDestroyed", new String[0]);
    }
}
