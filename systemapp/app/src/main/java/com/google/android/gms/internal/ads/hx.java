package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hx implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ zzbcx d;

    hx(zzbcx zzbcxVar, String str, String str2, int i) {
        this.d = zzbcxVar;
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("totalBytes", Integer.toString(this.c));
        this.d.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
