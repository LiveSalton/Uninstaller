package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzwq;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzby {
    private boolean d;
    private Context e;
    private boolean c = false;

    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> b = new WeakHashMap();

    @GuardedBy("this")
    private final BroadcastReceiver a = new s(this);

    public final synchronized void a(Context context) {
        if (this.c) {
            return;
        }
        this.e = context.getApplicationContext();
        if (this.e == null) {
            this.e = context;
        }
        zzabf.a(this.e);
        this.d = ((Boolean) zzwq.e().a(zzabf.bH)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.e.registerReceiver(this.a, intentFilter);
        this.c = true;
    }

    public final synchronized void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.d) {
            this.b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void a(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.d) {
            this.b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    public final synchronized void a(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.b.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }
}
