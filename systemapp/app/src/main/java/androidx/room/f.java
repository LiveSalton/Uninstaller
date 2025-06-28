package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: source */
/* loaded from: classes.dex */
public class f {
    private static final String[] h = {"UPDATE", "DELETE", "INSERT"};
    final String[] b;
    final i c;
    volatile androidx.g.a.f e;
    private Map<String, Set<String>> i;
    private a k;
    private final e l;
    private g m;
    AtomicBoolean d = new AtomicBoolean(false);
    private volatile boolean j = false;

    @SuppressLint({"RestrictedApi"})
    final androidx.a.a.b.b<b, c> f = new androidx.a.a.b.b<>();
    Runnable g = new Runnable() { // from class: androidx.room.f.1
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [androidx.room.f$c] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r3;
            Throwable th;
            Set<Integer> a2;
            Lock a3 = f.this.c.a();
            try {
                try {
                    a3.lock();
                } finally {
                    a3.unlock();
                }
            } catch (SQLiteException | IllegalStateException e) {
                e = e;
                r3 = 0;
            }
            if (f.this.a()) {
                r3 = 1;
                if (f.this.d.compareAndSet(true, false)) {
                    if (f.this.c.k()) {
                        return;
                    }
                    if (f.this.c.b) {
                        try {
                            androidx.g.a.b a4 = f.this.c.b().a();
                            a4.a();
                            try {
                                a2 = a();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                a4.c();
                                a4.b();
                                r3 = a2;
                            } catch (Throwable th3) {
                                th = th3;
                                a4.b();
                                throw th;
                            }
                        } catch (SQLiteException | IllegalStateException e2) {
                            e = e2;
                            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                            if (r3 != 0) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        r3 = a();
                    }
                    if (r3 != 0 || r3.isEmpty()) {
                        return;
                    }
                    synchronized (f.this.f) {
                        Iterator<Map.Entry<b, c>> it = f.this.f.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().a((Set<Integer>) r3);
                        }
                    }
                }
            }
        }

        private Set<Integer> a() {
            androidx.b.b bVar = new androidx.b.b();
            Cursor a2 = f.this.c.a(new androidx.g.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (a2.moveToNext()) {
                try {
                    bVar.add(Integer.valueOf(a2.getInt(0)));
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
            }
            a2.close();
            if (!bVar.isEmpty()) {
                f.this.e.a();
            }
            return bVar;
        }
    };
    final androidx.b.a<String, Integer> a = new androidx.b.a<>();

    public f(i iVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.c = iVar;
        this.k = new a(strArr.length);
        this.i = map2;
        this.l = new e(this.c);
        int length = strArr.length;
        this.b = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.a.put(lowerCase, Integer.valueOf(i));
            String str = map.get(strArr[i]);
            if (str != null) {
                this.b[i] = str.toLowerCase(Locale.US);
            } else {
                this.b[i] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.a.containsKey(lowerCase2)) {
                this.a.put(entry.getKey().toLowerCase(Locale.US), this.a.get(lowerCase2));
            }
        }
    }

    void a(androidx.g.a.b bVar) {
        synchronized (this) {
            if (this.j) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.c("PRAGMA temp_store = MEMORY;");
            bVar.c("PRAGMA recursive_triggers='ON';");
            bVar.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            b(bVar);
            this.e = bVar.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.j = true;
        }
    }

