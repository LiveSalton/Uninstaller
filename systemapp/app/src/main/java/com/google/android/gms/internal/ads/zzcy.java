package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcy extends zzcu<Integer, Object> {
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;

    public zzcy(String str) {
        this();
        a(str);
    }

    public zzcy() {
        this.a = "E";
        this.b = -1L;
        this.c = "E";
        this.d = "E";
        this.e = "E";
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.a = b.get(0) == null ? "E" : (String) b.get(0);
            this.b = b.get(1) == null ? -1L : ((Long) b.get(1)).longValue();
            this.c = b.get(2) == null ? "E" : (String) b.get(2);
            this.d = b.get(3) == null ? "E" : (String) b.get(3);
            this.e = b.get(4) == null ? "E" : (String) b.get(4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.a);
        hashMap.put(4, this.e);
        hashMap.put(3, this.d);
        hashMap.put(2, this.c);
        hashMap.put(1, Long.valueOf(this.b));
        return hashMap;
    }
}
