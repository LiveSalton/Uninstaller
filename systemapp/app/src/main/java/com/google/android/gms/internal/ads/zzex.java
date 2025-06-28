package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzex extends zzcu<Integer, Long> {
    public Long a;
    public Long b;

    public zzex() {
    }

    public zzex(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final void a(String str) {
        HashMap b = b(str);
        if (b != null) {
            this.a = (Long) b.get(0);
            this.b = (Long) b.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.a);
        hashMap.put(1, this.b);
        return hashMap;
    }
}
