package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzcm implements zzekj {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);

    private static final zzekm<zzcm> g = new zzekm<zzcm>() { // from class: com.google.android.gms.internal.ads.ur
    };
    private final int h;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.h;
    }

    public static zzcm a(int i2) {
        switch (i2) {
            case 0:
                return UNKNOWN_ENCRYPTION_METHOD;
            case 1:
                return BITSLICER;
            case 2:
                return TINK_HYBRID;
            case 3:
                return UNENCRYPTED;
            case 4:
                return DG;
            case 5:
                return DG_XTEA;
            default:
                return null;
        }
    }

    public static zzekl b() {
        return vz.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.h + " name=" + name() + '>';
    }

    zzcm(int i2) {
        this.h = i2;
    }
}
