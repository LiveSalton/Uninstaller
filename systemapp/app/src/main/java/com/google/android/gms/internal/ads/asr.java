package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
final class asr extends ast {
    private int a = 0;
    private final int b;
    private final /* synthetic */ zzeiu c;

    asr(zzeiu zzeiuVar) {
        this.c = zzeiuVar;
        this.b = this.c.b();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzejd
    public final byte a() {
        int i = this.a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.a = i + 1;
        return this.c.b(i);
    }
}
