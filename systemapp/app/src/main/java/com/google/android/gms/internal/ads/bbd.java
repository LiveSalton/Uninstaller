package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbd implements Runnable {
    private final /* synthetic */ zzaa a;
    private final /* synthetic */ zzm b;

    bbd(zzm zzmVar, zzaa zzaaVar) {
        this.b = zzmVar;
        this.a = zzaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.c.put(this.a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
