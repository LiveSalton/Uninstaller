package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.f;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class n {
    private final e a;
    private final ClassLoader b;
    int e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    String l;
    int m;
    CharSequence n;
    int o;
    CharSequence p;
    ArrayList<String> q;
    ArrayList<String> r;
    ArrayList<Runnable> t;
    ArrayList<a> d = new ArrayList<>();
    boolean k = true;
    boolean s = false;

    public abstract int b();

    public abstract void c();

    /* compiled from: source */
    static final class a {
        int a;
        Fragment b;
        int c;
        int d;
        int e;
        int f;
        f.b g;
        f.b h;

        a() {
        }

        a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            this.g = f.b.RESUMED;
            this.h = f.b.RESUMED;
        }
    }

    n(e eVar, ClassLoader classLoader) {
        this.a = eVar;
        this.b = classLoader;
    }

    void a(a aVar) {
        this.d.add(aVar);
        aVar.c = this.e;
        aVar.d = this.f;
        aVar.e = this.g;
        aVar.f = this.h;
    }

    public n a(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public n a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    n a(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.E = viewGroup;
        return a(viewGroup.getId(), fragment, str);
    }

    void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.x != null && !str.equals(fragment.x)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.x + " now " + str);
            }
            fragment.x = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.v != 0 && fragment.v != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.v + " now " + i);
            }
            fragment.v = i;
            fragment.w = i;
        }
        a(new a(i2, fragment));
    }

    public n b(int i, Fragment fragment) {
        return b(i, fragment, null);
    }

    public n b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i, fragment, str, 2);
        return this;
    }

    public n a(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    public n b(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    public n g() {
        if (this.j) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.k = false;
        return this;
    }

    public n c(boolean z) {
        this.s = z;
        return this;
    }
}
