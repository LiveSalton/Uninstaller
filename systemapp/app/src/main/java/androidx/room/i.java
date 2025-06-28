package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.g.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class i {

    @Deprecated
    protected volatile androidx.g.a.b a;
    boolean b;

    @Deprecated
    protected List<b> c;
    private Executor d;
    private Executor e;
    private androidx.g.a.c f;
    private boolean h;
    private final ReentrantReadWriteLock i = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> j = new ThreadLocal<>();
    private final Map<String, Object> k = new ConcurrentHashMap();
    private final f g = c();

    /* compiled from: source */
    public static abstract class b {
        public void a(androidx.g.a.b bVar) {
        }

        public void b(androidx.g.a.b bVar) {
        }
    }

    protected abstract androidx.g.a.c b(androidx.room.a aVar);

    protected abstract f c();

    Lock a() {
        return this.i.readLock();
    }

    public void a(androidx.room.a aVar) {
        this.f = b(aVar);
        if (Build.VERSION.SDK_INT >= 16) {
            r1 = aVar.g == c.WRITE_AHEAD_LOGGING;
            this.f.a(r1);
        }
        this.c = aVar.e;
        this.d = aVar.h;
        this.e = new n(aVar.i);
        this.h = aVar.f;
        this.b = r1;
        if (aVar.j) {
            this.g.a(aVar.b, aVar.c);
        }
    }

    public androidx.g.a.c b() {
        return this.f;
    }

    public boolean d() {
        androidx.g.a.b bVar = this.a;
        return bVar != null && bVar.e();
    }

    public void e() {
        if (!this.h && l()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void f() {
        if (!k() && this.j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor a(androidx.g.a.e eVar) {
        e();
        f();
        return this.f.a().a(eVar);
    }

    public androidx.g.a.f a(String str) {
        e();
        f();
        return this.f.a().a(str);
    }

    @Deprecated
    public void g() {
        e();
        androidx.g.a.b a2 = this.f.a();
        this.g.b(a2);
        a2.a();
    }

    @Deprecated
    public void h() {
        this.f.a().b();
        if (k()) {
            return;
        }
        this.g.b();
    }

    public Executor i() {
        return this.d;
    }

    @Deprecated
    public void j() {
        this.f.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(androidx.g.a.b bVar) {
        this.g.a(bVar);
    }

    public boolean k() {
        return this.f.a().d();
    }

    /* compiled from: source */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        @SuppressLint({"NewApi"})
        c a(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !androidx.core.app.b.a(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* compiled from: source */
    public static class a<T extends i> {
        private final Class<T> a;
        private final String b;
        private final Context c;
        private ArrayList<b> d;
        private Executor e;
        private Executor f;
        private c.InterfaceC0038c g;
        private boolean h;
        private boolean j;
        private boolean l;
        private Set<Integer> n;
        private Set<Integer> o;
        private c i = c.AUTOMATIC;
        private boolean k = true;
        private final d m = new d();

        a(Context context, Class<T> cls, String str) {
            this.c = context;
            this.a = cls;
            this.b = str;
        }

        public a<T> a(androidx.room.a.a... aVarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (androidx.room.a.a aVar : aVarArr) {
                this.o.add(Integer.valueOf(aVar.a));
                this.o.add(Integer.valueOf(aVar.b));
            }
            this.m.a(aVarArr);
            return this;
        }

        public a<T> a() {
            this.h = true;
            return this;
        }

        public a<T> a(Executor executor) {
            this.e = executor;
            return this;
        }

        public a<T> b() {
            this.k = false;
            this.l = true;
            return this;
        }

        public a<T> a(b bVar) {
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(bVar);
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T c() {
            if (this.c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            if (this.e == null && this.f == null) {
                Executor b = androidx.a.a.a.a.b();
                this.f = b;
                this.e = b;
            } else if (this.e != null && this.f == null) {
                this.f = this.e;
            } else if (this.e == null && this.f != null) {
                this.e = this.f;
            }
            if (this.o != null && this.n != null) {
                for (Integer num : this.o) {
                    if (this.n.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.g == null) {
                this.g = new androidx.g.a.a.c();
            }
            androidx.room.a aVar = new androidx.room.a(this.c, this.b, this.g, this.m, this.d, this.h, this.i.a(this.c), this.e, this.f, this.j, this.k, this.l, this.n);
            T t = (T) h.a(this.a, "_Impl");
            t.a(aVar);
            return t;
        }
    }

    /* compiled from: source */
    public static class d {
        private androidx.b.h<androidx.b.h<androidx.room.a.a>> a = new androidx.b.h<>();

        public void a(androidx.room.a.a... aVarArr) {
            for (androidx.room.a.a aVar : aVarArr) {
                a(aVar);
            }
        }

        private void a(androidx.room.a.a aVar) {
            int i = aVar.a;
            int i2 = aVar.b;
            androidx.b.h<androidx.room.a.a> a = this.a.a(i);
            if (a == null) {
                a = new androidx.b.h<>();
                this.a.b(i, a);
            }
            androidx.room.a.a a2 = a.a(i2);
            if (a2 != null) {
                Log.w("ROOM", "Overriding migration " + a2 + " with " + aVar);
            }
            a.c(i2, aVar);
        }

        public List<androidx.room.a.a> a(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i2 > i, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0019 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.List<androidx.room.a.a> a(java.util.List<androidx.room.a.a> r11, boolean r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = -1
                r1 = 1
                if (r12 == 0) goto L6
                r2 = r0
                goto L7
            L6:
                r2 = r1
            L7:
                if (r12 == 0) goto Lc
                if (r13 >= r14) goto L4d
                goto Le
            Lc:
                if (r13 <= r14) goto L4d
            Le:
                androidx.b.h<androidx.b.h<androidx.room.a.a>> r3 = r10.a
                java.lang.Object r3 = r3.a(r13)
                androidx.b.h r3 = (androidx.b.h) r3
                r4 = 0
                if (r3 != 0) goto L1a
                return r4
            L1a:
                int r5 = r3.b()
                r6 = 0
                if (r12 == 0) goto L25
                int r5 = r5 + (-1)
                r7 = r0
                goto L27
            L25:
                r7 = r5
                r5 = r6
            L27:
                if (r5 == r7) goto L4a
                int r8 = r3.d(r5)
                if (r12 == 0) goto L37
                if (r8 > r14) goto L35
                if (r8 <= r13) goto L35
            L33:
                r9 = r1
                goto L3c
            L35:
                r9 = r6
                goto L3c
            L37:
                if (r8 < r14) goto L35
                if (r8 >= r13) goto L35
                goto L33
            L3c:
                if (r9 == 0) goto L48
                java.lang.Object r13 = r3.e(r5)
                r11.add(r13)
                r6 = r1
                r13 = r8
                goto L4a
            L48:
                int r5 = r5 + r2
                goto L27
            L4a:
                if (r6 != 0) goto L7
                return r4
            L4d:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.i.d.a(java.util.List, boolean, int, int):java.util.List");
        }
    }

    private static boolean l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
