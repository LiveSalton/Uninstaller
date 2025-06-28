package androidx.e.a;

import android.os.Bundle;
import android.util.Log;
import androidx.b.h;
import androidx.e.a.a;
import androidx.e.b.a;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: source */
/* loaded from: classes.dex */
class b extends androidx.e.a.a {
    static boolean a = false;
    private final j b;
    private final c c;

    /* compiled from: source */
    public static class a<D> extends o<D> implements a.InterfaceC0034a<D> {
        private final int e;
        private final Bundle f;
        private final androidx.e.b.a<D> g;
        private j h;
        private C0033b<D> i;
        private androidx.e.b.a<D> j;

        androidx.e.b.a<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b.a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.a();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.e();
        }

        void f() {
            j jVar = this.h;
            C0033b<D> c0033b = this.i;
            if (jVar == null || c0033b == null) {
                return;
            }
            super.a((p) c0033b);
            a(jVar, c0033b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(p<? super D> pVar) {
            super.a((p) pVar);
            this.h = null;
            this.i = null;
        }

        androidx.e.b.a<D> a(boolean z) {
            if (b.a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.c();
            this.g.g();
            C0033b<D> c0033b = this.i;
            if (c0033b != null) {
                a((p) c0033b);
                if (z) {
                    c0033b.b();
                }
            }
            this.g.a((a.InterfaceC0034a) this);
            if ((c0033b != null && !c0033b.a()) || z) {
                this.g.i();
                return this.j;
            }
            return this.g;
        }

        @Override // androidx.lifecycle.o, androidx.lifecycle.LiveData
        public void b(D d) {
            super.b((a<D>) d);
            if (this.j != null) {
                this.j.i();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            androidx.core.g.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            this.g.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                this.i.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().a((androidx.e.b.a<D>) a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.e.a.b$b */
    static class C0033b<D> implements p<D> {
        private final androidx.e.b.a<D> a;
        private final a.InterfaceC0032a<D> b;
        private boolean c;

        @Override // androidx.lifecycle.p
        public void a(D d) {
            if (b.a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.a((androidx.e.b.a<D>) d));
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (b.a) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
    }

    /* compiled from: source */
    static class c extends v {
        private static final w.a a = new w.a() { // from class: androidx.e.a.b.c.1
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.w.a
            public <T extends v> T a(Class<T> cls) {
                return new c();
            }
        };
        private h<a> b = new h<>();
        private boolean c = false;

        /* compiled from: source */
        /* renamed from: androidx.e.a.b$c$1 */
        static class AnonymousClass1 implements w.a {
            AnonymousClass1() {
            }

            @Override // androidx.lifecycle.w.a
            public <T extends v> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c a(x xVar) {
            return (c) new w(xVar, a).a(c.class);
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).f();
            }
        }

        @Override // androidx.lifecycle.v
        protected void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.e(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a e = this.b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i));
                    printWriter.print(": ");
                    printWriter.println(e.toString());
                    e.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b(j jVar, x xVar) {
        this.b = jVar;
        this.c = c.a(xVar);
    }

    @Override // androidx.e.a.a
    public void a() {
        this.c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.g.a.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.e.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
