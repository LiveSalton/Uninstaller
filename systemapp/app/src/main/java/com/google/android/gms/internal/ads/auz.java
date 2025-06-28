package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
final class auz extends ast {
    private final avb a;
    private zzejd b = b();
    private final /* synthetic */ ava c;

    auz(ava avaVar) {
        this.c = avaVar;
        this.a = new avb(this.c, null);
    }

    private final zzejd b() {
        if (this.a.hasNext()) {
            return (zzejd) ((asy) this.a.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // com.google.android.gms.internal.ads.zzejd
    public final byte a() {
        if (this.b == null) {
            throw new NoSuchElementException();
        }
        byte a = this.b.a();
        if (!this.b.hasNext()) {
            this.b = b();
        }
        return a;
    }
}
