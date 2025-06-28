package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzwt;

/* compiled from: source */
/* loaded from: classes.dex */
final class c extends WebViewClient {
    private final /* synthetic */ zzj a;

    c(zzj zzjVar) {
        this.a = zzjVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzwt zzwtVar;
        zzwt zzwtVar2;
        String d;
        zzwt zzwtVar3;
        zzwt zzwtVar4;
        zzwt zzwtVar5;
        zzwt zzwtVar6;
        zzwt zzwtVar7;
        zzwt zzwtVar8;
        if (str.startsWith(this.a.t())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzwtVar7 = this.a.g;
            if (zzwtVar7 != null) {
                try {
                    zzwtVar8 = this.a.g;
                    zzwtVar8.a(3);
                } catch (RemoteException e) {
                    zzd.e("#007 Could not call remote method.", e);
                }
            }
            this.a.a(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzwtVar5 = this.a.g;
            if (zzwtVar5 != null) {
                try {
                    zzwtVar6 = this.a.g;
                    zzwtVar6.a(0);
                } catch (RemoteException e2) {
                    zzd.e("#007 Could not call remote method.", e2);
                }
            }
            this.a.a(0);
            return true;
        }
        if (str.startsWith("gmsg://adResized")) {
            zzwtVar3 = this.a.g;
            if (zzwtVar3 != null) {
                try {
                    zzwtVar4 = this.a.g;
                    zzwtVar4.c();
                } catch (RemoteException e3) {
                    zzd.e("#007 Could not call remote method.", e3);
                }
            }
            this.a.a(this.a.c(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        zzwtVar = this.a.g;
        if (zzwtVar != null) {
            try {
                zzwtVar2 = this.a.g;
                zzwtVar2.b();
            } catch (RemoteException e4) {
                zzd.e("#007 Could not call remote method.", e4);
            }
        }
        d = this.a.d(str);
        this.a.e(d);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzwt zzwtVar;
        zzwt zzwtVar2;
        zzwtVar = this.a.g;
        if (zzwtVar != null) {
            try {
                zzwtVar2 = this.a.g;
                zzwtVar2.a(0);
            } catch (RemoteException e) {
                zzd.e("#007 Could not call remote method.", e);
            }
        }
    }
}
