package androidx.g.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public interface b extends Closeable {
    Cursor a(e eVar);

    f a(String str);

    void a();

    Cursor b(String str);

    void b();

    void c();

    void c(String str) throws SQLException;

    boolean d();

    boolean e();

    String f();

    List<Pair<String, String>> g();
}
