package androidx.appcompat.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.v;
import java.util.WeakHashMap;

/* compiled from: source */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<C0002a>> b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = d(context, i);
        if (d != null) {
            return d;
        }
        ColorStateList c2 = c(context, i);
        if (c2 != null) {
            a(context, i, c2);
            return c2;
        }
        return androidx.core.content.a.b(context, i);
    }

    public static Drawable b(Context context, int i) {
        return v.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        C0002a c0002a;
        synchronized (c) {
            SparseArray<C0002a> sparseArray = b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0002a = sparseArray.get(i)) != null) {
                if (c0002a.b.equals(context.getResources().getConfiguration())) {
                    return c0002a.a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (c) {
            SparseArray<C0002a> sparseArray = b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0002a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    private static TypedValue a() {
        TypedValue typedValue = a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        a.set(typedValue2);
        return typedValue2;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.a.a.a$a */
    private static class C0002a {
        final ColorStateList a;
        final Configuration b;

        C0002a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.b = configuration;
        }
    }
}
