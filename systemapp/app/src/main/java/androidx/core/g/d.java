package androidx.core.g;

/* compiled from: source */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: source */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: source */
    public static class b<T> implements a<T> {
        private final Object[] a;
        private int b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[i];
        }

        @Override // androidx.core.g.d.a
        public T a() {
            if (this.b <= 0) {
                return null;
            }
            int i = this.b - 1;
            T t = (T) this.a[i];
            this.a[i] = null;
            this.b--;
            return t;
        }

        @Override // androidx.core.g.d.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.b >= this.a.length) {
                return false;
            }
            this.a[this.b] = t;
            this.b++;
            return true;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: source */
    public static class c<T> extends b<T> {
        private final Object a;

        public c(int i) {
            super(i);
            this.a = new Object();
        }

        @Override // androidx.core.g.d.b, androidx.core.g.d.a
        public T a() {
            T t;
            synchronized (this.a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // androidx.core.g.d.b, androidx.core.g.d.a
        public boolean a(T t) {
            boolean a;
            synchronized (this.a) {
                a = super.a(t);
            }
            return a;
        }
    }
}
