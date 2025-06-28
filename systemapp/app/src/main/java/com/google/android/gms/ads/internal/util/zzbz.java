package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzazy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbz {
    private final View a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private ViewTreeObserver.OnGlobalLayoutListener f;
    private ViewTreeObserver.OnScrollChangedListener g = null;

    public zzbz(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.b = activity;
        this.a = view;
        this.f = onGlobalLayoutListener;
    }

    public final void a(Activity activity) {
        this.b = activity;
    }

    public final void a() {
        this.e = true;
        if (this.d) {
            e();
        }
    }

    public final void b() {
        this.e = false;
        f();
    }

    public final void c() {
        this.d = true;
        if (this.e) {
            e();
        }
    }

    public final void d() {
        this.d = false;
        f();
    }

    private final void e() {
        if (this.c) {
            return;
        }
        if (this.f != null) {
            if (this.b != null) {
                Activity activity = this.b;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                ViewTreeObserver b = b(activity);
                if (b != null) {
                    b.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            zzp.z();
            zzazy.a(this.a, this.f);
        }
        this.c = true;
    }

    private final void f() {
        if (this.b != null && this.c) {
            if (this.f != null) {
                Activity activity = this.b;
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
                ViewTreeObserver b = b(activity);
                if (b != null) {
                    zzp.e();
                    b.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            this.c = false;
        }
    }

    private static ViewTreeObserver b(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
