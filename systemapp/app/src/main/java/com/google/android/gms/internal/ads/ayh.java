package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayh implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzik d;

    ayh(zzik zzikVar, int i, long j, long j2) {
        this.d = zzikVar;
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        zzihVar = this.d.b;
        zzihVar.a(this.a, this.b, this.c);
    }
}
