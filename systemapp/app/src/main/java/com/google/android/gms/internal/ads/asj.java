package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
final class asj extends WeakReference<Throwable> {
    private final int a;

    public asj(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        asj asjVar = (asj) obj;
        return this.a == asjVar.a && get() == asjVar.get();
    }
}
