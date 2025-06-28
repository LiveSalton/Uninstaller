package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzkm implements zzjw {
    private static final zzkb a = new aze();
    private static final byte[] b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID d = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private zzph F;
    private zzph G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private byte W;
    private int X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private zzjy ac;
    private final aza e;
    private final azi f;
    private final SparseArray<azg> g;
    private final boolean h;
    private final zzpn i;
    private final zzpn j;
    private final zzpn k;
    private final zzpn l;
    private final zzpn m;
    private final zzpn n;
    private final zzpn o;
    private final zzpn p;
    private final zzpn q;
    private ByteBuffer r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private azg x;
    private boolean y;
    private int z;

    public zzkm() {
        this(0);
    }

    static int a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void c() {
    }

    private zzkm(int i) {
        this(new ayz(), 0);
    }

    private zzkm(aza azaVar, int i) {
        this.t = -1L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.e = azaVar;
        this.e.a(new azd(this, null));
        this.h = true;
        this.f = new azi();
        this.g = new SparseArray<>();
        this.k = new zzpn(4);
        this.l = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.m = new zzpn(4);
        this.i = new zzpn(zzpi.a);
        this.j = new zzpn(4);
        this.n = new zzpn();
        this.o = new zzpn();
        this.p = new zzpn(8);
        this.q = new zzpn();
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final boolean a(zzjz zzjzVar) throws IOException, InterruptedException {
        return new azf().a(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(zzjy zzjyVar) {
        this.ac = zzjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(long j, long j2) {
        this.E = -9223372036854775807L;
        this.I = 0;
        this.e.a();
        this.f.a();
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.android.gms.internal.ads.zzjz r8, com.google.android.gms.internal.ads.zzkc r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            r0 = 0
            r7.aa = r0
            r1 = 1
            r2 = r1
        L5:
            if (r2 == 0) goto L3c
            boolean r3 = r7.aa
            if (r3 != 0) goto L3c
            com.google.android.gms.internal.ads.aza r2 = r7.e
            boolean r2 = r2.a(r8)
            if (r2 == 0) goto L5
            long r3 = r8.b()
            boolean r5 = r7.B
            if (r5 == 0) goto L25
            r7.D = r3
            long r3 = r7.C
            r9.a = r3
            r7.B = r0
        L23:
            r3 = r1
            goto L39
        L25:
            boolean r3 = r7.y
            if (r3 == 0) goto L38
            long r3 = r7.D
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L38
            long r3 = r7.D
            r9.a = r3
            r7.D = r5
            goto L23
        L38:
            r3 = r0
        L39:
            if (r3 == 0) goto L5
            return r1
        L3c:
            if (r2 == 0) goto L3f
            return r0
        L3f:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkm.a(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    final void a(int i, long j, long j2) throws zzhw {
        if (i == 160) {
            this.ab = false;
            return;
        }
        if (i == 174) {
            this.x = new azg(null);
            return;
        }
        if (i == 187) {
            this.H = false;
            return;
        }
        if (i == 19899) {
            this.z = -1;
            this.A = -1L;
            return;
        }
        if (i == 20533) {
            this.x.e = true;
            return;
        }
        if (i == 21968) {
            this.x.q = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                if (this.t != -1 && this.t != j) {
                    throw new zzhw("Multiple Segment elements not supported");
                }
                this.t = j;
                this.s = j2;
                return;
            }
            if (i == 475249515) {
                this.F = new zzph();
                this.G = new zzph();
            } else if (i == 524531317 && !this.y) {
                if (this.h && this.C != -1) {
                    this.B = true;
                } else {
                    this.ac.a(new zzke(this.w));
                    this.y = true;
                }
            }
        }
    }

    final void c(int i) throws zzhw {
        zzkf zzkeVar;
        int i2;
        if (i == 160) {
            if (this.I != 2) {
                return;
            }
            if (!this.ab) {
                this.Q |= 1;
            }
            a(this.g.get(this.O), this.J);
            this.I = 0;
            return;
        }
        if (i == 174) {
            String str = this.x.a;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                this.x.a(this.ac, this.x.b);
                this.g.put(this.x.b, this.x);
            }
            this.x = null;
            return;
        }
        if (i == 19899) {
            if (this.z == -1 || this.A == -1) {
                throw new zzhw("Mandatory element SeekID or SeekPosition not found");
            }
            if (this.z == 475249515) {
                this.C = this.A;
                return;
            }
            return;
        }
        if (i == 25152) {
            if (this.x.e) {
                if (this.x.g == null) {
                    throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.x.i = new zzjo(new zzjo.zza(zzhb.b, "video/webm", this.x.g.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            if (this.x.e && this.x.f != null) {
                throw new zzhw("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.u == -9223372036854775807L) {
                this.u = 1000000L;
            }
            if (this.v != -9223372036854775807L) {
                this.w = a(this.v);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i == 475249515 && !this.y) {
                zzjy zzjyVar = this.ac;
                if (this.t == -1 || this.w == -9223372036854775807L || this.F == null || this.F.a() == 0 || this.G == null || this.G.a() != this.F.a()) {
                    this.F = null;
                    this.G = null;
                    zzkeVar = new zzke(this.w);
                } else {
                    int a2 = this.F.a();
                    int[] iArr = new int[a2];
                    long[] jArr = new long[a2];
                    long[] jArr2 = new long[a2];
                    long[] jArr3 = new long[a2];
                    for (int i3 = 0; i3 < a2; i3++) {
                        jArr3[i3] = this.F.a(i3);
                        jArr[i3] = this.t + this.G.a(i3);
                    }
                    while (true) {
                        i2 = a2 - 1;
                        if (r1 >= i2) {
                            break;
                        }
                        int i4 = r1 + 1;
                        iArr[r1] = (int) (jArr[i4] - jArr[r1]);
                        jArr2[r1] = jArr3[i4] - jArr3[r1];
                        r1 = i4;
                    }
                    iArr[i2] = (int) ((this.t + this.s) - jArr[i2]);
                    jArr2[i2] = this.w - jArr3[i2];
                    this.F = null;
                    this.G = null;
                    zzkeVar = new zzju(iArr, jArr, jArr2, jArr3);
                }
                zzjyVar.a(zzkeVar);
                this.y = true;
                return;
            }
            return;
        }
        if (this.g.size() == 0) {
            throw new zzhw("No valid tracks were found");
        }
        this.ac.a();
    }

    final void a(int i, long j) throws zzhw {
        switch (i) {
            case 131:
                this.x.c = (int) j;
                return;
            case 136:
                this.x.L = j == 1;
                return;
            case 155:
                this.K = a(j);
                return;
            case 159:
                this.x.G = (int) j;
                return;
            case 176:
                this.x.j = (int) j;
                return;
            case 179:
                this.F.a(a(j));
                return;
            case 186:
                this.x.k = (int) j;
                return;
            case 215:
                this.x.b = (int) j;
                return;
            case 231:
                this.E = a(j);
                return;
            case 241:
                if (this.H) {
                    return;
                }
                this.G.a(j);
                this.H = true;
                return;
            case 251:
                this.ab = true;
                return;
            case 16980:
                if (j != 3) {
                    StringBuilder sb = new StringBuilder(50);
                    sb.append("ContentCompAlgo ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzhw(sb.toString());
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzhw(sb2.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("EBMLReadVersion ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzhw(sb3.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb4 = new StringBuilder(49);
                    sb4.append("ContentEncAlgo ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzhw(sb4.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb5 = new StringBuilder(56);
                    sb5.append("AESSettingsCipherMode ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzhw(sb5.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingOrder ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzhw(sb6.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(55);
                    sb7.append("ContentEncodingScope ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzhw(sb7.toString());
                }
                return;
            case 21420:
                this.A = j + this.t;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.x.p = 1;
                    return;
                }
                if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.x.p = 0;
                            return;
                        case 1:
                            this.x.p = 2;
                            return;
                        default:
                            return;
                    }
                }
                this.x.p = 3;
                return;
            case 21680:
                this.x.l = (int) j;
                return;
            case 21682:
                this.x.n = (int) j;
                return;
            case 21690:
                this.x.m = (int) j;
                return;
            case 21930:
                this.x.M = j == 1;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.x.t = 2;
                        return;
                    case 2:
                        this.x.t = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.x.s = 6;
                        return;
                    } else if (i3 == 18) {
                        this.x.s = 7;
                        return;
                    } else {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    }
                }
                this.x.s = 3;
                return;
            case 21947:
                this.x.q = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    this.x.r = 1;
                    return;
                } else {
                    if (i4 != 9) {
                        switch (i4) {
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.x.r = 2;
                                return;
                            default:
                                return;
                        }
                    }
                    this.x.r = 6;
                    return;
                }
            case 21948:
                this.x.u = (int) j;
                return;
            case 21949:
                this.x.v = (int) j;
                return;
            case 22186:
                this.x.J = j;
                return;
            case 22203:
                this.x.K = j;
                return;
            case 25188:
                this.x.H = (int) j;
                return;
            case 2352003:
                this.x.d = (int) j;
                return;
            case 2807729:
                this.u = j;
                return;
            default:
                return;
        }
    }

    final void a(int i, double d2) {
        if (i == 181) {
            this.x.I = (int) d2;
            return;
        }
        if (i == 17545) {
            this.v = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.x.w = (float) d2;
                break;
            case 21970:
                this.x.x = (float) d2;
                break;
            case 21971:
                this.x.y = (float) d2;
                break;
            case 21972:
                this.x.z = (float) d2;
                break;
            case 21973:
                this.x.A = (float) d2;
                break;
            case 21974:
                this.x.B = (float) d2;
                break;
            case 21975:
                this.x.C = (float) d2;
                break;
            case 21976:
                this.x.D = (float) d2;
                break;
            case 21977:
                this.x.E = (float) d2;
                break;
            case 21978:
                this.x.F = (float) d2;
                break;
        }
    }

    final void a(int i, String str) throws zzhw {
        if (i == 134) {
            this.x.a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.x.P = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(22 + String.valueOf(str).length());
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    final void a(int i, int i2, zzjz zzjzVar) throws IOException, InterruptedException {
        int i3;
        char c2;
        int i4;
        int i5 = 4;
        int i6 = 0;
        int i7 = 1;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                this.x.f = new byte[i2];
                zzjzVar.b(this.x.f, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr = new byte[i2];
                zzjzVar.b(bArr, 0, i2);
                this.x.g = new zzkg(1, bArr);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.m.a, (byte) 0);
                zzjzVar.b(this.m.a, 4 - i2, i2);
                this.m.c(0);
                this.z = (int) this.m.j();
                return;
            }
            if (i == 25506) {
                this.x.h = new byte[i2];
                zzjzVar.b(this.x.h, 0, i2);
                return;
            } else if (i == 30322) {
                this.x.o = new byte[i2];
                zzjzVar.b(this.x.o, 0, i2);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i);
                throw new zzhw(sb.toString());
            }
        }
        int i8 = 8;
        if (this.I == 0) {
            this.O = (int) this.f.a(zzjzVar, false, true, 8);
            this.P = this.f.b();
            this.K = -9223372036854775807L;
            this.I = 1;
            this.k.a();
        }
        azg azgVar = this.g.get(this.O);
        if (azgVar == null) {
            zzjzVar.b(i2 - this.P);
            this.I = 0;
            return;
        }
        if (this.I == 1) {
            a(zzjzVar, 3);
            char c3 = 6;
            int i9 = (this.k.a[2] & 6) >> 1;
            byte b2 = 255;
            if (i9 == 0) {
                this.M = 1;
                this.N = a(this.N, 1);
                this.N[0] = (i2 - this.P) - 3;
            } else {
                if (i != 163) {
                    throw new zzhw("Lacing only supported in SimpleBlocks.");
                }
                a(zzjzVar, 4);
                this.M = (this.k.a[3] & 255) + 1;
                this.N = a(this.N, this.M);
                if (i9 == 2) {
                    Arrays.fill(this.N, 0, this.M, ((i2 - this.P) - 4) / this.M);
                } else if (i9 == 1) {
                    int i10 = 0;
                    for (int i11 = 0; i11 < this.M - 1; i11++) {
                        this.N[i11] = 0;
                        do {
                            i5++;
                            a(zzjzVar, i5);
                            i4 = this.k.a[i5 - 1] & 255;
                            int[] iArr = this.N;
                            iArr[i11] = iArr[i11] + i4;
                        } while (i4 == 255);
                        i10 += this.N[i11];
                    }
                    this.N[this.M - 1] = ((i2 - this.P) - i5) - i10;
                } else if (i9 == 3) {
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < this.M - i7) {
                        this.N[i12] = i6;
                        i5++;
                        a(zzjzVar, i5);
                        int i14 = i5 - 1;
                        if (this.k.a[i14] == 0) {
                            throw new zzhw("No valid varint length mask found");
                        }
                        long j = 0;
                        int i15 = i6;
                        while (true) {
                            if (i15 >= i8) {
                                c2 = c3;
                                break;
                            }
                            int i16 = i7 << (7 - i15);
                            if ((this.k.a[i14] & i16) != 0) {
                                i5 += i15;
                                a(zzjzVar, i5);
                                int i17 = i14 + 1;
                                j = this.k.a[i14] & b2 & (~i16);
                                while (i17 < i5) {
                                    j = (j << i8) | (this.k.a[i17] & 255);
                                    i17++;
                                    i8 = 8;
                                }
                                if (i12 > 0) {
                                    c2 = 6;
                                    j -= (1 << (6 + (i15 * 7))) - 1;
                                } else {
                                    c2 = 6;
                                }
                            } else {
                                i15++;
                                i7 = 1;
                                i8 = 8;
                                b2 = 255;
                            }
                        }
                        long j2 = j;
                        if (j2 < -2147483648L || j2 > 2147483647L) {
                            throw new zzhw("EBML lacing sample size out of range.");
                        }
                        int i18 = (int) j2;
                        int[] iArr2 = this.N;
                        if (i12 != 0) {
                            i18 += this.N[i12 - 1];
                        }
                        iArr2[i12] = i18;
                        i13 += this.N[i12];
                        i12++;
                        c3 = c2;
                        i6 = 0;
                        i7 = 1;
                        i8 = 8;
                        b2 = 255;
                    }
                    this.N[this.M - 1] = ((i2 - this.P) - i5) - i13;
                } else {
                    StringBuilder sb2 = new StringBuilder(36);
                    sb2.append("Unexpected lacing value: ");
                    sb2.append(i9);
                    throw new zzhw(sb2.toString());
                }
            }
            this.J = this.E + a((this.k.a[0] << 8) | (this.k.a[1] & 255));
            this.Q = ((azgVar.c == 2 || (i == 163 && (this.k.a[2] & 128) == 128)) ? 1 : 0) | ((this.k.a[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
            this.I = 2;
            this.L = 0;
            i3 = 163;
        } else {
            i3 = 163;
        }
        if (i == i3) {
            while (this.L < this.M) {
                a(zzjzVar, azgVar, this.N[this.L]);
                a(azgVar, this.J + ((this.L * azgVar.d) / 1000));
                this.L++;
            }
            this.I = 0;
            return;
        }
        a(zzjzVar, azgVar, this.N[0]);
    }

    private final void a(azg azgVar, long j) {
        byte[] b2;
        if ("S_TEXT/UTF8".equals(azgVar.a)) {
            byte[] bArr = this.o.a;
            long j2 = this.K;
            if (j2 == -9223372036854775807L) {
                b2 = c;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                b2 = zzpt.b(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r7)) / 1000))));
            }
            System.arraycopy(b2, 0, bArr, 19, 12);
            azgVar.N.a(this.o, this.o.c());
            this.Z += this.o.c();
        }
        azgVar.N.a(j, this.Q, this.Z, 0, azgVar.g);
        this.aa = true;
        b();
    }

    private final void b() {
        this.R = 0;
        this.Z = 0;
        this.Y = 0;
        this.S = false;
        this.T = false;
        this.V = false;
        this.X = 0;
        this.W = (byte) 0;
        this.U = false;
        this.n.a();
    }

    private final void a(zzjz zzjzVar, int i) throws IOException, InterruptedException {
        if (this.k.c() >= i) {
            return;
        }
        if (this.k.e() < i) {
            this.k.a(Arrays.copyOf(this.k.a, Math.max(this.k.a.length << 1, i)), this.k.c());
        }
        zzjzVar.b(this.k.a, this.k.c(), i - this.k.c());
        this.k.b(i);
    }

    private final void a(zzjz zzjzVar, azg azgVar, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(azgVar.a)) {
            int length = b.length + i;
            if (this.o.e() < length) {
                this.o.a = Arrays.copyOf(b, length + i);
            }
            zzjzVar.b(this.o.a, b.length, i);
            this.o.c(0);
            this.o.b(length);
            return;
        }
        zzkh zzkhVar = azgVar.N;
        if (!this.S) {
            if (azgVar.e) {
                this.Q &= -1073741825;
                if (!this.T) {
                    zzjzVar.b(this.k.a, 0, 1);
                    this.R++;
                    if ((this.k.a[0] & 128) == 128) {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                    this.W = this.k.a[0];
                    this.T = true;
                }
                if ((this.W & 1) == 1) {
                    boolean z = (this.W & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.U) {
                        zzjzVar.b(this.p.a, 0, 8);
                        this.R += 8;
                        this.U = true;
                        this.k.a[0] = (byte) ((z ? 128 : 0) | 8);
                        this.k.c(0);
                        zzkhVar.a(this.k, 1);
                        this.Z++;
                        this.p.c(0);
                        zzkhVar.a(this.p, 8);
                        this.Z += 8;
                    }
                    if (z) {
                        if (!this.V) {
                            zzjzVar.b(this.k.a, 0, 1);
                            this.R++;
                            this.k.c(0);
                            this.X = this.k.f();
                            this.V = true;
                        }
                        int i2 = this.X << 2;
                        this.k.a(i2);
                        zzjzVar.b(this.k.a, 0, i2);
                        this.R += i2;
                        short s = (short) ((this.X / 2) + 1);
                        int i3 = (s * 6) + 2;
                        if (this.r == null || this.r.capacity() < i3) {
                            this.r = ByteBuffer.allocate(i3);
                        }
                        this.r.position(0);
                        this.r.putShort(s);
                        int i4 = 0;
                        int i5 = 0;
                        while (i4 < this.X) {
                            int o = this.k.o();
                            if (i4 % 2 == 0) {
                                this.r.putShort((short) (o - i5));
                            } else {
                                this.r.putInt(o - i5);
                            }
                            i4++;
                            i5 = o;
                        }
                        int i6 = (i - this.R) - i5;
                        if (this.X % 2 == 1) {
                            this.r.putInt(i6);
                        } else {
                            this.r.putShort((short) i6);
                            this.r.putInt(0);
                        }
                        this.q.a(this.r.array(), i3);
                        zzkhVar.a(this.q, i3);
                        this.Z += i3;
                    }
                }
            } else if (azgVar.f != null) {
                this.n.a(azgVar.f, azgVar.f.length);
            }
            this.S = true;
        }
        int c2 = i + this.n.c();
        if ("V_MPEG4/ISO/AVC".equals(azgVar.a) || "V_MPEGH/ISO/HEVC".equals(azgVar.a)) {
            byte[] bArr = this.j.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i7 = azgVar.O;
            int i8 = 4 - azgVar.O;
            while (this.R < c2) {
                if (this.Y == 0) {
                    int min = Math.min(i7, this.n.b());
                    zzjzVar.b(bArr, i8 + min, i7 - min);
                    if (min > 0) {
                        this.n.a(bArr, i8, min);
                    }
                    this.R += i7;
                    this.j.c(0);
                    this.Y = this.j.o();
                    this.i.c(0);
                    zzkhVar.a(this.i, 4);
                    this.Z += 4;
                } else {
                    this.Y -= a(zzjzVar, zzkhVar, this.Y);
                }
            }
        } else {
            while (this.R < c2) {
                a(zzjzVar, zzkhVar, c2 - this.R);
            }
        }
        if ("A_VORBIS".equals(azgVar.a)) {
            this.l.c(0);
            zzkhVar.a(this.l, 4);
            this.Z += 4;
        }
    }

    private final int a(zzjz zzjzVar, zzkh zzkhVar, int i) throws IOException, InterruptedException {
        int a2;
        int b2 = this.n.b();
        if (b2 > 0) {
            a2 = Math.min(i, b2);
            zzkhVar.a(this.n, a2);
        } else {
            a2 = zzkhVar.a(zzjzVar, i, false);
        }
        this.R += a2;
        this.Z += a2;
        return a2;
    }

    private final long a(long j) throws zzhw {
        if (this.u == -9223372036854775807L) {
            throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
        }
        return zzpt.a(j, this.u, 1000L);
    }

    private static int[] a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
