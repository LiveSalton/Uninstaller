package androidx.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends c {
    private static volatile a a;
    private static final Executor d = new Executor() { // from class: androidx.a.a.a.a.1
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: androidx.a.a.a.a.2
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };
    private c c = new b();
    private c b = this.c;

    /* compiled from: source */
    /* renamed from: androidx.a.a.a.a$1 */
    static class AnonymousClass1 implements Executor {
        AnonymousClass1() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.a.a.a.a$2 */
    static class AnonymousClass2 implements Executor {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    }

    private a() {
    }

    public static a a() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        this.b.b(runnable);
    }

    public static Executor b() {
        return e;
    }

    @Override // androidx.a.a.a.c
    public boolean c() {
        return this.b.c();
    }
}
