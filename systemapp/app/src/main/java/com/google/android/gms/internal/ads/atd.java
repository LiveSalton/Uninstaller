package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class atd implements aux {
    private final zzejj a;
    private int b;
    private int c;
    private int d = 0;

    public static atd a(zzejj zzejjVar) {
        return zzejjVar.d != null ? zzejjVar.d : new atd(zzejjVar);
    }

    private atd(zzejj zzejjVar) {
        this.a = (zzejj) zzekk.a(zzejjVar, "input");
        this.a.d = this;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int a() throws IOException {
        if (this.d != 0) {
            this.b = this.d;
            this.d = 0;
        } else {
            this.b = this.a.a();
        }
        if (this.b == 0 || this.b == this.c) {
            return Integer.MAX_VALUE;
        }
        return this.b >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final boolean c() throws IOException {
        if (this.a.t() || this.b == this.c) {
            return false;
        }
        return this.a.b(this.b);
    }

    private final void a(int i) throws IOException {
        if ((this.b & 7) != i) {
            throw zzeks.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final double d() throws IOException {
        a(1);
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final float e() throws IOException {
        a(5);
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final long f() throws IOException {
        a(0);
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final long g() throws IOException {
        a(0);
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int h() throws IOException {
        a(0);
        return this.a.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final long i() throws IOException {
        a(1);
        return this.a.g();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int j() throws IOException {
        a(5);
        return this.a.h();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final boolean k() throws IOException {
        a(0);
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final String l() throws IOException {
        a(2);
        return this.a.j();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final String m() throws IOException {
        a(2);
        return this.a.k();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final <T> T a(avd<T> avdVar, zzeju zzejuVar) throws IOException {
        a(2);
        return (T) c(avdVar, zzejuVar);
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final <T> T b(avd<T> avdVar, zzeju zzejuVar) throws IOException {
        a(3);
        return (T) d(avdVar, zzejuVar);
    }

    private final <T> T c(avd<T> avdVar, zzeju zzejuVar) throws IOException {
        int m = this.a.m();
        if (this.a.a >= this.a.b) {
            throw new zzeks("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int c = this.a.c(m);
        T a = avdVar.a();
        this.a.a++;
        avdVar.a(a, this, zzejuVar);
        avdVar.c(a);
        this.a.a(0);
        zzejj zzejjVar = this.a;
        zzejjVar.a--;
        this.a.d(c);
        return a;
    }

    private final <T> T d(avd<T> avdVar, zzeju zzejuVar) throws IOException {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T a = avdVar.a();
            avdVar.a(a, this, zzejuVar);
            avdVar.c(a);
            if (this.b != this.c) {
                throw zzeks.h();
            }
            return a;
        } finally {
            this.c = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final zzeiu n() throws IOException {
        a(2);
        return this.a.l();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int o() throws IOException {
        a(0);
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int p() throws IOException {
        a(0);
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int q() throws IOException {
        a(5);
        return this.a.o();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final long r() throws IOException {
        a(1);
        return this.a.p();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final int s() throws IOException {
        a(0);
        return this.a.q();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final long t() throws IOException {
        a(0);
        return this.a.r();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void a(List<Double> list) throws IOException {
        int a;
        int a2;
        if (list instanceof ati) {
            ati atiVar = (ati) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int m = this.a.m();
                    b(m);
                    int u = this.a.u() + m;
                    do {
                        atiVar.a(this.a.b());
                    } while (this.a.u() < u);
                    return;
                default:
                    throw zzeks.f();
            }
            do {
                atiVar.a(this.a.b());
                if (this.a.t()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.b);
            this.d = a2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int m2 = this.a.m();
                b(m2);
                int u2 = this.a.u() + m2;
                do {
                    list.add(Double.valueOf(this.a.b()));
                } while (this.a.u() < u2);
                return;
            default:
                throw zzeks.f();
        }
        do {
            list.add(Double.valueOf(this.a.b()));
            if (this.a.t()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.b);
        this.d = a;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void b(List<Float> list) throws IOException {
        int a;
        int a2;
        if (list instanceof atp) {
            atp atpVar = (atp) list;
            int i = this.b & 7;
            if (i == 2) {
                int m = this.a.m();
                c(m);
                int u = this.a.u() + m;
                do {
                    atpVar.a(this.a.c());
                } while (this.a.u() < u);
                return;
            }
            if (i == 5) {
                do {
                    atpVar.a(this.a.c());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int m2 = this.a.m();
            c(m2);
            int u2 = this.a.u() + m2;
            do {
                list.add(Float.valueOf(this.a.c()));
            } while (this.a.u() < u2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.a.c()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void c(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aud) {
            aud audVar = (aud) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    audVar.a(this.a.d());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    audVar.a(this.a.d());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.d()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.d()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void d(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aud) {
            aud audVar = (aud) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    audVar.a(this.a.e());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    audVar.a(this.a.e());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.e()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.e()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void e(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    attVar.d(this.a.f());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    attVar.d(this.a.f());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.f()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.f()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void f(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aud) {
            aud audVar = (aud) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int m = this.a.m();
                    b(m);
                    int u = this.a.u() + m;
                    do {
                        audVar.a(this.a.g());
                    } while (this.a.u() < u);
                    return;
                default:
                    throw zzeks.f();
            }
            do {
                audVar.a(this.a.g());
                if (this.a.t()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.b);
            this.d = a2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int m2 = this.a.m();
                b(m2);
                int u2 = this.a.u() + m2;
                do {
                    list.add(Long.valueOf(this.a.g()));
                } while (this.a.u() < u2);
                return;
            default:
                throw zzeks.f();
        }
        do {
            list.add(Long.valueOf(this.a.g()));
            if (this.a.t()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.b);
        this.d = a;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void g(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 2) {
                int m = this.a.m();
                c(m);
                int u = this.a.u() + m;
                do {
                    attVar.d(this.a.h());
                } while (this.a.u() < u);
                return;
            }
            if (i == 5) {
                do {
                    attVar.d(this.a.h());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int m2 = this.a.m();
            c(m2);
            int u2 = this.a.u() + m2;
            do {
                list.add(Integer.valueOf(this.a.h()));
            } while (this.a.u() < u2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.a.h()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void h(List<Boolean> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aso) {
            aso asoVar = (aso) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    asoVar.a(this.a.i());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    asoVar.a(this.a.i());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.a.i()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Boolean.valueOf(this.a.i()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int a;
        int a2;
        if ((this.b & 7) != 2) {
            throw zzeks.f();
        }
        if ((list instanceof zzekz) && !z) {
            zzekz zzekzVar = (zzekz) list;
            do {
                zzekzVar.a(n());
                if (this.a.t()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.b);
            this.d = a2;
            return;
        }
        do {
            list.add(z ? m() : l());
            if (this.a.t()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.b);
        this.d = a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.aux
    public final <T> void a(List<T> list, avd<T> avdVar, zzeju zzejuVar) throws IOException {
        int a;
        if ((this.b & 7) != 2) {
            throw zzeks.f();
        }
        int i = this.b;
        do {
            list.add(c(avdVar, zzejuVar));
            if (this.a.t() || this.d != 0) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == i);
        this.d = a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.aux
    public final <T> void b(List<T> list, avd<T> avdVar, zzeju zzejuVar) throws IOException {
        int a;
        if ((this.b & 7) != 3) {
            throw zzeks.f();
        }
        int i = this.b;
        do {
            list.add(d(avdVar, zzejuVar));
            if (this.a.t() || this.d != 0) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == i);
        this.d = a;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void k(List<zzeiu> list) throws IOException {
        int a;
        if ((this.b & 7) != 2) {
            throw zzeks.f();
        }
        do {
            list.add(n());
            if (this.a.t()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.b);
        this.d = a;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void l(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    attVar.d(this.a.m());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    attVar.d(this.a.m());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.m()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.m()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void m(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    attVar.d(this.a.n());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    attVar.d(this.a.n());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.n()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.n()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void n(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 2) {
                int m = this.a.m();
                c(m);
                int u = this.a.u() + m;
                do {
                    attVar.d(this.a.o());
                } while (this.a.u() < u);
                return;
            }
            if (i == 5) {
                do {
                    attVar.d(this.a.o());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 2) {
            int m2 = this.a.m();
            c(m2);
            int u2 = this.a.u() + m2;
            do {
                list.add(Integer.valueOf(this.a.o()));
            } while (this.a.u() < u2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.a.o()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void o(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aud) {
            aud audVar = (aud) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    int m = this.a.m();
                    b(m);
                    int u = this.a.u() + m;
                    do {
                        audVar.a(this.a.p());
                    } while (this.a.u() < u);
                    return;
                default:
                    throw zzeks.f();
            }
            do {
                audVar.a(this.a.p());
                if (this.a.t()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.b);
            this.d = a2;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                int m2 = this.a.m();
                b(m2);
                int u2 = this.a.u() + m2;
                do {
                    list.add(Long.valueOf(this.a.p()));
                } while (this.a.u() < u2);
                return;
            default:
                throw zzeks.f();
        }
        do {
            list.add(Long.valueOf(this.a.p()));
            if (this.a.t()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.b);
        this.d = a;
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void p(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof att) {
            att attVar = (att) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    attVar.d(this.a.q());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    attVar.d(this.a.q());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.a.q()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Integer.valueOf(this.a.q()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    @Override // com.google.android.gms.internal.ads.aux
    public final void q(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof aud) {
            aud audVar = (aud) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    audVar.a(this.a.r());
                    if (this.a.t()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.b);
                this.d = a2;
                return;
            }
            if (i == 2) {
                int u = this.a.u() + this.a.m();
                do {
                    audVar.a(this.a.r());
                } while (this.a.u() < u);
                d(u);
                return;
            }
            throw zzeks.f();
        }
        int i2 = this.b & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.a.r()));
                if (this.a.t()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.b);
            this.d = a;
            return;
        }
        if (i2 == 2) {
            int u2 = this.a.u() + this.a.m();
            do {
                list.add(Long.valueOf(this.a.r()));
            } while (this.a.u() < u2);
            d(u2);
            return;
        }
        throw zzeks.f();
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzeks.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.aux
    public final <K, V> void a(Map<K, V> map, aug<K, V> augVar, zzeju zzejuVar) throws IOException {
        int a;
        a(2);
        int c = this.a.c(this.a.m());
        Object obj = augVar.b;
        Object obj2 = augVar.d;
        while (true) {
            try {
                a = a();
            } finally {
                this.a.d(c);
            }
            if (a != Integer.MAX_VALUE && !this.a.t()) {
                switch (a) {
                    case 1:
                        obj = a(augVar.a, (Class<?>) null, (zzeju) null);
                        continue;
                    case 2:
                        obj2 = a(augVar.c, augVar.d.getClass(), zzejuVar);
                        continue;
                    default:
                        try {
                        } catch (zzekr unused) {
                            if (!c()) {
                                throw new zzeks("Unable to parse map entry.");
                            }
                        }
                        if (!c()) {
                            throw new zzeks("Unable to parse map entry.");
                            break;
                        } else {
                            continue;
                        }
                }
                this.a.d(c);
            }
        }
        map.put(obj, obj2);
    }

    private final Object a(zzenw zzenwVar, Class<?> cls, zzeju zzejuVar) throws IOException {
        switch (atf.a[zzenwVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                a(2);
                return c(auw.a().a((Class) cls), zzejuVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return m();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzeks.h();
        }
    }

    private final void d(int i) throws IOException {
        if (this.a.u() != i) {
            throw zzeks.a();
        }
    }
}
