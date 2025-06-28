package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzej extends zzcu<Integer, Long> {
    public long a;
    public long b;

    public zzej() {
        this.a = -1L;
        this.b = -1L;
    }

    public zzej(String str) {
        this();
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.a));
        hashMap.put(1, Long.valueOf(this.b));
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.a = ((Long) b.get(0)).longValue();
            this.b = ((Long) b.get(1)).longValue();
        }
    }
}
