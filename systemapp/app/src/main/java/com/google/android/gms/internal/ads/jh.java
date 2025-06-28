package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* compiled from: source */
@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class jh extends zzbgb implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzakj, zzbdv {

    @GuardedBy("this")
    private zzadx A;

    @GuardedBy("this")
    private zzads B;

    @GuardedBy("this")
    private zzsc C;

    @GuardedBy("this")
    private int D;

    @GuardedBy("this")
    private int E;
    private zzabq F;
    private zzabq G;
    private zzabq H;
    private zzabt I;
    private WeakReference<View.OnClickListener> J;
    private int K;

    @GuardedBy("this")
    private zze L;
    private zzbz M;
    private final AtomicReference<IObjectWrapper> N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private Map<String, zzbcx> S;
    private final WindowManager T;
    private final zzbfk a;
    private final zzbfm b;
    private final zzef c;
    private final zzacg d;
    private final zzazh e;
    private final com.google.android.gms.ads.internal.zzk f;
    private final com.google.android.gms.ads.internal.zzb g;
    private final DisplayMetrics h;
    private final zzts i;
    private final zzsu j;
    private final boolean k;
    private zzdmu l;
    private zzdmz m;

    @GuardedBy("this")
    private zze n;

    @GuardedBy("this")
    private zzbfn o;

    @GuardedBy("this")
    private String p;

    @GuardedBy("this")
    private boolean q;

    @GuardedBy("this")
    private boolean r;

    @GuardedBy("this")
    private boolean s;

    @GuardedBy("this")
    private int t;

    @GuardedBy("this")
    private boolean u;

    @GuardedBy("this")
    private boolean v;

    @GuardedBy("this")
    private String w;

    @GuardedBy("this")
    private zzbep x;

    @GuardedBy("this")
    private boolean y;

    @GuardedBy("this")
    private boolean z;

    @VisibleForTesting
    protected jh(zzbfk zzbfkVar, zzbfm zzbfmVar, zzbfn zzbfnVar, String str, boolean z, boolean z2, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdmu zzdmuVar, zzdmz zzdmzVar) {
        super(zzbfkVar, zzbfmVar);
        this.u = true;
        this.v = false;
        this.w = "";
        this.N = new AtomicReference<>();
        this.O = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.a = zzbfkVar;
        this.b = zzbfmVar;
        this.o = zzbfnVar;
        this.p = str;
        this.r = z;
        this.t = -1;
        this.c = zzefVar;
        this.d = zzacgVar;
        this.e = zzazhVar;
        this.f = zzkVar;
        this.g = zzbVar;
        this.T = (WindowManager) getContext().getSystemService("window");
        zzp.c();
        this.h = com.google.android.gms.ads.internal.util.zzm.a(this.T);
        this.i = zztsVar;
        this.j = zzsuVar;
        this.k = z3;
        this.l = zzdmuVar;
        this.m = zzdmzVar;
        this.M = new zzbz(this.a.a(), this, this, null);
        zzp.c().a(zzbfkVar, zzazhVar.a, getSettings());
        setDownloadListener(this);
        W();
        if (PlatformVersion.c()) {
            addJavascriptInterface(zzbet.a(this), "googleAdsJsInterface");
        }
        aa();
        this.I = new zzabt(new zzabs(true, "make_wv", this.p));
        this.I.a().a(zzabsVar);
        if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && this.m != null && this.m.b != null) {
            this.I.a().a("gqi", this.m.b);
        }
        this.G = zzabn.a(this.I.a());
        this.I.a("native:view_create", this.G);
        this.H = null;
        this.F = null;
        zzp.e().c(zzbfkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, com.google.android.gms.internal.ads.zzbdv
    public final void G() {
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean P() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final void a(String str, String str2) {
        zzaki.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void a(String str, Map map) {
        zzaki.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void a(String str, JSONObject jSONObject) {
        zzaki.a(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzakb
    public final void b(String str, JSONObject jSONObject) {
        zzaki.b(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzbax c() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbfh
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final com.google.android.gms.ads.internal.zzb h() {
        return this.g;
    }

    private final boolean U() {
        int i;
        int i2;
        if (!this.b.b() && !this.b.c()) {
            return false;
        }
        zzwq.a();
        int b = zzayr.b(this.h, this.h.widthPixels);
        zzwq.a();
        int b2 = zzayr.b(this.h, this.h.heightPixels);
        Activity a = this.a.a();
        if (a == null || a.getWindow() == null) {
            i = b;
            i2 = b2;
        } else {
            zzp.c();
            int[] a2 = com.google.android.gms.ads.internal.util.zzm.a(a);
            zzwq.a();
            int b3 = zzayr.b(this.h, a2[0]);
            zzwq.a();
            i2 = zzayr.b(this.h, a2[1]);
            i = b3;
        }
        if (this.P == b && this.O == b2 && this.Q == i && this.R == i2) {
            return false;
        }
        boolean z = (this.P == b && this.O == b2) ? false : true;
        this.P = b;
        this.O = b2;
        this.Q = i;
        this.R = i2;
        new zzaqu(this).a(b, b2, i, i2, this.h.density, this.T.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(String str, String str2, String str3) {
        super.loadDataWithBaseURL(str, zzbfd.a(str2, zzbfd.a()), "text/html", "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, com.google.android.gms.internal.ads.ji, com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzaky
    public final synchronized void d(String str) {
        if (!F()) {
            super.d(str);
        } else {
            zzd.e("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void r() {
        V();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.e.a);
        zzaki.a(this, "onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(int i) {
        if (i == 0) {
            zzabn.a(this.I.a(), this.G, "aebb2");
        }
        V();
        if (this.I.a() != null) {
            this.I.a().a("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.e.a);
        zzaki.a(this, "onhide", hashMap);
    }

    private final void V() {
        zzabn.a(this.I.a(), this.G, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void s() {
        if (this.F == null) {
            zzabn.a(this.I.a(), this.G, "aes2");
            this.F = zzabn.a(this.I.a());
            this.I.a("native:view_show", this.F);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.e.a);
        zzaki.a(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void t() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.h().b()));
        hashMap.put("app_volume", String.valueOf(zzp.h().a()));
        hashMap.put("device_volume", String.valueOf(zzad.a(getContext())));
        zzaki.a(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzaki.a(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zze v() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final IObjectWrapper D() {
        return this.N.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zze w() {
        return this.L;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbfc
    public final synchronized zzbfn x() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized String y() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final WebViewClient A() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean B() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbff
    public final zzef C() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbfe
    public final zzazh m() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbew
    public final synchronized boolean E() {
        return this.r;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzp.c();
            com.google.android.gms.ads.internal.util.zzm.a(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(51 + String.valueOf(str).length() + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzd.b(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b.c() && !this.b.d()) {
            synchronized (this) {
                if (this.A != null) {
                    this.A.a(motionEvent);
                }
            }
        } else {
            if (this.c != null) {
                this.c.a(motionEvent);
            }
            if (this.d != null) {
                this.d.a(motionEvent);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d3 A[Catch: all -> 0x01ee, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00c8, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x0150, B:94:0x016d, B:96:0x01ca, B:97:0x01ce, B:100:0x01d3, B:102:0x01d9, B:103:0x01dc, B:109:0x01e9), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013c A[Catch: all -> 0x01ee, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00c8, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x0150, B:94:0x016d, B:96:0x01ca, B:97:0x01ce, B:100:0x01d3, B:102:0x01d9, B:103:0x01dc, B:109:0x01e9), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d A[Catch: all -> 0x01ee, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00c8, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x0150, B:94:0x016d, B:96:0x01ca, B:97:0x01ce, B:100:0x01d3, B:102:0x01d9, B:103:0x01dc, B:109:0x01e9), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jh.onMeasure(int, int):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean U = U();
        zze v = v();
        if (v == null || !U) {
            return;
        }
        v.p();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zze zzeVar) {
        this.n = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(IObjectWrapper iObjectWrapper) {
        this.N.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void b(zze zzeVar) {
        this.L = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzbfn zzbfnVar) {
        this.o = zzbfnVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void b(boolean z) {
        boolean z2 = z != this.r;
        this.r = z;
        W();
        if (z2) {
            if (!((Boolean) zzwq.e().a(zzabf.H)).booleanValue() || !this.o.e()) {
                new zzaqu(this).c(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void J() {
        this.M.a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!F()) {
            this.M.c();
        }
        boolean z = this.y;
        if (this.b != null && this.b.c()) {
            if (!this.z) {
                this.b.f();
                this.b.g();
                this.z = true;
            }
            U();
            z = true;
        }
        h(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!F()) {
                this.M.d();
            }
            super.onDetachedFromWindow();
            if (this.z && this.b != null && this.b.c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.b.f();
                this.b.g();
                this.z = false;
            }
        }
        h(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(Context context) {
        this.a.setBaseContext(context);
        this.M.a(this.a.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void c(boolean z) {
        if (this.n != null) {
            this.n.a(this.b.b(), z);
        } else {
            this.q = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void setRequestedOrientation(int i) {
        this.t = i;
        if (this.n != null) {
            this.n.a(this.t);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbex
    public final Activity g() {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final Context u() {
        return this.a.b();
    }

    private final synchronized void W() {
        if (!this.r && !this.o.e()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzd.b("Disabling hardware acceleration on an AdView.");
                X();
                return;
            } else {
                zzd.b("Enabling hardware acceleration on an AdView.");
                Y();
                return;
            }
        }
        zzd.b("Enabling hardware acceleration on an overlay.");
        Y();
    }

    private final synchronized void X() {
        if (!this.s) {
            zzp.e();
            setLayerType(1, null);
        }
        this.s = true;
    }

    private final synchronized void Y() {
        if (this.s) {
            zzp.e();
            setLayerType(0, null);
        }
        this.s = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbgb
    protected final synchronized void g(boolean z) {
        if (!z) {
            try {
                aa();
                this.M.b();
                if (this.n != null) {
                    this.n.a();
                    this.n.l();
                    this.n = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.N.set(null);
        this.b.l();
        zzp.y();
        zzbcu.a(this);
        Z();
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void K() {
        if (this.H == null) {
            this.H = zzabn.a(this.I.a());
            this.I.a("native:view_load", this.H);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzd.c("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzd.c("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void N() {
        zzd.a("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void f(boolean z) {
        this.b.b(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgb, android.webkit.WebView
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzd.c("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void d(boolean z) {
        this.u = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean H() {
        return this.u;
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void a() {
        this.v = true;
        if (this.f != null) {
            this.f.a();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void b() {
        this.v = false;
        if (this.f != null) {
            this.f.b();
        }
    }

    private final synchronized void Z() {
        if (this.S != null) {
            Iterator<zzbcx> it = this.S.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        this.S = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(String str, zzbcx zzbcxVar) {
        if (this.S == null) {
            this.S = new HashMap();
        }
        this.S.put(str, zzbcxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized zzbcx a(String str) {
        if (this.S == null) {
            return null;
        }
        return this.S.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized String getRequestId() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized String j() {
        if (this.m == null) {
            return null;
        }
        return this.m.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(int i) {
        this.K = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized int k() {
        return this.K;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzabq f() {
        return this.G;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final zzabt l() {
        return this.I;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdv
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.J = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzadx zzadxVar) {
        this.A = zzadxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zzadx L() {
        return this.A;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized void p() {
        if (this.B != null) {
            this.B.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzads zzadsVar) {
        this.B = zzadsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzsc zzscVar) {
        this.C = zzscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zzsc O() {
        return this.C;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized zzbep d() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(zzbep zzbepVar) {
        if (this.x != null) {
            zzd.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.x = zzbepVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean I() {
        return this.D > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void e(boolean z) {
        this.D += z ? 1 : -1;
        if (this.D <= 0 && this.n != null) {
            this.n.r();
        }
    }

    private final void aa() {
        zzabs a;
        if (this.I == null || (a = this.I.a()) == null || zzp.g().a() == null) {
            return;
        }
        zzp.g().a().a(a);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void M() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void i() {
        zze v = v();
        if (v != null) {
            v.q();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final int n() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final int o() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.b.a(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void b(boolean z, int i) {
        this.b.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str) {
        this.b.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str, String str2) {
        this.b.a(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        synchronized (this) {
            this.y = zzqvVar.j;
        }
        h(zzqvVar.j);
    }

    private final void h(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzaki.a(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, zzahv<? super zzbdv> zzahvVar) {
        if (this.b != null) {
            this.b.a(str, zzahvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(String str, zzahv<? super zzbdv> zzahvVar) {
        if (this.b != null) {
            this.b.b(str, zzahvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        if (this.b != null) {
            this.b.a(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean a(boolean z, int i) {
        destroy();
        this.i.a(new zztv(z, i) { // from class: com.google.android.gms.internal.ads.jg
            private final boolean a;
            private final int b;

            {
                this.a = z;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                jh.a(this.a, this.b, zzaVar);
            }
        });
        this.i.a(zztu.zza.EnumC0074zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!R()) {
            zzd.a("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (this == null) {
                throw null;
            }
            viewGroup2.removeView(this);
        }
        zzd.a("Initializing ArWebView object.");
        zzsu zzsuVar = this.j;
        if (this == null) {
            throw null;
        }
        zzsuVar.a(activity, this);
        this.j.a(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.j.b());
        } else {
            zzd.c("The FrameLayout object cannot be null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzsu Q() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean R() {
        return ((Boolean) zzwq.e().a(zzabf.dx)).booleanValue() && this.j != null && this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbdk
    public final zzdmu q() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbeq
    public final zzdmz S() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if (this.b != null) {
            this.b.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzdmu zzdmuVar, zzdmz zzdmzVar) {
        this.l = zzdmuVar;
        this.m = zzdmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final /* synthetic */ zzbfg z() {
        return this.b;
    }

    static final /* synthetic */ void a(boolean z, int i, zzue.zzi.zza zzaVar) {
        zzue.zzae.zza b = zzue.zzae.b();
        if (b.a() != z) {
            b.a(z);
        }
        zzaVar.a((zzue.zzae) ((zzekh) b.a(i).g()));
    }
}
