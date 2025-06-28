package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzeey implements zzekj {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);

    private static final zzekm<zzeey> g = new zzekm<zzeey>() { // from class: com.google.android.gms.internal.ads.aqz
    };
    private final int h;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.h;
    }

    public static zzeey a(int i2) {
        if (i2 == 0) {
            return UNKNOWN_CURVE;
        }
        switch (i2) {
            case 2:
                return NIST_P256;
            case 3:
                return NIST_P384;
            case 4:
                return NIST_P521;
            case 5:
                return CURVE25519;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(a());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    zzeey(int i2) {
        this.h = i2;
    }
}
