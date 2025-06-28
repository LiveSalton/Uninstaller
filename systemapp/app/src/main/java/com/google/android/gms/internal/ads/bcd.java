package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
final class bcd implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private Context b;
    private Runnable h;
    private long j;
    private final Object c = new Object();
    private boolean d = true;
    private boolean e = false;

    @GuardedBy("lock")
    private final List<zzrl> f = new ArrayList();

    @GuardedBy("lock")
    private final List<zzrw> g = new ArrayList();
    private boolean i = false;

    bcd() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void a(Application application, Context context) {
        if (this.i) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.b = application;
        this.j = ((Long) zzwq.e().a(zzabf.aq)).longValue();
        this.i = true;
    }

    public final void a(zzrl zzrlVar) {
        synchronized (this.c) {
            this.f.add(zzrlVar);
        }
    }

    public final void b(zzrl zzrlVar) {
        synchronized (this.c) {
            this.f.remove(zzrlVar);
        }
    }

    public final Activity a() {
        return this.a;
    }

    public final Context b() {
        return this.b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity);
        this.e = false;
        boolean z = !this.d;
        this.d = true;
        if (this.h != null) {
            com.google.android.gms.ads.internal.util.zzm.a.removeCallbacks(this.h);
        }
        synchronized (this.c) {
            Iterator<zzrw> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(activity);
                } catch (Exception e) {
                    zzp.g().a(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzaza.c("", e);
                }
            }
            if (z) {
                Iterator<zzrl> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().a(true);
                    } catch (Exception e2) {
                        zzaza.c("", e2);
                    }
                }
            } else {
                zzd.b("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity);
        synchronized (this.c) {
            Iterator<zzrw> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    it.next().b(activity);
                } catch (Exception e) {
                    zzp.g().a(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzaza.c("", e);
                }
            }
        }
        this.e = true;
        if (this.h != null) {
            com.google.android.gms.ads.internal.util.zzm.a.removeCallbacks(this.h);
        }
        zzduw zzduwVar = com.google.android.gms.ads.internal.util.zzm.a;
        bcc bccVar = new bcc(this);
        this.h = bccVar;
        zzduwVar.postDelayed(bccVar, this.j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.c) {
            if (this.a == null) {
                return;
            }
            if (this.a.equals(activity)) {
                this.a = null;
            }
            Iterator<zzrw> it = this.g.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().c(activity)) {
                        it.remove();
                    }
                } catch (Exception e) {
                    zzp.g().a(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzaza.c("", e);
                }
            }
        }
    }

    private final void a(Activity activity) {
        synchronized (this.c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.a = activity;
            }
        }
    }

    static /* synthetic */ boolean a(bcd bcdVar, boolean z) {
        bcdVar.d = false;
        return false;
    }
}
