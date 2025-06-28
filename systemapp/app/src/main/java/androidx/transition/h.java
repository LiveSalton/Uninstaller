package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
class h implements f {
    private static Class<?> a;
    private static boolean b;
    private static Method c;
    private static boolean d;
    private static Method e;
    private static boolean f;
    private final View g;

    @Override // androidx.transition.f
    public void a(ViewGroup viewGroup, View view) {
    }

    static f a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        if (c != null) {
            try {
                return new h((View) c.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    static void a(View view) {
        c();
        if (e != null) {
            try {
                e.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private h(View view) {
        this.g = view;
    }

    @Override // androidx.transition.f
    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }

    private static void a() {
        if (b) {
            return;
        }
        try {
            a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        b = true;
    }

    private static void b() {
        if (d) {
            return;
        }
        try {
            a();
            c = a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            c.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        d = true;
    }

    private static void c() {
        if (f) {
            return;
        }
        try {
            a();
            e = a.getDeclaredMethod("removeGhost", View.class);
            e.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f = true;
    }
}
