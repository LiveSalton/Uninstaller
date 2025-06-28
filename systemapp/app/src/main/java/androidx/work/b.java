package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: source */
/* loaded from: classes.dex */
public final class b {
    private final Executor a;
    private final Executor b;
    private final q c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    /* compiled from: source */
    /* renamed from: androidx.work.b$b */
    public interface InterfaceC0051b {
        b a();
    }

    b(a aVar) {
        if (aVar.a == null) {
            this.a = h();
        } else {
            this.a = aVar.a;
        }
        if (aVar.c == null) {
            this.b = h();
        } else {
            this.b = aVar.c;
        }
        if (aVar.b == null) {
            this.c = q.a();
        } else {
            this.c = aVar.b;
        }
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public Executor a() {
        return this.a;
    }

    public Executor b() {
        return this.b;
    }

    public q c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.g / 2;
        }
        return this.g;
    }

    private Executor h() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    /* compiled from: source */
    public static final class a {
        Executor a;
        q b;
        Executor c;
        int d = 4;
        int e = 0;
        int f = Integer.MAX_VALUE;
        int g = 20;

        public b a() {
            return new b(this);
        }
    }
}
