package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class v {
    private final Map<String, Object> a = new HashMap();
    private volatile boolean b = false;

    protected void a() {
    }

    final void d() {
        this.b = true;
        if (this.a != null) {
            synchronized (this.a) {
                Iterator<Object> it = this.a.values().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
        a();
    }

    <T> T b(String str) {
        T t;
        if (this.a == null) {
            return null;
        }
        synchronized (this.a) {
            t = (T) this.a.get(str);
        }
        return t;
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
