package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
final class aur implements Application.ActivityLifecycleCallbacks {
    private final Application a;
    private final WeakReference<Application.ActivityLifecycleCallbacks> b;
    private boolean c = false;

    public aur(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.b = new WeakReference<>(activityLifecycleCallbacks);
        this.a = application;
    }

    private final void a(zzeu zzeuVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.b.get();
            if (activityLifecycleCallbacks != null) {
                zzeuVar.a(activityLifecycleCallbacks);
            } else {
                if (this.c) {
                    return;
                }
                this.a.unregisterActivityLifecycleCallbacks(this);
                this.c = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new atx(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new awm(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new avq(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new axe(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new axa(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new axg(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new axf(this, activity));
    }
}
