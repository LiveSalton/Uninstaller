package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

/* compiled from: source */
@TargetApi(11)
/* loaded from: classes.dex */
public final class zzbez extends zzbey {
    public zzbez(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        super(zzbdvVar, zztsVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str, (Map<String, String>) null);
    }
}
