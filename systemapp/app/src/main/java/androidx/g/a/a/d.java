package androidx.g.a.a;

import android.database.sqlite.SQLiteProgram;

/* compiled from: source */
/* loaded from: classes.dex */
class d implements androidx.g.a.d {
    private final SQLiteProgram a;

    d(SQLiteProgram sQLiteProgram) {
        this.a = sQLiteProgram;
    }

    @Override // androidx.g.a.d
    public void a(int i) {
        this.a.bindNull(i);
    }

    @Override // androidx.g.a.d
    public void a(int i, long j) {
        this.a.bindLong(i, j);
    }

    @Override // androidx.g.a.d
    public void a(int i, double d) {
        this.a.bindDouble(i, d);
    }

    @Override // androidx.g.a.d
    public void a(int i, String str) {
        this.a.bindString(i, str);
    }

    @Override // androidx.g.a.d
    public void a(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }
}
