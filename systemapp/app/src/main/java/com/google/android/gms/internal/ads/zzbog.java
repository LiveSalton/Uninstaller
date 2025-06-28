package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbog<AdT> implements zzbod<AdT> {
    private final Map<String, zzcqz<AdT>> a;

    zzbog(Map<String, zzcqz<AdT>> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final zzcqz<AdT> a(int i, String str) {
        return this.a.get(str);
    }
}
