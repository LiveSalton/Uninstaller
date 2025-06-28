package androidx.g.a.a;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import androidx.g.a.f;
import java.io.IOException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class a implements androidx.g.a.b {
    private static final String[] a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final String[] b = new String[0];
    private final SQLiteDatabase c;

    a(SQLiteDatabase sQLiteDatabase) {
        this.c = sQLiteDatabase;
    }

    @Override // androidx.g.a.b
    public f a(String str) {
        return new e(this.c.compileStatement(str));
    }

    @Override // androidx.g.a.b
    public void a() {
        this.c.beginTransaction();
    }

    @Override // androidx.g.a.b
    public void b() {
        this.c.endTransaction();
    }

    @Override // androidx.g.a.b
    public void c() {
        this.c.setTransactionSuccessful();
    }

    @Override // androidx.g.a.b
    public boolean d() {
        return this.c.inTransaction();
    }

    @Override // androidx.g.a.b
    public Cursor b(String str) {
        return a(new androidx.g.a.a(str));
    }

    /* compiled from: source */
    /* renamed from: androidx.g.a.a.a$1 */
    class AnonymousClass1 implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ androidx.g.a.e a;

        AnonymousClass1(androidx.g.a.e eVar) {
            eVar = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            eVar.a(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    @Override // androidx.g.a.b
    public Cursor a(androidx.g.a.e eVar) {
        return this.c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.g.a.a.a.1
            final /* synthetic */ androidx.g.a.e a;

            AnonymousClass1(androidx.g.a.e eVar2) {
                eVar = eVar2;
            }

            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar2.b(), b, null);
    }

    @Override // androidx.g.a.b
    public void c(String str) throws SQLException {
        this.c.execSQL(str);
    }

    @Override // androidx.g.a.b
    public boolean e() {
        return this.c.isOpen();
    }

    @Override // androidx.g.a.b
    public String f() {
        return this.c.getPath();
    }

    @Override // androidx.g.a.b
    public List<Pair<String, String>> g() {
        return this.c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.c == sQLiteDatabase;
    }
}
