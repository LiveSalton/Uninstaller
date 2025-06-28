package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyi implements MuteThisAdReason {
    private final String a;
    private zzyd b;

    public zzyi(zzyd zzydVar) {
        String str;
        this.b = zzydVar;
        try {
            str = zzydVar.a();
        } catch (RemoteException e) {
            zzaza.c("", e);
            str = null;
        }
        this.a = str;
    }

    public final String toString() {
        return this.a;
    }
}
