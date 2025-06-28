package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbn {
    private Map<Integer, Bitmap> a = new ConcurrentHashMap();
    private AtomicInteger b = new AtomicInteger(0);

    public final Bitmap a(Integer num) {
        return this.a.get(num);
    }
}
