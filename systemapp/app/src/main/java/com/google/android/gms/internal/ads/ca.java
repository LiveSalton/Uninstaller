package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class ca implements Runnable {
    private final zzako a;

    private ca(zzako zzakoVar) {
        this.a = zzakoVar;
    }

    static Runnable a(zzako zzakoVar) {
        return new ca(zzakoVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
