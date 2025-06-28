package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.e.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
class f extends j {
    private static final Class<?> a;
    private static final Constructor<?> b;
    private static final Method c;
    private static final Method d;

    f() {
    }

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0021b[] c0021bArr, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        androidx.b.g gVar = new androidx.b.g();
        for (b.C0021b c0021b : c0021bArr) {
            Uri a2 = c0021b.a();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(a2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, a2);
                gVar.put(a2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, c0021b.b(), c0021b.c(), c0021b.d())) {
                return null;
            }
        }
        Typeface a3 = a(b2);
        if (a3 == null) {
            return null;
        }
        return Typeface.create(a3, i);
    }

    @Override // androidx.core.graphics.j
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (c.C0018c c0018c : bVar.a()) {
            ByteBuffer a2 = k.a(context, resources, c0018c.f());
            if (a2 == null || !a(b2, a2, c0018c.e(), c0018c.b(), c0018c.c())) {
                return null;
            }
        }
        return a(b2);
    }
}
