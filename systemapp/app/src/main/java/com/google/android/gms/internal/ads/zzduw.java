package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzduw extends Handler {
    private static zzduv a;

    public zzduw() {
    }

    public zzduw(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        a(message);
    }

    protected void a(Message message) {
        super.dispatchMessage(message);
    }
}
