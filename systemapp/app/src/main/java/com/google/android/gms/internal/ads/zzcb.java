package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzcb implements zzekj {
    ENUM_SIGNAL_SOURCE_UNKNOWN(0),
    ENUM_SIGNAL_SOURCE_DISABLE(1),
    ENUM_SIGNAL_SOURCE_ADSHIELD(2),
    ENUM_SIGNAL_SOURCE_GASS(3),
    ENUM_SIGNAL_SOURCE_CALLER_PROVIDED(4);

    private static final zzekm<zzcb> f = new zzekm<zzcb>() { // from class: com.google.android.gms.internal.ads.rc
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.g;
    }

    public static zzcb a(int i) {
        switch (i) {
            case 0:
                return ENUM_SIGNAL_SOURCE_UNKNOWN;
            case 1:
                return ENUM_SIGNAL_SOURCE_DISABLE;
            case 2:
                return ENUM_SIGNAL_SOURCE_ADSHIELD;
            case 3:
                return ENUM_SIGNAL_SOURCE_GASS;
            case 4:
                return ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
            default:
                return null;
        }
    }

    public static zzekl b() {
        return qx.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.g + " name=" + name() + '>';
    }

    zzcb(int i) {
        this.g = i;
    }
}
