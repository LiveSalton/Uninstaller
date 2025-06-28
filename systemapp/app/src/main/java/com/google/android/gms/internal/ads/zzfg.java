package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzfg extends zzcu<Integer, Long> {
    public Long a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public Long j;
    public Long k;

    public zzfg() {
    }

    public zzfg(String str) {
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
            this.e = (Long) b.get(4);
            this.f = (Long) b.get(5);
            this.g = (Long) b.get(6);
            this.h = (Long) b.get(7);
            this.i = (Long) b.get(8);
            this.j = (Long) b.get(9);
            this.k = (Long) b.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        hashMap.put(2, this.c);
        hashMap.put(3, this.d);
        hashMap.put(4, this.e);
        hashMap.put(5, this.f);
        hashMap.put(6, this.g);
        hashMap.put(7, this.h);
        hashMap.put(8, this.i);
        hashMap.put(9, this.j);
        hashMap.put(10, this.k);
        return hashMap;
    }
}
