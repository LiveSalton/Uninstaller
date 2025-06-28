package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzcs implements zzekj {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);

    private static final zzekm<zzcs> e = new zzekm<zzcs>() { // from class: com.google.android.gms.internal.ads.xt
    };
    private final int f;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.f;
    }

    public static zzcs a(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PROTO;
            case 1:
                return AFMA_SIGNALS;
            case 2:
                return UNITY_SIGNALS;
            case 3:
                return PARTNER_SIGNALS;
            default:
                return null;
        }
    }

    public static zzekl b() {
        return yv.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f + " name=" + name() + '>';
    }

    zzcs(int i) {
        this.f = i;
    }
}
