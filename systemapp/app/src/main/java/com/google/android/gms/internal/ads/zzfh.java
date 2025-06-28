package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfh implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private final Context b;
    private Application c;
    private final PowerManager d;
    private final KeyguardManager e;
    private BroadcastReceiver f;
    private final zzey g;
    private WeakReference<ViewTreeObserver> h;
    private WeakReference<View> i;
    private aur j;
    private byte k = -1;
    private int l = -1;
    private long m = -3;

    public zzfh(Context context, zzey zzeyVar) {
        this.b = context.getApplicationContext();
        this.g = zzeyVar;
        this.d = (PowerManager) this.b.getSystemService("power");
        this.e = (KeyguardManager) this.b.getSystemService("keyguard");
        if (this.b instanceof Application) {
            this.c = (Application) this.b;
            this.j = new aur((Application) this.b, this);
        }
        a((View) null);
    }

    final void a(View view) {
        View b = b();
        if (b != null) {
            b.removeOnAttachStateChangeListener(this);
            c(b);
        }
        this.i = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                b(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.m = -2L;
            return;
        }
        this.m = -3L;
    }

    private final View b() {
        if (this.i != null) {
            return this.i.get();
        }
        return null;
    }

    private final void c() {
        a.post(new axp(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.l = -1;
        b(view);
        d();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.l = -1;
        d();
        c();
        c(view);
    }

    private final void a(Activity activity, int i) {
        Window window;
        if (this.i == null || (window = activity.getWindow()) == null) {
            return;
        }
        View peekDecorView = window.peekDecorView();
        View b = b();
        if (b == null || peekDecorView == null || b.getRootView() != peekDecorView.getRootView()) {
            return;
        }
        this.l = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, 0);
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, 0);
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, 0);
        d();
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, 4);
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        d();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        d();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        d();
    }

    public final long a() {
        if (this.m <= -2 && b() == null) {
            this.m = -3L;
        }
        return this.m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r7 == false) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.i
            if (r0 != 0) goto L5
            return
        L5:
            android.view.View r0 = r9.b()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L13
            r9.m = r2
            r9.k = r1
            return
        L13:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L1d
            r4 = r5
            goto L1e
        L1d:
            r4 = r6
        L1e:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L27
            r4 = r4 | 2
            byte r4 = (byte) r4
        L27:
            android.os.PowerManager r7 = r9.d
            if (r7 == 0) goto L36
            android.os.PowerManager r7 = r9.d
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L36
            r4 = r4 | 4
            byte r4 = (byte) r4
        L36:
            com.google.android.gms.internal.ads.zzey r7 = r9.g
            boolean r7 = r7.a()
            if (r7 != 0) goto L6c
            android.app.KeyguardManager r7 = r9.e
            if (r7 == 0) goto L6b
            android.app.KeyguardManager r7 = r9.e
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L6b
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzff.a(r0)
            if (r7 == 0) goto L67
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L58
            r7 = 0
            goto L5c
        L58:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L5c:
            if (r7 == 0) goto L67
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L67
            r7 = r5
            goto L68
        L67:
            r7 = r6
        L68:
            if (r7 == 0) goto L6b
            goto L6c
        L6b:
            r5 = r6
        L6c:
            if (r5 != 0) goto L71
            r4 = r4 | 8
            byte r4 = (byte) r4
        L71:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L7f
            r4 = r4 | 16
            byte r4 = (byte) r4
        L7f:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L8d
            r4 = r4 | 32
            byte r4 = (byte) r4
        L8d:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.l
            if (r5 == r1) goto L97
            int r0 = r9.l
        L97:
            if (r0 == 0) goto L9c
            r0 = r4 | 64
            byte r4 = (byte) r0
        L9c:
            byte r0 = r9.k
            if (r0 == r4) goto Lb2
            r9.k = r4
            byte r0 = r9.k
            if (r0 != 0) goto Lab
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto Lb0
        Lab:
            byte r0 = r9.k
            long r0 = (long) r0
            long r0 = r2 - r0
        Lb0:
            r9.m = r0
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.d():void");
    }

    private final void b(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.h = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f = new axo(this);
            this.b.registerReceiver(this.f, intentFilter);
        }
        if (this.c != null) {
            try {
                this.c.registerActivityLifecycleCallbacks(this.j);
            } catch (Exception unused) {
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
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        if (this.f != null) {
            try {
                this.b.unregisterReceiver(this.f);
            } catch (Exception unused3) {
            }
            this.f = null;
        }
        if (this.c != null) {
            try {
                this.c.unregisterActivityLifecycleCallbacks(this.j);
            } catch (Exception unused4) {
            }
        }
    }
}
