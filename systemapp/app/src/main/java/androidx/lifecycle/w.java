package androidx.lifecycle;

/* compiled from: source */
/* loaded from: classes.dex */
public class w {
    private final a a;
    private final x b;

    /* compiled from: source */
    public interface a {
        <T extends v> T a(Class<T> cls);
    }

    /* compiled from: source */
    static class c {
        void a(v vVar) {
        }

        c() {
        }
    }

    /* compiled from: source */
    static abstract class b extends c implements a {
        public abstract <T extends v> T a(String str, Class<T> cls);

        b() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    public w(x xVar, a aVar) {
        this.a = aVar;
        this.b = xVar;
    }

    public <T extends v> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends v> T a(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.b.a(str);
        if (cls.isInstance(t2)) {
            if (this.a instanceof c) {
                ((c) this.a).a(t2);
            }
            return t2;
        }
        if (this.a instanceof b) {
            t = (T) ((b) this.a).a(str, cls);
        } else {
            t = (T) this.a.a(cls);
        }
        this.b.a(str, t);
        return t;
    }
}
