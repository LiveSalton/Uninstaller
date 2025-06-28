package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzefl implements zzekj {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    private static final zzekm<zzefl> f = new zzekm<zzefl>() { // from class: com.google.android.gms.internal.ads.arg
    };
    private final int g;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.g;
    }

    public static zzefl a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
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

    zzefl(int i) {
        this.g = i;
    }
}
