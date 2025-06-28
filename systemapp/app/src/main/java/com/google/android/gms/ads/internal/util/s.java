package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: source */
/* loaded from: classes.dex */
final class s extends BroadcastReceiver {
    private final /* synthetic */ zzby a;

    s(zzby zzbyVar) {
        this.a = zzbyVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.a(context, intent);
    }
}
