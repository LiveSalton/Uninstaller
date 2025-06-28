package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
final class af extends ah {
    private int a = 0;
    private final int b;
    private final /* synthetic */ zzdu c;

    af(zzdu zzduVar) {
        this.c = zzduVar;
        this.b = this.c.a();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.measurement.zzed
    public final byte a() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.b(i);
    }
}
