package androidx.core.d;

import android.os.Build;
import android.os.CancellationSignal;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a {
    private boolean a;
    private InterfaceC0020a b;
    private Object c;
    private boolean d;

    /* compiled from: source */
    /* renamed from: androidx.core.d.a$a */
    public interface InterfaceC0020a {
        void a();
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void b() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            InterfaceC0020a interfaceC0020a = this.b;
            Object obj = this.c;
            if (interfaceC0020a != null) {
                try {
                    interfaceC0020a.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public void a(InterfaceC0020a interfaceC0020a) {
        synchronized (this) {
            c();
            if (this.b == interfaceC0020a) {
                return;
            }
            this.b = interfaceC0020a;
            if (this.a && interfaceC0020a != null) {
                interfaceC0020a.a();
            }
        }
    }

    private void c() {
        while (this.d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
