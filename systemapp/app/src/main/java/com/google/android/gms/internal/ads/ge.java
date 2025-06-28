package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ge implements Runnable {
    private final /* synthetic */ zzbac a;

    ge(zzbac zzbacVar) {
        this.a = zzbacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbam zzbamVar;
        zzbam zzbamVar2;
        zzbamVar = this.a.s;
        if (zzbamVar != null) {
            zzbamVar2 = this.a.s;
            zzbamVar2.a();
        }
    }
}
