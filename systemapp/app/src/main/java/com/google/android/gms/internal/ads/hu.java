package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class hu implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ long e;
    private final /* synthetic */ long f;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ int h;
    private final /* synthetic */ int i;
    private final /* synthetic */ zzbcx j;

    hu(zzbcx zzbcxVar, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.j = zzbcxVar;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = z;
        this.h = i3;
        this.i = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("bufferedDuration", Long.toString(this.e));
        hashMap.put("totalDuration", Long.toString(this.f));
        hashMap.put("cacheReady", this.g ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.h));
        hashMap.put("playerPreparedCount", Integer.toString(this.i));
        this.j.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
