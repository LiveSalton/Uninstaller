package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class azq implements azo {
    private final int a;
    private final int b;
    private final zzpn c;

    public azq(azj azjVar) {
        this.c = azjVar.aP;
        this.c.c(12);
        this.a = this.c.o();
        this.b = this.c.o();
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final int b() {
        return this.a == 0 ? this.c.o() : this.a;
    }

    @Override // com.google.android.gms.internal.ads.azo
    public final boolean c() {
        return this.a != 0;
    }
}
