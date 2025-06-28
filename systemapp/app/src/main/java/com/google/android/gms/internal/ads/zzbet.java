package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;

/* compiled from: source */
@TargetApi(17)
/* loaded from: classes.dex */
public final class zzbet<WebViewT extends zzbex & zzbff & zzbfh> {
    private final zzbeu a;
    private final WebViewT b;

    public static zzbet<zzbdv> a(zzbdv zzbdvVar) {
        return new zzbet<>(zzbdvVar, new zzbeu(zzbdvVar) { // from class: com.google.android.gms.internal.ads.iz
            private final zzbdv a;

            {
                this.a = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbeu
            public final void a(Uri uri) {
                zzbfg z = this.a.z();
                if (z == null) {
                    zzd.c("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                } else {
                    z.a(uri);
                }
            }
        });
    }

    private zzbet(WebViewT webviewt, zzbeu zzbeuVar) {
        this.a = zzbeuVar;
        this.b = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.e("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzm.a.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.ja
                private final zzbet a;
                private final String b;

                {
                    this.a = this;
                    this.b = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b);
                }
            });
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.a("Click string is empty, not proceeding.");
            return "";
        }
        zzef C = this.b.C();
        if (C == null) {
            zzd.a("Signal utils is empty, ignoring.");
            return "";
        }
        zzdv a = C.a();
        if (a == null) {
            zzd.a("Signals object is empty, ignoring.");
            return "";
        }
        if (this.b.getContext() == null) {
            zzd.a("Context is null, ignoring.");
            return "";
        }
        return a.a(this.b.getContext(), str, this.b.getView(), this.b.g());
    }

    final /* synthetic */ void a(String str) {
        this.a.a(Uri.parse(str));
    }
}
