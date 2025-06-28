package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class aas implements Runnable {
    private final zzcxq a;

    private aas(zzcxq zzcxqVar) {
        this.a = zzcxqVar;
    }

    static Runnable a(zzcxq zzcxqVar) {
        return new aas(zzcxqVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
