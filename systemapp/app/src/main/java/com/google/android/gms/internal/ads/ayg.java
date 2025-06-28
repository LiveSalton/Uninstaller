package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayg implements Runnable {
    private final /* synthetic */ zzjm a;
    private final /* synthetic */ zzik b;

    ayg(zzik zzikVar, zzjm zzjmVar) {
        this.b = zzikVar;
        this.a = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        this.a.a();
        zzihVar = this.b.b;
        zzihVar.d(this.a);
    }
}
