package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzip {
    private static boolean a = false;
    private static boolean b = false;
    private int A;
    private int B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private Method G;
    private int H;
    private long I;
    private long J;
    private int K;
    private long L;
    private long M;
    private int N;
    private int O;
    private long P;
    private long Q;
    private long R;
    private float S;
    private zzif[] T;
    private ByteBuffer[] U;
    private ByteBuffer V;
    private ByteBuffer W;
    private byte[] X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private long af;
    private final ayo d;
    private final zzjf e;
    private final zzif[] f;
    private final zziv g;
    private final long[] i;
    private final ayj j;
    private final LinkedList<aym> k;
    private AudioTrack l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private long t;
    private zzhv u;
    private zzhv v;
    private long w;
    private long x;
    private ByteBuffer y;
    private int z;
    private final zzig c = null;
    private final ConditionVariable h = new ConditionVariable(true);

    public zzip(zzig zzigVar, zzif[] zzifVarArr, zziv zzivVar) {
        this.g = zzivVar;
        if (zzpt.a >= 18) {
            try {
                this.G = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.a >= 19) {
            this.j = new ayl();
        } else {
            this.j = new ayj(null);
        }
        this.d = new ayo();
        this.e = new zzjf();
        this.f = new zzif[zzifVarArr.length + 3];
        this.f[0] = new ayq();
        this.f[1] = this.d;
        System.arraycopy(zzifVarArr, 0, this.f, 2, zzifVarArr.length);
        this.f[2 + zzifVarArr.length] = this.e;
        this.i = new long[10];
        this.S = 1.0f;
        this.O = 0;
        this.q = 3;
        this.ac = 0;
        this.v = zzhv.a;
        this.Z = -1;
        this.T = new zzif[0];
        this.U = new ByteBuffer[0];
        this.k = new LinkedList<>();
    }

    public final long a(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        zzhv zzhvVar;
        long j5;
        long j6;
        if (!(n() && this.O != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.l.getPlayState() == 3) {
            long c = this.j.c();
            if (c != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.D >= 30000) {
                    this.i[this.A] = c - nanoTime;
                    this.A = (this.A + 1) % 10;
                    if (this.B < 10) {
                        this.B++;
                    }
                    this.D = nanoTime;
                    this.C = 0L;
                    for (int i = 0; i < this.B; i++) {
                        this.C += this.i[i] / this.B;
                    }
                }
                if (!q() && nanoTime - this.F >= 500000) {
                    this.E = this.j.d();
                    if (this.E) {
                        long e = this.j.e() / 1000;
                        long f = this.j.f();
                        if (e < this.Q) {
                            this.E = false;
                        } else if (Math.abs(e - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(f);
                            sb.append(", ");
                            sb.append(e);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(c);
                            Log.w("AudioTrack", sb.toString());
                            this.E = false;
                        } else if (Math.abs(b(f) - c) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(f);
                            sb2.append(", ");
                            sb2.append(e);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(c);
                            Log.w("AudioTrack", sb2.toString());
                            this.E = false;
                        }
                    }
                    if (this.G != null && !this.r) {
                        try {
                            this.R = (((Integer) this.G.invoke(this.l, null)).intValue() * 1000) - this.t;
                            this.R = Math.max(this.R, 0L);
                            if (this.R > 5000000) {
                                long j7 = this.R;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j7);
                                Log.w("AudioTrack", sb3.toString());
                                this.R = 0L;
                            }
                        } catch (Exception unused) {
                            this.G = null;
                        }
                    }
                    this.F = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.E) {
            j2 = b(this.j.f() + c(nanoTime2 - (this.j.e() / 1000)));
        } else {
            if (this.B == 0) {
                j = this.j.c();
            } else {
                j = nanoTime2 + this.C;
            }
            long j8 = j;
            j2 = !z ? j8 - this.R : j8;
        }
        long j9 = this.P;
        while (!this.k.isEmpty()) {
            j4 = this.k.getFirst().c;
            if (j2 < j4) {
                break;
            }
            aym remove = this.k.remove();
            zzhvVar = remove.a;
            this.v = zzhvVar;
            j5 = remove.c;
            this.x = j5;
            j6 = remove.b;
            this.w = j6 - this.P;
        }
        if (this.v.b == 1.0f) {
            j3 = (j2 + this.w) - this.x;
        } else if (this.k.isEmpty() && this.e.j() >= 1024) {
            j3 = zzpt.a(j2 - this.x, this.e.i(), this.e.j()) + this.w;
        } else {
            j3 = ((long) (this.v.b * (j2 - this.x))) + this.w;
        }
        return j9 + j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r19, int r20, int r21, int r22, int r23, int[] r24) throws com.google.android.gms.internal.ads.zzit {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.a(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void k() {
        ArrayList arrayList = new ArrayList();
        for (zzif zzifVar : this.f) {
            if (zzifVar.a()) {
                arrayList.add(zzifVar);
            } else {
                zzifVar.g();
            }
        }
        int size = arrayList.size();
        this.T = (zzif[]) arrayList.toArray(new zzif[size]);
        this.U = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzif zzifVar2 = this.T[i];
            zzifVar2.g();
            this.U[i] = zzifVar2.e();
        }
    }

    public final void a() {
        this.ab = true;
        if (n()) {
            this.Q = System.nanoTime() / 1000;
            this.l.play();
        }
    }

    public final void b() {
        if (this.O == 1) {
            this.O = 2;
        }
    }

    public final boolean a(ByteBuffer byteBuffer, long j) throws zziw, zzix {
        int i;
        int a2;
        zzpc.a(this.V == null || byteBuffer == this.V);
        if (!n()) {
            this.h.block();
            if (this.ad) {
                this.l = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.n).setEncoding(this.p).setSampleRate(this.m).build(), this.s, 1, this.ac);
            } else if (this.ac == 0) {
                this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1);
            } else {
                this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1, this.ac);
            }
            int state = this.l.getState();
            if (state != 1) {
                try {
                    this.l.release();
                } catch (Exception unused) {
                } finally {
                    this.l = null;
                }
                throw new zziw(state, this.m, this.n, this.s);
            }
            int audioSessionId = this.l.getAudioSessionId();
            if (this.ac != audioSessionId) {
                this.ac = audioSessionId;
                this.g.a(audioSessionId);
            }
            this.j.a(this.l, q());
            m();
            this.ae = false;
            if (this.ab) {
                a();
            }
        }
        if (q()) {
            if (this.l.getPlayState() == 2) {
                this.ae = false;
                return false;
            }
            if (this.l.getPlayState() == 1 && this.j.b() != 0) {
                return false;
            }
        }
        boolean z = this.ae;
        this.ae = e();
        if (z && !this.ae && this.l.getPlayState() != 1) {
            this.g.a(this.s, zzhb.a(this.t), SystemClock.elapsedRealtime() - this.af);
        }
        if (this.V == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.r && this.N == 0) {
                int i2 = this.p;
                if (i2 == 7 || i2 == 8) {
                    a2 = zziz.a(byteBuffer);
                } else if (i2 == 5) {
                    a2 = zzid.a();
                } else if (i2 == 6) {
                    a2 = zzid.a(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
                this.N = a2;
            }
            if (this.u != null) {
                if (!l()) {
                    return false;
                }
                this.k.add(new aym(this.u, Math.max(0L, j), b(o()), null));
                this.u = null;
                k();
            }
            if (this.O == 0) {
                this.P = Math.max(0L, j);
                this.O = 1;
            } else {
                long b2 = this.P + b(this.r ? this.J : this.I / this.H);
                if (this.O != 1 || Math.abs(b2 - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(b2);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.O = 2;
                }
                if (this.O == i) {
                    this.P += j - b2;
                    this.O = 1;
                    this.g.a();
                }
            }
            if (this.r) {
                this.J += this.N;
            } else {
                this.I += byteBuffer.remaining();
            }
            this.V = byteBuffer;
        }
        if (this.r) {
            b(this.V, j);
        } else {
            a(j);
        }
        if (this.V.hasRemaining()) {
            return false;
        }
        this.V = null;
        return true;
    }

    private final void a(long j) throws zzix {
        ByteBuffer byteBuffer;
        int length = this.T.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.U[i - 1];
            } else {
                byteBuffer = this.V != null ? this.V : zzif.a;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                zzif zzifVar = this.T[i];
                zzifVar.a(byteBuffer);
                ByteBuffer e = zzifVar.e();
                this.U[i] = e;
                if (e.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00db, code lost:
    
        if (r11 < r10) goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean b(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzix {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.b(java.nio.ByteBuffer, long):boolean");
    }

    public final void c() throws zzix {
        if (!this.aa && n() && l()) {
            this.j.a(o());
            this.z = 0;
            this.aa = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean l() throws com.google.android.gms.internal.ads.zzix {
        /*
            r8 = this;
            int r0 = r8.Z
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r8.r
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzif[] r0 = r8.T
            int r0 = r0.length
            goto L10
        Lf:
            r0 = r3
        L10:
            r8.Z = r0
        L12:
            r0 = r2
            goto L15
        L14:
            r0 = r3
        L15:
            int r4 = r8.Z
            com.google.android.gms.internal.ads.zzif[] r5 = r8.T
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = r5.length
            if (r4 >= r5) goto L3c
            com.google.android.gms.internal.ads.zzif[] r4 = r8.T
            int r5 = r8.Z
            r4 = r4[r5]
            if (r0 == 0) goto L2c
            r4.d()
        L2c:
            r8.a(r6)
            boolean r0 = r4.f()
            if (r0 != 0) goto L36
            return r3
        L36:
            int r0 = r8.Z
            int r0 = r0 + r2
            r8.Z = r0
            goto L12
        L3c:
            java.nio.ByteBuffer r0 = r8.W
            if (r0 == 0) goto L4a
            java.nio.ByteBuffer r0 = r8.W
            r8.b(r0, r6)
            java.nio.ByteBuffer r0 = r8.W
            if (r0 == 0) goto L4a
            return r3
        L4a:
            r8.Z = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.l():boolean");
    }

    public final boolean d() {
        if (n()) {
            return this.aa && !e();
        }
        return true;
    }

    public final boolean e() {
        if (n()) {
            if (o() <= this.j.b()) {
                if (q() && this.l.getPlayState() == 2 && this.l.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhv a(zzhv zzhvVar) {
        zzhv zzhvVar2;
        if (this.r) {
            this.v = zzhv.a;
            return this.v;
        }
        zzhv zzhvVar3 = new zzhv(this.e.a(zzhvVar.b), this.e.b(zzhvVar.c));
        if (this.u != null) {
            zzhvVar2 = this.u;
        } else if (!this.k.isEmpty()) {
            zzhvVar2 = this.k.getLast().a;
        } else {
            zzhvVar2 = this.v;
        }
        if (!zzhvVar3.equals(zzhvVar2)) {
            if (n()) {
                this.u = zzhvVar3;
            } else {
                this.v = zzhvVar3;
            }
        }
        return this.v;
    }

    public final zzhv f() {
        return this.v;
    }

    public final void a(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        if (this.ad) {
            return;
        }
        i();
        this.ac = 0;
    }

    public final void g() {
        if (this.ad) {
            this.ad = false;
            this.ac = 0;
            i();
        }
    }

    public final void a(float f) {
        if (this.S != f) {
            this.S = f;
            m();
        }
    }

    private final void m() {
        if (n()) {
            if (zzpt.a >= 21) {
                this.l.setVolume(this.S);
                return;
            }
            AudioTrack audioTrack = this.l;
            float f = this.S;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void h() {
        this.ab = false;
        if (n()) {
            p();
            this.j.a();
        }
    }

    public final void i() {
        zzhv zzhvVar;
        if (n()) {
            this.I = 0L;
            this.J = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0;
            if (this.u != null) {
                this.v = this.u;
                this.u = null;
            } else if (!this.k.isEmpty()) {
                zzhvVar = this.k.getLast().a;
                this.v = zzhvVar;
            }
            this.k.clear();
            this.w = 0L;
            this.x = 0L;
            this.V = null;
            this.W = null;
            for (int i = 0; i < this.T.length; i++) {
                zzif zzifVar = this.T[i];
                zzifVar.g();
                this.U[i] = zzifVar.e();
            }
            this.aa = false;
            this.Z = -1;
            this.y = null;
            this.z = 0;
            this.O = 0;
            this.R = 0L;
            p();
            if (this.l.getPlayState() == 3) {
                this.l.pause();
            }
            AudioTrack audioTrack = this.l;
            this.l = null;
            this.j.a(null, false);
            this.h.close();
            new ayk(this, audioTrack).start();
        }
    }

    public final void j() {
        i();
        for (zzif zzifVar : this.f) {
            zzifVar.h();
        }
        this.ac = 0;
        this.ab = false;
    }

    private final boolean n() {
        return this.l != null;
    }

    private final long b(long j) {
        return (j * 1000000) / this.m;
    }

    private final long c(long j) {
        return (j * this.m) / 1000000;
    }

    private final long o() {
        return this.r ? this.M : this.L / this.K;
    }

    private final void p() {
        this.C = 0L;
        this.B = 0;
        this.A = 0;
        this.D = 0L;
        this.E = false;
        this.F = 0L;
    }

    private final boolean q() {
        if (zzpt.a < 23) {
            return this.p == 5 || this.p == 6;
        }
        return false;
    }
}
