package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class jm {

    @VisibleForTesting
    @GuardedBy("InvokeJavascriptWorkaround.class")
    private static Boolean a;

    private jm() {
    }

    @TargetApi(19)
    private static boolean a(WebView webView) {
        boolean booleanValue;
        synchronized (jm.class) {
            if (a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    a = true;
                } catch (IllegalStateException unused) {
                    a = false;
                }
            }
            booleanValue = a.booleanValue();
        }
        return booleanValue;
    }

    @TargetApi(19)
    static void a(WebView webView, String str) {
        if (PlatformVersion.e() && a(webView)) {
            webView.evaluateJavascript(str, null);
        } else {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
        }
    }
}
