package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfm extends zzbfz implements zzbfg {
    protected zzbdv a;
    private zzva d;
    private zzp e;
    private zzbfj f;
    private zzbfi g;
    private zzagy h;
    private zzaha i;
    private zzbfl j;
    private volatile boolean l;

    @GuardedBy("lock")
    private boolean m;

    @GuardedBy("lock")
    private boolean n;

    @GuardedBy("lock")
    private boolean o;
    private com.google.android.gms.ads.internal.overlay.zzu p;
    private zzaqv q;
    private zza r;
    private zzaqk s;
    private zzawq t;
    private boolean u;
    private boolean v;
    private int w;
    private boolean x;
    private View.OnAttachStateChangeListener y;
    private final Object c = new Object();
    private boolean k = false;
    private final zzakn<zzbdv> b = new zzakn<>();

    final void a(zzbdv zzbdvVar, boolean z) {
        zzaqv zzaqvVar = new zzaqv(zzbdvVar, zzbdvVar.u(), new zzaam(zzbdvVar.getContext()));
        this.a = zzbdvVar;
        this.l = z;
        this.q = zzaqvVar;
        this.s = null;
        this.b.a((zzakn<zzbdv>) zzbdvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(int i, int i2, boolean z) {
        this.q.a(i, i2);
        if (this.s != null) {
            this.s.a(i, i2, false);
        }
    }

    public final void a(String str, zzahv<? super zzbdv> zzahvVar) {
        this.b.a(str, zzahvVar);
    }

    public final void b(String str, zzahv<? super zzbdv> zzahvVar) {
        this.b.b(str, zzahvVar);
    }

    public final void a(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.b.a(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzva zzvaVar, zzagy zzagyVar, zzp zzpVar, zzaha zzahaVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahu zzahuVar, zza zzaVar, zzaqx zzaqxVar, zzawq zzawqVar, zzcqo zzcqoVar, zzdrz zzdrzVar, zzckq zzckqVar) {
        if (zzaVar == null) {
            zzaVar = new zza(this.a.getContext(), zzawqVar, null);
        }
        this.s = new zzaqk(this.a, zzaqxVar);
        this.t = zzawqVar;
        if (((Boolean) zzwq.e().a(zzabf.ao)).booleanValue()) {
            a("/adMetadata", new zzagz(zzagyVar));
        }
        a("/appEvent", new zzahb(zzahaVar));
        a("/backButton", zzahc.k);
        a("/refresh", zzahc.l);
        a("/canOpenApp", zzahc.b);
        a("/canOpenURLs", zzahc.a);
        a("/canOpenIntents", zzahc.c);
        a("/close", zzahc.e);
        a("/customClose", zzahc.f);
        a("/instrument", zzahc.o);
        a("/delayPageLoaded", zzahc.q);
        a("/delayPageClosed", zzahc.r);
        a("/getLocationInfo", zzahc.s);
        a("/log", zzahc.h);
        a("/mraid", new zzahw(zzaVar, this.s, zzaqxVar));
        a("/mraidLoaded", this.q);
        a("/open", new zzahz(zzaVar, this.s, zzcqoVar, zzckqVar));
        a("/precache", new zzbdc());
        a("/touch", zzahc.j);
        a("/video", zzahc.m);
        a("/videoMeta", zzahc.n);
        if (zzcqoVar != null && zzdrzVar != null) {
            a("/click", zzdnu.a(zzcqoVar, zzdrzVar));
            a("/httpTrack", zzdnu.b(zzcqoVar, zzdrzVar));
        } else {
            a("/click", zzahc.d);
            a("/httpTrack", zzahc.g);
        }
        if (com.google.android.gms.ads.internal.zzp.A().a(this.a.getContext())) {
            a("/logScionEvent", new zzahx(this.a.getContext()));
        }
        this.d = zzvaVar;
        this.e = zzpVar;
        this.h = zzagyVar;
        this.i = zzahaVar;
        this.p = zzuVar;
        this.r = zzaVar;
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final void e() {
        if (this.d != null) {
            this.d.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final zza a() {
        return this.r;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final boolean b() {
        return this.l;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.c) {
            z = this.m;
        }
        return z;
    }

    public final boolean d() {
        boolean z;
        synchronized (this.c) {
            z = this.n;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener f() {
        synchronized (this.c) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener g() {
        synchronized (this.c) {
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu Q = this.a.Q();
        if (Q != null && webView == Q.a()) {
            Q.a(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final void a(zzbfy zzbfyVar) {
        this.u = true;
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        p();
    }

    public final void a(View view, zzawq zzawqVar, int i) {
        if (!zzawqVar.b() || i <= 0) {
            return;
        }
        zzawqVar.a(view);
        if (zzawqVar.b()) {
            com.google.android.gms.ads.internal.util.zzm.a.postDelayed(new jb(this, view, zzawqVar, i), 100L);
        }
    }

    private final void o() {
        if (this.y == null) {
            return;
        }
        this.a.getView().removeOnAttachStateChangeListener(this.y);
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void h() {
        zzawq zzawqVar = this.t;
        if (zzawqVar != null) {
            WebView webView = this.a.getWebView();
            if (androidx.core.h.w.F(webView)) {
                a(webView, zzawqVar, 10);
                return;
            }
            o();
            this.y = new je(this, zzawqVar);
            this.a.getView().addOnAttachStateChangeListener(this.y);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void i() {
        synchronized (this.c) {
            this.o = true;
        }
        this.w++;
        p();
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void j() {
        this.w--;
        p();
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void k() {
        this.v = true;
        p();
    }

    private final void p() {
        if (this.f != null && ((this.u && this.w <= 0) || this.v)) {
            if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && this.a.l() != null) {
                zzabn.a(this.a.l().a(), this.a.f(), "awfllc");
            }
            this.f.a(!this.v);
            this.f = null;
        }
        this.a.K();
    }

    public final void a(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel(zzbVar, (!E || this.a.x().e()) ? this.d : null, E ? null : this.e, this.p, this.a.m()));
    }

    public final void a(boolean z, int i) {
        a(new AdOverlayInfoParcel((!this.a.E() || this.a.x().e()) ? this.d : null, this.e, this.p, this.a, z, i, this.a.m()));
    }

    public final void a(boolean z, int i, String str) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel((!E || this.a.x().e()) ? this.d : null, E ? null : new jd(this.a, this.e), this.h, this.i, this.p, this.a, z, i, str, this.a.m()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel((!E || this.a.x().e()) ? this.d : null, E ? null : new jd(this.a, this.e), this.h, this.i, this.p, this.a, z, i, str, str2, this.a.m()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean a = this.s != null ? this.s.a() : false;
        com.google.android.gms.ads.internal.zzp.b();
        zzo.a(this.a.getContext(), adOverlayInfoParcel, a ? false : true);
        if (this.t != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.a != null) {
                str = adOverlayInfoParcel.a.a;
            }
            this.t.a(str);
        }
    }

    public final void l() {
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        o();
        this.b.d();
        this.b.a((zzakn<zzbdv>) null);
        synchronized (this.c) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.p = null;
            this.j = null;
            if (this.s != null) {
                this.s.a(true);
                this.s = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzbfj zzbfjVar) {
        this.f = zzbfjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzbfi zzbfiVar) {
        this.g = zzbfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final void b(zzbfy zzbfyVar) {
        this.b.a(zzbfyVar.b);
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final boolean c(zzbfy zzbfyVar) {
        String valueOf = String.valueOf(zzbfyVar.a);
        zzd.a(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbfyVar.b;
        if (this.b.a(uri)) {
            return true;
        }
        if (this.k) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                if (this.d != null) {
                    this.d.e();
                    if (this.t != null) {
                        this.t.a(zzbfyVar.a);
                    }
                    this.d = null;
                }
                return false;
            }
        }
        if (!this.a.getWebView().willNotDraw()) {
            try {
                zzef C = this.a.C();
                if (C != null && C.a(uri)) {
                    uri = C.a(uri, this.a.getContext(), this.a.getView(), this.a.g());
                }
            } catch (zzei unused) {
                String valueOf2 = String.valueOf(zzbfyVar.a);
                zzd.e(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            if (this.r == null || this.r.b()) {
                a(new com.google.android.gms.ads.internal.overlay.zzb("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.r.a(zzbfyVar.a);
            }
        } else {
            String valueOf3 = String.valueOf(zzbfyVar.a);
            zzd.e(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfz
    public final WebResourceResponse d(zzbfy zzbfyVar) {
        String str;
        WebResourceResponse c;
        zzta a;
        if (this.t != null) {
            this.t.a(zzbfyVar.a, zzbfyVar.c, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbfyVar.a).getName())) {
            n();
            if (this.a.x().e()) {
                str = (String) zzwq.e().a(zzabf.F);
            } else if (this.a.E()) {
                str = (String) zzwq.e().a(zzabf.E);
            } else {
                str = (String) zzwq.e().a(zzabf.D);
            }
            com.google.android.gms.ads.internal.zzp.c();
            c = com.google.android.gms.ads.internal.util.zzm.c(this.a.getContext(), this.a.m().a, str);
        } else {
            c = null;
        }
        if (c != null) {
            return c;
        }
        try {
            if (!zzaxm.a(zzbfyVar.a, this.a.getContext(), this.x).equals(zzbfyVar.a)) {
                return e(zzbfyVar);
            }
            zztf a2 = zztf.a(zzbfyVar.a);
            if (a2 != null && (a = com.google.android.gms.ads.internal.zzp.i().a(a2)) != null && a.a()) {
                return new WebResourceResponse("", "", a.b());
            }
            if (zzayu.c() && zzacw.b.a().booleanValue()) {
                return e(zzbfyVar);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzp.g().a(e, "AdWebViewClient.interceptRequest");
            return q();
        }
    }

    private static WebResourceResponse q() {
        if (((Boolean) zzwq.e().a(zzabf.ah)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse e(zzbfy zzbfyVar) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbfyVar.a);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry<String, String> entry : zzbfyVar.c.entrySet()) {
                    openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (!(openConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                httpURLConnection = (HttpURLConnection) openConnection;
                com.google.android.gms.ads.internal.zzp.c().a(this.a.getContext(), this.a.m().a, false, httpURLConnection);
                zzayu zzayuVar = new zzayu();
                zzayuVar.a(httpURLConnection, (byte[]) null);
                int responseCode = httpURLConnection.getResponseCode();
                zzayuVar.a(httpURLConnection, responseCode);
                if (responseCode < 300 || responseCode >= 400) {
                    break;
                }
                String headerField = httpURLConnection.getHeaderField("Location");
                if (headerField == null) {
                    throw new IOException("Missing Location header in redirect");
                }
                if (headerField.startsWith("tel:")) {
                    return null;
                }
                URL url2 = new URL(url, headerField);
                String protocol = url2.getProtocol();
                if (protocol == null) {
                    zzd.e("Protocol is null");
                    return q();
                }
                if (!protocol.equals("http") && !protocol.equals("https")) {
                    String valueOf = String.valueOf(protocol);
                    zzd.e(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
                    return q();
                }
                String valueOf2 = String.valueOf(headerField);
                zzd.b(valueOf2.length() != 0 ? "Redirecting to ".concat(valueOf2) : new String("Redirecting to "));
                httpURLConnection.disconnect();
                url = url2;
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        com.google.android.gms.ads.internal.zzp.c();
        return com.google.android.gms.ads.internal.util.zzm.a(httpURLConnection);
    }

    public final void a(boolean z) {
        this.k = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final zzawq m() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void n() {
        synchronized (this.c) {
            this.k = false;
            this.l = true;
            zzazj.e.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jc
                private final zzbfm a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbfm zzbfmVar = this.a;
                    zzbfmVar.a.J();
                    zze v = zzbfmVar.a.v();
                    if (v != null) {
                        v.n();
                    }
                }
            });
        }
    }

    public final void b(boolean z) {
        this.x = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(int i, int i2) {
        if (this.s != null) {
            this.s.a(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void c(boolean z) {
        synchronized (this.c) {
            this.m = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void d(boolean z) {
        synchronized (this.c) {
            this.n = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(Uri uri) {
        this.b.b(uri);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.a.a(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
