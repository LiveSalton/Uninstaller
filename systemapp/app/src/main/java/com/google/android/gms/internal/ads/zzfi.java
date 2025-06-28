package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfi extends zzcu<Integer, Long> {
    public Long a;
    public Long b;
    public Long c;
    public Long d;

    public zzfi() {
    }

    public zzfi(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.a = (Long) b.get(0);
            this.b = (Long) b.get(1);
            this.c = (Long) b.get(2);
            this.d = (Long) b.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        hashMap.put(2, this.c);
        hashMap.put(3, this.d);
        return hashMap;
    }
}
