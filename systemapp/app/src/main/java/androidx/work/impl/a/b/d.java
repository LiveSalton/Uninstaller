package androidx.work.impl.a.b;

import android.content.Context;
import androidx.work.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class d<T> {
    private static final String d = h.a("ConstraintTracker");
    protected final androidx.work.impl.utils.b.a a;
    protected final Context b;
    T c;
    private final Object e = new Object();
    private final Set<androidx.work.impl.a.a<T>> f = new LinkedHashSet();

    public abstract T c();

    public abstract void d();

    public abstract void e();

    d(Context context, androidx.work.impl.utils.b.a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
    }

    public void a(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.e) {
            if (this.f.add(aVar)) {
                if (this.f.size() == 1) {
                    this.c = c();
                    h.a().b(d, String.format("%s: initial state = %s", getClass().getSimpleName(), this.c), new Throwable[0]);
                    d();
                }
                aVar.a(this.c);
            }
        }
    }

    public void b(androidx.work.impl.a.a<T> aVar) {
        synchronized (this.e) {
            if (this.f.remove(aVar) && this.f.isEmpty()) {
                e();
            }
        }
    }

    public void a(T t) {
        synchronized (this.e) {
            if (this.c != t && (this.c == null || !this.c.equals(t))) {
                this.c = t;
                this.a.a().execute(new Runnable() { // from class: androidx.work.impl.a.b.d.1
                    final /* synthetic */ List a;

                    AnonymousClass1(List list) {
                        arrayList = list;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((androidx.work.impl.a.a) it.next()).a(d.this.c);
                        }
                    }
                });
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.a.b.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List a;

        AnonymousClass1(List list) {
            arrayList = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((androidx.work.impl.a.a) it.next()).a(d.this.c);
            }
        }
    }
}