    void a(Context context, String str) {
        this.m = new g(context, str, this, this.c.i());
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void a(androidx.g.a.b bVar, int i) {
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, str2);
            bVar.c(sb.toString());
        }
    }

    private void b(androidx.g.a.b bVar, int i) {
        bVar.c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.c(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(b bVar) {
        c a2;
        String[] b2 = b(bVar.a);
        int[] iArr = new int[b2.length];
        int length = b2.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.a.get(b2[i].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + b2[i]);
            }
            iArr[i] = num.intValue();
        }
        c cVar = new c(bVar, iArr, b2);
        synchronized (this.f) {
            a2 = this.f.a(bVar, cVar);
        }
        if (a2 == null && this.k.a(iArr)) {
            c();
        }
    }

    private String[] b(String[] strArr) {
        androidx.b.b bVar = new androidx.b.b();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.i.containsKey(lowerCase)) {
                bVar.addAll(this.i.get(lowerCase));
            } else {
                bVar.add(str);
            }
        }
        return (String[]) bVar.toArray(new String[bVar.size()]);
    }

    @SuppressLint({"RestrictedApi"})
    public void b(b bVar) {
        c b2;
        synchronized (this.f) {
            b2 = this.f.b(bVar);
        }
        if (b2 == null || !this.k.b(b2.a)) {
            return;
        }
        c();
    }

    boolean a() {
        if (!this.c.d()) {
            return false;
        }
        if (!this.j) {
            this.c.b().a();
        }
        if (this.j) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* compiled from: source */
    /* renamed from: androidx.room.f$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [androidx.room.f$c] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.util.Set] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r3;
            Throwable th;
            Set<Integer> a2;
            Lock a3 = f.this.c.a();
            try {
                try {
                    a3.lock();
                } finally {
                    a3.unlock();
                }
            } catch (SQLiteException | IllegalStateException e) {
                e = e;
                r3 = 0;
            }
            if (f.this.a()) {
                r3 = 1;
                if (f.this.d.compareAndSet(true, false)) {
                    if (f.this.c.k()) {
                        return;
                    }
                    if (f.this.c.b) {
                        try {
                            androidx.g.a.b a4 = f.this.c.b().a();
                            a4.a();
                            try {
                                a2 = a();
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                a4.c();
                                a4.b();
                                r3 = a2;
                            } catch (Throwable th3) {
                                th = th3;
                                a4.b();
                                throw th;
                            }
                        } catch (SQLiteException | IllegalStateException e2) {
                            e = e2;
                            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                            if (r3 != 0) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        r3 = a();
                    }
                    if (r3 != 0 || r3.isEmpty()) {
                        return;
                    }
                    synchronized (f.this.f) {
                        Iterator<Map.Entry<b, c>> it = f.this.f.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().a((Set<Integer>) r3);
                        }
                    }
                }
            }
        }

        private Set<Integer> a() {
            androidx.b.b bVar = new androidx.b.b();
            Cursor a2 = f.this.c.a(new androidx.g.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (a2.moveToNext()) {
                try {
                    bVar.add(Integer.valueOf(a2.getInt(0)));
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
            }
            a2.close();
            if (!bVar.isEmpty()) {
                f.this.e.a();
            }
            return bVar;
        }
    }

    public void b() {
        if (this.d.compareAndSet(false, true)) {
            this.c.i().execute(this.g);
        }
    }

    public void a(String... strArr) {
        synchronized (this.f) {
            Iterator<Map.Entry<b, c>> it = this.f.iterator();
            while (it.hasNext()) {
                Map.Entry<b, c> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().a(strArr);
                }
            }
        }
    }

    void b(androidx.g.a.b bVar) {
        if (bVar.d()) {
            return;
        }
        while (true) {
            try {
                Lock a2 = this.c.a();
                a2.lock();
                try {
                    int[] a3 = this.k.a();
                    if (a3 == null) {
                        return;
                    }
                    int length = a3.length;
                    bVar.a();
                    for (int i = 0; i < length; i++) {
                        try {
                            switch (a3[i]) {
                                case 1:
                                    b(bVar, i);
                                    break;
                                case 2:
                                    a(bVar, i);
                                    break;
                            }
                        } finally {
                        }
                    }
                    bVar.c();
                    bVar.b();
                    this.k.b();
                } finally {
                    a2.unlock();
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }

    void c() {
        if (this.c.d()) {
            b(this.c.b().a());
        }
    }

    /* compiled from: source */
    static class c {
        final int[] a;
        final b b;
        private final String[] c;
        private final Set<String> d;

        c(b bVar, int[] iArr, String[] strArr) {
            this.b = bVar;
            this.a = iArr;
            this.c = strArr;
            if (iArr.length == 1) {
                androidx.b.b bVar2 = new androidx.b.b();
                bVar2.add(this.c[0]);
                this.d = Collections.unmodifiableSet(bVar2);
                return;
            }
            this.d = null;
        }

        void a(Set<Integer> set) {
            Set<String> set2 = null;
            int length = this.a.length;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.a[i]))) {
                    if (length == 1) {
                        set2 = this.d;
                    } else {
                        if (set2 == null) {
                            set2 = new androidx.b.b<>(length);
                        }
                        set2.add(this.c[i]);
                    }
                }
            }
            if (set2 != null) {
                this.b.a(set2);
            }
        }

        void a(String[] strArr) {
            Set<String> set = null;
            if (this.c.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (strArr[i].equalsIgnoreCase(this.c[0])) {
                        set = this.d;
                        break;
                    }
                    i++;
                }
            } else {
                androidx.b.b bVar = new androidx.b.b();
                for (String str : strArr) {
                    String[] strArr2 = this.c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String str2 = strArr2[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                bVar.add(str2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (bVar.size() > 0) {
                    set = bVar;
                }
            }
            if (set != null) {
                this.b.a(set);
            }
        }
    }

    /* compiled from: source */
    public static abstract class b {
        final String[] a;

        public abstract void a(Set<String> set);

        boolean a() {
            return false;
        }

        public b(String[] strArr) {
            this.a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* compiled from: source */
    static class a {
        final long[] a;
        final boolean[] b;
        final int[] c;
        boolean d;
        boolean e;

        a(int i) {
            this.a = new long[i];
            this.b = new boolean[i];
            this.c = new int[i];
            Arrays.fill(this.a, 0L);
            Arrays.fill(this.b, false);
        }

        boolean a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.a[i];
                    this.a[i] = 1 + j;
                    if (j == 0) {
                        this.d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.a[i];
                    this.a[i] = j - 1;
                    if (j == 1) {
                        this.d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        int[] a() {
            synchronized (this) {
                if (this.d && !this.e) {
                    int length = this.a.length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i < length) {
                            boolean z = this.a[i] > 0;
                            if (z != this.b[i]) {
                                int[] iArr = this.c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.c[i] = 0;
                            }
                            this.b[i] = z;
                            i++;
                        } else {
                            this.e = true;
                            this.d = false;
                            return this.c;
                        }
                    }
                }
                return null;
            }
        }

        void b() {
            synchronized (this) {
                this.e = false;
            }
        }
    }
}
