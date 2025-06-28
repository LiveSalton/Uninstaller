package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdwe {

    @NullableDecl
    private static final Object a;

    @NullableDecl
    private static final Method b;

    @NullableDecl
    private static final Method c;

    public static void a(Throwable th) {
        zzdvv.a(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    @Deprecated
    public static RuntimeException b(Throwable th) {
        a(th);
        throw new RuntimeException(th);
    }

    public static String c(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzeid.a(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @NullableDecl
    private static Object a() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method b() {
        try {
            Method a2 = a("getStackTraceDepth", Throwable.class);
            if (a2 == null) {
                return null;
            }
            a2.invoke(a(), new Throwable());
            return a2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method a(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        Object a2 = a();
        a = a2;
        b = a2 == null ? null : a("getStackTraceElement", Throwable.class, Integer.TYPE);
        c = a != null ? b() : null;
    }
}
