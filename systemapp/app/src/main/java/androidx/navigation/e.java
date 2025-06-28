package androidx.navigation;

import androidx.b.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends d implements Iterable<d> {
    final h<d> a;
    private int b;
    private String c;

    public final d a(int i) {
        return a(i, true);
    }

    final d a(int i, boolean z) {
        d a = this.a.a(i);
        if (a != null) {
            return a;
        }
        if (!z || a() == null) {
            return null;
        }
        return a().a(i);
    }

    /* compiled from: source */
    /* renamed from: androidx.navigation.e$1 */
    class AnonymousClass1 implements Iterator<d> {
        private int b = -1;
        private boolean c = false;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b + 1 < e.this.a.b();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public d next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.c = true;
            h<d> hVar = e.this.a;
            int i = this.b + 1;
            this.b = i;
            return hVar.e(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            e.this.a.e(this.b).a(null);
            e.this.a.c(this.b);
            this.b--;
            this.c = false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        return new Iterator<d>() { // from class: androidx.navigation.e.1
            private int b = -1;
            private boolean c = false;

            AnonymousClass1() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b + 1 < e.this.a.b();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public d next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.c = true;
                h<d> hVar = e.this.a;
                int i = this.b + 1;
                this.b = i;
                return hVar.e(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.c) {
                    throw new IllegalStateException("You must call next() before you can remove an element");
                }
                e.this.a.e(this.b).a(null);
                e.this.a.c(this.b);
                this.b--;
                this.c = false;
            }
        };
    }

    public final int b() {
        return this.b;
    }

    @Override // androidx.navigation.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        d a = a(b());
        if (a == null) {
            if (this.c == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.b));
            } else {
                sb.append(this.c);
            }
        } else {
            sb.append("{");
            sb.append(a.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
