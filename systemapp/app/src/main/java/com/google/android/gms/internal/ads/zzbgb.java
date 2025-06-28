package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbgb extends ji implements zzbgc {
    private final zzbfz a;

    @GuardedBy("this")
    private boolean b;

    @GuardedBy("this")
    private boolean c;

    public zzbgb(Context context, zzbfz zzbfzVar) {
        super(context);
        zzp.g().e();
        this.a = zzbfzVar;
        super.setWebViewClient(zzbfzVar);
    }

    @GuardedBy("this")
    protected void g(boolean z) {
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    public final synchronized boolean F() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a(this);
        g(false);
        zzd.a("Initiating WebView self destruct sequence in 3...");
        zzd.a("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e) {
            zzp.g().a(e, "AdWebViewImpl.loadUrlUnsafe");
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgc
    public final synchronized void a(zzbfy zzbfyVar) {
        zzd.a("Blank page loaded, 1...");
        G();
    }

    @VisibleForTesting
    public synchronized void G() {
        zzd.a("Destroying WebView!");
        a();
        zzazj.e.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.jl
            private final zzbgb a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.T();
            }
        });
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!F()) {
                    g(true);
                }
                a();
            }
        } finally {
            super.finalize();
        }
    }

    private final synchronized void a() {
        if (!this.c) {
            this.c = true;
            zzp.g().f();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (F()) {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.google.android.gms.internal.ads.ji, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (!F()) {
            super.loadUrl(str);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (!F()) {
            super.loadData(str, str2, str3);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!F()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzd.e("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !F() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (F()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public void onPause() {
        if (F()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbdv
    public void onResume() {
        if (F()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (F()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.ji, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.google.android.gms.internal.ads.ji, com.google.android.gms.internal.ads.zzakj, com.google.android.gms.internal.ads.zzaky
    public /* bridge */ /* synthetic */ void d(String str) {
        super.d(str);
    }

    final /* synthetic */ void T() {
        super.destroy();
    }
}
