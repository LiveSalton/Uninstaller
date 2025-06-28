package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzef;

/* compiled from: source */
/* loaded from: classes.dex */
final class b implements View.OnTouchListener {
    private final /* synthetic */ zzj a;

    b(zzj zzjVar) {
        this.a = zzjVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzef zzefVar;
        zzef zzefVar2;
        zzefVar = this.a.h;
        if (zzefVar == null) {
            return false;
        }
        zzefVar2 = this.a.h;
        zzefVar2.a(motionEvent);
        return false;
    }
}
