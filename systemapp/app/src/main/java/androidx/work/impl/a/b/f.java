package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends c<Boolean> {
    private static final String d = h.a("StorageNotLowTracker");

    public f(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.b.registerReceiver(null, b());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return true;
        }
        String action = registerReceiver.getAction();
        char c = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c = 1;
        }
        switch (c) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return null;
        }
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
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
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c = 1;
        }
        switch (c) {
            case 0:
                a((f) true);
                break;
            case 1:
                a((f) false);
                break;
        }
    }
}
