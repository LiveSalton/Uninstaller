package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: source */
/* loaded from: classes.dex */
final class ac extends BroadcastReceiver {
    private final /* synthetic */ zzm a;

    private ac(zzm zzmVar) {
        this.a = zzmVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.a.d = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.d = false;
        }
    }

    /* synthetic */ ac(zzm zzmVar, z zVar) {
        this(zzmVar);
    }
}
