package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class anp<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable a = new anr();
    private static final Runnable b = new anr();
    private static final Runnable c = new anr();

    anp() {
    }

    abstract T a() throws Exception;

    abstract void a(@NullableDecl T t, @NullableDecl Throwable th);

    abstract String b();

    abstract boolean c();

    @Override // java.lang.Runnable
    public final void run() {
        T a2;
        Thread currentThread = Thread.currentThread();
        if (compareAndSet(null, currentThread)) {
            boolean z = !c();
            if (z) {
                try {
                    a2 = a();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, a)) {
                        Runnable runnable = get();
                        int i = 0;
                        boolean z2 = false;
                        while (true) {
                            if (runnable != b && runnable != c) {
                                break;
                            }
                            i++;
                            if (i <= 1000) {
                                Thread.yield();
                            } else if (runnable == c || compareAndSet(b, c)) {
                                boolean z3 = Thread.interrupted() || z2;
                                LockSupport.park(this);
                                z2 = z3;
                            }
                            runnable = get();
                        }
                        if (z2) {
                            currentThread.interrupt();
                        }
                    }
                    if (z) {
                        a(null, th);
                        return;
                    }
                    return;
                }
            } else {
                a2 = null;
            }
            if (!compareAndSet(currentThread, a)) {
                Runnable runnable2 = get();
                int i2 = 0;
                boolean z4 = false;
                while (true) {
                    if (runnable2 != b && runnable2 != c) {
                        break;
                    }
                    i2++;
                    if (i2 <= 1000) {
                        Thread.yield();
                    } else if (runnable2 == c || compareAndSet(b, c)) {
                        boolean z5 = Thread.interrupted() || z4;
                        LockSupport.park(this);
                        z4 = z5;
                    }
                    runnable2 = get();
                }
                if (z4) {
                    currentThread.interrupt();
                }
            }
            if (z) {
                a(a2, null);
            }
        }
    }

    final void e() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, b)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(a) == c) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == a) {
            str = "running=[DONE]";
        } else if (runnable == b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(21 + String.valueOf(name).length());
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String b2 = b();
        StringBuilder sb2 = new StringBuilder(2 + String.valueOf(str).length() + String.valueOf(b2).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(b2);
        return sb2.toString();
    }
}
