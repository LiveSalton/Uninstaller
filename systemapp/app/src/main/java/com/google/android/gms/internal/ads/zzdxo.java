package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzdxo<V> extends zzdzr implements zzdyz<V> {
    private static final boolean a;
    private static final Logger b;
    private static final a c;
    private static final Object d;

    @NullableDecl
    private volatile Object e;

    @NullableDecl
    private volatile d f;

    @NullableDecl
    private volatile k g;

    /* compiled from: source */
    static abstract class a {
        private a() {
        }

        abstract void a(k kVar, k kVar2);

        abstract void a(k kVar, Thread thread);

        abstract boolean a(zzdxo<?> zzdxoVar, d dVar, d dVar2);

        abstract boolean a(zzdxo<?> zzdxoVar, k kVar, k kVar2);

        abstract boolean a(zzdxo<?> zzdxoVar, Object obj, Object obj2);

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: source */
    static final class b {
        static final b a = new b(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzdxo.b.1
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
        /* renamed from: com.google.android.gms.internal.ads.zzdxo$b$1 */
        class AnonymousClass1 extends Throwable {
            AnonymousClass1(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        b(Throwable th) {
            this.b = (Throwable) zzdvv.a(th);
        }
    }

    /* compiled from: source */
    static final class d {
        static final d a = new d(null, null);
        final Runnable b;
        final Executor c;

        @NullableDecl
        d d;

        d(Runnable runnable, Executor executor) {
            this.b = runnable;
            this.c = executor;
        }
    }

    /* compiled from: source */
    interface g<V> extends zzdyz<V> {
    }

    /* compiled from: source */
    static final class h extends a {
        private h() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, Thread thread) {
            kVar.b = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, k kVar2) {
            kVar.c = kVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, k kVar, k kVar2) {
            synchronized (zzdxoVar) {
                if (((zzdxo) zzdxoVar).g != kVar) {
                    return false;
                }
                ((zzdxo) zzdxoVar).g = kVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, d dVar, d dVar2) {
            synchronized (zzdxoVar) {
                if (((zzdxo) zzdxoVar).f != dVar) {
                    return false;
                }
                ((zzdxo) zzdxoVar).f = dVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, Object obj, Object obj2) {
            synchronized (zzdxoVar) {
                if (((zzdxo) zzdxoVar).e != obj) {
                    return false;
                }
                ((zzdxo) zzdxoVar).e = obj2;
                return true;
            }
        }

        /* synthetic */ h(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* compiled from: source */
    static final class i extends a {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        /* compiled from: source */
        /* renamed from: com.google.android.gms.internal.ads.zzdxo$i$1 */
        class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
            AnonymousClass1() {
            }

            @Override // java.security.PrivilegedExceptionAction
            public /* synthetic */ Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        private i() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, Thread thread) {
            a.putObject(kVar, e, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, k kVar2) {
            a.putObject(kVar, f, kVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, k kVar, k kVar2) {
            return a.compareAndSwapObject(zzdxoVar, c, kVar, kVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, d dVar, d dVar2) {
            return a.compareAndSwapObject(zzdxoVar, b, dVar, dVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, Object obj, Object obj2) {
            return a.compareAndSwapObject(zzdxoVar, d, obj, obj2);
        }

        /* synthetic */ i(AnonymousClass1 anonymousClass1) {
            this();
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzdxo.i.1
                        AnonymousClass1() {
                        }

                        @Override // java.security.PrivilegedExceptionAction
                        public /* synthetic */ Unsafe run() throws Exception {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    c = unsafe.objectFieldOffset(zzdxo.class.getDeclaredField("waiters"));
                    b = unsafe.objectFieldOffset(zzdxo.class.getDeclaredField("listeners"));
                    d = unsafe.objectFieldOffset(zzdxo.class.getDeclaredField("value"));
                    e = unsafe.objectFieldOffset(k.class.getDeclaredField("b"));
                    f = unsafe.objectFieldOffset(k.class.getDeclaredField("c"));
                    a = unsafe;
                } catch (Exception e2) {
                    zzdwe.a(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }
    }

    /* compiled from: source */
    static abstract class j<V> extends zzdxo<V> implements g<V> {
        j() {
        }

        @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* compiled from: source */
    static final class k {
        static final k a = new k(false);

        @NullableDecl
        volatile Thread b;

        @NullableDecl
        volatile k c;

        private k(boolean z) {
        }

        k() {
            zzdxo.c.a(this, Thread.currentThread());
        }

        final void a(k kVar) {
            zzdxo.c.a(this, kVar);
        }
    }

    private final void a(k kVar) {
        kVar.b = null;
        while (true) {
            k kVar2 = this.g;
            if (kVar2 == k.a) {
                return;
            }
            k kVar3 = null;
            while (kVar2 != null) {
                k kVar4 = kVar2.c;
                if (kVar2.b != null) {
                    kVar3 = kVar2;
                } else if (kVar3 != null) {
                    kVar3.c = kVar4;
                    if (kVar3.b == null) {
                        break;
                    }
                } else if (c.a((zzdxo<?>) this, kVar2, kVar4)) {
                }
                kVar2 = kVar4;
            }
            return;
        }
    }

    protected void b() {
    }

    protected void c() {
    }

    /* compiled from: source */
    static final class c {
        static final c a;
        static final c b;
        final boolean c;

        @NullableDecl
        final Throwable d;

        c(boolean z, @NullableDecl Throwable th) {
            this.c = z;
            this.d = th;
        }

        static {
            if (zzdxo.a) {
                b = null;
                a = null;
            } else {
                b = new c(false, null);
                a = new c(true, null);
            }
        }
    }

    /* compiled from: source */
    static final class e<V> implements Runnable {
        final zzdxo<V> a;
        final zzdyz<? extends V> b;

        e(zzdxo<V> zzdxoVar, zzdyz<? extends V> zzdyzVar) {
            this.a = zzdxoVar;
            this.b = zzdyzVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzdxo) this.a).e != this) {
                return;
            }
            if (zzdxo.c.a((zzdxo<?>) this.a, (Object) this, zzdxo.c(this.b))) {
                zzdxo.e(this.a);
            }
        }
    }

    /* compiled from: source */
    static final class f extends a {
        final AtomicReferenceFieldUpdater<k, Thread> a;
        final AtomicReferenceFieldUpdater<k, k> b;
        final AtomicReferenceFieldUpdater<zzdxo, k> c;
        final AtomicReferenceFieldUpdater<zzdxo, d> d;
        final AtomicReferenceFieldUpdater<zzdxo, Object> e;

        f(AtomicReferenceFieldUpdater<k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<k, k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdxo, k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdxo, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdxo, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, Thread thread) {
            this.a.lazySet(kVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final void a(k kVar, k kVar2) {
            this.b.lazySet(kVar, kVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, k kVar, k kVar2) {
            return this.c.compareAndSet(zzdxoVar, kVar, kVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, d dVar, d dVar2) {
            return this.d.compareAndSet(zzdxoVar, dVar, dVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzdxo.a
        final boolean a(zzdxo<?> zzdxoVar, Object obj, Object obj2) {
            return this.e.compareAndSet(zzdxoVar, obj, obj2);
        }
    }

    protected zzdxo() {
    }

    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.e;
        if ((obj != null) & (!(obj instanceof e))) {
            return (V) a(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            k kVar = this.g;
            if (kVar != k.a) {
                k kVar2 = new k();
                do {
                    kVar2.a(kVar);
                    if (c.a((zzdxo<?>) this, kVar, kVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                a(kVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.e;
                            if ((obj2 != null) & (!(obj2 instanceof e))) {
                                return (V) a(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        a(kVar2);
                    } else {
                        kVar = this.g;
                    }
                } while (kVar != k.a);
            }
            return (V) a(this.e);
        }
        while (nanos > 0) {
            Object obj3 = this.e;
            if ((obj3 != null) & (!(obj3 instanceof e))) {
                return (V) a(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String zzdxoVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(28 + String.valueOf(lowerCase2).length());
        sb.append("Waited ");
        sb.append(j2);
        sb.append(" ");
        sb.append(lowerCase2);
        String sb2 = sb.toString();
        if (nanos + 1000 < 0) {
            String concat = String.valueOf(sb2).concat(" (plus ");
            long j3 = -nanos;
            long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String valueOf = String.valueOf(concat);
                StringBuilder sb3 = new StringBuilder(21 + String.valueOf(valueOf).length() + String.valueOf(lowerCase).length());
                sb3.append(valueOf);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String sb4 = sb3.toString();
                if (z) {
                    sb4 = String.valueOf(sb4).concat(",");
                }
                concat = String.valueOf(sb4).concat(" ");
            }
            if (z) {
                String valueOf2 = String.valueOf(concat);
                StringBuilder sb5 = new StringBuilder(33 + String.valueOf(valueOf2).length());
                sb5.append(valueOf2);
                sb5.append(nanos2);
                sb5.append(" nanoseconds ");
                concat = sb5.toString();
            }
            sb2 = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb6 = new StringBuilder(5 + String.valueOf(sb2).length() + String.valueOf(zzdxoVar).length());
        sb6.append(sb2);
        sb6.append(" for ");
        sb6.append(zzdxoVar);
        throw new TimeoutException(sb6.toString());
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.e;
        if ((obj2 != null) & (!(obj2 instanceof e))) {
            return (V) a(obj2);
        }
        k kVar = this.g;
        if (kVar != k.a) {
            k kVar2 = new k();
            do {
                kVar2.a(kVar);
                if (c.a((zzdxo<?>) this, kVar, kVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            a(kVar2);
                            throw new InterruptedException();
                        }
                        obj = this.e;
                    } while (!((obj != null) & (!(obj instanceof e))));
                    return (V) a(obj);
                }
                kVar = this.g;
            } while (kVar != k.a);
        }
        return (V) a(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V a(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            Throwable th = ((c) obj).d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof b) {
            throw new ExecutionException(((b) obj).b);
        }
        if (obj == d) {
            return null;
        }
        return obj;
    }

    public boolean isDone() {
        Object obj = this.e;
        return (obj != null) & (obj instanceof e ? false : true);
    }

    public boolean isCancelled() {
        return this.e instanceof c;
    }

    public boolean cancel(boolean z) {
        c cVar;
        Object obj = this.e;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        if (a) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            cVar = c.a;
        } else {
            cVar = c.b;
        }
        Object obj2 = obj;
        boolean z2 = false;
        zzdxo<V> zzdxoVar = this;
        while (true) {
            if (c.a((zzdxo<?>) zzdxoVar, obj2, (Object) cVar)) {
                if (z) {
                    zzdxoVar.c();
                }
                e(zzdxoVar);
                if (!(obj2 instanceof e)) {
                    return true;
                }
                zzdyz<? extends V> zzdyzVar = ((e) obj2).b;
                if (zzdyzVar instanceof g) {
                    zzdxoVar = (zzdxo) zzdyzVar;
                    obj2 = zzdxoVar.e;
                    if (!(obj2 == null) && !(obj2 instanceof e)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzdyzVar.cancel(z);
                    return true;
                }
            } else {
                obj2 = zzdxoVar.e;
                if (!(obj2 instanceof e)) {
                    return z2;
                }
            }
        }
    }

    protected final boolean d() {
        Object obj = this.e;
        return (obj instanceof c) && ((c) obj).c;
    }

    public void a(Runnable runnable, Executor executor) {
        d dVar;
        zzdvv.a(runnable, "Runnable was null.");
        zzdvv.a(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f) != d.a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.d = dVar;
                if (c.a((zzdxo<?>) this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f;
                }
            } while (dVar != d.a);
        }
        b(runnable, executor);
    }

    protected boolean b(@NullableDecl V v) {
        if (v == null) {
            v = (V) d;
        }
        if (!c.a((zzdxo<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        e(this);
        return true;
    }

    protected boolean a(Throwable th) {
        if (!c.a((zzdxo<?>) this, (Object) null, (Object) new b((Throwable) zzdvv.a(th)))) {
            return false;
        }
        e(this);
        return true;
    }

    protected final boolean a(zzdyz<? extends V> zzdyzVar) {
        b bVar;
        zzdvv.a(zzdyzVar);
        Object obj = this.e;
        if (obj == null) {
            if (zzdyzVar.isDone()) {
                if (!c.a((zzdxo<?>) this, (Object) null, c(zzdyzVar))) {
                    return false;
                }
                e(this);
                return true;
            }
            e eVar = new e(this, zzdyzVar);
            if (c.a((zzdxo<?>) this, (Object) null, (Object) eVar)) {
                try {
                    zzdyzVar.a(eVar, anf.INSTANCE);
                } catch (Throwable th) {
                    try {
                        bVar = new b(th);
                    } catch (Throwable unused) {
                        bVar = b.a;
                    }
                    c.a((zzdxo<?>) this, (Object) eVar, (Object) bVar);
                }
                return true;
            }
            obj = this.e;
        }
        if (obj instanceof c) {
            zzdyzVar.cancel(((c) obj).c);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object c(zzdyz<?> zzdyzVar) {
        Throwable a2;
        if (zzdyzVar instanceof g) {
            Object obj = ((zzdxo) zzdyzVar).e;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.c) {
                return obj;
            }
            if (cVar.d != null) {
                return new c(false, cVar.d);
            }
            return c.b;
        }
        if ((zzdyzVar instanceof zzdzr) && (a2 = zzdzu.a((zzdzr) zzdyzVar)) != null) {
            return new b(a2);
        }
        boolean isCancelled = zzdyzVar.isCancelled();
        if ((!a) & isCancelled) {
            return c.b;
        }
        try {
            Object b2 = b((Future<Object>) zzdyzVar);
            if (!isCancelled) {
                return b2 == null ? d : b2;
            }
            String valueOf = String.valueOf(zzdyzVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(valueOf);
            return new c(false, new IllegalArgumentException(sb.toString()));
        } catch (CancellationException e2) {
            if (!isCancelled) {
                String valueOf2 = String.valueOf(zzdyzVar);
                StringBuilder sb2 = new StringBuilder(77 + String.valueOf(valueOf2).length());
                sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb2.append(valueOf2);
                return new b(new IllegalArgumentException(sb2.toString(), e2));
            }
            return new c(false, e2);
        } catch (ExecutionException e3) {
            if (isCancelled) {
                String valueOf3 = String.valueOf(zzdyzVar);
                StringBuilder sb3 = new StringBuilder(84 + String.valueOf(valueOf3).length());
                sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb3.append(valueOf3);
                return new c(false, new IllegalArgumentException(sb3.toString(), e3));
            }
            return new b(e3.getCause());
        } catch (Throwable th) {
            return new b(th);
        }
    }

    private static <V> V b(Future<V> future) throws ExecutionException {
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

    public static void e(zzdxo<?> zzdxoVar) {
        d dVar;
        d dVar2;
        d dVar3 = null;
        while (true) {
            k kVar = ((zzdxo) zzdxoVar).g;
            if (c.a(zzdxoVar, kVar, k.a)) {
                while (kVar != null) {
                    Thread thread = kVar.b;
                    if (thread != null) {
                        kVar.b = null;
                        LockSupport.unpark(thread);
                    }
                    kVar = kVar.c;
                }
                zzdxoVar.b();
                do {
                    dVar = ((zzdxo) zzdxoVar).f;
                } while (!c.a(zzdxoVar, dVar, d.a));
                while (true) {
                    dVar2 = dVar3;
                    dVar3 = dVar;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar = dVar3.d;
                    dVar3.d = dVar2;
                }
                while (dVar2 != null) {
                    dVar3 = dVar2.d;
                    Runnable runnable = dVar2.b;
                    if (runnable instanceof e) {
                        e eVar = (e) runnable;
                        zzdxoVar = eVar.a;
                        if (((zzdxo) zzdxoVar).e == eVar) {
                            if (!c.a((zzdxo<?>) zzdxoVar, (Object) eVar, c(eVar.b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        b(runnable, dVar2.c);
                    }
                    dVar2 = dVar3;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzr
    @NullableDecl
    protected final Throwable e() {
        if (!(this instanceof g)) {
            return null;
        }
        Object obj = this.e;
        if (obj instanceof b) {
            return ((b) obj).b;
        }
        return null;
    }

    final void a(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(d());
        }
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            int length = sb2.length();
            sb2.append("PENDING");
            Object obj = this.e;
            if (obj instanceof e) {
                sb2.append(", setFuture=[");
                a(sb2, ((e) obj).b);
                sb2.append("]");
            } else {
                try {
                    sb = zzdwc.b(a());
                } catch (RuntimeException | StackOverflowError e2) {
                    String valueOf = String.valueOf(e2.getClass());
                    StringBuilder sb3 = new StringBuilder(38 + String.valueOf(valueOf).length());
                    sb3.append("Exception thrown from implementation: ");
                    sb3.append(valueOf);
                    sb = sb3.toString();
                }
                if (sb != null) {
                    sb2.append(", info=[");
                    sb2.append(sb);
                    sb2.append("]");
                }
            }
            if (isDone()) {
                sb2.delete(length, sb2.length());
                a(sb2);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    protected String a() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    private final void a(StringBuilder sb) {
        try {
            Object b2 = b((Future<Object>) this);
            sb.append("SUCCESS, result=[");
            a(sb, b2);
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

    private final void a(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = b;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(57 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e2);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        a hVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        a = z;
        b = Logger.getLogger(zzdxo.class.getName());
        try {
            hVar = new i();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = null;
                th = th3;
                hVar = new f(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "c"), AtomicReferenceFieldUpdater.newUpdater(zzdxo.class, k.class, "g"), AtomicReferenceFieldUpdater.newUpdater(zzdxo.class, d.class, "f"), AtomicReferenceFieldUpdater.newUpdater(zzdxo.class, Object.class, "e"));
            } catch (Throwable th4) {
                th = th3;
                th2 = th4;
                hVar = new h();
            }
        }
        c = hVar;
        if (th2 != null) {
            b.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            b.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        d = new Object();
    }
}
