package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepa {
    public static final zzepa a = new zzepa(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa k = new zzepa(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa l = new zzepa(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzepa m = new zzepa(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    private final double h;
    private final double i;
    private final double j;

    private zzepa(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.b = d5;
        this.c = d6;
        this.d = d7;
        this.e = d;
        this.f = d2;
        this.g = d3;
        this.h = d4;
        this.i = d8;
        this.j = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzepa zzepaVar = (zzepa) obj;
        return Double.compare(zzepaVar.e, this.e) == 0 && Double.compare(zzepaVar.f, this.f) == 0 && Double.compare(zzepaVar.g, this.g) == 0 && Double.compare(zzepaVar.h, this.h) == 0 && Double.compare(zzepaVar.i, this.i) == 0 && Double.compare(zzepaVar.j, this.j) == 0 && Double.compare(zzepaVar.b, this.b) == 0 && Double.compare(zzepaVar.c, this.c) == 0 && Double.compare(zzepaVar.d, this.d) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.c);
        int i = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.d);
        int i2 = (i * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.e);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.f);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.g);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.h);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.i);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.j);
        return (i7 * 31) + ((int) ((doubleToLongBits9 >>> 32) ^ doubleToLongBits9));
    }

    public final String toString() {
        if (equals(a)) {
            return "Rotate 0°";
        }
        if (equals(k)) {
            return "Rotate 90°";
        }
        if (equals(l)) {
            return "Rotate 180°";
        }
        if (equals(m)) {
            return "Rotate 270°";
        }
        double d = this.b;
        double d2 = this.c;
        double d3 = this.d;
        double d4 = this.e;
        double d5 = this.f;
        double d6 = this.g;
        double d7 = this.h;
        double d8 = this.i;
        double d9 = this.j;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d7);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static zzepa a(ByteBuffer byteBuffer) {
        double d = zzbq.d(byteBuffer);
        double d2 = zzbq.d(byteBuffer);
        double e = zzbq.e(byteBuffer);
        return new zzepa(d, d2, zzbq.d(byteBuffer), zzbq.d(byteBuffer), e, zzbq.e(byteBuffer), zzbq.e(byteBuffer), zzbq.d(byteBuffer), zzbq.d(byteBuffer));
    }
}
