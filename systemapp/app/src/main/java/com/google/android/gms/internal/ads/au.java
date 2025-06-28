package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: source */
/* loaded from: classes.dex */
final class au extends TimerTask {
    private final /* synthetic */ AlertDialog a;
    private final /* synthetic */ Timer b;

    au(zzahz zzahzVar, AlertDialog alertDialog, Timer timer) {
        this.a = alertDialog;
        this.b = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.a.dismiss();
        this.b.cancel();
    }
}
