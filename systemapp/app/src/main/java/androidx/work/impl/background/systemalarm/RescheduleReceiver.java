package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String a = h.a("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        h.a().b(a, String.format("Received intent %s", intent), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                androidx.work.impl.h.b(context).a(goAsync());
                return;
            } catch (IllegalStateException unused) {
                h.a().e(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[0]);
                return;
            }
        }
        context.startService(b.b(context));
    }
}
