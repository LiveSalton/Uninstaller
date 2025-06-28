package androidx.e.a;

import androidx.lifecycle.j;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: source */
    /* renamed from: androidx.e.a.a$a */
    public interface InterfaceC0032a<D> {
        void a(androidx.e.b.a<D> aVar);

        void a(androidx.e.b.a<D> aVar, D d);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends j & y> a a(T t) {
        return new b(t, t.c());
    }
}
