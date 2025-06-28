package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class amz<OutputT> extends zzdxo.j<OutputT> {
    private static final b c;
    private static final Logger d = Logger.getLogger(amz.class.getName());
    private volatile Set<Throwable> a = null;
    private volatile int b;

    /* compiled from: source */
    static abstract class b {
        private b() {
        }

        abstract int a(amz amzVar);

        abstract void a(amz amzVar, Set<Throwable> set, Set<Throwable> set2);

        /* synthetic */ b(amy amyVar) {
            this();
        }
    }

    /* compiled from: source */
    static final class c extends b {
        private c() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.amz.b
        final void a(amz amzVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (amzVar) {
                if (amzVar.a == null) {
                    amzVar.a = set2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.amz.b
        final int a(amz amzVar) {
            int b;
            synchronized (amzVar) {
                b = amz.b(amzVar);
            }
            return b;
        }

        /* synthetic */ c(amy amyVar) {
            this();
        }
    }

    amz(int i) {
        this.b = i;
    }

    abstract void a(Set<Throwable> set);

    /* compiled from: source */
    static final class a extends b {
        private final AtomicReferenceFieldUpdater<amz, Set<Throwable>> a;
        private final AtomicIntegerFieldUpdater<amz> b;

        a(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.amz.b
        final void a(amz amzVar, Set<Throwable> set, Set<Throwable> set2) {
            this.a.compareAndSet(amzVar, null, set2);
        }

        @Override // com.google.android.gms.internal.ads.amz.b
        final int a(amz amzVar) {
            return this.b.decrementAndGet(amzVar);
        }
    }

    final Set<Throwable> j() {
        Set<Throwable> set = this.a;
        if (set != null) {
            return set;
        }
        Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        a(newSetFromMap);
        c.a(this, null, newSetFromMap);
        return this.a;
    }

    final int k() {
        return c.a(this);
    }

    final void l() {
        this.a = null;
    }

    static /* synthetic */ int b(amz amzVar) {
        int i = amzVar.b - 1;
        amzVar.b = i;
        return i;
    }

    static {
        Throwable th;
        b cVar;
        try {
            cVar = new a(AtomicReferenceFieldUpdater.newUpdater(amz.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(amz.class, "b"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            cVar = new c();
        }
        c = cVar;
        if (th != null) {
            d.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
