package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class je implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawq a;
    private final /* synthetic */ zzbfm b;

    je(zzbfm zzbfmVar, zzawq zzawqVar) {
        this.b = zzbfmVar;
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
