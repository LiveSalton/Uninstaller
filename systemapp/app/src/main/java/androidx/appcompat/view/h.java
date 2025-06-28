package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ac;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public class h {
    ab b;
    private Interpolator d;
    private boolean e;
    private long c = -1;
    private final ac f = new ac() { // from class: androidx.appcompat.view.h.1
        private boolean b = false;
        private int c = 0;

        AnonymousClass1() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void a(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (h.this.b != null) {
                h.this.b.a(null);
            }
        }

        void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.a.size()) {
                if (h.this.b != null) {
                    h.this.b.b(null);
                }
                a();
            }
        }
    };
    final ArrayList<aa> a = new ArrayList<>();

    public h a(aa aaVar) {
        if (!this.e) {
            this.a.add(aaVar);
        }
        return this;
    }

    public h a(aa aaVar, aa aaVar2) {
        this.a.add(aaVar);
        aaVar2.b(aaVar.a());
        this.a.add(aaVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        Iterator<aa> it = this.a.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            if (this.c >= 0) {
                next.a(this.c);
            }
            if (this.d != null) {
                next.a(this.d);
            }
            if (this.b != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<aa> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public h a(ab abVar) {
        if (!this.e) {
            this.b = abVar;
        }
        return this;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.h$1 */
    class AnonymousClass1 extends ac {
        private boolean b = false;
        private int c = 0;

        AnonymousClass1() {
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void a(View view) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (h.this.b != null) {
                h.this.b.a(null);
            }
        }

        void a() {
            this.c = 0;
            this.b = false;
            h.this.b();
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.a.size()) {
                if (h.this.b != null) {
                    h.this.b.b(null);
                }
                a();
            }
        }
    }
}
