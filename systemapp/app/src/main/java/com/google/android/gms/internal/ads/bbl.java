package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbl implements Runnable {
    private final /* synthetic */ zzjm a;
    private final /* synthetic */ zzqj b;

    bbl(zzqj zzqjVar, zzjm zzjmVar) {
        this.b = zzqjVar;
        this.a = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.b.b;
        zzqgVar.a(this.a);
    }
}
