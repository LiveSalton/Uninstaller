package androidx.work.impl.utils.b;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.f;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements a {
    private final Executor a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Executor c = new Executor() { // from class: androidx.work.impl.utils.b.b.1
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.b(runnable);
        }
    };

    public b(Executor executor) {
        this.a = new f(executor);
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.utils.b.b$1 */
    class AnonymousClass1 implements Executor {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.b(runnable);
        }
    }

    public void b(Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // androidx.work.impl.utils.b.a
    public Executor a() {
        return this.c;
    }

    @Override // androidx.work.impl.utils.b.a
    public void a(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // androidx.work.impl.utils.b.a
    public Executor b() {
        return this.a;
    }
}
