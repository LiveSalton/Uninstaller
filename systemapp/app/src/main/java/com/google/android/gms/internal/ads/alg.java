package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class alg<T> implements Iterator<T> {
    private int a = alh.b;

    @NullableDecl
    private T b;

    protected alg() {
    }

    protected abstract T a();

    @NullableDecl
    protected final T b() {
        this.a = alh.c;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!(this.a != alh.d)) {
            throw new IllegalStateException();
        }
        switch (ali.a[this.a - 1]) {
            case 1:
                return false;
            case 2:
                return true;
            default:
                this.a = alh.d;
                this.b = a();
                if (this.a == alh.c) {
                    return false;
                }
                this.a = alh.a;
                return true;
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = alh.b;
        T t = this.b;
        this.b = null;
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
