package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class fy {
    private final WeakReference<View> a;

    public fy(View view) {
        this.a = new WeakReference<>(view);
    }

    protected abstract void a(ViewTreeObserver viewTreeObserver);

    protected abstract void b(ViewTreeObserver viewTreeObserver);

    public final void a() {
        ViewTreeObserver c = c();
        if (c != null) {
            a(c);
        }
    }

    public final void b() {
        ViewTreeObserver c = c();
        if (c != null) {
            b(c);
        }
    }

    private final ViewTreeObserver c() {
        ViewTreeObserver viewTreeObserver;
        View view = this.a.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }
}
