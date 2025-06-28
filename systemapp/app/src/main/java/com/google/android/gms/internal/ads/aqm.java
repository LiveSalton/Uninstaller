package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: source */
/* loaded from: classes.dex */
final class aqm implements Runnable {
    private final /* synthetic */ MotionEvent a;

    aqm(zzdx zzdxVar, MotionEvent motionEvent) {
        this.a = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a(this.a);
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2022, -1L, e);
        }
    }
}
