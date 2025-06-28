package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class gi implements Runnable {
    private final zzbap a;

    private gi(zzbap zzbapVar) {
        this.a = zzbapVar;
    }

    static Runnable a(zzbap zzbapVar) {
        return new gi(zzbapVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
