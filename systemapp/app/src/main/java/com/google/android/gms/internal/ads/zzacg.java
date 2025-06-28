package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzacg {
    private MotionEvent a = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent b = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.a.getEventTime()) {
            this.a = MotionEvent.obtain(motionEvent);
        } else {
            if (motionEvent.getAction() != 0 || motionEvent.getEventTime() <= this.b.getEventTime()) {
                return;
            }
            this.b = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent a() {
        return this.a;
    }

    public final MotionEvent b() {
        return this.b;
    }
}
