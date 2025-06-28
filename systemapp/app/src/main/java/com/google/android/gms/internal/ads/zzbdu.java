package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zztu;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@VisibleForTesting
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbdu extends WebViewClient implements zzbfg {
    protected zzbdv a;
    protected zzawq b;
    private final zzts c;
    private final HashMap<String, List<zzahv<? super zzbdv>>> d;
    private final Object e;
    private zzva f;
    private zzp g;
    private zzbfj h;
    private zzbfi i;
    private zzagy j;
    private zzaha k;
    private zzbfl l;
    private boolean m;

    @GuardedBy("lock")
    private boolean n;

    @GuardedBy("lock")
    private boolean o;

    @GuardedBy("lock")
    private boolean p;

    @GuardedBy("lock")
    private boolean q;
    private com.google.android.gms.ads.internal.overlay.zzu r;
    private final zzaqv s;
    private zza t;
    private zzaqk u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    private View.OnAttachStateChangeListener z;

    public zzbdu(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        this(zzbdvVar, zztsVar, z, new zzaqv(zzbdvVar, zzbdvVar.u(), new zzaam(zzbdvVar.getContext())), null);
    }

    @VisibleForTesting
    private zzbdu(zzbdv zzbdvVar, zzts zztsVar, boolean z, zzaqv zzaqvVar, zzaqk zzaqkVar) {
        this.d = new HashMap<>();
        this.e = new Object();
        this.m = false;
        this.c = zztsVar;
        this.a = zzbdvVar;
        this.n = z;
        this.s = zzaqvVar;
        this.u = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(int i, int i2, boolean z) {
        this.s.a(i, i2);
        if (this.u != null) {
            this.u.a(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzva zzvaVar, zzagy zzagyVar, zzp zzpVar, zzaha zzahaVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar, boolean z, zzahu zzahuVar, zza zzaVar, zzaqx zzaqxVar, zzawq zzawqVar, zzcqo zzcqoVar, zzdrz zzdrzVar, zzckq zzckqVar) {
        if (zzaVar == null) {
            zzaVar = new zza(this.a.getContext(), zzawqVar, null);
        }
        this.u = new zzaqk(this.a, zzaqxVar);
        this.b = zzawqVar;
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
        a("/mraid", new zzahw(zzaVar, this.u, zzaqxVar));
        a("/mraidLoaded", this.s);
        a("/open", new zzahz(zzaVar, this.u, zzcqoVar, zzckqVar));
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
        this.f = zzvaVar;
        this.g = zzpVar;
        this.j = zzagyVar;
        this.k = zzahaVar;
        this.r = zzuVar;
        this.t = zzaVar;
        this.m = z;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public void e() {
        if (this.f != null) {
            this.f.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final zza a() {
        return this.t;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final boolean b() {
        boolean z;
        synchronized (this.e) {
            z = this.n;
        }
        return z;
    }

    public final boolean c() {
        boolean z;
        synchronized (this.e) {
            z = this.o;
        }
        return z;
    }

    public final boolean d() {
        boolean z;
        synchronized (this.e) {
            z = this.p;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener f() {
        synchronized (this.e) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener g() {
        synchronized (this.e) {
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu Q = this.a.Q();
        if (Q != null && webView == Q.a()) {
            Q.a(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.e) {
            if (this.a.F()) {
                zzd.a("Blank page loaded, 1...");
                this.a.G();
                return;
            }
            this.v = true;
            if (this.i != null) {
                this.i.a();
                this.i = null;
            }
            p();
        }
    }

    public final void a(View view, zzawq zzawqVar, int i) {
        if (!zzawqVar.b() || i <= 0) {
            return;
        }
        zzawqVar.a(view);
        if (zzawqVar.b()) {
            com.google.android.gms.ads.internal.util.zzm.a.postDelayed(new il(this, view, zzawqVar, i), 100L);
        }
    }

    private final void o() {
        if (this.z == null) {
            return;
        }
        this.a.getView().removeOnAttachStateChangeListener(this.z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void h() {
        zzawq zzawqVar = this.b;
        if (zzawqVar != null) {
            WebView webView = this.a.getWebView();
            if (androidx.core.h.w.F(webView)) {
                a(webView, zzawqVar, 10);
                return;
            }
            o();
            this.z = new ik(this, zzawqVar);
            this.a.getView().addOnAttachStateChangeListener(this.z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void i() {
        synchronized (this.e) {
            this.q = true;
        }
        this.x++;
        p();
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void j() {
        this.x--;
        p();
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void k() {
        if (this.c != null) {
            this.c.a(zztu.zza.EnumC0074zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.w = true;
        p();
        if (((Boolean) zzwq.e().a(zzabf.cU)).booleanValue()) {
            this.a.destroy();
        }
    }

    private final void p() {
        if (this.h != null && ((this.v && this.x <= 0) || this.w)) {
            if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue() && this.a.l() != null) {
                zzabn.a(this.a.l().a(), this.a.f(), "awfllc");
            }
            this.h.a(!this.w);
            this.h = null;
        }
        this.a.K();
    }

    public final void a(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel(zzbVar, (!E || this.a.x().e()) ? this.f : null, E ? null : this.g, this.r, this.a.m()));
    }

    public final void a(boolean z, int i) {
        a(new AdOverlayInfoParcel((!this.a.E() || this.a.x().e()) ? this.f : null, this.g, this.r, this.a, z, i, this.a.m()));
    }

    public final void a(boolean z, int i, String str) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel((!E || this.a.x().e()) ? this.f : null, E ? null : new im(this.a, this.g), this.j, this.k, this.r, this.a, z, i, str, this.a.m()));
    }

    public final void a(boolean z, int i, String str, String str2) {
        boolean E = this.a.E();
        a(new AdOverlayInfoParcel((!E || this.a.x().e()) ? this.f : null, E ? null : new im(this.a, this.g), this.j, this.k, this.r, this.a, z, i, str, str2, this.a.m()));
    }

    private final void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean a = this.u != null ? this.u.a() : false;
        com.google.android.gms.ads.internal.zzp.b();
        zzo.a(this.a.getContext(), adOverlayInfoParcel, a ? false : true);
        if (this.b != null) {
            String str = adOverlayInfoParcel.l;
            if (str == null && adOverlayInfoParcel.a != null) {
                str = adOverlayInfoParcel.a.a;
            }
            this.b.a(str);
        }
    }

    public final void a(String str, zzahv<? super zzbdv> zzahvVar) {
        synchronized (this.e) {
            List<zzahv<? super zzbdv>> list = this.d.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.d.put(str, list);
            }
            list.add(zzahvVar);
        }
    }

    public final void b(String str, zzahv<? super zzbdv> zzahvVar) {
        synchronized (this.e) {
            List<zzahv<? super zzbdv>> list = this.d.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzahvVar);
        }
    }

    public final void a(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        synchronized (this.e) {
            List<zzahv<? super zzbdv>> list = this.d.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzahv<? super zzbdv> zzahvVar : list) {
                if (predicate.a(zzahvVar)) {
                    arrayList.add(zzahvVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void l() {
        if (this.b != null) {
            this.b.d();
            this.b = null;
        }
        o();
        synchronized (this.e) {
            this.d.clear();
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.m = false;
            this.n = false;
            this.o = false;
            this.q = false;
            this.r = null;
            this.l = null;
            if (this.u != null) {
                this.u.a(true);
                this.u = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzbfj zzbfjVar) {
        this.h = zzbfjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(zzbfi zzbfiVar) {
        this.i = zzbfiVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.a(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.a(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            a(parse);
        } else {
            if (this.m && webView == this.a.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    if (this.f != null) {
                        this.f.e();
                        if (this.b != null) {
                            this.b.a(str);
                        }
                        this.f = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.a.getWebView().willNotDraw()) {
                try {
                    zzef C = this.a.C();
                    if (C != null && C.a(parse)) {
                        parse = C.a(parse, this.a.getContext(), this.a.getView(), this.a.g());
                    }
                } catch (zzei unused) {
                    String valueOf2 = String.valueOf(str);
                    zzd.e(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                if (this.t == null || this.t.b()) {
                    a(new com.google.android.gms.ads.internal.overlay.zzb("android.intent.action.VIEW", parse.toString(), null, null, null, null, null));
                } else {
                    this.t.a(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzd.e(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(str, Collections.emptyMap());
    }

    protected final WebResourceResponse a(String str, Map<String, String> map) {
        zzta a;
        try {
            String a2 = zzaxm.a(str, this.a.getContext(), this.y);
            if (!a2.equals(str)) {
                return b(a2, map);
            }
            zztf a3 = zztf.a(str);
            if (a3 != null && (a = com.google.android.gms.ads.internal.zzp.i().a(a3)) != null && a.a()) {
                return new WebResourceResponse("", "", a.b());
            }
            if (zzayu.c() && zzacw.b.a().booleanValue()) {
                return b(str, map);
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

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f6, code lost:
    
        com.google.android.gms.ads.internal.zzp.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
    
        return com.google.android.gms.ads.internal.util.zzm.a(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse b(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.b(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final void a(boolean z) {
        this.m = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final zzawq m() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void n() {
        synchronized (this.e) {
            this.m = false;
            this.n = true;
            zzazj.e.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ij
                private final zzbdu a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbdu zzbduVar = this.a;
                    zzbduVar.a.J();
                    zze v = zzbduVar.a.v();
                    if (v != null) {
                        v.n();
                    }
                }
            });
        }
    }

    public final void b(boolean z) {
        this.y = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(int i, int i2) {
        if (this.u != null) {
            this.u.a(i, i2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void a(Uri uri) {
        String path = uri.getPath();
        List<zzahv<? super zzbdv>> list = this.d.get(path);
        if (list != null) {
            if (!((Boolean) zzwq.e().a(zzabf.cR)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.c();
                a(com.google.android.gms.ads.internal.util.zzm.b(uri), list, path);
                return;
            } else {
                zzdyr.a(com.google.android.gms.ads.internal.zzp.c().a(uri), new in(this, list, path), zzazj.f);
                return;
            }
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(32 + String.valueOf(valueOf).length());
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzd.a(sb.toString());
        if (!((Boolean) zzwq.e().a(zzabf.dS)).booleanValue() || com.google.android.gms.ads.internal.zzp.g().a() == null) {
            return;
        }
        zzazj.a.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.ii
            private final String a;

            {
                this.a = path;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.zzp.g().a().b(this.a.substring(1));
            }
        });
    }

    public final void a(Map<String, String> map, List<zzahv<? super zzbdv>> list, String str) {
        if (zzd.a(2)) {
            String valueOf = String.valueOf(str);
            zzd.a(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(4 + String.valueOf(str2).length() + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzd.a(sb.toString());
            }
        }
        Iterator<zzahv<? super zzbdv>> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(this.a, map);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void c(boolean z) {
        synchronized (this.e) {
            this.o = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfg
    public final void d(boolean z) {
        synchronized (this.e) {
            this.p = z;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.a.a(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
