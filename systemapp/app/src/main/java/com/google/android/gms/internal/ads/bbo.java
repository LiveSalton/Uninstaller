package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbo implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ float d;
    private final /* synthetic */ zzqj e;

    bbo(zzqj zzqjVar, int i, int i2, int i3, float f) {
        this.e = zzqjVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.e.b;
        zzqgVar.a(this.a, this.b, this.c, this.d);
    }
}
