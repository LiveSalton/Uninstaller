package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends c<Boolean> {
    private static final String d = h.a("BatteryChrgTracker");

    public a(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            h.a().e(d, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf(a(registerReceiver));
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    @Override // androidx.work.impl.a.b.c
    public void a(Context context, Intent intent) {
        char c;
        String action = intent.getAction();
        if (action == null) {
        }
        h.a().b(d, String.format("Received %s", action), new Throwable[0]);
        int hashCode = action.hashCode();
        if (hashCode == -1886648615) {
            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                c = 3;
            }
            c = 65535;
        } else if (hashCode == -54942926) {
            if (action.equals("android.os.action.DISCHARGING")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != 948344062) {
            if (hashCode == 1019184907 && action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (action.equals("android.os.action.CHARGING")) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                a((a) true);
                break;
            case 1:
                a((a) false);
                break;
            case 2:
                a((a) true);
                break;
            case 3:
                a((a) false);
                break;
        }
    }

    private boolean a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }
}
