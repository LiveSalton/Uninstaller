package androidx.work.impl.utils.a;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a<V> implements com.google.a.a.a.a<V> {
    static final AbstractC0052a b;
    private static final Object g;
    volatile Object c;
    volatile d d;
    volatile h e;
    static final boolean a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger f = Logger.getLogger(a.class.getName());

    protected void a() {
    }

    protected void b() {
    }

    static {
        Throwable th;
        AbstractC0052a gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "e"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "c"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            gVar = new g();
        }
        b = gVar;
        if (th != null) {
            f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    /* compiled from: source */
    private static final class h {
        static final h a = new h(false);
        volatile Thread b;
        volatile h c;

        h(boolean z) {
        }

        h() {
            a.b.a(this, Thread.currentThread());
        }

        void a(h hVar) {
            a.b.a(this, hVar);
        }

        void a() {
            Thread thread = this.b;
            if (thread != null) {
                this.b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    private void a(h hVar) {
        hVar.b = null;
        while (true) {
            h hVar2 = this.e;
            if (hVar2 == h.a) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.c;
                if (hVar2.b != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.c = hVar4;
                    if (hVar3.b == null) {
                        break;
                    }
                } else if (!b.a((a<?>) this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    /* compiled from: source */
    private static final class d {
        static final d a = new d(null, null);
        final Runnable b;
        final Executor c;
        d d;

        d(Runnable runnable, Executor executor) {
            this.b = runnable;
            this.c = executor;
        }
    }

    /* compiled from: source */
    private static final class c {
        static final c a = new c(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.a.a.c.1
            AnonymousClass1(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable b;

        /* compiled from: source */
        /* renamed from: androidx.work.impl.utils.a.a$c$1 */
        static class AnonymousClass1 extends Throwable {
            AnonymousClass1(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        c(Throwable th) {
            this.b = (Throwable) a.b(th);
        }
    }

    /* compiled from: source */
    private static final class b {
        static final b a;
        static final b b;
        final boolean c;
        final Throwable d;

        static {
            if (a.a) {
                b = null;
                a = null;
            } else {
                b = new b(false, null);
                a = new b(true, null);
            }
        }

        b(boolean z, Throwable th) {
            this.c = z;
            this.d = th;
        }
    }

    /* compiled from: source */
    private static final class f<V> implements Runnable {
        final a<V> a;
        final com.google.a.a.a.a<? extends V> b;

        f(a<V> aVar, com.google.a.a.a.a<? extends V> aVar2) {
            this.a = aVar;
            this.b = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.c != this) {
                return;
            }
            if (a.b.a((a<?>) this.a, (Object) this, a.b((com.google.a.a.a.a<?>) this.b))) {
                a.a((a<?>) this.a);
            }
        }
    }

    protected a() {
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.c;
        if ((obj != null) & (!(obj instanceof f))) {
            return c(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.e;
            if (hVar != h.a) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (b.a((a<?>) this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                a(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.c;
                            if ((obj2 != null) & (!(obj2 instanceof f))) {
                                return c(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        a(hVar2);
                    } else {
                        hVar = this.e;
                    }
                } while (hVar != h.a);
            }
            return c(this.c);
        }
        while (nanos > 0) {
            Object obj3 = this.c;
            if ((obj3 != null) & (!(obj3 instanceof f))) {
                return c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.c;
        if ((obj2 != null) & (!(obj2 instanceof f))) {
            return c(obj2);
        }
        h hVar = this.e;
        if (hVar != h.a) {
            h hVar2 = new h();
            do {
                hVar2.a(hVar);
                if (b.a((a<?>) this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.c;
                    } while (!((obj != null) & (!(obj instanceof f))));
                    return c(obj);
                }
                hVar = this.e;
            } while (hVar != h.a);
        }
        return c(this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V c(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            throw a("Task was cancelled.", ((b) obj).d);
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).b);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.c;
        return (obj != null) & (obj instanceof f ? false : true);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.c instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.c;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        b bVar = a ? new b(z, new CancellationException("Future.cancel() was called.")) : z ? b.a : b.b;
        Object obj2 = obj;
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (b.a((a<?>) aVar, obj2, (Object) bVar)) {
                if (z) {
                    aVar.a();
                }
                a((a<?>) aVar);
                if (!(obj2 instanceof f)) {
                    return true;
                }
                com.google.a.a.a.a<? extends V> aVar2 = ((f) obj2).b;
                if (aVar2 instanceof a) {
                    aVar = (a) aVar2;
                    obj2 = aVar.c;
                    if (!(obj2 == null) && !(obj2 instanceof f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    aVar2.cancel(z);
                    return true;
                }
            } else {
                obj2 = aVar.c;
                if (!(obj2 instanceof f)) {
                    return z2;
                }
            }
        }
    }

    @Override // com.google.a.a.a.a
    public final void a(Runnable runnable, Executor executor) {
        b(runnable);
        b(executor);
        d dVar = this.d;
        if (dVar != d.a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.d = dVar;
                if (b.a((a<?>) this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.d;
                }
            } while (dVar != d.a);
        }
        b(runnable, executor);
    }

    protected boolean a(V v) {
        if (v == null) {
            v = (V) g;
        }
        if (!b.a((a<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    protected boolean a(Throwable th) {
        if (!b.a((a<?>) this, (Object) null, (Object) new c((Throwable) b(th)))) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    protected boolean a(com.google.a.a.a.a<? extends V> aVar) {
        c cVar;
        b(aVar);
        Object obj = this.c;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!b.a((a<?>) this, (Object) null, b((com.google.a.a.a.a<?>) aVar))) {
                    return false;
                }
                a((a<?>) this);
                return true;
            }
            f fVar = new f(this, aVar);
            if (b.a((a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    aVar.a(fVar, androidx.work.impl.utils.a.b.INSTANCE);
                } catch (Throwable th) {
                    try {
                        cVar = new c(th);
                    } catch (Throwable unused) {
                        cVar = c.a;
                    }
                    b.a((a<?>) this, (Object) fVar, (Object) cVar);
                }
                return true;
            }
            obj = this.c;
        }
        if (obj instanceof b) {
            aVar.cancel(((b) obj).c);
        }
        return false;
    }

    static Object b(com.google.a.a.a.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).c;
            if (!(obj instanceof b)) {
                return obj;
            }
            b bVar = (b) obj;
            return bVar.c ? bVar.d != null ? new b(false, bVar.d) : b.b : obj;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!a) & isCancelled) {
            return b.b;
        }
        try {
            Object a2 = a((Future<Object>) aVar);
            return a2 == null ? g : a2;
        } catch (CancellationException e2) {
            if (!isCancelled) {
                return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e2));
            }
            return new b(false, e2);
        } catch (ExecutionException e3) {
            return new c(e3.getCause());
        } catch (Throwable th) {
            return new c(th);
        }
    }

    private static <V> V a(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    static void a(a<?> aVar) {
        d dVar = null;
        while (true) {
            aVar.d();
            aVar.b();
            d a2 = aVar.a(dVar);
            while (a2 != null) {
                dVar = a2.d;
                Runnable runnable = a2.b;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    aVar = fVar.a;
                    if (aVar.c == fVar) {
                        if (b.a((a<?>) aVar, (Object) fVar, b((com.google.a.a.a.a<?>) fVar.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    b(runnable, a2.c);
                }
                a2 = dVar;
            }
            return;
        }
    }

    private void d() {
        h hVar;
        do {
            hVar = this.e;
        } while (!b.a((a<?>) this, hVar, h.a));
        while (hVar != null) {
            hVar.a();
            hVar = hVar.c;
        }
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.d;
        } while (!b.a((a<?>) this, dVar2, d.a));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.d;
            dVar4.d = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = c();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String c() {
        Object obj = this.c;
        if (obj instanceof f) {
            return "setFuture=[" + d(((f) obj).b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    private void a(StringBuilder sb) {
        try {
            Object a2 = a((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            sb.append(d(a2));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private String d(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.utils.a.a$a */
    private static abstract class AbstractC0052a {
        abstract void a(h hVar, h hVar2);

        abstract void a(h hVar, Thread thread);

        abstract boolean a(a<?> aVar, d dVar, d dVar2);

        abstract boolean a(a<?> aVar, h hVar, h hVar2);

        abstract boolean a(a<?> aVar, Object obj, Object obj2);

        private AbstractC0052a() {
        }

        /* synthetic */ AbstractC0052a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: source */
    private static final class e extends AbstractC0052a {
        final AtomicReferenceFieldUpdater<h, Thread> a;
        final AtomicReferenceFieldUpdater<h, h> b;
        final AtomicReferenceFieldUpdater<a, h> c;
        final AtomicReferenceFieldUpdater<a, d> d;
        final AtomicReferenceFieldUpdater<a, Object> e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        void a(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        void a(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, h hVar, h hVar2) {
            return this.c.compareAndSet(aVar, hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, d dVar, d dVar2) {
            return this.d.compareAndSet(aVar, dVar, dVar2);
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, Object obj, Object obj2) {
            return this.e.compareAndSet(aVar, obj, obj2);
        }
    }

    /* compiled from: source */
    private static final class g extends AbstractC0052a {
        g() {
            super();
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        void a(h hVar, Thread thread) {
            hVar.b = thread;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        void a(h hVar, h hVar2) {
            hVar.c = hVar2;
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.e != hVar) {
                    return false;
                }
                aVar.e = hVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, d dVar, d dVar2) {
            synchronized (aVar) {
                if (aVar.d != dVar) {
                    return false;
                }
                aVar.d = dVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.a.a.AbstractC0052a
        boolean a(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.c != obj) {
                    return false;
                }
                aVar.c = obj2;
                return true;
            }
        }
    }

    private static CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T b(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
