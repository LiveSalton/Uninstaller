package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbp implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzqj c;

    bbp(zzqj zzqjVar, int i, long j) {
        this.c = zzqjVar;
        this.a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.c.b;
        zzqgVar.a(this.a, this.b);
    }
}
