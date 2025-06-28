package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzcn implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);

    private static final zzekm<zzcn> e = new zzekm<zzcn>() { // from class: com.google.android.gms.internal.ads.xf
    };
    private final int f;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.f;
    }

    public static zzcn a(int i) {
        if (i != 1000) {
            switch (i) {
                case 0:
                    return ENUM_FALSE;
                case 1:
                    return ENUM_TRUE;
                case 2:
                    return ENUM_FAILURE;
                default:
                    return null;
            }
        }
        return ENUM_UNKNOWN;
    }

    public static zzekl b() {
        return wu.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f + " name=" + name() + '>';
    }

    zzcn(int i) {
        this.f = i;
    }
}
