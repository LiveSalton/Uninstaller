package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfy {
    public final String a;
    public final Uri b;
    public final Map<String, String> c;
    private final String d;

    @TargetApi(21)
    public zzbfy(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public zzbfy(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private zzbfy(String str, Uri uri, String str2, Map<String, String> map) {
        this.a = str;
        this.b = uri;
        this.d = str2 == null ? "GET" : str2;
        this.c = map == null ? Collections.emptyMap() : map;
    }
}
