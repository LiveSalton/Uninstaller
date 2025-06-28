package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class ik implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawq a;
    private final /* synthetic */ zzbdu b;

    ik(zzbdu zzbduVar, zzawq zzawqVar) {
        this.b = zzbduVar;
        this.a = zzawqVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.b.a(view, this.a, 10);
    }
}
