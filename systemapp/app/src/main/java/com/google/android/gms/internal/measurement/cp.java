package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class cp implements Iterator<String> {
    private Iterator<String> a;
    private final /* synthetic */ zzia b;

    cp(zzia zziaVar) {
        zzfv zzfvVar;
        this.b = zziaVar;
        zzfvVar = this.b.a;
        this.a = zzfvVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.a.next();
    }
}
