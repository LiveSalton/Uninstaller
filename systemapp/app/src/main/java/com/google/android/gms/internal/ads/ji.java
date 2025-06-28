package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
class ji extends WebView {
    public ji(Context context) {
        super(context);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzp.e().a(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzd.c("Unable to enable Javascript.", e);
        }
    }

    public void d(String str) {
        jm.a(this, str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
            zzp.g().a(e, "CoreWebView.loadUrl");
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            zzd.a("Ignore addJavascriptInterface due to low Android version.");
        }
    }
}
