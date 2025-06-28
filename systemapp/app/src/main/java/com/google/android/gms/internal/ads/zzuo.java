package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzuo implements zzekj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final zzekm<zzuo> d = new zzekm<zzuo>() { // from class: com.google.android.gms.internal.ads.bdj
    };
    private final int e;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.e;
    }

    public static zzuo a(int i) {
        if (i != 1000) {
            switch (i) {
                case 0:
                    return ENUM_FALSE;
                case 1:
                    return ENUM_TRUE;
                default:
                    return null;
            }
        }
        return ENUM_UNKNOWN;
    }

    public static zzekl b() {
        return bdk.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.e + " name=" + name() + '>';
    }

    zzuo(int i) {
        this.e = i;
    }
}
