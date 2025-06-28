package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class l implements androidx.g.a.d, androidx.g.a.e {
    static final TreeMap<Integer, l> g = new TreeMap<>();
    final long[] a;
    final double[] b;
    final String[] c;
    final byte[][] d;
    final int e;
    int f;
    private volatile String h;
    private final int[] i;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public static l a(String str, int i) {
        synchronized (g) {
            Map.Entry<Integer, l> ceilingEntry = g.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                g.remove(ceilingEntry.getKey());
                l value = ceilingEntry.getValue();
                value.b(str, i);
                return value;
            }
            l lVar = new l(i);
            lVar.b(str, i);
            return lVar;
        }
    }

    private l(int i) {
        this.e = i;
        int i2 = i + 1;
        this.i = new int[i2];
        this.a = new long[i2];
        this.b = new double[i2];
        this.c = new String[i2];
        this.d = new byte[i2][];
    }

    void b(String str, int i) {
        this.h = str;
        this.f = i;
    }

    public void a() {
        synchronized (g) {
            g.put(Integer.valueOf(this.e), this);
            c();
        }
    }

    private static void c() {
        if (g.size() <= 15) {
            return;
        }
        int size = g.size() - 10;
        Iterator<Integer> it = g.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    @Override // androidx.g.a.e
    public String b() {
        return this.h;
    }

    @Override // androidx.g.a.e
    public void a(androidx.g.a.d dVar) {
        for (int i = 1; i <= this.f; i++) {
            switch (this.i[i]) {
                case 1:
                    dVar.a(i);
                    break;
                case 2:
                    dVar.a(i, this.a[i]);
                    break;
                case 3:
                    dVar.a(i, this.b[i]);
                    break;
                case 4:
                    dVar.a(i, this.c[i]);
                    break;
                case 5:
                    dVar.a(i, this.d[i]);
                    break;
            }
        }
    }

    @Override // androidx.g.a.d
    public void a(int i) {
        this.i[i] = 1;
    }

    @Override // androidx.g.a.d
    public void a(int i, long j) {
        this.i[i] = 2;
        this.a[i] = j;
    }

    @Override // androidx.g.a.d
    public void a(int i, double d) {
        this.i[i] = 3;
        this.b[i] = d;
    }

    @Override // androidx.g.a.d
    public void a(int i, String str) {
        this.i[i] = 4;
        this.c[i] = str;
    }

    @Override // androidx.g.a.d
    public void a(int i, byte[] bArr) {
        this.i[i] = 5;
        this.d[i] = bArr;
    }
}
