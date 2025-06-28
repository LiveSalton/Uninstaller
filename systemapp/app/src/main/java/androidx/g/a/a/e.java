package androidx.g.a.a;

import android.database.sqlite.SQLiteStatement;
import androidx.g.a.f;

/* compiled from: source */
/* loaded from: classes.dex */
class e extends d implements f {
    private final SQLiteStatement a;

    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.a = sQLiteStatement;
    }

    @Override // androidx.g.a.f
    public int a() {
        return this.a.executeUpdateDelete();
    }

    @Override // androidx.g.a.f
    public long b() {
        return this.a.executeInsert();
    }
}
