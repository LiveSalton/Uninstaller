package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
@TargetApi(19)
/* loaded from: classes.dex */
public abstract class zzlv extends zzhc {
    private static final byte[] b = zzpt.d("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    protected zzjm a;
    private final zzlx c;
    private final zzjt<zzjv> d;
    private final boolean e;
    private final zzjl f;
    private final zzjl g;
    private final zzhr h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private zzhp k;
    private zzjr<zzjv> l;
    private zzjr<zzjv> m;
    private MediaCodec n;
    private zzls o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    public zzlv(int i, zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z) {
        super(i);
        zzpc.b(zzpt.a >= 16);
        this.c = (zzlx) zzpc.a(zzlxVar);
        this.d = null;
        this.e = z;
        this.f = new zzjl(0);
        this.g = new zzjl(0);
        this.h = new zzhr();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.F = 0;
        this.G = 0;
    }

    protected abstract int a(zzlx zzlxVar, zzhp zzhpVar) throws zzma;

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
    }

    protected void a(zzjl zzjlVar) {
    }

    protected abstract void a(zzls zzlsVar, MediaCodec mediaCodec, zzhp zzhpVar, MediaCrypto mediaCrypto) throws zzma;

    protected void a(String str, long j, long j2) {
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhe;

    protected boolean a(MediaCodec mediaCodec, boolean z, zzhp zzhpVar, zzhp zzhpVar2) {
        return false;
    }

    protected boolean a(zzls zzlsVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhc, com.google.android.gms.internal.ads.zzhx
    public final int m() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected void n() {
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected void o() {
    }

    protected void y() throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final int a(zzhp zzhpVar) throws zzhe {
        try {
            return a(this.c, zzhpVar);
        } catch (zzma e) {
            throw zzhe.a(e, r());
        }
    }

    protected zzls a(zzlx zzlxVar, zzhp zzhpVar, boolean z) throws zzma {
        return zzlxVar.a(zzhpVar.d, z);
    }

    protected final void z() throws zzhe {
        if (this.n != null || this.k == null) {
            return;
        }
        this.l = this.m;
        String str = this.k.d;
        if (this.l != null) {
            int a = this.l.a();
            if (a == 0) {
                throw zzhe.a(this.l.c(), r());
            }
            if (a == 3 || a == 4) {
                this.l.b();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.o == null) {
            try {
                this.o = a(this.c, this.k, false);
                zzls zzlsVar = this.o;
            } catch (zzma e) {
                a(new zzlu(this.k, (Throwable) e, false, -49998));
            }
            if (this.o == null) {
                a(new zzlu(this.k, (Throwable) null, false, -49999));
            }
        }
        if (a(this.o)) {
            String str2 = this.o.a;
            this.p = zzpt.a < 21 && this.k.f.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.q = zzpt.a < 18 || (zzpt.a == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpt.a == 19 && zzpt.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.r = zzpt.a < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpt.b) || "flounder_lte".equals(zzpt.b) || "grouper".equals(zzpt.b) || "tilapia".equals(zzpt.b));
            this.s = zzpt.a <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.t = (zzpt.a <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpt.a <= 19 && "hb2000".equals(zzpt.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.u = zzpt.a == 21 && "OMX.google.aac.decoder".equals(str2);
            this.v = zzpt.a <= 18 && this.k.m == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String valueOf = String.valueOf(str2);
                zzpq.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                this.n = MediaCodec.createByCodecName(str2);
                zzpq.a();
                zzpq.a("configureCodec");
                a(this.o, this.n, this.k, (MediaCrypto) null);
                zzpq.a();
                zzpq.a("startCodec");
                this.n.start();
                zzpq.a();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.y = this.n.getInputBuffers();
                this.z = this.n.getOutputBuffers();
            } catch (Exception e2) {
                a(new zzlu(this.k, (Throwable) e2, false, str2));
            }
            this.A = d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.a.a++;
        }
    }

    private final void a(zzlu zzluVar) throws zzhe {
        throw zzhe.a(zzluVar, r());
    }

    protected final MediaCodec A() {
        return this.n;
    }

    protected final zzls B() {
        return this.o;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected void a(boolean z) throws zzhe {
        this.a = new zzjm();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected void a(long j, boolean z) throws zzhe {
        this.J = false;
        this.K = false;
        if (this.n != null) {
            this.A = -9223372036854775807L;
            this.B = -1;
            this.C = -1;
            this.M = true;
            this.L = false;
            this.D = false;
            this.i.clear();
            this.w = false;
            this.x = false;
            if (this.q || (this.t && this.I)) {
                C();
                z();
            } else if (this.G != 0) {
                C();
                z();
            } else {
                this.n.flush();
                this.H = false;
            }
            if (!this.E || this.k == null) {
                return;
            }
            this.F = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    protected void p() {
        this.k = null;
        try {
            C();
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void C() {
        this.A = -9223372036854775807L;
        this.B = -1;
        this.C = -1;
        this.L = false;
        this.D = false;
        this.i.clear();
        this.y = null;
        this.z = null;
        this.o = null;
        this.E = false;
        this.H = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.I = false;
        this.F = 0;
        this.G = 0;
        this.f.b = null;
        if (this.n != null) {
            this.a.b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                    this.n = null;
                    if (this.l == null || this.m == this.l) {
                        return;
                    }
                    try {
                        this.d.a(this.l);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    if (this.l != null && this.m != this.l) {
                        try {
                            this.d.a(this.l);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void a(long j, long j2) throws zzhe {
        if (this.K) {
            y();
            return;
        }
        if (this.k == null) {
            this.g.a();
            int a = a(this.h, this.g, true);
            if (a != -5) {
                if (a == -4) {
                    zzpc.b(this.g.c());
                    this.J = true;
                    w();
                    return;
                }
                return;
            }
            b(this.h.a);
        }
        z();
        if (this.n != null) {
            zzpq.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (v()) {
            }
            zzpq.a();
        } else {
            b(j);
            this.g.a();
            int a2 = a(this.h, this.g, false);
            if (a2 == -5) {
                b(this.h.a);
            } else if (a2 == -4) {
                zzpc.b(this.g.c());
                this.J = true;
                w();
            }
        }
        this.a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0153 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean v() throws com.google.android.gms.internal.ads.zzhe {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.v():boolean");
    }

    protected void b(zzhp zzhpVar) throws zzhe {
        zzhp zzhpVar2 = this.k;
        this.k = zzhpVar;
        if (!zzpt.a(this.k.g, zzhpVar2 == null ? null : zzhpVar2.g)) {
            if (this.k.g != null) {
                if (this.d == null) {
                    throw zzhe.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
                }
                this.m = this.d.a(Looper.myLooper(), this.k.g);
                if (this.m == this.l) {
                    this.d.a(this.m);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m == this.l && this.n != null && a(this.n, this.o.b, zzhpVar2, this.k)) {
            this.E = true;
            this.F = 1;
            this.w = this.r && this.k.h == zzhpVar2.h && this.k.i == zzhpVar2.i;
        } else if (this.H) {
            this.G = 1;
        } else {
            C();
            z();
        }
    }

    public boolean u() {
        return this.K;
    }

    public boolean t() {
        if (this.k == null || this.L) {
            return false;
        }
        if (s() || this.C >= 0) {
            return true;
        }
        return this.A != -9223372036854775807L && SystemClock.elapsedRealtime() < this.A;
    }

    private final boolean b(long j, long j2) throws zzhe {
        boolean a;
        boolean z;
        if (this.C < 0) {
            if (this.u && this.I) {
                try {
                    this.C = this.n.dequeueOutputBuffer(this.j, 0L);
                } catch (IllegalStateException unused) {
                    w();
                    if (this.K) {
                        C();
                    }
                    return false;
                }
            } else {
                this.C = this.n.dequeueOutputBuffer(this.j, 0L);
            }
            if (this.C >= 0) {
                if (this.x) {
                    this.x = false;
                    this.n.releaseOutputBuffer(this.C, false);
                    this.C = -1;
                    return true;
                }
                if ((this.j.flags & 4) != 0) {
                    w();
                    this.C = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.z[this.C];
                if (byteBuffer != null) {
                    byteBuffer.position(this.j.offset);
                    byteBuffer.limit(this.j.offset + this.j.size);
                }
                long j3 = this.j.presentationTimeUs;
                int size = this.i.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        break;
                    }
                    if (this.i.get(i).longValue() == j3) {
                        this.i.remove(i);
                        z = true;
                        break;
                    }
                    i++;
                }
                this.D = z;
            } else {
                if (this.C == -2) {
                    MediaFormat outputFormat = this.n.getOutputFormat();
                    if (this.r && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.x = true;
                    } else {
                        if (this.v) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        a(this.n, outputFormat);
                    }
                    return true;
                }
                if (this.C == -3) {
                    this.z = this.n.getOutputBuffers();
                    return true;
                }
                if (this.s && (this.J || this.G == 2)) {
                    w();
                }
                return false;
            }
        }
        if (this.u && this.I) {
            try {
                a = a(j, j2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
            } catch (IllegalStateException unused2) {
                w();
                if (this.K) {
                    C();
                }
                return false;
            }
        } else {
            a = a(j, j2, this.n, this.z[this.C], this.C, this.j.flags, this.j.presentationTimeUs, this.D);
        }
        if (!a) {
            return false;
        }
        long j4 = this.j.presentationTimeUs;
        this.C = -1;
        return true;
    }

    private final void w() throws zzhe {
        if (this.G == 2) {
            C();
            z();
        } else {
            this.K = true;
            y();
        }
    }
}
