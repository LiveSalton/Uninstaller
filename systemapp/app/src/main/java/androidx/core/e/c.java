package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {
    private HandlerThread b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;
    private final Object a = new Object();
    private Handler.Callback e = new Handler.Callback() { // from class: androidx.core.e.c.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c.this.a();
                    break;
                case 1:
                    c.this.a((Runnable) message.obj);
                    break;
            }
            return true;
        }
    };
    private int d = 0;

    /* compiled from: source */
    public interface a<T> {
        void a(T t);
    }

    /* compiled from: source */
    /* renamed from: androidx.core.e.c$1 */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c.this.a();
                    break;
                case 1:
                    c.this.a((Runnable) message.obj);
                    break;
            }
            return true;
        }
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.e.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Callable a;
        final /* synthetic */ Handler b;
        final /* synthetic */ a c;

        AnonymousClass2(Callable callable, Handler handler, a aVar) {
            callable = callable;
            handler = handler;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = callable.call();
            } catch (Exception unused) {
                obj = null;
            }
            handler.post(new Runnable() { // from class: androidx.core.e.c.2.1
                final /* synthetic */ Object a;

                AnonymousClass1(Object obj2) {
                    obj = obj2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(obj);
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.core.e.c$2$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Object a;

            AnonymousClass1(Object obj2) {
                obj = obj2;
            }

            @Override // java.lang.Runnable
            public void run() {
                aVar.a(obj);
            }
        }
    }

    public <T> void a(Callable<T> callable, a<T> aVar) {
        b(new Runnable() { // from class: androidx.core.e.c.2
            final /* synthetic */ Callable a;
            final /* synthetic */ Handler b;
            final /* synthetic */ a c;

            AnonymousClass2(Callable callable2, Handler handler, a aVar2) {
                callable = callable2;
                handler = handler;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                try {
                    obj2 = callable.call();
                } catch (Exception unused) {
                    obj2 = null;
                }
                handler.post(new Runnable() { // from class: androidx.core.e.c.2.1
                    final /* synthetic */ Object a;

                    AnonymousClass1(Object obj22) {
                        obj = obj22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(obj);
                    }
                });
            }

            /* compiled from: source */
            /* renamed from: androidx.core.e.c$2$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ Object a;

                AnonymousClass1(Object obj22) {
                    obj = obj22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(obj);
                }
            }
        });
    }

    public <T> T a(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new Runnable() { // from class: androidx.core.e.c.3
            final /* synthetic */ AtomicReference a;
            final /* synthetic */ Callable b;
            final /* synthetic */ ReentrantLock c;
            final /* synthetic */ AtomicBoolean d;
            final /* synthetic */ Condition e;

            AnonymousClass3(AtomicReference atomicReference2, Callable callable2, ReentrantLock reentrantLock2, AtomicBoolean atomicBoolean2, Condition newCondition2) {
                atomicReference = atomicReference2;
                callable = callable2;
                reentrantLock = reentrantLock2;
                atomicBoolean = atomicBoolean2;
                newCondition = newCondition2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock2.lock();
        try {
            if (!atomicBoolean2.get()) {
                return (T) atomicReference2.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = newCondition2.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean2.get()) {
                    return (T) atomicReference2.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock2.unlock();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.e.c$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ AtomicReference a;
        final /* synthetic */ Callable b;
        final /* synthetic */ ReentrantLock c;
        final /* synthetic */ AtomicBoolean d;
        final /* synthetic */ Condition e;

        AnonymousClass3(AtomicReference atomicReference2, Callable callable2, ReentrantLock reentrantLock2, AtomicBoolean atomicBoolean2, Condition newCondition2) {
            atomicReference = atomicReference2;
            callable = callable2;
            reentrantLock = reentrantLock2;
            atomicBoolean = atomicBoolean2;
            newCondition = newCondition2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                atomicReference.set(callable.call());
            } catch (Exception unused) {
            }
            reentrantLock.lock();
            try {
                atomicBoolean.set(false);
                newCondition.signal();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f);
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }
}
