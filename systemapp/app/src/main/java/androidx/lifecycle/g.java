package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
class g {
    private static AtomicBoolean a = new AtomicBoolean(false);

    static void a(Context context) {
        if (a.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }

    /* compiled from: source */
    static class a extends b {
        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        a() {
        }

        @Override // androidx.lifecycle.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            s.a(activity);
        }
    }
}
