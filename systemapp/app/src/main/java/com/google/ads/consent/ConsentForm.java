package com.google.ads.consent;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class ConsentForm {
    private final boolean adFreeOption;
    private final URL appPrivacyPolicyURL;
    private final Context context;
    private final Dialog dialog;
    private final ConsentFormListener listener;
    private LoadState loadState;
    private final boolean nonPersonalizedAdsOption;
    private final boolean personalizedAdsOption;
    private final WebView webView;

    /* compiled from: source */
    /* renamed from: com.google.ads.consent.ConsentForm$1 */
    class AnonymousClass1 extends ConsentFormListener {
    }

    /* compiled from: source */
    public static class Builder {
        private boolean adFreeOption;
        private final URL appPrivacyPolicyURL;
        private final Context context;
        private ConsentFormListener listener;
        private boolean nonPersonalizedAdsOption;
        private boolean personalizedAdsOption;
    }

    /* compiled from: source */
    private enum LoadState {
        NOT_READY,
        LOADING,
        LOADED
    }

    /* compiled from: source */
    /* renamed from: com.google.ads.consent.ConsentForm$2 */
    class AnonymousClass2 extends WebViewClient {
        boolean isInternalRedirect;
        final /* synthetic */ ConsentForm this$0;

        private boolean a(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("consent://");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        
            if (r1.equals("dismiss") == false) goto L52;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(java.lang.String r8) {
            /*
                r7 = this;
                boolean r0 = r7.a(r8)
                if (r0 != 0) goto L7
                return
            L7:
                r0 = 1
                r7.isInternalRedirect = r0
                android.net.Uri r8 = android.net.Uri.parse(r8)
                java.lang.String r1 = "action"
                java.lang.String r1 = r8.getQueryParameter(r1)
                java.lang.String r2 = "status"
                java.lang.String r2 = r8.getQueryParameter(r2)
                java.lang.String r3 = "url"
                java.lang.String r8 = r8.getQueryParameter(r3)
                r3 = -1
                int r4 = r1.hashCode()
                r5 = -1370505102(0xffffffffae4fc072, float:-4.7237277E-11)
                r6 = 0
                if (r4 == r5) goto L49
                r5 = 150940456(0x8ff2b28, float:1.53574E-33)
                if (r4 == r5) goto L3f
                r5 = 1671672458(0x63a3b28a, float:6.039369E21)
                if (r4 == r5) goto L36
                goto L53
            L36:
                java.lang.String r4 = "dismiss"
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L53
                goto L54
            L3f:
                java.lang.String r0 = "browser"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L53
                r0 = 2
                goto L54
            L49:
                java.lang.String r0 = "load_complete"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L53
                r0 = r6
                goto L54
            L53:
                r0 = r3
            L54:
                switch(r0) {
                    case 0: goto L66;
                    case 1: goto L5e;
                    case 2: goto L58;
                    default: goto L57;
                }
            L57:
                goto L6b
            L58:
                com.google.ads.consent.ConsentForm r0 = r7.this$0
                com.google.ads.consent.ConsentForm.c(r0, r8)
                goto L6b
            L5e:
                r7.isInternalRedirect = r6
                com.google.ads.consent.ConsentForm r8 = r7.this$0
                com.google.ads.consent.ConsentForm.b(r8, r2)
                goto L6b
            L66:
                com.google.ads.consent.ConsentForm r8 = r7.this$0
                com.google.ads.consent.ConsentForm.a(r8, r2)
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.consent.ConsentForm.AnonymousClass2.b(java.lang.String):void");
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            b(str);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            if (!a(uri)) {
                return false;
            }
            b(uri);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!a(str)) {
                return false;
            }
            b(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!this.isInternalRedirect) {
                this.this$0.a(webView);
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            this.this$0.loadState = LoadState.NOT_READY;
            this.this$0.listener.a(webResourceError.toString());
        }
    }

    private static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    private static String b(Context context) {
        Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
        Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        applicationIcon.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        return valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
    }

    private static String a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("info", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("args", hashMap);
        return String.format("javascript:%s(%s)", str, new Gson().toJson(hashMap2));
    }

    public void a(WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_name", a(this.context));
        hashMap.put("app_icon", b(this.context));
        hashMap.put("offer_personalized", Boolean.valueOf(this.personalizedAdsOption));
        hashMap.put("offer_non_personalized", Boolean.valueOf(this.nonPersonalizedAdsOption));
        hashMap.put("offer_ad_free", Boolean.valueOf(this.adFreeOption));
        hashMap.put("is_request_in_eea_or_unknown", Boolean.valueOf(ConsentInformation.a(this.context).e()));
        hashMap.put("app_privacy_url", this.appPrivacyPolicyURL);
        ConsentData d = ConsentInformation.a(this.context).d();
        hashMap.put("plat", d.g());
        hashMap.put("consent_info", d);
        webView.loadUrl(a("setUpConsentDialog", new Gson().toJson(hashMap)));
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a("No information");
        } else if (str.contains("Error")) {
            this.loadState = LoadState.NOT_READY;
            this.listener.a(str);
        } else {
            this.loadState = LoadState.LOADED;
            this.listener.a();
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No valid URL for browser navigation.");
            return;
        }
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            this.listener.a("No Activity found to handle browser intent.");
        }
    }

    public void c(String str) {
        ConsentStatus consentStatus;
        this.loadState = LoadState.NOT_READY;
        this.dialog.dismiss();
        if (TextUtils.isEmpty(str)) {
            this.listener.a("No information provided.");
            return;
        }
        if (str.contains("Error")) {
            this.listener.a(str);
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        boolean z = false;
        if (hashCode != -1152655096) {
            if (hashCode != -258041904) {
                if (hashCode == 1666911234 && str.equals("non_personalized")) {
                    c = 1;
                }
            } else if (str.equals("personalized")) {
                c = 0;
            }
        } else if (str.equals("ad_free")) {
            c = 2;
        }
        switch (c) {
            case 0:
                consentStatus = ConsentStatus.PERSONALIZED;
                break;
            case 1:
                consentStatus = ConsentStatus.NON_PERSONALIZED;
                break;
            case 2:
                consentStatus = ConsentStatus.UNKNOWN;
                z = true;
                break;
            default:
                consentStatus = ConsentStatus.UNKNOWN;
                break;
        }
        ConsentInformation.a(this.context).a(consentStatus, "form");
        this.listener.a(consentStatus, Boolean.valueOf(z));
    }

    /* compiled from: source */
    /* renamed from: com.google.ads.consent.ConsentForm$3 */
    class AnonymousClass3 implements DialogInterface.OnShowListener {
        final /* synthetic */ ConsentForm this$0;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            this.this$0.listener.b();
        }
    }
}
