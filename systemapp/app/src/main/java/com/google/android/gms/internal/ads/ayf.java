package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayf implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzik d;

    ayf(zzik zzikVar, String str, long j, long j2) {
        this.d = zzikVar;
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        zzihVar = this.d.b;
        zzihVar.b(this.a, this.b, this.c);
    }
}
