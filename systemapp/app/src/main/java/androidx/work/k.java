package androidx.work;

import android.annotation.SuppressLint;

/* compiled from: source */
/* loaded from: classes.dex */
public interface k {

    @SuppressLint({"SyntheticAccessor"})
    public static final a.c a = new a.c();

    @SuppressLint({"SyntheticAccessor"})
    public static final a.b b = new a.b();

    /* compiled from: source */
    public static abstract class a {
        a() {
        }

        /* compiled from: source */
        public static final class c extends a {
            public String toString() {
                return "SUCCESS";
            }

            /* synthetic */ c(AnonymousClass1 anonymousClass1) {
                this();
            }

            private c() {
            }
        }

        /* compiled from: source */
        public static final class b extends a {
            public String toString() {
                return "IN_PROGRESS";
            }

            /* synthetic */ b(AnonymousClass1 anonymousClass1) {
                this();
            }

            private b() {
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.work.k$a$a */
        public static final class C0053a extends a {
            private final Throwable a;

            public C0053a(Throwable th) {
                this.a = th;
            }

            public Throwable a() {
                return this.a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }
    }
}
