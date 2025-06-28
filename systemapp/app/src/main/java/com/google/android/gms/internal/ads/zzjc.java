package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzjc extends zzlv implements zzpg {
    private final zzik b;
    private final zzip c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private long i;
    private boolean j;

    public zzjc(zzlx zzlxVar, Handler handler, zzih zzihVar) {
        this(zzlxVar, null, true, handler, zzihVar);
    }

    protected static void a(int i, long j, long j2) {
    }

    protected static void b(int i) {
    }

    protected static void v() {
    }

    @Override // com.google.android.gms.internal.ads.zzhc, com.google.android.gms.internal.ads.zzhy
    public final zzpg c() {
        return this;
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzih zzihVar) {
        this(zzlxVar, null, true, handler, zzihVar, null, new zzif[0]);
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzih zzihVar, zzig zzigVar, zzif... zzifVarArr) {
        super(1, zzlxVar, null, true);
        this.c = new zzip(null, zzifVarArr, new ayr(this));
        this.b = new zzik(handler, zzihVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int a(zzlx zzlxVar, zzhp zzhpVar) throws zzma {
        String str = zzhpVar.d;
        if (!zzpj.a(str)) {
            return 0;
        }
        int i = zzpt.a >= 21 ? 16 : 0;
        if (a(str) && zzlxVar.a() != null) {
            return 4 | i | 3;
        }
        zzls a = zzlxVar.a(str, false);
        boolean z = true;
        if (a == null) {
            return 1;
        }
        if (zzpt.a >= 21 && ((zzhpVar.n != -1 && !a.a(zzhpVar.n)) || (zzhpVar.m != -1 && !a.b(zzhpVar.m)))) {
            z = false;
        }
        return 4 | i | (z ? 3 : 2);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final zzls a(zzlx zzlxVar, zzhp zzhpVar, boolean z) throws zzma {
        zzls a;
        if (a(zzhpVar.d) && (a = zzlxVar.a()) != null) {
            this.d = true;
            return a;
        }
        this.d = false;
        return super.a(zzlxVar, zzhpVar, z);
    }

    private final boolean a(String str) {
        zzip zzipVar = this.c;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(zzls zzlsVar, MediaCodec mediaCodec, zzhp zzhpVar, MediaCrypto mediaCrypto) {
        this.e = zzpt.a < 24 && "OMX.SEC.aac.dec".equals(zzlsVar.a) && "samsung".equals(zzpt.c) && (zzpt.b.startsWith("zeroflte") || zzpt.b.startsWith("herolte") || zzpt.b.startsWith("heroqlte"));
        if (this.d) {
            this.f = zzhpVar.b();
            this.f.setString("mime", "audio/raw");
            mediaCodec.configure(this.f, (Surface) null, (MediaCrypto) null, 0);
            this.f.setString("mime", zzhpVar.d);
            return;
        }
        mediaCodec.configure(zzhpVar.b(), (Surface) null, (MediaCrypto) null, 0);
        this.f = null;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void b(zzhp zzhpVar) throws zzhe {
        super.b(zzhpVar);
        this.b.a(zzhpVar);
        this.g = "audio/raw".equals(zzhpVar.d) ? zzhpVar.o : 2;
        this.h = zzhpVar.m;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzhe {
        int[] iArr;
        boolean z = this.f != null;
        String string = z ? this.f.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.f;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.e && integer == 6 && this.h < 6) {
            iArr = new int[this.h];
            for (int i = 0; i < this.h; i++) {
                iArr[i] = i;
            }
        } else {
            iArr = null;
        }
        try {
            this.c.a(string, integer, integer2, this.g, 0, iArr);
        } catch (zzit e) {
            throw zzhe.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void a(boolean z) throws zzhe {
        super.a(z);
        this.b.a(this.a);
        int i = q().b;
        this.c.g();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void a(long j, boolean z) throws zzhe {
        super.a(j, z);
        this.c.i();
        this.i = j;
        this.j = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void n() {
        super.n();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void o() {
        this.c.h();
        super.o();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhc
    protected final void p() {
        try {
            this.c.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean u() {
        return super.u() && this.c.d();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean t() {
        return this.c.e() || super.t();
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final long w() {
        long a = this.c.a(u());
        if (a != Long.MIN_VALUE) {
            if (!this.j) {
                a = Math.max(this.i, a);
            }
            this.i = a;
            this.j = false;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final zzhv a(zzhv zzhvVar) {
        return this.c.a(zzhvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final zzhv x() {
        return this.c.f();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzhe {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.a.e++;
            this.c.b();
            return true;
        }
        try {
            if (!this.c.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.a.d++;
            return true;
        } catch (zziw | zzix e) {
            throw zzhe.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void y() throws zzhe {
        try {
            this.c.c();
        } catch (zzix e) {
            throw zzhe.a(e, r());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc, com.google.android.gms.internal.ads.zzhf
    public final void a(int i, Object obj) throws zzhe {
        switch (i) {
            case 2:
                this.c.a(((Float) obj).floatValue());
                break;
            case 3:
                this.c.a(((Integer) obj).intValue());
                break;
            default:
                super.a(i, obj);
                break;
        }
    }

    static /* synthetic */ boolean a(zzjc zzjcVar, boolean z) {
        zzjcVar.j = true;
        return true;
    }
}
