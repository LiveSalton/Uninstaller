package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import androidx.work.n;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a implements Runnable {
    private final androidx.work.impl.b a = new androidx.work.impl.b();

    abstract void b();

    public k a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b();
            this.a.a(k.a);
        } catch (Throwable th) {
            this.a.a(new k.a.C0053a(th));
        }
    }

    void a(androidx.work.impl.h hVar, String str) {
        a(hVar.c(), str);
        hVar.f().c(str);
        Iterator<androidx.work.impl.d> it = hVar.e().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    void a(androidx.work.impl.h hVar) {
        androidx.work.impl.e.a(hVar.d(), hVar.c(), hVar.e());
    }

    private void a(WorkDatabase workDatabase, String str) {
        androidx.work.impl.b.k o = workDatabase.o();
        androidx.work.impl.b.b p = workDatabase.p();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            n.a f = o.f(str2);
            if (f != n.a.SUCCEEDED && f != n.a.FAILED) {
                o.a(n.a.CANCELLED, str2);
            }
            linkedList.addAll(p.b(str2));
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.utils.a$1 */
    static class AnonymousClass1 extends a {
        final /* synthetic */ String b;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // androidx.work.impl.utils.a
        void b() {
            WorkDatabase c = androidx.work.impl.h.this.c();
            c.g();
            try {
                Iterator<String> it = c.o().h(str).iterator();
                while (it.hasNext()) {
                    a(androidx.work.impl.h.this, it.next());
                }
                c.j();
                c.h();
                a(androidx.work.impl.h.this);
            } catch (Throwable th) {
                c.h();
                throw th;
            }
        }
    }

    public static a a(String str, androidx.work.impl.h hVar) {
        return new a() { // from class: androidx.work.impl.utils.a.1
            final /* synthetic */ String b;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // androidx.work.impl.utils.a
            void b() {
                WorkDatabase c = androidx.work.impl.h.this.c();
                c.g();
                try {
                    Iterator<String> it = c.o().h(str).iterator();
                    while (it.hasNext()) {
                        a(androidx.work.impl.h.this, it.next());
                    }
                    c.j();
                    c.h();
                    a(androidx.work.impl.h.this);
                } catch (Throwable th) {
                    c.h();
                    throw th;
                }
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.utils.a$2 */
    static class AnonymousClass2 extends a {
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        AnonymousClass2(String str, boolean z) {
            str = str;
            z = z;
        }

        @Override // androidx.work.impl.utils.a
        void b() {
            WorkDatabase c = androidx.work.impl.h.this.c();
            c.g();
            try {
                Iterator<String> it = c.o().i(str).iterator();
                while (it.hasNext()) {
                    a(androidx.work.impl.h.this, it.next());
                }
                c.j();
                c.h();
                if (z) {
                    a(androidx.work.impl.h.this);
                }
            } catch (Throwable th) {
                c.h();
                throw th;
            }
        }
    }

    public static a a(String str, androidx.work.impl.h hVar, boolean z) {
        return new a() { // from class: androidx.work.impl.utils.a.2
            final /* synthetic */ String b;
            final /* synthetic */ boolean c;

            AnonymousClass2(String str2, boolean z2) {
                str = str2;
                z = z2;
            }

            @Override // androidx.work.impl.utils.a
            void b() {
                WorkDatabase c = androidx.work.impl.h.this.c();
                c.g();
                try {
                    Iterator<String> it = c.o().i(str).iterator();
                    while (it.hasNext()) {
                        a(androidx.work.impl.h.this, it.next());
                    }
                    c.j();
                    c.h();
                    if (z) {
                        a(androidx.work.impl.h.this);
                    }
                } catch (Throwable th) {
                    c.h();
                    throw th;
                }
            }
        };
    }
}
