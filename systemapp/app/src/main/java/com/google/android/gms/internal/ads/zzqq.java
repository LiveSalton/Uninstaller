package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: source */
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzqq implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long a = ((Long) zzwq.e().a(zzabf.aE)).longValue();
    private final Context b;
    private Application c;
    private final WindowManager d;
    private final PowerManager e;
    private final KeyguardManager f;

    @VisibleForTesting
    private BroadcastReceiver g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private bbv j;
    private com.google.android.gms.ads.internal.util.zzbs k = new com.google.android.gms.ads.internal.util.zzbs(a);
    private boolean l = false;
    private int m = -1;
    private final HashSet<zzqu> n = new HashSet<>();
    private final DisplayMetrics o;
    private final Rect p;

    public zzqq(Context context, View view) {
        this.b = context.getApplicationContext();
        this.d = (WindowManager) context.getSystemService("window");
        this.e = (PowerManager) this.b.getSystemService("power");
        this.f = (KeyguardManager) context.getSystemService("keyguard");
        if (this.b instanceof Application) {
            this.c = (Application) this.b;
            this.j = new bbv((Application) this.b, this);
        }
        this.o = context.getResources().getDisplayMetrics();
        this.p = new Rect();
        this.p.right = this.d.getDefaultDisplay().getWidth();
        this.p.bottom = this.d.getDefaultDisplay().getHeight();
        View view2 = this.i != null ? this.i.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            c(view2);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if (zzp.e().a(view)) {
                b(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void a(zzqu zzquVar) {
        this.n.add(zzquVar);
        a(3);
    }

    public final void b(zzqu zzquVar) {
        this.n.remove(zzquVar);
    }

    private final void c() {
        com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.bbt
            private final zzqq a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.m = -1;
        b(view);
        a(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.m = -1;
        a(3);
        c();
        c(view);
    }

    private final void a(Activity activity, int i) {
        Window window;
        if (this.i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View view = this.i.get();
        if (view == null || peekDecorView == null || view.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.m = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(3);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(3);
        c();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(2);
        c();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013b A[LOOP:0: B:56:0x0135->B:58:0x013b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r33) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.a(int):void");
    }

    private final Rect a(Rect rect) {
        return new Rect(b(rect.left), b(rect.top), b(rect.right), b(rect.bottom));
    }

    private final int b(int i) {
        return (int) (i / this.o.density);
    }

    private final List<Rect> a(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(a(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzp.g().a(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.g = new bbs(this);
            zzp.x().a(this.b, this.g, intentFilter);
        }
        if (this.c != null) {
            try {
                this.c.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception e) {
                zzd.c("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void c(View view) {
        try {
            if (this.h != null) {
                ViewTreeObserver viewTreeObserver = this.h.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.h = null;
            }
        } catch (Exception e) {
            zzd.c("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzd.c("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.g != null) {
            try {
                zzp.x().a(this.b, this.g);
            } catch (IllegalStateException e3) {
                zzd.c("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzp.g().a(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.g = null;
        }
        if (this.c != null) {
            try {
                this.c.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception e5) {
                zzd.c("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void a(long j) {
        this.k.a(j);
    }

    public final void a() {
        this.k.a(a);
    }

    final /* synthetic */ void b() {
        a(3);
    }
}
