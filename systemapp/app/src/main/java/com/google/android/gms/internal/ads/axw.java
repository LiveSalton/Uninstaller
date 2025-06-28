package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: source */
/* loaded from: classes.dex */
final class axw extends Handler {
    private final /* synthetic */ axx a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    axw(axx axxVar, Looper looper) {
        super(looper);
        this.a = axxVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.a(message);
    }
}
