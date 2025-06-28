package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gg implements Runnable {
    private final /* synthetic */ zzbac a;

    gg(zzbac zzbacVar) {
        this.a = zzbacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbam zzbamVar;
        zzbam zzbamVar2;
        zzbam zzbamVar3;
        zzbamVar = this.a.s;
        if (zzbamVar != null) {
            zzbamVar2 = this.a.s;
            zzbamVar2.d();
            zzbamVar3 = this.a.s;
            zzbamVar3.f();
        }
    }
}
