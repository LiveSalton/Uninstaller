package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bx {
    private static final Class<?> a = d();
    private static final cl<?, ?> b = a(false);
    private static final cl<?, ?> c = a(true);
    private static final cl<?, ?> d = new cm();

    public static void a(Class<?> cls) {
        if (!zzfd.class.isAssignableFrom(cls) && a != null && !a.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static cl<?, ?> a() {
        return b;
    }

    public static cl<?, ?> b() {
        return c;
    }

    public static cl<?, ?> c() {
        return d;
    }

    private static cl<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (cl) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void a(bi biVar, T t, T t2, long j) {
        co.a(t, j, biVar.a(co.f(t, j), co.f(t2, j)));
    }

    static <T, FT extends zzey<FT>> void a(ap<FT> apVar, T t, T t2) {
        at<FT> a2 = apVar.a(t2);
        if (a2.a.isEmpty()) {
            return;
        }
        apVar.b(t).a(a2);
    }

    static <T, UT, UB> void a(cl<UT, UB> clVar, T t, T t2) {
        clVar.a(t, clVar.b(clVar.a(t), clVar.a(t2)));
    }
}
