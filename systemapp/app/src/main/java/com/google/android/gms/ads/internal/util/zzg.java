package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzduw;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzg extends zzduw {
    public zzg(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzp.g().a(e, "AdMobHandler.handleMessage");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzduw
    protected final void a(Message message) {
        try {
            super.a(message);
        } catch (Throwable th) {
            zzp.c();
            zzm.a(zzp.g().i(), th);
            throw th;
        }
    }
}
