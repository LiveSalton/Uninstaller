package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: source */
/* loaded from: classes.dex */
final class axo extends BroadcastReceiver {
    private final /* synthetic */ zzfh a;

    axo(zzfh zzfhVar) {
        this.a = zzfhVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.d();
    }
}
