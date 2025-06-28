package com.jumobile.manager.systemapp.ui.widget.slidingmenu.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu;

/* compiled from: source */
/* loaded from: classes.dex */
public class a {
    private Activity a;
    private SlidingMenu b;
    private View c;
    private View d;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;

    public a(Activity activity) {
        this.a = activity;
    }

    public void a(Bundle bundle) {
        this.b = (SlidingMenu) LayoutInflater.from(this.a).inflate(R.layout.slidingmenu_main, (ViewGroup) null);
    }

    public void b(Bundle bundle) {
        boolean z;
        if (this.d == null || this.c == null) {
            throw new IllegalStateException("Both setBehindContentView must be called in onCreate in addition to setContentView.");
        }
        this.f = true;
        this.b.a(this.a, 1 ^ (this.g ? 1 : 0));
        boolean z2 = false;
        if (bundle != null) {
            z2 = bundle.getBoolean("SlidingActivityHelper.open");
            z = bundle.getBoolean("SlidingActivityHelper.secondary");
        } else {
            z = false;
        }
        new Handler().post(new Runnable() { // from class: com.jumobile.manager.systemapp.ui.widget.slidingmenu.app.a.1
            final /* synthetic */ boolean a;
            final /* synthetic */ boolean b;

            AnonymousClass1(boolean z22, boolean z3) {
                z2 = z22;
                z = z3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!z2) {
                    a.this.b.c(false);
                } else if (z) {
                    a.this.b.b(false);
                } else {
                    a.this.b.a(false);
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.ui.widget.slidingmenu.app.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        AnonymousClass1(boolean z22, boolean z3) {
            z2 = z22;
            z = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!z2) {
                a.this.b.c(false);
            } else if (z) {
                a.this.b.b(false);
            } else {
                a.this.b.a(false);
            }
        }
    }

    public View a(int i) {
        View findViewById;
        if (this.b == null || (findViewById = this.b.findViewById(i)) == null) {
            return null;
        }
        return findViewById;
    }

    public void c(Bundle bundle) {
        bundle.putBoolean("SlidingActivityHelper.open", this.b.b());
        bundle.putBoolean("SlidingActivityHelper.secondary", this.b.c());
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.e) {
            return;
        }
        this.c = view;
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        this.d = view;
        this.b.setMenu(this.d);
    }

    public void a() {
        this.b.a();
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.b.b()) {
            return false;
        }
        a();
        return true;
    }
}
