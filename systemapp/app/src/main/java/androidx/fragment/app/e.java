package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* compiled from: source */
/* loaded from: classes.dex */
public class e {
    private static final androidx.b.g<String, Class<?>> a = new androidx.b.g<>();

    private static Class<?> d(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Class<?> cls = a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        a.put(str, cls2);
        return cls2;
    }

    static boolean a(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends Fragment> b(ClassLoader classLoader, String str) {
        try {
            return d(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public Fragment c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
