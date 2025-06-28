package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzhv {
    public static final zzhv a = new zzhv(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    public zzhv(float f, float f2) {
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public final long a(long j) {
        return j * this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhv zzhvVar = (zzhv) obj;
        return this.b == zzhvVar.b && this.c == zzhvVar.c;
    }

    public final int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.b)) * 31) + Float.floatToRawIntBits(this.c);
    }
}
