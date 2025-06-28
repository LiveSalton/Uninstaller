package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: source */
@TargetApi(11)
/* loaded from: classes.dex */
public class zzbey extends zzbdu {
    public zzbey(zzbdv zzbdvVar, zzts zztsVar, boolean z) {
        super(zzbdvVar, zztsVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse a(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbdv)) {
            zzd.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbdv zzbdvVar = (zzbdv) webView;
        if (this.b != null) {
            this.b.a(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.a(str, map);
        }
        if (zzbdvVar.z() != null) {
            zzbdvVar.z().n();
        }
        if (zzbdvVar.x().e()) {
            str2 = (String) zzwq.e().a(zzabf.F);
        } else if (zzbdvVar.E()) {
            str2 = (String) zzwq.e().a(zzabf.E);
        } else {
            str2 = (String) zzwq.e().a(zzabf.D);
        }
        zzp.c();
        return com.google.android.gms.ads.internal.util.zzm.c(zzbdvVar.getContext(), zzbdvVar.m().a, str2);
    }
}
