package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzawx {
    private final AtomicReference<ExecutorService> a = new AtomicReference<>(null);
    private final Object b = new Object();

    @GuardedBy("gmpAppIdLock")
    private String c = null;

    @GuardedBy("gmpAppIdLock")
    private String d = null;

    @VisibleForTesting
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicInteger f = new AtomicInteger(-1);
    private final AtomicReference<Object> g = new AtomicReference<>(null);
    private final AtomicReference<Object> h = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> i = new ConcurrentHashMap(9);
    private final AtomicReference<zzbgf> j = new AtomicReference<>(null);

    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> k = new ArrayBlockingQueue(20);
    private final Object l = new Object();

    public final boolean a(Context context) {
        if (!((Boolean) zzwq.e().a(zzabf.R)).booleanValue() || this.e.get()) {
            return false;
        }
        if (((Boolean) zzwq.e().a(zzabf.ab)).booleanValue()) {
            return true;
        }
        if (this.f.get() == -1) {
            zzwq.a();
            if (!zzayr.c(context, GooglePlayServicesUtilLight.a)) {
                zzwq.a();
                if (zzayr.c(context)) {
                    zzd.e("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                    this.f.set(0);
                }
            }
            this.f.set(1);
        }
        return this.f.get() == 1;
    }

    @VisibleForTesting
    private static boolean h(Context context) {
        if (!((Boolean) zzwq.e().a(zzabf.Y)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwq.e().a(zzabf.Z)).intValue()) {
            return false;
        }
        if (!((Boolean) zzwq.e().a(zzabf.aa)).booleanValue()) {
            return true;
        }
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public final void a(Context context, zzaae zzaaeVar) {
        if (((Boolean) zzwq.e().a(zzabf.ad)).booleanValue() && a(context) && h(context)) {
            synchronized (this.l) {
            }
        }
    }

    public final void a(Context context, zzvk zzvkVar) {
        if (((Boolean) zzwq.e().a(zzabf.ad)).booleanValue() && a(context) && h(context)) {
            synchronized (this.l) {
            }
        }
    }

    public final void a(Context context, String str) {
        if (a(context)) {
            if (h(context)) {
                a("beginAdUnitExposure", new ey(str) { // from class: com.google.android.gms.internal.ads.ei
                    private final String a;

                    {
                        this.a = str;
                    }

                    @Override // com.google.android.gms.internal.ads.ey
                    public final void a(zzbgf zzbgfVar) {
                        zzbgfVar.b(this.a);
                    }
                });
            } else {
                a(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void b(Context context, String str) {
        if (a(context)) {
            if (h(context)) {
                a("endAdUnitExposure", new ey(str) { // from class: com.google.android.gms.internal.ads.ep
                    private final String a;

                    {
                        this.a = str;
                    }

                    @Override // com.google.android.gms.internal.ads.ey
                    public final void a(zzbgf zzbgfVar) {
                        zzbgfVar.c(this.a);
                    }
                });
            } else {
                a(context, str, "endAdUnitExposure");
            }
        }
    }

    public final String b(Context context) {
        if (!a(context)) {
            return "";
        }
        if (h(context)) {
            return (String) a("getCurrentScreenNameOrScreenClass", "", (ew<String>) eo.a);
        }
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return "";
        }
        try {
            String str = (String) i(context, "getCurrentScreenName").invoke(this.g.get(), new Object[0]);
            if (str == null) {
                str = (String) i(context, "getCurrentScreenClass").invoke(this.g.get(), new Object[0]);
            }
            return str != null ? str : "";
        } catch (Exception unused) {
            a("getCurrentScreenName", false);
            return "";
        }
    }

    @Deprecated
    public final void c(Context context, String str) {
        if (a(context) && (context instanceof Activity)) {
            if (h(context)) {
                a("setScreenName", new ey(context, str) { // from class: com.google.android.gms.internal.ads.er
                    private final Context a;
                    private final String b;

                    {
                        this.a = context;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.ey
                    public final void a(zzbgf zzbgfVar) {
                        Context context2 = this.a;
                        zzbgfVar.a(ObjectWrapper.a(context2), this.b, context2.getPackageName());
                    }
                });
            } else if (a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.h, false)) {
                try {
                    j(context, "setCurrentScreen").invoke(this.h.get(), (Activity) context, str, context.getPackageName());
                } catch (Exception unused) {
                    a("setCurrentScreen", false);
                }
            }
        }
    }

    public final String c(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.b) {
            if (this.c != null) {
                return this.c;
            }
            if (h(context)) {
                this.c = (String) a("getGmpAppId", this.c, (ew<String>) eq.a);
            } else {
                this.c = (String) a("getGmpAppId", context);
            }
            return this.c;
        }
    }

    public final String d(Context context) {
        if (!a(context)) {
            return null;
        }
        long longValue = ((Long) zzwq.e().a(zzabf.W)).longValue();
        if (h(context)) {
            try {
                if (longValue < 0) {
                    return (String) a("getAppInstanceId", (String) null, (ew<String>) et.a);
                }
                return (String) b().submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.es
                    private final zzawx a;

                    {
                        this.a = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.a.a();
                    }
                }).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        }
        if (longValue < 0) {
            return (String) a("getAppInstanceId", context);
        }
        try {
            return (String) b().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.ev
                private final zzawx a;
                private final Context b;

                {
                    this.a = this;
                    this.b = context;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.g(this.b);
                }
            }).get(longValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused3) {
            return "TIME_OUT";
        } catch (Exception unused4) {
            return null;
        }
    }

    public final String e(Context context) {
        if (!a(context)) {
            return null;
        }
        if (h(context)) {
            Long l = (Long) a("getAdEventId", (String) null, (ew<String>) eu.a);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object a = a("generateEventId", context);
        if (a != null) {
            return a.toString();
        }
        return null;
    }

    public final String f(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.b) {
            if (this.d != null) {
                return this.d;
            }
            if (h(context)) {
                this.d = (String) a("getAppIdOrigin", this.d, (ew<String>) ek.a);
            } else {
                this.d = "fa";
            }
            return this.d;
        }
    }

    public final void d(Context context, String str) {
        a(context, "_ac", str, (Bundle) null);
    }

    public final void e(Context context, String str) {
        a(context, "_ai", str, (Bundle) null);
    }

    public final void f(Context context, String str) {
        a(context, "_aq", str, (Bundle) null);
    }

    public final void g(Context context, String str) {
        a(context, "_aa", str, (Bundle) null);
    }

    public final void a(Context context, String str, String str2, String str3, int i) {
        if (a(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            a(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(75 + String.valueOf(str3).length());
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzd.a(sb.toString());
        }
    }

    private final void a(Context context, String str, String str2, Bundle bundle) {
        if (a(context)) {
            Bundle a = a(str2, str);
            if (bundle != null) {
                a.putAll(bundle);
            }
            if (h(context)) {
                a("logEventInternal", new ey(str, a) { // from class: com.google.android.gms.internal.ads.ej
                    private final String a;
                    private final Bundle b;

                    {
                        this.a = str;
                        this.b = a;
                    }

                    @Override // com.google.android.gms.internal.ads.ey
                    public final void a(zzbgf zzbgfVar) {
                        zzbgfVar.a("am", this.a, this.b);
                    }
                });
            } else if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
                try {
                    i(context).invoke(this.g.get(), "am", str, a);
                } catch (Exception unused) {
                    a("logEventInternal", true);
                }
            }
        }
    }

    private static Bundle a(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzd.c(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method i(Context context) {
        Method method = this.i.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.i.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            a("logEventInternal", true);
            return null;
        }
    }

    private final Method h(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            a(str, false);
            return null;
        }
    }

    private final Method i(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            a(str, false);
            return null;
        }
    }

    private final Method j(Context context, String str) {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            a(str, false);
            return null;
        }
    }

    private final void a(Context context, String str, String str2) {
        if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            try {
                h(context, str2).invoke(this.g.get(), str);
                StringBuilder sb = new StringBuilder(37 + String.valueOf(str2).length() + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzd.a(sb.toString());
            } catch (Exception unused) {
                a(str2, false);
            }
        }
    }

    private final Object a(String str, Context context) {
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return null;
        }
        try {
            return i(context, str).invoke(this.g.get(), new Object[0]);
        } catch (Exception unused) {
            a(str, true);
            return null;
        }
    }

    private final void a(String str, boolean z) {
        if (this.e.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(30 + String.valueOf(str).length());
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        zzd.e(sb.toString());
        if (z) {
            zzd.e("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.e.set(true);
        }
    }

    private final ExecutorService b() {
        ExecutorService threadPoolExecutor;
        if (this.a.get() == null) {
            if (ClientLibraryUtils.a()) {
                threadPoolExecutor = zzduo.a().a(((Integer) zzwq.e().a(zzabf.X)).intValue(), c(), zzdut.b);
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzwq.e().a(zzabf.X)).intValue(), ((Integer) zzwq.e().a(zzabf.X)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), c());
            }
            this.a.compareAndSet(null, threadPoolExecutor);
        }
        return this.a.get();
    }

    private final ThreadFactory c() {
        return new ex(this);
    }

    private final boolean a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception unused) {
                a("getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void a(String str, ey eyVar) {
        synchronized (this.j) {
            FutureTask<?> futureTask = new FutureTask<>(new Runnable(this, eyVar, str) { // from class: com.google.android.gms.internal.ads.en
                private final zzawx a;
                private final ey b;
                private final String c;

                {
                    this.a = this;
                    this.b = eyVar;
                    this.c = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b, this.c);
                }
            }, null);
            if (this.j.get() != null) {
                futureTask.run();
            } else {
                this.k.offer(futureTask);
            }
        }
    }

    private final <T> T a(String str, T t, ew<T> ewVar) {
        synchronized (this.j) {
            if (this.j.get() != null) {
                try {
                    return ewVar.a(this.j.get());
                } catch (Exception unused) {
                    a(str, false);
                }
            }
            return t;
        }
    }

    final /* synthetic */ void a(ey eyVar, String str) {
        if (this.j.get() != null) {
            try {
                eyVar.a(this.j.get());
            } catch (Exception unused) {
                a(str, false);
            }
        }
    }

    final /* synthetic */ String g(Context context) throws Exception {
        return (String) a("getAppInstanceId", context);
    }

    final /* synthetic */ String a() throws Exception {
        return (String) a("getAppInstanceId", (String) null, (ew<String>) em.a);
    }
}
