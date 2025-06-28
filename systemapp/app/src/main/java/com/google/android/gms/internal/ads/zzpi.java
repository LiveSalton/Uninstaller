package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpi {
    public static final byte[] a = {0, 0, 0, 1};
    private static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object c = new Object();
    private static int[] d = new int[10];

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    if (d.length <= i4) {
                        d = Arrays.copyOf(d, d.length << 1);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean a(String str, byte b2) {
        return ("video/avc".equals(str) && (b2 & 31) == 6) || ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39);
    }

    public static zzpl a(byte[] bArr, int i, int i2) {
        int b2;
        boolean z;
        int i3;
        boolean z2;
        float f;
        int i4;
        int i5;
        zzpm zzpmVar = new zzpm(bArr, i, i2);
        zzpmVar.a(8);
        int b3 = zzpmVar.b(8);
        zzpmVar.a(16);
        int b4 = zzpmVar.b();
        if (b3 == 100 || b3 == 110 || b3 == 122 || b3 == 244 || b3 == 44 || b3 == 83 || b3 == 86 || b3 == 118 || b3 == 128 || b3 == 138) {
            b2 = zzpmVar.b();
            boolean a2 = b2 == 3 ? zzpmVar.a() : false;
            zzpmVar.b();
            zzpmVar.b();
            zzpmVar.a(1);
            if (zzpmVar.a()) {
                int i6 = b2 != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (zzpmVar.a()) {
                        int i8 = i7 < 6 ? 16 : 64;
                        int i9 = 8;
                        int i10 = 8;
                        for (int i11 = 0; i11 < i8; i11++) {
                            if (i9 != 0) {
                                i9 = ((zzpmVar.c() + i10) + 256) % 256;
                            }
                            if (i9 != 0) {
                                i10 = i9;
                            }
                        }
                    }
                    i7++;
                }
            }
            z = a2;
        } else {
            z = false;
            b2 = 1;
        }
        int b5 = zzpmVar.b() + 4;
        int b6 = zzpmVar.b();
        if (b6 == 0) {
            z2 = false;
            i3 = zzpmVar.b() + 4;
        } else if (b6 == 1) {
            boolean a3 = zzpmVar.a();
            zzpmVar.c();
            zzpmVar.c();
            long b7 = zzpmVar.b();
            for (int i12 = 0; i12 < b7; i12++) {
                zzpmVar.b();
            }
            i3 = 0;
            z2 = a3;
        } else {
            i3 = 0;
            z2 = false;
        }
        zzpmVar.b();
        zzpmVar.a(1);
        int b8 = zzpmVar.b() + 1;
        int b9 = zzpmVar.b() + 1;
        boolean a4 = zzpmVar.a();
        int i13 = (2 - (a4 ? 1 : 0)) * b9;
        if (!a4) {
            zzpmVar.a(1);
        }
        zzpmVar.a(1);
        int i14 = b8 << 4;
        int i15 = i13 << 4;
        if (zzpmVar.a()) {
            int b10 = zzpmVar.b();
            int b11 = zzpmVar.b();
            int b12 = zzpmVar.b();
            int b13 = zzpmVar.b();
            if (b2 == 0) {
                i5 = 2 - (a4 ? 1 : 0);
                i4 = 1;
            } else {
                i4 = b2 == 3 ? 1 : 2;
                i5 = (2 - (a4 ? 1 : 0)) * (b2 == 1 ? 2 : 1);
            }
            i14 -= (b10 + b11) * i4;
            i15 -= (b12 + b13) * i5;
        }
        int i16 = i14;
        int i17 = i15;
        float f2 = 1.0f;
        if (zzpmVar.a() && zzpmVar.a()) {
            int b14 = zzpmVar.b(8);
            if (b14 == 255) {
                int b15 = zzpmVar.b(16);
                int b16 = zzpmVar.b(16);
                if (b15 != 0 && b16 != 0) {
                    f2 = b15 / b16;
                }
            } else {
                if (b14 < b.length) {
                    f = b[b14];
                    return new zzpl(b4, i16, i17, f, z, a4, b5, b6, i3, z2);
                }
                StringBuilder sb = new StringBuilder(46);
                sb.append("Unexpected aspect_ratio_idc value: ");
                sb.append(b14);
                Log.w("NalUnitUtil", sb.toString());
            }
        }
        f = f2;
        return new zzpl(b4, i16, i17, f, z, a4, b5, b6, i3, z2);
    }
}
