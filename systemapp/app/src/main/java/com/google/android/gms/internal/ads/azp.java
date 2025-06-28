package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class azp implements azo {
    private final zzpn a;
    private final int b;
    private final int c;
    private int d;
    private int e;

    public azp(azj azjVar) {
        this.a = azjVar.aP;
        this.a.c(12);
        this.c = this.a.o() & 255;
        this.b = this.a.o();
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final int b() {
        if (this.c == 8) {
            return this.a.f();
        }
        if (this.c == 16) {
            return this.a.g();
        }
        int i = this.d;
        this.d = i + 1;
        if (i % 2 == 0) {
            this.e = this.a.f();
            return (this.e & 240) >> 4;
        }
        return this.e & 15;
    }
}
