package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class gb implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzbac c;

    gb(zzbac zzbacVar, String str, String str2) {
        this.c = zzbacVar;
        this.a = str;
        this.b = str2;
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
