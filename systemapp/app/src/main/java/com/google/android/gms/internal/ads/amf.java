package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
final class amf<T> extends zzdxh<T> {
    private boolean a;
    private final /* synthetic */ Object b;

    amf(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.a;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.a) {
            throw new NoSuchElementException();
        }
        this.a = true;
        return (T) this.b;
    }
}
