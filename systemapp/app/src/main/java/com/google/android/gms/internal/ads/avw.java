package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class avw<T, B> {
    avw() {
    }

    abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    abstract void a(B b, int i, long j);

    abstract void a(B b, int i, zzeiu zzeiuVar);

    abstract void a(B b, int i, T t);

    abstract void a(T t, awo awoVar) throws IOException;

    abstract void a(Object obj, T t);

    abstract boolean a(aux auxVar);

    abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    abstract void b(T t, awo awoVar) throws IOException;

    abstract void b(Object obj, B b);

    abstract B c(Object obj);

    abstract T c(T t, T t2);

    abstract void d(Object obj);

    abstract int e(T t);

    abstract int f(T t);

    final boolean a(B b, aux auxVar) throws IOException {
        int b2 = auxVar.b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                a((avw<T, B>) b, i, auxVar.g());
                return true;
            case 1:
                b(b, i, auxVar.i());
                return true;
            case 2:
                a((avw<T, B>) b, i, auxVar.n());
                return true;
            case 3:
                B a = a();
                int i2 = (i << 3) | 4;
                while (auxVar.a() != Integer.MAX_VALUE && a((avw<T, B>) a, auxVar)) {
                }
                if (i2 != auxVar.b()) {
                    throw zzeks.e();
                }
                a((avw<T, B>) b, i, (int) a((avw<T, B>) a));
                return true;
            case 4:
                return false;
            case 5:
                a((avw<T, B>) b, i, auxVar.j());
                return true;
            default:
                throw zzeks.f();
        }
    }
}
