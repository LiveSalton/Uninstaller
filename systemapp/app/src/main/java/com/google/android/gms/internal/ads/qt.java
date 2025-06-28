package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class qt implements Runnable {
    private final zzccm a;

    private qt(zzccm zzccmVar) {
        this.a = zzccmVar;
    }

    static Runnable a(zzccm zzccmVar) {
        return new qt(zzccmVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();
    }
}
