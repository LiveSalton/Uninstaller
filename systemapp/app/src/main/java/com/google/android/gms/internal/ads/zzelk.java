package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzelk<K, V> {
    static <K, V> void a(zzejo zzejoVar, aug<K, V> augVar, K k, V v) throws IOException {
        atl.a(zzejoVar, augVar.a, 1, k);
        atl.a(zzejoVar, augVar.c, 2, v);
    }

    static <K, V> int a(aug<K, V> augVar, K k, V v) {
        return atl.a(augVar.a, 1, k) + atl.a(augVar.c, 2, v);
    }
}
