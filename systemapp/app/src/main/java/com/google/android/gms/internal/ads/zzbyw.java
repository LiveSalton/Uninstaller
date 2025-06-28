package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyw implements zzsu {
    private zzdva a;

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void a(Activity activity, WebView webView) {
        try {
            this.a = new zzdva(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(46 + String.valueOf(valueOf).length());
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzd.c(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void a(String str, String str2) {
        if (this.a == null) {
            zzd.c("ArWebView is not initialized.");
        } else {
            zzdva.getWebView().loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final WebView a() {
        if (this.a == null) {
            return null;
        }
        return zzdva.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final View b() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzsu
    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.a != null) {
            zzdva.a(webView, str, bitmap);
        }
    }
}
