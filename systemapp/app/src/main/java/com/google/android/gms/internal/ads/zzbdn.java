package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: source */
@TargetApi(11)
/* loaded from: classes.dex */
public final class zzbdn extends WebChromeClient {
    private final zzbdv a;

    public zzbdn(zzbdv zzbdvVar) {
        this.a = zzbdvVar;
    }

    private final boolean a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zza a;
        try {
        } catch (WindowManager.BadTokenException e) {
            zzd.d("Fail to display Dialog.", e);
        }
        if (this.a != null && this.a.z() != null && this.a.z().a() != null && (a = this.a.z().a()) != null && !a.b()) {
            StringBuilder sb = new StringBuilder(11 + String.valueOf(str).length() + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            a.a(sb.toString());
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str2);
        if (z) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builder.setView(linearLayout).setPositiveButton(R.string.ok, new ih(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new ie(jsPromptResult)).setOnCancelListener(new Cif(jsPromptResult)).create().show();
        } else {
            builder.setMessage(str3).setPositiveButton(R.string.ok, new ic(jsResult)).setNegativeButton(R.string.cancel, new id(jsResult)).setOnCancelListener(new ib(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.a.A() != null) {
            webView2.setWebViewClient(this.a.A());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbdv)) {
            zzd.e("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zze v = ((zzbdv) webView).v();
        if (v == null) {
            zzd.e("Tried to close an AdWebView not associated with an overlay.");
        } else {
            v.a();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(19 + String.valueOf(message).length() + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (ig.a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzd.c(sb2);
                break;
            case 2:
                zzd.e(sb2);
                break;
            case 3:
            case 4:
                zzd.d(sb2);
                break;
            case 5:
                zzd.b(sb2);
                break;
            default:
                zzd.d(sb2);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(131072L, j4), 1048576L);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        zze v = this.a.v();
        if (v == null) {
            zzd.e("Could not get ad overlay when hiding custom view.");
        } else {
            v.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context a(WebView webView) {
        if (!(webView instanceof zzbdv)) {
            return webView.getContext();
        }
        zzbdv zzbdvVar = (zzbdv) webView;
        Activity g = zzbdvVar.g();
        return g != null ? g : zzbdvVar.getContext();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + 131072;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zze v = this.a.v();
        if (v == null) {
            zzd.e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            v.a(view, customViewCallback);
            v.a(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzp.c();
            if (!com.google.android.gms.ads.internal.util.zzm.a(this.a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzp.c();
                if (!com.google.android.gms.ads.internal.util.zzm.a(this.a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (!PlatformVersion.g() || zzadm.a.a().booleanValue()) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        if (this.a == null || this.a.z() == null || this.a.z().m() == null) {
            super.onPermissionRequest(permissionRequest);
            return;
        }
        String[] a = this.a.z().m().a(permissionRequest.getResources());
        if (a.length > 0) {
            permissionRequest.grant(a);
        } else {
            permissionRequest.deny();
        }
    }
}
