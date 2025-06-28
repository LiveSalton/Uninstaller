package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbm implements Runnable {
    private final /* synthetic */ zzhp a;
    private final /* synthetic */ zzqj b;

    bbm(zzqj zzqjVar, zzhp zzhpVar) {
        this.b = zzqjVar;
        this.a = zzhpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.b.b;
        zzqgVar.a(this.a);
    }
}
