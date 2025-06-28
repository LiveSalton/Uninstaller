package com.google.android.gms.ads.internal.util;

/* compiled from: source */
/* loaded from: classes.dex */
final class t implements Runnable {
    private final /* synthetic */ zza a;

    t(zza zzaVar) {
        this.a = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = Thread.currentThread();
        this.a.a();
    }
}
