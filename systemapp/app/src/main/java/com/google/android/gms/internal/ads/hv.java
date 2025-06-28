package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hv implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ long e;
    private final /* synthetic */ long f;
    private final /* synthetic */ long g;
    private final /* synthetic */ boolean h;
    private final /* synthetic */ int i;
    private final /* synthetic */ int j;
    private final /* synthetic */ zzbcx k;

    hv(zzbcx zzbcxVar, String str, String str2, long j, long j2, long j3, long j4, long j5, boolean z, int i, int i2) {
        this.k = zzbcxVar;
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = z;
        this.i = i;
        this.j = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bufferedDuration", Long.toString(this.c));
        hashMap.put("totalDuration", Long.toString(this.d));
        if (((Boolean) zzwq.e().a(zzabf.aW)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.e));
            hashMap.put("qoeCachedBytes", Long.toString(this.f));
            hashMap.put("totalBytes", Long.toString(this.g));
            hashMap.put("reportTime", Long.toString(zzp.j().a()));
        }
        hashMap.put("cacheReady", this.h ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.i));
        hashMap.put("playerPreparedCount", Integer.toString(this.j));
        this.k.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
