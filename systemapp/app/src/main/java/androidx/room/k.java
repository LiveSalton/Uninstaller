package androidx.room;

import android.database.Cursor;
import androidx.g.a.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class k extends c.a {
    private androidx.room.a b;
    private final a c;
    private final String d;
    private final String e;

    public k(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.a);
        this.b = aVar;
        this.c = aVar2;
        this.d = str;
        this.e = str2;
    }

    @Override // androidx.g.a.c.a
    public void a(androidx.g.a.b bVar) {
        super.a(bVar);
    }

    @Override // androidx.g.a.c.a
    public void b(androidx.g.a.b bVar) {
        f(bVar);
        this.c.b(bVar);
        this.c.d(bVar);
    }

    @Override // androidx.g.a.c.a
    public void a(androidx.g.a.b bVar, int i, int i2) {
        boolean z;
        List<androidx.room.a.a> a2;
        if (this.b == null || (a2 = this.b.d.a(i, i2)) == null) {
            z = false;
        } else {
            this.c.f(bVar);
            Iterator<androidx.room.a.a> it = a2.iterator();
            while (it.hasNext()) {
                it.next().a(bVar);
            }
            this.c.e(bVar);
            this.c.g(bVar);
            f(bVar);
            z = true;
        }
        if (z) {
            return;
        }
        if (this.b != null && !this.b.a(i, i2)) {
            this.c.a(bVar);
            this.c.b(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.g.a.c.a
    public void b(androidx.g.a.b bVar, int i, int i2) {
        a(bVar, i, i2);
    }

    @Override // androidx.g.a.c.a
    public void c(androidx.g.a.b bVar) {
        super.c(bVar);
        e(bVar);
        this.c.c(bVar);
        this.b = null;
    }

    private void e(androidx.g.a.b bVar) {
        if (h(bVar)) {
            Cursor a2 = bVar.a(new androidx.g.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                r1 = a2.moveToFirst() ? a2.getString(0) : null;
            } finally {
                a2.close();
            }
        }
        if (!this.d.equals(r1) && !this.e.equals(r1)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    private void f(androidx.g.a.b bVar) {
        g(bVar);
        bVar.c(j.a(this.d));
    }

    private void g(androidx.g.a.b bVar) {
        bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h(androidx.g.a.b bVar) {
        Cursor b = bVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (b.moveToFirst()) {
                if (b.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            b.close();
        }
    }

    /* compiled from: source */
    public static abstract class a {
        public final int a;

        protected abstract void a(androidx.g.a.b bVar);

        protected abstract void b(androidx.g.a.b bVar);

        protected abstract void c(androidx.g.a.b bVar);

        protected abstract void d(androidx.g.a.b bVar);

        protected abstract void e(androidx.g.a.b bVar);

        protected void f(androidx.g.a.b bVar) {
        }

        protected void g(androidx.g.a.b bVar) {
        }

        public a(int i) {
            this.a = i;
        }
    }
}
