package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzefa implements zzekj {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);

    private static final zzekm<zzefa> g = new zzekm<zzefa>() { // from class: com.google.android.gms.internal.ads.ara
    };
    private final int h;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.h;
    }

    public static zzefa a(int i2) {
        switch (i2) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA384;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
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

    zzefa(int i2) {
        this.h = i2;
    }
}
