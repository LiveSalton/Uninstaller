package androidx.appcompat.app;

/* compiled from: source */
/* loaded from: classes.dex */
class h {
    private static h d;
    public long a;
    public long b;
    public int c;

    h() {
    }

    static h a() {
        if (d == null) {
            d = new h();
        }
        return d;
    }

    public void a(long j, double d2, double d3) {
        double d4 = 6.24006f + (0.01720197f * ((j - 946728000000L) / 8.64E7f));
        double sin = (0.03341960161924362d * Math.sin(d4)) + d4 + (3.4906598739326E-4d * Math.sin(2.0f * r6)) + (5.236000106378924E-6d * Math.sin(3.0f * r6)) + 1.796593063d + 3.141592653589793d;
        double round = Math.round((r4 - 9.0E-4f) - r5) + 9.0E-4f + ((-d3) / 360.0d) + (0.0053d * Math.sin(d4)) + ((-0.0069d) * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.c = 1;
            this.a = -1L;
            this.b = -1L;
        } else {
            if (sin2 <= -1.0d) {
                this.c = 0;
                this.a = -1L;
                this.b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            this.b = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            if (this.b < j && this.a > j) {
                this.c = 0;
            } else {
                this.c = 1;
            }
        }
    }
}
