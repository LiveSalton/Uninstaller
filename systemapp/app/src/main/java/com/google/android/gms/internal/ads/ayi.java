package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayi implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ zzik b;

    ayi(zzik zzikVar, int i) {
        this.b = zzikVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        zzihVar = this.b.b;
        zzihVar.a(this.a);
    }
}
