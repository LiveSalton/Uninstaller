package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

/* compiled from: source */
/* loaded from: classes.dex */
final class atr implements auk {
    private static final atr a = new atr();

    private atr() {
    }

    public static atr a() {
        return a;
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final boolean a(Class<?> cls) {
        return zzekh.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final aul b(Class<?> cls) {
        if (!zzekh.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (aul) zzekh.a(cls.asSubclass(zzekh.class)).a(zzekh.zzf.c, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
