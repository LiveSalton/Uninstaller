package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class ava extends zzeiu {
    static final int[] b = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int c;
    private final zzeiu d;
    private final zzeiu e;
    private final int f;
    private final int g;

    private ava(zzeiu zzeiuVar, zzeiu zzeiuVar2) {
        this.d = zzeiuVar;
        this.e = zzeiuVar2;
        this.f = zzeiuVar.b();
        this.c = this.f + zzeiuVar2.b();
        this.g = Math.max(zzeiuVar.i(), zzeiuVar2.i()) + 1;
    }

    static zzeiu a(zzeiu zzeiuVar, zzeiu zzeiuVar2) {
        zzeiu a;
        if (zzeiuVar2.b() == 0) {
            return zzeiuVar;
        }
        if (zzeiuVar.b() == 0) {
            return zzeiuVar2;
        }
        int b2 = zzeiuVar.b() + zzeiuVar2.b();
        if (b2 < 128) {
            return b(zzeiuVar, zzeiuVar2);
        }
        if (zzeiuVar instanceof ava) {
            ava avaVar = (ava) zzeiuVar;
            if (avaVar.e.b() + zzeiuVar2.b() < 128) {
                return new ava(avaVar.d, b(avaVar.e, zzeiuVar2));
            }
            if (avaVar.d.i() > avaVar.e.i() && avaVar.i() > zzeiuVar2.i()) {
                return new ava(avaVar.d, new ava(avaVar.e, zzeiuVar2));
            }
        }
        if (b2 >= d(Math.max(zzeiuVar.i(), zzeiuVar2.i()) + 1)) {
            return new ava(zzeiuVar, zzeiuVar2);
        }
        a = new avc(null).a(zzeiuVar, zzeiuVar2);
        return a;
    }

    private static zzeiu b(zzeiu zzeiuVar, zzeiu zzeiuVar2) {
        int b2 = zzeiuVar.b();
        int b3 = zzeiuVar2.b();
        byte[] bArr = new byte[b2 + b3];
        zzeiuVar.a(bArr, 0, 0, b2);
        zzeiuVar2.a(bArr, 0, b2, b3);
        return zzeiu.b(bArr);
    }

    static int d(int i) {
        if (i >= b.length) {
            return Integer.MAX_VALUE;
        }
        return b[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final byte a(int i) {
        b(i, this.c);
        return b(i);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    final byte b(int i) {
        if (i < this.f) {
            return this.d.b(i);
        }
        return this.e.b(i - this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    /* renamed from: a */
    public final zzejd iterator() {
        return new auz(this);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final int i() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final boolean j() {
        return this.c >= d(this.g);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final zzeiu a(int i, int i2) {
        int c = c(i, i2, this.c);
        if (c == 0) {
            return zzeiu.a;
        }
        if (c == this.c) {
            return this;
        }
        if (i2 <= this.f) {
            return this.d.a(i, i2);
        }
        if (i >= this.f) {
            return this.e.a(i - this.f, i2 - this.f);
        }
        zzeiu zzeiuVar = this.d;
        return new ava(zzeiuVar.a(i, zzeiuVar.b()), this.e.a(0, i2 - this.f));
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final void b(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f) {
            this.d.b(bArr, i, i2, i3);
        } else {
            if (i >= this.f) {
                this.e.b(bArr, i - this.f, i2, i3);
                return;
            }
            int i4 = this.f - i;
            this.d.b(bArr, i, i2, i4);
            this.e.b(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    final void a(zzeiv zzeivVar) throws IOException {
        this.d.a(zzeivVar);
        this.e.a(zzeivVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final String a(Charset charset) {
        return new String(d(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final boolean f() {
        return this.e.a(this.d.a(0, 0, this.f), 0, this.e.b()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final int a(int i, int i2, int i3) {
        if (i2 + i3 <= this.f) {
            return this.d.a(i, i2, i3);
        }
        if (i2 >= this.f) {
            return this.e.a(i, i2 - this.f, i3);
        }
        int i4 = this.f - i2;
        return this.e.a(this.d.a(i, i2, i4), 0, i3 - i4);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final boolean equals(Object obj) {
        boolean a;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu)) {
            return false;
        }
        zzeiu zzeiuVar = (zzeiu) obj;
        if (this.c != zzeiuVar.b()) {
            return false;
        }
        if (this.c == 0) {
            return true;
        }
        int k = k();
        int k2 = zzeiuVar.k();
        if (k != 0 && k2 != 0 && k != k2) {
            return false;
        }
        avb avbVar = new avb(this, null);
        asy next = avbVar.next();
        avb avbVar2 = new avb(zzeiuVar, null);
        asy next2 = avbVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int b2 = next.b() - i;
            int b3 = next2.b() - i2;
            int min = Math.min(b2, b3);
            if (i == 0) {
                a = next.a(next2, i2, min);
            } else {
                a = next2.a(next, i, min);
            }
            if (!a) {
                return false;
            }
            i3 += min;
            if (i3 >= this.c) {
                if (i3 == this.c) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == b2) {
                next = avbVar.next();
                i = 0;
            } else {
                i += min;
                next = next;
            }
            if (min == b3) {
                next2 = avbVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    protected final int b(int i, int i2, int i3) {
        if (i2 + i3 <= this.f) {
            return this.d.b(i, i2, i3);
        }
        if (i2 >= this.f) {
            return this.e.b(i, i2 - this.f, i3);
        }
        int i4 = this.f - i2;
        return this.e.b(this.d.b(i, i2, i4), 0, i3 - i4);
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final zzejj g() {
        return new atb(new ave(this));
    }

    @Override // com.google.android.gms.internal.ads.zzeiu, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ ava(zzeiu zzeiuVar, zzeiu zzeiuVar2, auz auzVar) {
        this(zzeiuVar, zzeiuVar2);
    }
}
