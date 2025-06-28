package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.h;
import androidx.work.impl.background.systemalarm.ConstraintProxy;

/* compiled from: source */
/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    static final String a = h.a("ConstrntProxyUpdtRecvr");

    public static Intent a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            h.a().b(a, String.format("Ignoring unknown action %s", action), new Throwable[0]);
        } else {
            androidx.work.impl.h.b(context).g().a(new Runnable() { // from class: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver.1
                final /* synthetic */ Intent a;
                final /* synthetic */ Context b;
                final /* synthetic */ BroadcastReceiver.PendingResult c;

                AnonymousClass1(Intent intent2, Context context2, BroadcastReceiver.PendingResult pendingResult) {
                    intent = intent2;
                    context = context2;
                    goAsync = pendingResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                        boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                        boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                        h.a().b(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                        androidx.work.impl.utils.d.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                        androidx.work.impl.utils.d.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                        androidx.work.impl.utils.d.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                        androidx.work.impl.utils.d.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                    } finally {
                        goAsync.finish();
                    }
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Intent a;
        final /* synthetic */ Context b;
        final /* synthetic */ BroadcastReceiver.PendingResult c;

        AnonymousClass1(Intent intent2, Context context2, BroadcastReceiver.PendingResult pendingResult) {
            intent = intent2;
            context = context2;
            goAsync = pendingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                h.a().b(ConstraintProxyUpdateReceiver.a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)), new Throwable[0]);
                androidx.work.impl.utils.d.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                androidx.work.impl.utils.d.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                androidx.work.impl.utils.d.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                androidx.work.impl.utils.d.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                goAsync.finish();
            }
        }
    }
}
