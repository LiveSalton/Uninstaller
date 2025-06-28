package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzha;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzx {
    private static volatile zzx b = null;
    private static Boolean h = null;
    private static Boolean i = null;
    private static boolean j = false;
    private static Boolean k = null;

    @VisibleForTesting
    private static String l = "use_dynamite_api";

    @VisibleForTesting
    private static String m = "allow_remote_dynamite";
    private static boolean n = false;
    private static boolean o = false;
    protected final Clock a;
    private final String c;
    private final ExecutorService d;
    private final AppMeasurementSdk e;
    private List<Pair<zzha, Object>> f;
    private int g;
    private boolean p;
    private String q;
    private zzm r;

    /* compiled from: source */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzx.this.a(new r(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzx.this.a(new t(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzx.this.a(new s(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzx.this.a(new v(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzx.this.a(new u(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzk zzkVar = new zzk();
            zzx.this.a(new x(this, activity, zzkVar));
            Bundle b = zzkVar.b(50L);
            if (b != null) {
                bundle.putAll(b);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzx.this.a(new w(this, activity));
        }
    }

    /* compiled from: source */
    abstract class a implements Runnable {
        final long a;
        final long b;
        private final boolean c;

        a(zzx zzxVar) {
            this(true);
        }

        abstract void a() throws RemoteException;

        protected void b() {
        }

        a(boolean z) {
            this.a = zzx.this.a.a();
            this.b = zzx.this.a.b();
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzx.this.p) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e) {
                zzx.this.a(e, false, this.c);
                b();
            }
        }
    }

    public static zzx a(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.a(context);
        if (b == null) {
            synchronized (zzx.class) {
                if (b == null) {
                    b = new zzx(context, str, str2, str3, bundle);
                }
            }
        }
        return b;
    }

    public final AppMeasurementSdk a() {
        return this.e;
    }

    private zzx(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !b(str2, str3)) {
            this.c = "FA";
        } else {
            this.c = str;
        }
        this.a = DefaultClock.d();
        this.d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.e = new AppMeasurementSdk(this);
        if (!(!d(context) || i())) {
            this.q = null;
            this.p = true;
            Log.w(this.c, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!b(str2, str3)) {
            this.q = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.c, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.p = true;
                return;
            } else {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.c, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.q = str2;
        }
        a(new com.google.android.gms.internal.measurement.a(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.c, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    private static boolean d(Context context) {
        try {
            GoogleServices.a(context);
            return GoogleServices.a() != null;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        return (str2 == null || str == null || i()) ? false : true;
    }

    public final void a(a aVar) {
        this.d.execute(aVar);
    }

    protected final zzm a(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        try {
            if (z) {
                versionPolicy = DynamiteModule.f;
            } else {
                versionPolicy = DynamiteModule.b;
            }
            return zzl.a(DynamiteModule.a(context, versionPolicy, "com.google.android.gms.measurement.dynamite").a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            a((Exception) e, true, false);
            return null;
        }
    }

    public static int e(Context context) {
        return DynamiteModule.b(context, "com.google.android.gms.measurement.dynamite");
    }

    public static int f(Context context) {
        return DynamiteModule.a(context, "com.google.android.gms.measurement.dynamite");
    }

    public final void a(Exception exc, boolean z, boolean z2) {
        this.p |= z;
        if (z) {
            Log.w(this.c, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.c, "Error with data collection. Data lost.", exc);
    }

    private static boolean i() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, null);
    }

    private final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        a(new p(this, l2, str, str2, bundle, z, z2));
    }

    public final void a(String str, String str2, Object obj) {
        a(str, str2, obj, true);
    }

    private final void a(String str, String str2, Object obj, boolean z) {
        a(new o(this, str, str2, obj, z));
    }

    public final void a(Bundle bundle) {
        a(new q(this, bundle));
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(new da(this, str, str2, bundle));
    }

    public final List<Bundle> a(String str, String str2) {
        zzk zzkVar = new zzk();
        a(new com.google.android.gms.internal.measurement.b(this, str, str2, zzkVar));
        List<Bundle> list = (List) zzk.a(zzkVar.b(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void a(Activity activity, String str, String str2) {
        a(new c(this, activity, str, str2));
    }

    public final void a(String str) {
        a(new d(this, str));
    }

    public final void b(String str) {
        a(new e(this, str));
    }

    public final String b() {
        zzk zzkVar = new zzk();
        a(new g(this, zzkVar));
        return zzkVar.a(500L);
    }

    public final String c() {
        zzk zzkVar = new zzk();
        a(new f(this, zzkVar));
        return zzkVar.a(50L);
    }

    public final long d() {
        zzk zzkVar = new zzk();
        a(new i(this, zzkVar));
        Long l2 = (Long) zzk.a(zzkVar.b(500L), Long.class);
        if (l2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.a.a()).nextLong();
            int i2 = this.g + 1;
            this.g = i2;
            return nextLong + i2;
        }
        return l2.longValue();
    }

    public final String e() {
        zzk zzkVar = new zzk();
        a(new h(this, zzkVar));
        return zzkVar.a(500L);
    }

    public final String f() {
        zzk zzkVar = new zzk();
        a(new k(this, zzkVar));
        return zzkVar.a(500L);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        zzk zzkVar = new zzk();
        a(new j(this, str, str2, z, zzkVar));
        Bundle b2 = zzkVar.b(5000L);
        if (b2 == null || b2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(b2.size());
        for (String str3 : b2.keySet()) {
            Object obj = b2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void a(int i2, String str, Object obj, Object obj2, Object obj3) {
        a(new m(this, false, 5, str, obj, null, null));
    }

    public final Bundle a(Bundle bundle, boolean z) {
        zzk zzkVar = new zzk();
        a(new l(this, bundle, zzkVar));
        if (z) {
            return zzkVar.b(5000L);
        }
        return null;
    }

    public final int c(String str) {
        zzk zzkVar = new zzk();
        a(new n(this, str, zzkVar));
        Integer num = (Integer) zzk.a(zzkVar.b(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String g() {
        return this.q;
    }

    public static void g(Context context) {
        synchronized (zzx.class) {
            try {
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                h = false;
                i = false;
            }
            if (h == null || i == null) {
                if (a(context, "app_measurement_internal_disable_startup_flags")) {
                    h = false;
                    i = false;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                h = Boolean.valueOf(sharedPreferences.getBoolean(l, false));
                i = Boolean.valueOf(sharedPreferences.getBoolean(m, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(l);
                edit.remove(m);
                edit.apply();
            }
        }
    }

    private static boolean a(Context context, String str) {
        Preconditions.a(str);
        try {
            ApplicationInfo a2 = Wrappers.a(context).a(context.getPackageName(), 128);
            if (a2 != null && a2.metaData != null) {
                return a2.metaData.getBoolean(str);
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
