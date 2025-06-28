package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class c {
    private static final Handler g = new Handler(Looper.getMainLooper());
    protected static final Class<?> a = d();
    protected static final Field b = b();
    protected static final Field c = c();
    protected static final Method d = a(a);
    protected static final Method e = b(a);
    protected static final Method f = c(a);

    static boolean a(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (a() && f == null) {
            return false;
        }
        if (e == null && d == null) {
            return false;
        }
        try {
            Object obj2 = c.get(activity);
            if (obj2 == null || (obj = b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            a aVar = new a(activity);
            application.registerActivityLifecycleCallbacks(aVar);
            g.post(new Runnable() { // from class: androidx.core.app.c.1
                final /* synthetic */ Object b;

                AnonymousClass1(Object obj22) {
                    obj2 = obj22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a = obj2;
                }
            });
            try {
                if (a()) {
                    f.invoke(obj, obj22, null, null, 0, false, null, null, false, false);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                g.post(new Runnable() { // from class: androidx.core.app.c.2
                    final /* synthetic */ Application a;
                    final /* synthetic */ a b;

                    AnonymousClass2(Application application2, a aVar2) {
                        application = application2;
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.app.c$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Object b;

        AnonymousClass1(Object obj22) {
            obj2 = obj22;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a = obj2;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.app.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Application a;
        final /* synthetic */ a b;

        AnonymousClass2(Application application2, a aVar2) {
            application = application2;
            aVar = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            application.unregisterActivityLifecycleCallbacks(aVar);
        }
    }

    /* compiled from: source */
    private static final class a implements Application.ActivityLifecycleCallbacks {
        Object a;
        private Activity b;
        private boolean c = false;
        private boolean d = false;
        private boolean e = false;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        a(Activity activity) {
            this.b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.b == activity) {
                this.c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.d || this.e || this.c || !c.a(this.a, activity)) {
                return;
            }
            this.e = true;
            this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.b == activity) {
                this.b = null;
                this.d = true;
            }
        }
    }

    protected static boolean a(Object obj, Activity activity) {
        try {
            Object obj2 = c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            g.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.c.3
                final /* synthetic */ Object a;
                final /* synthetic */ Object b;

                AnonymousClass3(Object obj3, Object obj22) {
                    obj3 = obj3;
                    obj2 = obj22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.d != null) {
                            c.d.invoke(obj3, obj2, false, "AppCompat recreation");
                        } else {
                            c.e.invoke(obj3, obj2, false);
                        }
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.app.c$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Object a;
        final /* synthetic */ Object b;

        AnonymousClass3(Object obj3, Object obj22) {
            obj3 = obj3;
            obj2 = obj22;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.d != null) {
                    c.d.invoke(obj3, obj2, false, "AppCompat recreation");
                } else {
                    c.e.invoke(obj3, obj2, false);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method c(Class<?> cls) {
        if (!a() || cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
