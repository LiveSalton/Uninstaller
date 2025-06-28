package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class zr implements Runnable {
    private final zzcif a;

    private zr(zzcif zzcifVar) {
        this.a = zzcifVar;
    }

    static Runnable a(zzcif zzcifVar) {
        return new zr(zzcifVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
