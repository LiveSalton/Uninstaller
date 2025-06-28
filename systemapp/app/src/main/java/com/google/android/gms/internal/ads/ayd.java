package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayd implements Runnable {
    private final /* synthetic */ zzjm a;
    private final /* synthetic */ zzik b;

    ayd(zzik zzikVar, zzjm zzjmVar) {
        this.b = zzikVar;
        this.a = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        zzihVar = this.b.b;
        zzihVar.c(this.a);
    }
}
