package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzew extends zzcu<Integer, Object> {
    public Long a;
    public Boolean b;
    public Boolean c;

    public zzew() {
    }

    public zzew(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.a = (Long) b.get(0);
            this.b = (Boolean) b.get(1);
            this.c = (Boolean) b.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        hashMap.put(2, this.c);
        return hashMap;
    }
}
