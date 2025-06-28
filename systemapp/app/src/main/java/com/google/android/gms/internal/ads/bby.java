package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* compiled from: source */
/* loaded from: classes.dex */
final class bby implements zzrf {
    private final /* synthetic */ Activity a;

    bby(bbv bbvVar, Activity activity) {
        this.a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.a);
    }
}
