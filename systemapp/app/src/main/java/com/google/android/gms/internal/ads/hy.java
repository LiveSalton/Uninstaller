package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hy implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzbcx e;

    hy(zzbcx zzbcxVar, String str, String str2, String str3, String str4) {
        this.e = zzbcxVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String c;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.a);
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("cachedSrc", this.b);
        }
        zzbcx zzbcxVar = this.e;
        c = zzbcx.c(this.c);
        hashMap.put("type", c);
        hashMap.put("reason", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put("message", this.d);
        }
        this.e.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
