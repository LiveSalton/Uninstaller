package com.jumobile.manager.systemapp.inappbilling.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: source */
/* loaded from: classes.dex */
public class IabBroadcastReceiver extends BroadcastReceiver {
    private final a a;

    /* compiled from: source */
    public interface a {
        void a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.a != null) {
            this.a.a();
        }
    }
}
