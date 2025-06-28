package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* compiled from: source */
/* loaded from: classes.dex */
final class axe implements zzeu {
    private final /* synthetic */ Activity a;

    axe(aur aurVar, Activity activity) {
        this.a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.a);
    }
}
