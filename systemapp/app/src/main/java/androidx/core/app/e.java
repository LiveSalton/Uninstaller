package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: source */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: source */
    static class a {
        private static Method a;
        private static boolean b;

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!b) {
                try {
                    a = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    a = null;
                }
            }
        }
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
