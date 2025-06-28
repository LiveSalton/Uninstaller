package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class awa implements Iterator<String> {
    private Iterator<String> a;
    private final /* synthetic */ zzenk b;

    awa(zzenk zzenkVar) {
        zzekz zzekzVar;
        this.b = zzenkVar;
        zzekzVar = this.b.a;
        this.a = zzekzVar.iterator();
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
