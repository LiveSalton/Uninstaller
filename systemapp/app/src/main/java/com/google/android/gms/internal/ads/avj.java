package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class avj extends avp {
    private final /* synthetic */ avi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private avj(avi aviVar) {
        super(aviVar, null);
        this.a = aviVar;
    }

    @Override // com.google.android.gms.internal.ads.avp, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new avk(this.a, null);
    }

    /* synthetic */ avj(avi aviVar, avh avhVar) {
        this(aviVar);
    }
}
