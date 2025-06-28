package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends c<Boolean> {
    private static final String d = h.a("BatteryNotLowTracker");

    public b(Context context, androidx.work.impl.utils.b.a aVar) {
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
        int intExtra = registerReceiver.getIntExtra("plugged", 0);
        int intExtra2 = registerReceiver.getIntExtra("status", -1);
        float intExtra3 = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
        boolean z = true;
        if (intExtra == 0 && intExtra2 != 1 && intExtra3 <= 0.15f) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.a.b.c
    public void a(Context context, Intent intent) {
        if (intent.getAction() == null) {
        }
        h.a().b(d, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        char c = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1980154005) {
            if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                c = 1;
            }
        } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
            c = 0;
        }
        switch (c) {
            case 0:
                a((b) true);
                break;
            case 1:
                a((b) false);
                break;
        }
    }
}
