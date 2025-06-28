package androidx.g.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: source */
    /* renamed from: androidx.g.a.c$c */
    public interface InterfaceC0038c {
        c a(b bVar);
    }

    androidx.g.a.b a();

    void a(boolean z);

    /* compiled from: source */
    public static abstract class a {
        public final int a;

        public void a(androidx.g.a.b bVar) {
        }

        public abstract void a(androidx.g.a.b bVar, int i, int i2);

        public abstract void b(androidx.g.a.b bVar);

        public void c(androidx.g.a.b bVar) {
        }

        public a(int i) {
            this.a = i;
        }

        public void b(androidx.g.a.b bVar, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void d(androidx.g.a.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.f());
            if (!bVar.e()) {
                a(bVar.f());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.g();
                } finally {
                    if (list != null) {
                        Iterator<Pair<String, String>> it = list.iterator();
                        while (it.hasNext()) {
                            a((String) it.next().second);
                        }
                    } else {
                        a(bVar.f());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                bVar.close();
            } catch (IOException unused2) {
            }
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (Exception e) {
                        Log.e("SupportSQLite", "error while deleting corrupted database file", e);
                    }
                }
            } catch (Exception e2) {
                Log.w("SupportSQLite", "delete failed: ", e2);
            }
        }
    }

    /* compiled from: source */
    public static class b {
        public final Context a;
        public final String b;
        public final a c;

        b(Context context, String str, a aVar) {
            this.a = context;
            this.b = str;
            this.c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }

        /* compiled from: source */
        public static class a {
            Context a;
            String b;
            a c;

            public b a() {
                if (this.c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                return new b(this.a, this.b, this.c);
            }

            a(Context context) {
                this.a = context;
            }

            public a a(String str) {
                this.b = str;
                return this;
            }

            public a a(a aVar) {
                this.c = aVar;
                return this;
            }
        }
    }
}
