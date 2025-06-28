package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: source */
/* loaded from: classes.dex */
final class apz implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    apz(zzdx zzdxVar, int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a(MotionEvent.obtain(0L, this.a, 0, this.b, this.c, 0));
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2022, -1L, e);
        }
    }
}
