package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdwn<E> {
    zzdwn() {
    }

    public abstract zzdwn<E> b(E e);

    public zzdwn<E> a(Iterable<? extends E> iterable) {
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        return this;
    }

    public zzdwn<E> a(Iterator<? extends E> it) {
        while (it.hasNext()) {
            b(it.next());
        }
        return this;
    }
}
