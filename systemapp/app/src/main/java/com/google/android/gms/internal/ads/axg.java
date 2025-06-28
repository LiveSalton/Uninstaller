package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
final class axg implements zzeu {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    axg(aur aurVar, Activity activity, Bundle bundle) {
        this.a = activity;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeu
    public final void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.a, this.b);
    }
}
