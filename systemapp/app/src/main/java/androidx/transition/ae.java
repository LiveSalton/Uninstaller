package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
class ae {
    private static boolean a = true;
    private static Method b;
    private static boolean c;

    static ad a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ac(viewGroup);
        }
        return ab.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT >= 18) {
            b(viewGroup, z);
        } else {
            af.a(viewGroup, z);
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(ViewGroup viewGroup, boolean z) {
        if (a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }

    static int a(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!c) {
            try {
                b = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                b.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            c = true;
        }
        if (b != null) {
            try {
                return ((Integer) b.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }
}
