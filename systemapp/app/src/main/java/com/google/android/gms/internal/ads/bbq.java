package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbq implements Runnable {
    private final /* synthetic */ zzjm a;
    private final /* synthetic */ zzqj b;

    bbq(zzqj zzqjVar, zzjm zzjmVar) {
        this.b = zzqjVar;
        this.a = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        this.a.a();
        zzqgVar = this.b.b;
        zzqgVar.b(this.a);
    }
}
