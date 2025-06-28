package androidx.g.a.a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.g.a.c;

/* compiled from: source */
/* loaded from: classes.dex */
class b implements androidx.g.a.c {
    private final a a;

    b(Context context, String str, c.a aVar) {
        this.a = a(context, str, aVar);
    }

    private a a(Context context, String str, c.a aVar) {
        return new a(context, str, new androidx.g.a.a.a[1], aVar);
    }

    @Override // androidx.g.a.c
    public void a(boolean z) {
        this.a.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.g.a.c
    public androidx.g.a.b a() {
        return this.a.a();
    }

    /* compiled from: source */
    static class a extends SQLiteOpenHelper {
        final androidx.g.a.a.a[] a;
        final c.a b;
        private boolean c;

        /* compiled from: source */
        /* renamed from: androidx.g.a.a.b$a$1 */
        class AnonymousClass1 implements DatabaseErrorHandler {
            final /* synthetic */ androidx.g.a.a.a[] b;

            AnonymousClass1(androidx.g.a.a.a[] aVarArr) {
                aVarArr = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                c.a.this.d(a.a(aVarArr, sQLiteDatabase));
            }
        }

        a(Context context, String str, androidx.g.a.a.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.a, new DatabaseErrorHandler() { // from class: androidx.g.a.a.b.a.1
                final /* synthetic */ androidx.g.a.a.a[] b;

                AnonymousClass1(androidx.g.a.a.a[] aVarArr2) {
                    aVarArr = aVarArr2;
                }

                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    c.a.this.d(a.a(aVarArr, sQLiteDatabase));
                }
            });
            this.b = aVar;
            this.a = aVarArr2;
        }

        synchronized androidx.g.a.b a() {
            this.c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        androidx.g.a.a.a a(SQLiteDatabase sQLiteDatabase) {
            return a(this.a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.a(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.b.a(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.c = true;
            this.b.b(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.c) {
                return;
            }
            this.b.c(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.a[0] = null;
        }

        static androidx.g.a.a.a a(androidx.g.a.a.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            androidx.g.a.a.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new androidx.g.a.a.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }
    }
}
