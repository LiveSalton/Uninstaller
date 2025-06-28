package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: source */
@TargetApi(21)
/* loaded from: classes.dex */
public final class zzbfb extends zzbey {
    public zzbfb(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        super(zzbdvVar, zztsVar, z);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
