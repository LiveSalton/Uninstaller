package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
final class avb implements Iterator<asy> {
    private final ArrayDeque<ava> a;
    private asy b;

    private avb(zzeiu zzeiuVar) {
        if (!(zzeiuVar instanceof ava)) {
            this.a = null;
            this.b = (asy) zzeiuVar;
        } else {
            ava avaVar = (ava) zzeiuVar;
            this.a = new ArrayDeque<>(avaVar.i());
            this.a.push(avaVar);
            this.b = a(avaVar.d);
        }
    }

    private final asy a(zzeiu zzeiuVar) {
        while (zzeiuVar instanceof ava) {
            ava avaVar = (ava) zzeiuVar;
            this.a.push(avaVar);
            zzeiuVar = avaVar.d;
        }
        return (asy) zzeiuVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ asy next() {
        asy asyVar;
        if (this.b == null) {
            throw new NoSuchElementException();
        }
        asy asyVar2 = this.b;
        while (this.a != null && !this.a.isEmpty()) {
            asyVar = a(this.a.pop().e);
            if (!asyVar.c()) {
                break;
            }
        }
        asyVar = null;
        this.b = asyVar;
        return asyVar2;
    }

    /* synthetic */ avb(zzeiu zzeiuVar, auz auzVar) {
        this(zzeiuVar);
    }
}
