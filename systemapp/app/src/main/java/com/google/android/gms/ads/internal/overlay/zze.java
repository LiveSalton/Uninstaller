package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaqu;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbed;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzwq;
import java.util.Collections;

/* compiled from: source */
/* loaded from: classes.dex */
public class zze extends zzari implements zzz {

    @VisibleForTesting
    private static final int e = Color.argb(0, 0, 0, 0);
    protected final Activity a;

    @VisibleForTesting
    AdOverlayInfoParcel b;

    @VisibleForTesting
    zzbdv c;

    @VisibleForTesting
    private zzk f;

    @VisibleForTesting
    private zzr g;

    @VisibleForTesting
    private FrameLayout i;

    @VisibleForTesting
    private WebChromeClient.CustomViewCallback j;

    @VisibleForTesting
    private d m;
    private Runnable p;
    private boolean q;
    private boolean r;

    @VisibleForTesting
    private boolean h = false;

    @VisibleForTesting
    private boolean k = false;

    @VisibleForTesting
    private boolean l = false;

    @VisibleForTesting
    private boolean n = false;

    @VisibleForTesting
    zzl d = zzl.BACK_BUTTON;
    private final Object o = new Object();
    private boolean s = false;
    private boolean t = false;
    private boolean u = true;

    public zze(Activity activity) {
        this.a = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void g() {
    }

    public final void a() {
        this.d = zzl.CUSTOM_CLOSE;
        this.a.finish();
    }

    public final void b() {
        if (this.b != null && this.h) {
            a(this.b.j);
        }
        if (this.i != null) {
            this.a.setContentView(this.m);
            this.r = true;
            this.i.removeAllViews();
            this.i = null;
        }
        if (this.j != null) {
            this.j.onCustomViewHidden();
            this.j = null;
        }
        this.h = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzz
    public final void j_() {
        this.d = zzl.CLOSE_BUTTON;
        this.a.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void d() {
        this.d = zzl.BACK_BUTTON;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void e() {
        if (this.b.c != null) {
            this.b.c.f_();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final boolean f() {
        this.d = zzl.BACK_BUTTON;
        if (this.c == null) {
            return true;
        }
        boolean H = this.c.H();
        if (!H) {
            this.c.a("onbackblocked", Collections.emptyMap());
        }
        return H;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public void a(Bundle bundle) {
        this.a.requestWindowFeature(1);
        this.k = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.b = AdOverlayInfoParcel.a(this.a.getIntent());
            if (this.b == null) {
                throw new e("Could not get info for ad overlay.");
            }
            if (this.b.m.c > 7500000) {
                this.d = zzl.OTHER;
            }
            if (this.a.getIntent() != null) {
                this.u = this.a.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.b.o != null) {
                this.l = this.b.o.a;
            } else {
                this.l = false;
            }
            if (this.l && this.b.o.e != -1) {
                new f(this).b();
            }
            if (bundle == null) {
                if (this.b.c != null && this.u) {
                    this.b.c.e_();
                }
                if (this.b.k != 1 && this.b.b != null) {
                    this.b.b.e();
                }
            }
            this.m = new d(this.a, this.b.n, this.b.m.a);
            this.m.setId(1000);
            com.google.android.gms.ads.internal.zzp.e().a(this.a);
            switch (this.b.k) {
                case 1:
                    b(false);
                    return;
                case 2:
                    this.f = new zzk(this.b.d);
                    b(false);
                    return;
                case 3:
                    b(true);
                    return;
                default:
                    throw new e("Could not determine ad overlay type.");
            }
        } catch (e e2) {
            zzd.e(e2.getMessage());
            this.d = zzl.OTHER;
            this.a.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void h() {
        if (((Boolean) zzwq.e().a(zzabf.cq)).booleanValue()) {
            if (this.c != null && !this.c.F()) {
                com.google.android.gms.ads.internal.zzp.e();
                com.google.android.gms.ads.internal.util.zzu.b(this.c);
            } else {
                zzd.e("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void i() {
        if (this.b.c != null) {
            this.b.c.g_();
        }
        a(this.a.getResources().getConfiguration());
        if (((Boolean) zzwq.e().a(zzabf.cq)).booleanValue()) {
            return;
        }
        if (this.c != null && !this.c.F()) {
            com.google.android.gms.ads.internal.zzp.e();
            com.google.android.gms.ads.internal.util.zzu.b(this.c);
        } else {
            zzd.e("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void j() {
        b();
        if (this.b.c != null) {
            this.b.c.b_();
        }
        if (!((Boolean) zzwq.e().a(zzabf.cq)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.f == null)) {
            com.google.android.gms.ads.internal.zzp.e();
            com.google.android.gms.ads.internal.util.zzu.a(this.c);
        }
        s();
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(IObjectWrapper iObjectWrapper) {
        a((Configuration) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void b(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.k);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void k() {
        if (((Boolean) zzwq.e().a(zzabf.cq)).booleanValue() && this.c != null && (!this.a.isFinishing() || this.f == null)) {
            com.google.android.gms.ads.internal.zzp.e();
            com.google.android.gms.ads.internal.util.zzu.a(this.c);
        }
        s();
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void l() {
        if (this.c != null) {
            try {
                this.m.removeView(this.c.getView());
            } catch (NullPointerException unused) {
            }
        }
        s();
    }

    private final void a(boolean z) {
        int intValue = ((Integer) zzwq.e().a(zzabf.cs)).intValue();
        zzq zzqVar = new zzq();
        zzqVar.e = 50;
        zzqVar.a = z ? intValue : 0;
        zzqVar.b = z ? 0 : intValue;
        zzqVar.c = 0;
        zzqVar.d = intValue;
        this.g = new zzr(this.a, zzqVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        a(z, this.b.g);
        this.m.addView(this.g, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void m() {
        this.r = true;
    }

    public final void a(boolean z, boolean z2) {
        boolean z3 = false;
        boolean z4 = ((Boolean) zzwq.e().a(zzabf.aw)).booleanValue() && this.b != null && this.b.o != null && this.b.o.g;
        boolean z5 = ((Boolean) zzwq.e().a(zzabf.ax)).booleanValue() && this.b != null && this.b.o != null && this.b.o.h;
        if (z && z2 && z4 && !z5) {
            new zzaqu(this.c, "useCustomClose").a("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.g != null) {
            zzr zzrVar = this.g;
            if (z5 || (z2 && !z4)) {
                z3 = true;
            }
            zzrVar.a(z3);
        }
    }

    public final void n() {
        this.m.removeView(this.g);
        a(true);
    }

    public final void a(int i) {
        if (this.a.getApplicationInfo().targetSdkVersion >= ((Integer) zzwq.e().a(zzabf.dh)).intValue()) {
            if (this.a.getApplicationInfo().targetSdkVersion <= ((Integer) zzwq.e().a(zzabf.di)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwq.e().a(zzabf.dj)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwq.e().a(zzabf.dk)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.a.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.g().b(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.i = new FrameLayout(this.a);
        this.i.setBackgroundColor(-16777216);
        this.i.addView(view, -1, -1);
        this.a.setContentView(this.i);
        this.r = true;
        this.j = customViewCallback;
        this.h = true;
    }

    private final void b(boolean z) throws e {
        if (!this.r) {
            this.a.requestWindowFeature(1);
        }
        Window window = this.a.getWindow();
        if (window == null) {
            throw new e("Invalid activity, no window available.");
        }
        zzbfg z2 = this.b.d != null ? this.b.d.z() : null;
        boolean z3 = z2 != null && z2.b();
        this.n = false;
        if (z3) {
            int i = this.b.j;
            com.google.android.gms.ads.internal.zzp.e();
            if (i == 6) {
                this.n = this.a.getResources().getConfiguration().orientation == 1;
            } else {
                int i2 = this.b.j;
                com.google.android.gms.ads.internal.zzp.e();
                if (i2 == 7) {
                    this.n = this.a.getResources().getConfiguration().orientation == 2;
                }
            }
        }
        boolean z4 = this.n;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Delay onShow to next orientation change: ");
        sb.append(z4);
        zzd.b(sb.toString());
        a(this.b.j);
        com.google.android.gms.ads.internal.zzp.e();
        window.setFlags(16777216, 16777216);
        zzd.b("Hardware acceleration on the AdActivity window enabled.");
        if (!this.l) {
            this.m.setBackgroundColor(-16777216);
        } else {
            this.m.setBackgroundColor(e);
        }
        this.a.setContentView(this.m);
        this.r = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzp.d();
                this.c = zzbed.a(this.a, this.b.d != null ? this.b.d.x() : null, this.b.d != null ? this.b.d.y() : null, true, z3, null, null, this.b.m, null, null, this.b.d != null ? this.b.d.h() : null, zzts.a(), null, false, null, null);
                this.c.z().a(null, this.b.p, null, this.b.e, this.b.i, true, null, this.b.d != null ? this.b.d.z().a() : null, null, null, null, null, null);
                this.c.z().a(new zzbfj(this) { // from class: com.google.android.gms.ads.internal.overlay.a
                    private final zze a;

                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbfj
                    public final void a(boolean z5) {
                        zze zzeVar = this.a;
                        if (zzeVar.c != null) {
                            zzeVar.c.s();
                        }
                    }
                });
                if (this.b.l != null) {
                    this.c.loadUrl(this.b.l);
                } else if (this.b.h != null) {
                    this.c.loadDataWithBaseURL(this.b.f, this.b.h, "text/html", "UTF-8", null);
                } else {
                    throw new e("No URL or HTML to display in ad overlay.");
                }
                if (this.b.d != null) {
                    this.b.d.b(this);
                }
            } catch (Exception e2) {
                zzd.c("Error obtaining webview.", e2);
                throw new e("Could not obtain webview for the overlay.");
            }
        } else {
            this.c = this.b.d;
            this.c.a(this.a);
        }
        this.c.a(this);
        if (this.b.d != null) {
            a(this.b.d.D(), this.m);
        }
        ViewParent parent = this.c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.c.getView());
        }
        if (this.l) {
            this.c.M();
        }
        this.c.a((ViewGroup) null, this.a, this.b.f, this.b.h);
        this.m.addView(this.c.getView(), -1, -1);
        if (!z && !this.n) {
            t();
        }
        a(z3);
        if (this.c.B()) {
            a(z3, true);
        }
    }

    private final void s() {
        if (!this.a.isFinishing() || this.s) {
            return;
        }
        this.s = true;
        if (this.c != null) {
            this.c.b(this.d.a());
            synchronized (this.o) {
                if (!this.q && this.c.I()) {
                    this.p = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.c
                        private final zze a;

                        {
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.o();
                        }
                    };
                    zzm.a.postDelayed(this.p, ((Long) zzwq.e().a(zzabf.av)).longValue());
                    return;
                }
            }
        }
        o();
    }

    @VisibleForTesting
    final void o() {
        if (this.t) {
            return;
        }
        this.t = true;
        if (this.c != null) {
            this.m.removeView(this.c.getView());
            if (this.f != null) {
                this.c.a(this.f.d);
                this.c.b(false);
                this.f.c.addView(this.c.getView(), this.f.a, this.f.b);
                this.f = null;
            } else if (this.a.getApplicationContext() != null) {
                this.c.a(this.a.getApplicationContext());
            }
            this.c = null;
        }
        if (this.b != null && this.b.c != null) {
            this.b.c.a(this.d);
        }
        if (this.b == null || this.b.d == null) {
            return;
        }
        a(this.b.d.D(), this.b.d.getView());
    }

    private static void a(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.r().a(iObjectWrapper, view);
    }

    public final void p() {
        if (this.n) {
            this.n = false;
            t();
        }
    }

    private final void t() {
        this.c.s();
    }

    public final void q() {
        this.m.a = true;
    }

    public final void r() {
        synchronized (this.o) {
            this.q = true;
            if (this.p != null) {
                zzm.a.removeCallbacks(this.p);
                zzm.a.post(this.p);
            }
        }
    }

    private final void a(Configuration configuration) {
        boolean z = false;
        boolean z2 = true;
        boolean z3 = (this.b == null || this.b.o == null || !this.b.o.b) ? false : true;
        boolean a = com.google.android.gms.ads.internal.zzp.e().a(this.a, configuration);
        if ((this.l && !z3) || a) {
            z2 = false;
        } else if (Build.VERSION.SDK_INT >= 19 && this.b != null && this.b.o != null && this.b.o.f) {
            z = true;
        }
        Window window = this.a.getWindow();
        if (((Boolean) zzwq.e().a(zzabf.ay)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z2) {
                i = 5380;
                if (z) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (z2) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT < 19 || !z) {
                return;
            }
            window.getDecorView().setSystemUiVisibility(4098);
            return;
        }
        window.addFlags(2048);
        window.clearFlags(1024);
    }
}
