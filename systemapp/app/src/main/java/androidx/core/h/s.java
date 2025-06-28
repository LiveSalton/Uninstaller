package androidx.core.h;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: source */
/* loaded from: classes.dex */
public final class s implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;

    private s(View view, Runnable runnable) {
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static s a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        s sVar = new s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
        return sVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void a() {
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
