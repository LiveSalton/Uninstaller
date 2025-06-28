package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gd implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;
    private final /* synthetic */ zzbac c;

    gd(zzbac zzbacVar, int i, int i2) {
        this.c = zzbacVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbam zzbamVar;
        zzbam zzbamVar2;
        zzbamVar = this.c.s;
        if (zzbamVar != null) {
            zzbamVar2 = this.c.s;
            zzbamVar2.a(this.a, this.b);
        }
    }
}
