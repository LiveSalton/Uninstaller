package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbu extends zzeoq {
    private Date b;
    private Date c;
    private long d;
    private long e;
    private double f;
    private float g;
    private zzepa h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public zzbu() {
        super("mvhd");
        this.f = 1.0d;
        this.g = 1.0f;
        this.h = zzepa.a;
    }

    public final long b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzeoo
    public final void a(ByteBuffer byteBuffer) {
        b(byteBuffer);
        if (e() == 1) {
            this.b = zzeot.a(zzbq.c(byteBuffer));
            this.c = zzeot.a(zzbq.c(byteBuffer));
            this.d = zzbq.a(byteBuffer);
            this.e = zzbq.c(byteBuffer);
        } else {
            this.b = zzeot.a(zzbq.a(byteBuffer));
            this.c = zzeot.a(zzbq.a(byteBuffer));
            this.d = zzbq.a(byteBuffer);
            this.e = zzbq.a(byteBuffer);
        }
        this.f = zzbq.d(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.g = ((short) ((r0[1] & 255) | ((short) (0 | ((r0[0] << 8) & 65280))))) / 256.0f;
        zzbq.b(byteBuffer);
        zzbq.a(byteBuffer);
        zzbq.a(byteBuffer);
        this.h = zzepa.a(byteBuffer);
        this.j = byteBuffer.getInt();
        this.k = byteBuffer.getInt();
        this.l = byteBuffer.getInt();
        this.m = byteBuffer.getInt();
        this.n = byteBuffer.getInt();
        this.o = byteBuffer.getInt();
        this.i = zzbq.a(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.b + ";modificationTime=" + this.c + ";timescale=" + this.d + ";duration=" + this.e + ";rate=" + this.f + ";volume=" + this.g + ";matrix=" + this.h + ";nextTrackId=" + this.i + "]";
    }
}
