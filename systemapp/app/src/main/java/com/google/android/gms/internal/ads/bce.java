package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: source */
/* loaded from: classes.dex */
final class bce implements Runnable {
    final /* synthetic */ zzre a;
    final /* synthetic */ WebView b;
    final /* synthetic */ boolean c;
    final /* synthetic */ zzrk d;
    private ValueCallback<String> e = new bch(this);

    bce(zzrk zzrkVar, zzre zzreVar, WebView webView, boolean z) {
        this.d = zzrkVar;
        this.a = zzreVar;
        this.b = webView;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.getSettings().getJavaScriptEnabled()) {
            try {
                this.b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.e);
            } catch (Throwable unused) {
                this.e.onReceiveValue("");
            }
        }
    }
}
