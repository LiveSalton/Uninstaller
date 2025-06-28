package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzqa extends zzlv {
    private static final int[] c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int A;
    private int B;
    private int C;
    private float D;
    private boolean E;
    private int F;
    private long G;
    private int H;
    bbj b;
    private final Context d;
    private final zzqe e;
    private final zzqj f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private zzhp[] k;
    private zzqc l;
    private Surface m;
    private Surface n;
    private int o;
    private boolean p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private float v;
    private int w;
    private int x;
    private int y;
    private float z;

    public zzqa(Context context, zzlx zzlxVar, long j, Handler handler, zzqg zzqgVar, int i) {
        this(context, zzlxVar, 0L, null, false, handler, zzqgVar, -1);
    }

    private static boolean c(long j) {
        return j < -30000;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzqa(Context context, zzlx zzlxVar, long j, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzqg zzqgVar, int i) {
        super(2, zzlxVar, null, false);
        boolean z2 = false;
        this.g = 0L;
        this.h = -1;
        this.d = context.getApplicationContext();
        this.e = new zzqe(context);
        this.f = new zzqj(handler, zzqgVar);
        if (zzpt.a <= 22 && "foster".equals(zzpt.b) && "NVIDIA".equals(zzpt.c)) {
            z2 = true;
        }
        this.i = z2;
        this.j = new long[10];
        this.G = -9223372036854775807L;
        this.q = -9223372036854775807L;
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.o = 1;
        D();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int a(zzlx zzlxVar, zzhp zzhpVar) throws zzma {
        boolean z;
        String str = zzhpVar.d;
        if (!zzpj.b(str)) {
            return 0;
        }
        zzjo zzjoVar = zzhpVar.g;
        if (zzjoVar != null) {
            z = false;
            for (int i = 0; i < zzjoVar.a; i++) {
                z |= zzjoVar.a(i).a;
            }
        } else {
            z = false;
        }
        zzls a = zzlxVar.a(str, z);
        if (a == null) {
            return 1;
        }
        boolean b = a.b(zzhpVar.b);
        if (b && zzhpVar.h > 0 && zzhpVar.i > 0) {
            if (zzpt.a >= 21) {
                b = a.a(zzhpVar.h, zzhpVar.i, zzhpVar.j);
            } else {
                b = zzhpVar.h * zzhpVar.i <= zzlz.b();
                if (!b) {
                    int i2 = zzhpVar.h;
                    int i3 = zzhpVar.i;
                    String str2 = zzpt.e;
                    StringBuilder sb = new StringBuilder(56 + String.valueOf(str2).length());
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(i3);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        return (b ? 3 : 2) | (a.b ? 8 : 4) | (a.c ? 16 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void a(boolean z) throws zzhe {
        super.a(z);
        this.F = q().b;
        this.E = this.F != 0;
        this.f.a(this.a);
        this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected final void a(zzhp[] zzhpVarArr, long j) throws zzhe {
        this.k = zzhpVarArr;
        if (this.G == -9223372036854775807L) {
            this.G = j;
        } else {
            if (this.H == this.j.length) {
                long j2 = this.j[this.H - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.H++;
            }
            this.j[this.H - 1] = j;
        }
        super.a(zzhpVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void a(long j, boolean z) throws zzhe {
        super.a(j, z);
        x();
        this.t = 0;
        if (this.H != 0) {
            this.G = this.j[this.H - 1];
            this.H = 0;
        }
        if (z) {
            w();
        } else {
            this.q = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean t() {
        if (super.t() && (this.p || ((this.n != null && this.m == this.n) || A() == null))) {
            this.q = -9223372036854775807L;
            return true;
        }
        if (this.q == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.q) {
            return true;
        }
        this.q = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void n() {
        super.n();
        this.s = 0;
        this.r = SystemClock.elapsedRealtime();
        this.q = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void o() {
        G();
        super.o();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void p() {
        this.w = -1;
        this.x = -1;
        this.z = -1.0f;
        this.v = -1.0f;
        this.G = -9223372036854775807L;
        this.H = 0;
        D();
        x();
        this.e.b();
        this.b = null;
        this.E = false;
        try {
            super.p();
        } finally {
            this.a.a();
            this.f.b(this.a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc, com.google.android.gms.internal.ads.zzhf
    public final void a(int i, Object obj) throws zzhe {
        if (i != 1) {
            if (i == 4) {
                this.o = ((Integer) obj).intValue();
                MediaCodec A = A();
                if (A != null) {
                    A.setVideoScalingMode(this.o);
                    return;
                }
                return;
            }
            super.a(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            if (this.n != null) {
                surface = this.n;
            } else {
                zzls B = B();
                if (B != null && b(B.d)) {
                    this.n = zzpw.a(this.d, B.d);
                    surface = this.n;
                }
            }
        }
        if (this.m != surface) {
            this.m = surface;
            int d = d();
            if (d == 1 || d == 2) {
                MediaCodec A2 = A();
                if (zzpt.a >= 23 && A2 != null && surface != null) {
                    A2.setOutputSurface(surface);
                } else {
                    C();
                    z();
                }
            }
            if (surface != null && surface != this.n) {
                F();
                x();
                if (d == 2) {
                    w();
                    return;
                }
                return;
            }
            D();
            x();
            return;
        }
        if (surface == null || surface == this.n) {
            return;
        }
        F();
        if (this.p) {
            this.f.a(this.m);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean a(zzls zzlsVar) {
        return this.m != null || b(zzlsVar.d);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(zzls zzlsVar, MediaCodec mediaCodec, zzhp zzhpVar, MediaCrypto mediaCrypto) throws zzma {
        zzqc zzqcVar;
        Point point;
        zzhp[] zzhpVarArr = this.k;
        int i = zzhpVar.h;
        int i2 = zzhpVar.i;
        int c2 = c(zzhpVar);
        if (zzhpVarArr.length == 1) {
            zzqcVar = new zzqc(i, i2, c2);
        } else {
            int i3 = i2;
            int i4 = c2;
            boolean z = false;
            int i5 = i;
            for (zzhp zzhpVar2 : zzhpVarArr) {
                if (a(zzlsVar.b, zzhpVar, zzhpVar2)) {
                    z |= zzhpVar2.h == -1 || zzhpVar2.i == -1;
                    i5 = Math.max(i5, zzhpVar2.h);
                    int max = Math.max(i3, zzhpVar2.i);
                    i4 = Math.max(i4, c(zzhpVar2));
                    i3 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i5);
                sb.append("x");
                sb.append(i3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhpVar.i > zzhpVar.h;
                int i6 = z2 ? zzhpVar.i : zzhpVar.h;
                int i7 = z2 ? zzhpVar.h : zzhpVar.i;
                float f = i7 / i6;
                int[] iArr = c;
                int length = iArr.length;
                int i8 = 0;
                while (i8 < length) {
                    int i9 = iArr[i8];
                    int i10 = (int) (i9 * f);
                    if (i9 <= i6 || i10 <= i7) {
                        break;
                    }
                    int i11 = i6;
                    int i12 = i7;
                    if (zzpt.a >= 21) {
                        int i13 = z2 ? i10 : i9;
                        if (!z2) {
                            i9 = i10;
                        }
                        Point a = zzlsVar.a(i13, i9);
                        if (zzlsVar.a(a.x, a.y, zzhpVar.j)) {
                            point = a;
                            break;
                        } else {
                            i8++;
                            i6 = i11;
                            i7 = i12;
                        }
                    } else {
                        int a2 = zzpt.a(i9, 16) << 4;
                        int a3 = zzpt.a(i10, 16) << 4;
                        if (a2 * a3 <= zzlz.b()) {
                            int i14 = z2 ? a3 : a2;
                            if (z2) {
                                a3 = a2;
                            }
                            point = new Point(i14, a3);
                        } else {
                            i8++;
                            i6 = i11;
                            i7 = i12;
                        }
                    }
                }
                point = null;
                if (point != null) {
                    i5 = Math.max(i5, point.x);
                    i3 = Math.max(i3, point.y);
                    i4 = Math.max(i4, a(zzhpVar.d, i5, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i5);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzqcVar = new zzqc(i5, i3, i4);
        }
        this.l = zzqcVar;
        zzqc zzqcVar2 = this.l;
        boolean z3 = this.i;
        int i15 = this.F;
        MediaFormat b = zzhpVar.b();
        b.setInteger("max-width", zzqcVar2.a);
        b.setInteger("max-height", zzqcVar2.b);
        if (zzqcVar2.c != -1) {
            b.setInteger("max-input-size", zzqcVar2.c);
        }
        if (z3) {
            b.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            b.setFeatureEnabled("tunneled-playback", true);
            b.setInteger("audio-session-id", i15);
        }
        if (this.m == null) {
            zzpc.b(b(zzlsVar.d));
            if (this.n == null) {
                this.n = zzpw.a(this.d, zzlsVar.d);
            }
            this.m = this.n;
        }
        mediaCodec.configure(b, this.m, (MediaCrypto) null, 0);
        if (zzpt.a < 23 || !this.E) {
            return;
        }
        this.b = new bbj(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void C() {
        try {
            super.C();
        } finally {
            if (this.n != null) {
                if (this.m == this.n) {
                    this.m = null;
                }
                this.n.release();
                this.n = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(String str, long j, long j2) {
        this.f.a(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void b(zzhp zzhpVar) throws zzhe {
        super.b(zzhpVar);
        this.f.a(zzhpVar);
        this.v = zzhpVar.l == -1.0f ? 1.0f : zzhpVar.l;
        this.u = d(zzhpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(zzjl zzjlVar) {
        if (zzpt.a >= 23 || !this.E) {
            return;
        }
        v();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.w = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.x = integer2;
        this.z = this.v;
        if (zzpt.a >= 21) {
            if (this.u == 90 || this.u == 270) {
                int i = this.w;
                this.w = this.x;
                this.x = i;
                this.z = 1.0f / this.z;
            }
        } else {
            this.y = this.u;
        }
        mediaCodec.setVideoScalingMode(this.o);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean a(MediaCodec mediaCodec, boolean z, zzhp zzhpVar, zzhp zzhpVar2) {
        return a(z, zzhpVar, zzhpVar2) && zzhpVar2.h <= this.l.a && zzhpVar2.i <= this.l.b && zzhpVar2.e <= this.l.c;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (this.H != 0 && j3 >= this.j[0]) {
            this.G = this.j[0];
            this.H--;
            System.arraycopy(this.j, 1, this.j, 0, this.H);
        }
        long j4 = j3 - this.G;
        if (z) {
            a(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.m == this.n) {
            if (!c(j5)) {
                return false;
            }
            a(mediaCodec, i, j4);
            return true;
        }
        if (!this.p) {
            if (zzpt.a >= 21) {
                a(mediaCodec, i, j4, System.nanoTime());
            } else {
                b(mediaCodec, i, j4);
            }
            return true;
        }
        if (d() != 2) {
            return false;
        }
        long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
        long nanoTime = System.nanoTime();
        long a = this.e.a(j3, (elapsedRealtime * 1000) + nanoTime);
        long j6 = (a - nanoTime) / 1000;
        if (c(j6)) {
            zzpq.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            zzpq.a();
            this.a.f++;
            this.s++;
            this.t++;
            this.a.g = Math.max(this.t, this.a.g);
            if (this.s == this.h) {
                G();
            }
            return true;
        }
        if (zzpt.a >= 21) {
            if (j6 < 50000) {
                a(mediaCodec, i, j4, a);
                return true;
            }
        } else if (j6 < 30000) {
            if (j6 > 11000) {
                try {
                    Thread.sleep((j6 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            b(mediaCodec, i, j4);
            return true;
        }
        return false;
    }

    private final void a(MediaCodec mediaCodec, int i, long j) {
        zzpq.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpq.a();
        this.a.e++;
    }

    private final void b(MediaCodec mediaCodec, int i, long j) {
        E();
        zzpq.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpq.a();
        this.a.d++;
        this.t = 0;
        v();
    }

    @TargetApi(21)
    private final void a(MediaCodec mediaCodec, int i, long j, long j2) {
        E();
        zzpq.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpq.a();
        this.a.d++;
        this.t = 0;
        v();
    }

    private final boolean b(boolean z) {
        if (zzpt.a < 23 || this.E) {
            return false;
        }
        return !z || zzpw.a(this.d);
    }

    private final void w() {
        this.q = -9223372036854775807L;
    }

    private final void x() {
        MediaCodec A;
        this.p = false;
        if (zzpt.a < 23 || !this.E || (A = A()) == null) {
            return;
        }
        this.b = new bbj(this, A);
    }

    final void v() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.f.a(this.m);
    }

    private final void D() {
        this.A = -1;
        this.B = -1;
        this.D = -1.0f;
        this.C = -1;
    }

    private final void E() {
        if (this.A == this.w && this.B == this.x && this.C == this.y && this.D == this.z) {
            return;
        }
        this.f.a(this.w, this.x, this.y, this.z);
        this.A = this.w;
        this.B = this.x;
        this.C = this.y;
        this.D = this.z;
    }

    private final void F() {
        if (this.A == -1 && this.B == -1) {
            return;
        }
        this.f.a(this.w, this.x, this.y, this.z);
    }

    private final void G() {
        if (this.s > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(this.s, elapsedRealtime - this.r);
            this.s = 0;
            this.r = elapsedRealtime;
        }
    }

    private static int c(zzhp zzhpVar) {
        if (zzhpVar.e != -1) {
            return zzhpVar.e;
        }
        return a(zzhpVar.d, zzhpVar.h, zzhpVar.i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str, int i, int i2) {
        char c2;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                i3 = i * i2;
                i4 = 2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(zzpt.d)) {
                    i3 = ((zzpt.a(i, 16) * zzpt.a(i2, 16)) << 4) << 4;
                    i4 = 2;
                    break;
                }
                break;
            case 3:
                i3 = i * i2;
                i4 = 2;
                break;
            case 4:
            case 5:
                i3 = i * i2;
                break;
        }
        return -1;
    }

    private static boolean a(boolean z, zzhp zzhpVar, zzhp zzhpVar2) {
        if (!zzhpVar.d.equals(zzhpVar2.d) || d(zzhpVar) != d(zzhpVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzhpVar.h == zzhpVar2.h && zzhpVar.i == zzhpVar2.i;
    }

    private static int d(zzhp zzhpVar) {
        if (zzhpVar.k == -1) {
            return 0;
        }
        return zzhpVar.k;
    }
}
