package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class azl {
    public final int a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final zzpn f;
    private final zzpn g;
    private int h;
    private int i;

    public azl(zzpn zzpnVar, zzpn zzpnVar2, boolean z) {
        this.g = zzpnVar;
        this.f = zzpnVar2;
        this.e = z;
        zzpnVar2.c(12);
        this.a = zzpnVar2.o();
        zzpnVar.c(12);
        this.i = zzpnVar.o();
        zzpc.b(zzpnVar.l() == 1, "first_chunk must be 1");
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.a) {
            return false;
        }
        this.d = this.e ? this.f.p() : this.f.j();
        if (this.b == this.h) {
            this.c = this.g.o();
            this.g.d(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? this.g.o() - 1 : -1;
        }
        return true;
    }
}
