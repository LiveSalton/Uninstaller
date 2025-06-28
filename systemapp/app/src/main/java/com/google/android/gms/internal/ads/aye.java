package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aye implements Runnable {
    private final /* synthetic */ zzhp a;
    private final /* synthetic */ zzik b;

    aye(zzik zzikVar, zzhp zzhpVar) {
        this.b = zzikVar;
        this.a = zzhpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzih zzihVar;
        zzihVar = this.b.b;
        zzihVar.b(this.a);
    }
}
