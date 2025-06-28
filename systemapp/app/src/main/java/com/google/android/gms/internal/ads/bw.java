package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class bw implements Runnable {
    private final zzako a;

    private bw(zzako zzakoVar) {
        this.a = zzakoVar;
    }

    static Runnable a(zzako zzakoVar) {
        return new bw(zzakoVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
