package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbs extends BroadcastReceiver {
    private final /* synthetic */ zzqq a;

    bbs(zzqq zzqqVar) {
        this.a = zzqqVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.a(3);
    }
}
