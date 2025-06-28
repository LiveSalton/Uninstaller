package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbfn {
    public final int a;
    public final int b;
    private final int c;

    public static zzbfn a(zzvn zzvnVar) {
        return zzvnVar.d ? new zzbfn(3, 0, 0) : zzvnVar.i ? new zzbfn(2, 0, 0) : zzvnVar.h ? a() : a(zzvnVar.f, zzvnVar.c);
    }

    public static zzbfn a() {
        return new zzbfn(0, 0, 0);
    }

    public static zzbfn a(int i, int i2) {
        return new zzbfn(1, i, i2);
    }

    public static zzbfn b() {
        return new zzbfn(4, 0, 0);
    }

    public static zzbfn c() {
        return new zzbfn(5, 0, 0);
    }

    private zzbfn(int i, int i2, int i3) {
        this.c = i;
        this.b = i2;
        this.a = i3;
    }

    public final boolean d() {
        return this.c == 2;
    }

    public final boolean e() {
        return this.c == 3;
    }

    public final boolean f() {
        return this.c == 0;
    }

    public final boolean g() {
        return this.c == 4;
    }

    public final boolean h() {
        return this.c == 5;
    }
}
