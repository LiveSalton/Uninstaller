package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzgn implements zzekj {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(999);

    private static final zzekm<zzgn> g = new zzekm<zzgn>() { // from class: com.google.android.gms.internal.ads.axt
    };
    private final int h;

    @Override // com.google.android.gms.internal.ads.zzekj
    public final int a() {
        return this.h;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.h + " name=" + name() + '>';
    }

    zzgn(int i2) {
        this.h = i2;
    }
}
