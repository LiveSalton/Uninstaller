package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbn implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzqj d;

    bbn(zzqj zzqjVar, String str, long j, long j2) {
        this.d = zzqjVar;
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.d.b;
        zzqgVar.a(this.a, this.b, this.c);
    }
}
