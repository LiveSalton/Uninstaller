package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
class b {
    private static b a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.b.1
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0085b) message.obj);
            return true;
        }
    });
    private C0085b d;
    private C0085b e;

    /* compiled from: source */
    interface a {
        void a();

        void a(int i);
    }

    static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private b() {
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.b$1 */
    class AnonymousClass1 implements Handler.Callback {
        AnonymousClass1() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0085b) message.obj);
            return true;
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.b) {
            if (f(aVar)) {
                a(this.d, i);
            } else if (g(aVar)) {
                a(this.e, i);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.b) {
            if (f(aVar)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.b) {
            if (f(aVar)) {
                b(this.d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.b) {
            if (f(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.b) {
            if (f(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z;
        synchronized (this.b) {
            z = f(aVar) || g(aVar);
        }
        return z;
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.snackbar.b$b */
    private static class C0085b {
        final WeakReference<a> a;
        int b;
        boolean c;

        boolean a(a aVar) {
            return aVar != null && this.a.get() == aVar;
        }
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            a aVar = this.d.a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.d = null;
            }
        }
    }

    private boolean a(C0085b c0085b, int i) {
        a aVar = c0085b.a.get();
        if (aVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(c0085b);
        aVar.a(i);
        return true;
    }

    private boolean f(a aVar) {
        return this.d != null && this.d.a(aVar);
    }

    private boolean g(a aVar) {
        return this.e != null && this.e.a(aVar);
    }

    private void b(C0085b c0085b) {
        if (c0085b.b == -2) {
            return;
        }
        int i = 2750;
        if (c0085b.b > 0) {
            i = c0085b.b;
        } else if (c0085b.b == -1) {
            i = 1500;
        }
        this.c.removeCallbacksAndMessages(c0085b);
        this.c.sendMessageDelayed(Message.obtain(this.c, 0, c0085b), i);
    }

    void a(C0085b c0085b) {
        synchronized (this.b) {
            if (this.d == c0085b || this.e == c0085b) {
                a(c0085b, 2);
            }
        }
    }
}
