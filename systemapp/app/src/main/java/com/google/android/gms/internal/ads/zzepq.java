package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepq<T> {
    private final List<zzeps<T>> a;
    private final List<zzeps<Collection<T>>> b;

    /* JADX INFO: Access modifiers changed from: private */
    zzepq(int i, int i2) {
        this.a = zzepe.a(i);
        this.b = zzepe.a(i2);
    }

    public final zzepq<T> a(zzeps<? extends T> zzepsVar) {
        this.a.add(zzepsVar);
        return this;
    }

    public final zzepq<T> b(zzeps<? extends Collection<? extends T>> zzepsVar) {
        this.b.add(zzepsVar);
        return this;
    }

    public final zzepo<T> a() {
        return new zzepo<>(this.a, this.b);
    }

    /* synthetic */ zzepq(int i, int i2, axd axdVar) {
        this(i, i2);
    }
}
