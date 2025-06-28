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
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
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
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class iu extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbdv {

    @GuardedBy("this")
    private boolean A;

    @GuardedBy("this")
    private String B;

    @GuardedBy("this")
    private zzbep C;

    @GuardedBy("this")
    private boolean D;

    @GuardedBy("this")
    private boolean E;

    @GuardedBy("this")
    private zzadx F;

    @GuardedBy("this")
    private zzads G;

    @GuardedBy("this")
    private zzsc H;

    @GuardedBy("this")
    private int I;

    @GuardedBy("this")
    private int J;
    private zzabq K;
    private zzabq L;
    private zzabq M;
    private zzabt N;
    private WeakReference<View.OnClickListener> O;
    private int P;

    @GuardedBy("this")
    private zze Q;

    @GuardedBy("this")
    private boolean R;
    private zzbz S;
    private int T;
    private int U;
    private int V;
    private int W;
    private final zzbfk a;
    private Map<String, zzbcx> aa;
    private final WindowManager ab;
    private final zzts ac;
    private final zzef b;
    private final zzacg c;
    private final zzazh d;
    private final com.google.android.gms.ads.internal.zzk e;
    private final com.google.android.gms.ads.internal.zzb f;
    private final DisplayMetrics g;
    private final float h;
    private final zzsu i;
    private final boolean j;
    private zzdmu k;
    private zzdmz l;
    private boolean m;
    private boolean n;
    private zzbdu o;

    @GuardedBy("this")
    private zze p;

    @GuardedBy("this")
    private IObjectWrapper q;

    @GuardedBy("this")
    private zzbfn r;

    @GuardedBy("this")
    private String s;

    @GuardedBy("this")
    private boolean t;

    @GuardedBy("this")
    private boolean u;

    @GuardedBy("this")
    private boolean v;

    @GuardedBy("this")
    private boolean w;

    @GuardedBy("this")
    private Boolean x;

    @GuardedBy("this")
    private int y;

    @GuardedBy("this")
    private boolean z;

    static iu a(Context context, zzbfn zzbfnVar, String str, boolean z, boolean z2, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdmu zzdmuVar, zzdmz zzdmzVar) {
        return new iu(new zzbfk(context), zzbfnVar, str, z, z2, zzefVar, zzacgVar, zzazhVar, zzabsVar, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdmuVar, zzdmzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean P() {
        return false;
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

    @VisibleForTesting
    private iu(zzbfk zzbfkVar, zzbfn zzbfnVar, String str, boolean z, boolean z2, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdmu zzdmuVar, zzdmz zzdmzVar) {
        super(zzbfkVar);
        this.m = false;
        this.n = false;
        this.z = true;
        this.A = false;
        this.B = "";
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.a = zzbfkVar;
        this.r = zzbfnVar;
        this.s = str;
        this.v = z;
        this.y = -1;
        this.b = zzefVar;
        this.c = zzacgVar;
        this.d = zzazhVar;
        this.e = zzkVar;
        this.f = zzbVar;
        this.ab = (WindowManager) getContext().getSystemService("window");
        zzp.c();
        this.g = com.google.android.gms.ads.internal.util.zzm.a(this.ab);
        this.h = this.g.density;
        this.ac = zztsVar;
        this.i = zzsuVar;
        this.j = z3;
        this.k = zzdmuVar;
        this.l = zzdmzVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzd.c("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzp.c().a(zzbfkVar, zzazhVar.a, settings);
        zzp.e().a(getContext(), settings);
        setDownloadListener(this);
        X();
        if (PlatformVersion.c()) {
            addJavascriptInterface(zzbet.a(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.S = new zzbz(this.a.a(), this, this, null);
        ac();
        this.N = new zzabt(new zzabs(true, "make_wv", this.s));
        this.N.a().a(zzabsVar);
        if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && this.l != null && this.l.b != null) {
            this.N.a().a("gqi", this.l.b);
        }
        this.L = zzabn.a(this.N.a());
        this.N.a("native:view_create", this.L);
        this.M = null;
        this.K = null;
        zzp.e().c(zzbfkVar);
        zzp.g().e();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbdu) {
            this.o = (zzbdu) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final com.google.android.gms.ads.internal.zzb h() {
        return this.f;
    }

    private final boolean T() {
        int i;
        int i2;
        if (!this.o.b() && !this.o.c()) {
            return false;
        }
        zzwq.a();
        int b = zzayr.b(this.g, this.g.widthPixels);
        zzwq.a();
        int b2 = zzayr.b(this.g, this.g.heightPixels);
        Activity a = this.a.a();
        if (a == null || a.getWindow() == null) {
            i = b;
            i2 = b2;
        } else {
            zzp.c();
            int[] a2 = com.google.android.gms.ads.internal.util.zzm.a(a);
            zzwq.a();
            int b3 = zzayr.b(this.g, a2[0]);
            zzwq.a();
            i2 = zzayr.b(this.g, a2[1]);
            i = b3;
        }
        if (this.U == b && this.T == b2 && this.V == i && this.W == i2) {
            return false;
        }
        boolean z = (this.U == b && this.T == b2) ? false : true;
        this.U = b;
        this.T = b2;
        this.V = i;
        this.W = i2;
        new zzaqu(this).a(b, b2, i, i2, this.g.density, this.ab.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void a(String str, Map<String, ?> map) {
        try {
            b(str, zzp.c().a(map));
        } catch (JSONException unused) {
            zzd.e("Could not convert parameters to JSON.");
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (F()) {
            zzd.f("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    private final synchronized void b(String str) {
        if (!F()) {
            loadUrl(str);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final synchronized void loadUrl(String str) {
        if (!F()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzp.g().a(e, "AdWebViewImpl.loadUrl");
                zzd.d("Could not call loadUrl. ", e);
                return;
            }
        }
        zzd.e("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void c(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzp.g().a(e, "AdWebViewImpl.loadUrlUnsafe");
            zzd.d("Could not call loadUrl. ", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!F()) {
            super.loadData(str, str2, str3);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!F()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(String str, String str2, String str3) {
        if (!F()) {
            super.loadDataWithBaseURL(str, zzbfd.a(str2, zzbfd.a()), "text/html", "UTF-8", str3);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @TargetApi(19)
    private final synchronized void a(String str, ValueCallback<String> valueCallback) {
        if (!F()) {
            evaluateJavascript(str, null);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void e(String str) {
        if (PlatformVersion.e()) {
            if (V() == null) {
                U();
            }
            if (V().booleanValue()) {
                a(str, (ValueCallback<String>) null);
                return;
            } else {
                String valueOf = String.valueOf(str);
                b(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
                return;
            }
        }
        String valueOf2 = String.valueOf(str);
        b(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void d(String str) {
        e(str);
    }

    private final synchronized void U() {
        this.x = zzp.g().b();
        if (this.x == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                a((Boolean) true);
            } catch (IllegalStateException unused) {
                a((Boolean) false);
            }
        }
    }

    @VisibleForTesting
    private final void a(Boolean bool) {
        synchronized (this) {
            this.x = bool;
        }
        zzp.g().a(bool);
    }

    @VisibleForTesting
    private final synchronized Boolean V() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzaky
    public final void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(3 + String.valueOf(str).length() + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        e(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzakb
    public final void b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzd.b(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        e(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void r() {
        W();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.d.a);
        a("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(int i) {
        if (i == 0) {
            zzabn.a(this.N.a(), this.L, "aebb2");
        }
        W();
        if (this.N.a() != null) {
            this.N.a().a("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.d.a);
        a("onhide", hashMap);
    }

    private final void W() {
        zzabn.a(this.N.a(), this.L, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void s() {
        if (this.K == null) {
            zzabn.a(this.N.a(), this.L, "aes2");
            this.K = zzabn.a(this.N.a());
            this.N.a("native:view_show", this.K);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.d.a);
        a("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void t() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.h().b()));
        hashMap.put("app_volume", String.valueOf(zzp.h().a()));
        hashMap.put("device_volume", String.valueOf(zzad.a(getContext())));
        a("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final void a(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        a("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zze v() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized IObjectWrapper D() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zze w() {
        return this.Q;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbfc
    public final synchronized zzbfn x() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized String y() {
        return this.s;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final WebViewClient A() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean B() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbff
    public final zzef C() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe, com.google.android.gms.internal.ads.zzbfe
    public final zzazh m() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbew
    public final synchronized boolean E() {
        return this.v;
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

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.o.c() && !this.o.d()) {
            synchronized (this) {
                if (this.F != null) {
                    this.F.a(motionEvent);
                }
            }
        } else {
            if (this.b != null) {
                this.b.a(motionEvent);
            }
            if (this.c != null) {
                this.c.a(motionEvent);
            }
        }
        if (F()) {
            return false;
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x01d2 A[Catch: all -> 0x01fa, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00cc, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x014c, B:93:0x0167, B:95:0x01bc, B:96:0x01c0, B:98:0x01c7, B:103:0x01d2, B:105:0x01d8, B:106:0x01db, B:108:0x01df, B:109:0x01e8, B:115:0x01f5), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013c A[Catch: all -> 0x01fa, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00cc, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x014c, B:93:0x0167, B:95:0x01bc, B:96:0x01c0, B:98:0x01c7, B:103:0x01d2, B:105:0x01d8, B:106:0x01db, B:108:0x01df, B:109:0x01e8, B:115:0x01f5), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0167 A[Catch: all -> 0x01fa, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:9:0x000d, B:11:0x0013, B:13:0x0017, B:16:0x0021, B:18:0x0029, B:21:0x002e, B:23:0x0036, B:25:0x0048, B:28:0x004d, B:30:0x0054, B:33:0x005e, B:36:0x0063, B:39:0x0075, B:40:0x0082, B:45:0x007e, B:47:0x008f, B:49:0x0097, B:51:0x00a9, B:54:0x00b0, B:56:0x00cc, B:57:0x00d6, B:60:0x00d2, B:61:0x00db, B:64:0x00e0, B:66:0x00e8, B:69:0x00f5, B:76:0x0119, B:78:0x0120, B:82:0x012a, B:84:0x013c, B:86:0x014c, B:93:0x0167, B:95:0x01bc, B:96:0x01c0, B:98:0x01c7, B:103:0x01d2, B:105:0x01d8, B:106:0x01db, B:108:0x01df, B:109:0x01e8, B:115:0x01f5), top: B:2:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.iu.onMeasure(int, int):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean T = T();
        zze v = v();
        if (v == null || !T) {
            return;
        }
        v.p();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zze zzeVar) {
        this.p = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(IObjectWrapper iObjectWrapper) {
        this.q = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void b(zze zzeVar) {
        this.Q = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzbfn zzbfnVar) {
        this.r = zzbfnVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void b(boolean z) {
        boolean z2 = z != this.v;
        this.v = z;
        X();
        if (z2) {
            if (!((Boolean) zzwq.e().a(zzabf.H)).booleanValue() || !this.r.e()) {
                new zzaqu(this).c(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void J() {
        this.S.a();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!F()) {
            this.S.c();
        }
        boolean z = this.D;
        if (this.o != null && this.o.c()) {
            if (!this.E) {
                this.o.f();
                this.o.g();
                this.E = true;
            }
            T();
            z = true;
        }
        g(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!F()) {
                this.S.d();
            }
            super.onDetachedFromWindow();
            if (this.E && this.o != null && this.o.c() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.o.f();
                this.o.g();
                this.E = false;
            }
        }
        g(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(Context context) {
        this.a.setBaseContext(context);
        this.S.a(this.a.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void c(boolean z) {
        if (this.p != null) {
            this.p.a(this.o.b(), z);
        } else {
            this.t = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void setRequestedOrientation(int i) {
        this.y = i;
        if (this.p != null) {
            this.p.a(this.y);
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

    private final synchronized void X() {
        if (!this.v && !this.r.e()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzd.b("Disabling hardware acceleration on an AdView.");
                Y();
                return;
            } else {
                zzd.b("Enabling hardware acceleration on an AdView.");
                Z();
                return;
            }
        }
        zzd.b("Enabling hardware acceleration on an overlay.");
        Z();
    }

    private final synchronized void Y() {
        if (!this.w) {
            zzp.e();
            setLayerType(1, null);
        }
        this.w = true;
    }

    private final synchronized void Z() {
        if (this.w) {
            zzp.e();
            setLayerType(0, null);
        }
        this.w = false;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final synchronized void destroy() {
        ac();
        this.S.b();
        if (this.p != null) {
            this.p.a();
            this.p.l();
            this.p = null;
        }
        this.q = null;
        this.o.l();
        if (this.u) {
            return;
        }
        zzp.y();
        zzbcu.a(this);
        ab();
        this.u = true;
        zzd.a("Initiating WebView self destruct sequence in 3...");
        zzd.a("Loading blank page in WebView, 2...");
        c("about:blank");
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.u) {
                    this.o.l();
                    zzp.y();
                    zzbcu.a(this);
                    ab();
                    aa();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void G() {
        zzd.a("Destroying WebView!");
        aa();
        com.google.android.gms.ads.internal.util.zzm.a.post(new iv(this));
    }

    private final synchronized void aa() {
        if (!this.R) {
            this.R = true;
            zzp.g().f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean F() {
        return this.u;
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (F()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void K() {
        if (this.M == null) {
            this.M = zzabn.a(this.N.a());
            this.N.a("native:view_load", this.M);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final void onPause() {
        if (F()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzd.c("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public final void onResume() {
        if (F()) {
            return;
        }
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
        this.o.b(z);
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (F()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzd.c("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void d(boolean z) {
        this.z = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean H() {
        return this.z;
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void a() {
        this.A = true;
        if (this.e != null) {
            this.e.a();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void b() {
        this.A = false;
        if (this.e != null) {
            this.e.b();
        }
    }

    private final synchronized void ab() {
        if (this.aa != null) {
            Iterator<zzbcx> it = this.aa.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
        this.aa = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(String str, zzbcx zzbcxVar) {
        if (this.aa == null) {
            this.aa = new HashMap();
        }
        this.aa.put(str, zzbcxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized zzbcx a(String str) {
        if (this.aa == null) {
            return null;
        }
        return this.aa.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized String getRequestId() {
        return this.B;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized String j() {
        if (this.l == null) {
            return null;
        }
        return this.l.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(int i) {
        this.P = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized int k() {
        return this.P;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final synchronized void p() {
        if (this.G != null) {
            this.G.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzads zzadsVar) {
        this.G = zzadsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzsc zzscVar) {
        this.H = zzscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zzsc O() {
        return this.H;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe
    public final zzabq f() {
        return this.L;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final zzabt l() {
        return this.N;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdv
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.O = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void a(zzadx zzadxVar) {
        this.F = zzadxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized zzadx L() {
        return this.F;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized zzbep d() {
        return this.C;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbbe
    public final synchronized void a(zzbep zzbepVar) {
        if (this.C != null) {
            zzd.c("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.C = zzbepVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized boolean I() {
        return this.I > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final synchronized void e(boolean z) {
        this.I += z ? 1 : -1;
        if (this.I <= 0 && this.p != null) {
            this.p.r();
        }
    }

    private final void ac() {
        zzabs a;
        if (this.N == null || (a = this.N.a()) == null || zzp.g().a() == null) {
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
        this.o.a(z);
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
        this.o.a(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void b(boolean z, int i) {
        this.o.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str) {
        this.o.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void a(boolean z, int i, String str, String str2) {
        this.o.a(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        synchronized (this) {
            this.D = zzqvVar.j;
        }
        g(zzqvVar.j);
    }

    private final void g(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        a("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, zzahv<? super zzbdv> zzahvVar) {
        if (this.o != null) {
            this.o.a(str, zzahvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void b(String str, zzahv<? super zzbdv> zzahvVar) {
        if (this.o != null) {
            this.o.b(str, zzahvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        if (this.o != null) {
            this.o.a(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean a(boolean z, int i) {
        destroy();
        this.ac.a(new zztv(z, i) { // from class: com.google.android.gms.internal.ads.it
            private final boolean a;
            private final int b;

            {
                this.a = z;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zztv
            public final void a(zzue.zzi.zza zzaVar) {
                iu.a(this.a, this.b, zzaVar);
            }
        });
        this.ac.a(zztu.zza.EnumC0074zza.ANDROID_WEBVIEW_CRASH);
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
        zzsu zzsuVar = this.i;
        if (this == null) {
            throw null;
        }
        zzsuVar.a(activity, this);
        this.i.a(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.i.b());
        } else {
            zzd.c("The FrameLayout object cannot be null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final zzsu Q() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final boolean R() {
        return ((Boolean) zzwq.e().a(zzabf.dx)).booleanValue() && this.i != null && this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbdk
    public final zzdmu q() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv, com.google.android.gms.internal.ads.zzbeq
    public final zzdmz S() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if (this.o != null) {
            this.o.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final void a(zzdmu zzdmuVar, zzdmz zzdmzVar) {
        this.k = zzdmuVar;
        this.l = zzdmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdv
    public final /* synthetic */ zzbfg z() {
        return this.o;
    }

    static final /* synthetic */ void a(boolean z, int i, zzue.zzi.zza zzaVar) {
        zzue.zzae.zza b = zzue.zzae.b();
        if (b.a() != z) {
            b.a(z);
        }
        zzaVar.a((zzue.zzae) ((zzekh) b.a(i).g()));
    }
}
