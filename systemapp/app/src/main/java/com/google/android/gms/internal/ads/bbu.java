package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbu implements zzrf {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    bbu(bbv bbvVar, Activity activity, Bundle bundle) {
        this.a = activity;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzrf
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.a, this.b);
    }
}
