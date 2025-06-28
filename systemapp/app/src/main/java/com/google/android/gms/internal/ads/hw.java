package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hw implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzbcx d;

    hw(zzbcx zzbcxVar, String str, String str2, long j) {
        this.d = zzbcxVar;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("totalDuration", Long.toString(this.c));
        this.d.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
