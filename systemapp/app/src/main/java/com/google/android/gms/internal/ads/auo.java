package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: source */
/* loaded from: classes.dex */
final class auo<T> implements avd<T> {
    private static final int[] a = new int[0];
    private static final Unsafe b = avz.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzels g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final aus o;
    private final atz p;
    private final avw<?, ?> q;
    private final atk<?> r;
    private final auh s;

    private auo(int[] iArr, Object[] objArr, int i, int i2, zzels zzelsVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, aus ausVar, atz atzVar, avw<?, ?> avwVar, atk<?> atkVar, auh auhVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzelsVar instanceof zzekh;
        this.j = z;
        this.h = atkVar != null && atkVar.a(zzelsVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = ausVar;
        this.p = atzVar;
        this.q = avwVar;
        this.r = atkVar;
        this.g = zzelsVar;
        this.s = auhVar;
    }

    private static boolean f(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> auo<T> a(Class<T> cls, aul aulVar, aus ausVar, atz atzVar, avw<?, ?> avwVar, atk<?> atkVar, auh auhVar) {
        int i;
        int i2;
        char charAt;
        int i3;
        int i4;
        int i5;
        char charAt2;
        int i6;
        int charAt3;
        int i7;
        int[] iArr;
        int i8;
        int i9;
        int i10;
        char c;
        int i11;
        char charAt4;
        int i12;
        char charAt5;
        int i13;
        char charAt6;
        char charAt7;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        int i14;
        int i15;
        int[] iArr2;
        int i16;
        int objectFieldOffset;
        char c2;
        int i17;
        int i18;
        int i19;
        Field a2;
        char charAt12;
        int i20;
        int i21;
        int i22;
        Field a3;
        Field a4;
        char charAt13;
        int i23;
        char charAt14;
        int i24;
        char charAt15;
        char charAt16;
        if (aulVar instanceof auy) {
            auy auyVar = (auy) aulVar;
            boolean z = auyVar.a() == zzemd.b;
            String d = auyVar.d();
            int length = d.length();
            if (d.charAt(0) >= 55296) {
                int i25 = 1;
                while (true) {
                    i = i25 + 1;
                    if (d.charAt(i25) < 55296) {
                        break;
                    }
                    i25 = i;
                }
            } else {
                i = 1;
            }
            int i26 = i + 1;
            int charAt17 = d.charAt(i);
            if (charAt17 >= 55296) {
                int i27 = charAt17 & 8191;
                int i28 = 13;
                while (true) {
                    i2 = i26 + 1;
                    charAt16 = d.charAt(i26);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i27 |= (charAt16 & 8191) << i28;
                    i28 += 13;
                    i26 = i2;
                }
                charAt17 = i27 | (charAt16 << i28);
            } else {
                i2 = i26;
            }
            if (charAt17 == 0) {
                charAt = 0;
                c = 0;
                charAt2 = 0;
                charAt3 = 0;
                i9 = 0;
                i10 = 0;
                iArr = a;
                i8 = 0;
            } else {
                int i29 = i2 + 1;
                charAt = d.charAt(i2);
                if (charAt >= 55296) {
                    int i30 = charAt & 8191;
                    int i31 = 13;
                    while (true) {
                        i3 = i29 + 1;
                        charAt11 = d.charAt(i29);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i30 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i29 = i3;
                    }
                    charAt = ((charAt11 << i31) | i30) == true ? 1 : 0;
                } else {
                    i3 = i29;
                }
                int i32 = i3 + 1;
                int charAt18 = d.charAt(i3);
                if (charAt18 >= 55296) {
                    int i33 = charAt18 & 8191;
                    int i34 = 13;
                    while (true) {
                        i4 = i32 + 1;
                        charAt10 = d.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i33 |= (charAt10 & 8191) << i34;
                        i34 += 13;
                        i32 = i4;
                    }
                    charAt18 = i33 | (charAt10 << i34);
                } else {
                    i4 = i32;
                }
                int i35 = i4 + 1;
                char charAt19 = d.charAt(i4);
                if (charAt19 >= 55296) {
                    int i36 = charAt19 & 8191;
                    int i37 = 13;
                    while (true) {
                        i5 = i35 + 1;
                        charAt9 = d.charAt(i35);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i36 |= (charAt9 & 8191) << i37;
                        i37 += 13;
                        i35 = i5;
                    }
                    charAt19 = ((charAt9 << i37) | i36) == true ? 1 : 0;
                } else {
                    i5 = i35;
                }
                int i38 = i5 + 1;
                charAt2 = d.charAt(i5);
                if (charAt2 >= 55296) {
                    int i39 = charAt2 & 8191;
                    int i40 = 13;
                    while (true) {
                        i6 = i38 + 1;
                        charAt8 = d.charAt(i38);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i39 |= (charAt8 & 8191) << i40;
                        i40 += 13;
                        i38 = i6;
                    }
                    charAt2 = ((charAt8 << i40) | i39) == true ? 1 : 0;
                } else {
                    i6 = i38;
                }
                int i41 = i6 + 1;
                charAt3 = d.charAt(i6);
                if (charAt3 >= 55296) {
                    int i42 = charAt3 & 8191;
                    int i43 = 13;
                    while (true) {
                        i7 = i41 + 1;
                        charAt7 = d.charAt(i41);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i42 |= (charAt7 & 8191) << i43;
                        i43 += 13;
                        i41 = i7;
                    }
                    charAt3 = (charAt7 << i43) | i42;
                } else {
                    i7 = i41;
                }
                int i44 = i7 + 1;
                int charAt20 = d.charAt(i7);
                if (charAt20 >= 55296) {
                    int i45 = charAt20 & 8191;
                    int i46 = 13;
                    while (true) {
                        i13 = i44 + 1;
                        charAt6 = d.charAt(i44);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i45 |= (charAt6 & 8191) << i46;
                        i46 += 13;
                        i44 = i13;
                    }
                    charAt20 = (charAt6 << i46) | i45;
                    i44 = i13;
                }
                int i47 = i44 + 1;
                int charAt21 = d.charAt(i44);
                if (charAt21 >= 55296) {
                    int i48 = charAt21 & 8191;
                    int i49 = 13;
                    while (true) {
                        i12 = i47 + 1;
                        charAt5 = d.charAt(i47);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i48 |= (charAt5 & 8191) << i49;
                        i49 += 13;
                        i47 = i12;
                    }
                    charAt21 = i48 | (charAt5 << i49);
                    i47 = i12;
                }
                int i50 = i47 + 1;
                int charAt22 = d.charAt(i47);
                if (charAt22 >= 55296) {
                    int i51 = 13;
                    int i52 = charAt22 & 8191;
                    int i53 = i50;
                    while (true) {
                        i11 = i53 + 1;
                        charAt4 = d.charAt(i53);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i52 |= (charAt4 & 8191) << i51;
                        i51 += 13;
                        i53 = i11;
                    }
                    charAt22 = i52 | (charAt4 << i51);
                    i50 = i11;
                }
                int i54 = i50;
                iArr = new int[charAt22 + charAt20 + charAt21];
                i8 = charAt20;
                i9 = charAt22;
                i10 = (charAt << 1) + charAt18;
                c = charAt19;
                i2 = i54;
            }
            Unsafe unsafe = b;
            Object[] e = auyVar.e();
            Class<?> cls2 = auyVar.c().getClass();
            int[] iArr3 = new int[charAt3 * 3];
            Object[] objArr = new Object[charAt3 << 1];
            int i55 = i9 + i8;
            int i56 = i9;
            int i57 = i10;
            int i58 = i55;
            int i59 = 0;
            int i60 = 0;
            while (i2 < length) {
                int i61 = i2 + 1;
                int charAt23 = d.charAt(i2);
                char c3 = 55296;
                if (charAt23 >= 55296) {
                    int i62 = 13;
                    int i63 = charAt23 & 8191;
                    int i64 = i61;
                    while (true) {
                        i24 = i64 + 1;
                        charAt15 = d.charAt(i64);
                        if (charAt15 < c3) {
                            break;
                        }
                        i63 |= (charAt15 & 8191) << i62;
                        i62 += 13;
                        i64 = i24;
                        c3 = 55296;
                    }
                    charAt23 = i63 | (charAt15 << i62);
                    i14 = i24;
                } else {
                    i14 = i61;
                }
                int i65 = i14 + 1;
                int charAt24 = d.charAt(i14);
                int i66 = length;
                char c4 = 55296;
                if (charAt24 >= 55296) {
                    int i67 = 13;
                    int i68 = charAt24 & 8191;
                    int i69 = i65;
                    while (true) {
                        i23 = i69 + 1;
                        charAt14 = d.charAt(i69);
                        if (charAt14 < c4) {
                            break;
                        }
                        i68 |= (charAt14 & 8191) << i67;
                        i67 += 13;
                        i69 = i23;
                        c4 = 55296;
                    }
                    charAt24 = i68 | (charAt14 << i67);
                    i15 = i23;
                } else {
                    i15 = i65;
                }
                int i70 = i9;
                int i71 = charAt24 & 255;
                char c5 = charAt2;
                if ((charAt24 & 1024) != 0) {
                    iArr[i59] = i60;
                    i59++;
                }
                int i72 = i59;
                if (i71 >= 51) {
                    int i73 = i15 + 1;
                    int charAt25 = d.charAt(i15);
                    char c6 = 55296;
                    if (charAt25 >= 55296) {
                        int i74 = charAt25 & 8191;
                        int i75 = 13;
                        while (true) {
                            i20 = i73 + 1;
                            charAt13 = d.charAt(i73);
                            if (charAt13 < c6) {
                                break;
                            }
                            i74 |= (charAt13 & 8191) << i75;
                            i75 += 13;
                            i73 = i20;
                            c6 = 55296;
                        }
                        charAt25 = i74 | (charAt13 << i75);
                    } else {
                        i20 = i73;
                    }
                    int i76 = i71 - 51;
                    if (i76 == 9 || i76 == 17) {
                        i21 = 1;
                        i22 = i57 + 1;
                        objArr[((i60 / 3) << 1) + 1] = e[i57];
                    } else {
                        if (i76 != 12 || z) {
                            i22 = i57;
                        } else {
                            objArr[((i60 / 3) << 1) + 1] = e[i57];
                            i22 = i57 + 1;
                        }
                        i21 = 1;
                    }
                    int i77 = charAt25 << i21;
                    Object obj = e[i77];
                    if (obj instanceof Field) {
                        a3 = (Field) obj;
                    } else {
                        a3 = a(cls2, (String) obj);
                        e[i77] = a3;
                    }
                    iArr2 = iArr3;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(a3);
                    int i78 = i77 + 1;
                    Object obj2 = e[i78];
                    if (obj2 instanceof Field) {
                        a4 = (Field) obj2;
                    } else {
                        a4 = a(cls2, (String) obj2);
                        e[i78] = a4;
                    }
                    i17 = (int) unsafe.objectFieldOffset(a4);
                    c2 = charAt;
                    i57 = i22;
                    i18 = i20;
                    objectFieldOffset = objectFieldOffset2;
                    i19 = 0;
                } else {
                    iArr2 = iArr3;
                    int i79 = i57 + 1;
                    Field a5 = a(cls2, (String) e[i57]);
                    if (i71 == 9 || i71 == 17) {
                        objArr[((i60 / 3) << 1) + 1] = a5.getType();
                    } else {
                        if (i71 == 27 || i71 == 49) {
                            i16 = i79 + 1;
                            objArr[((i60 / 3) << 1) + 1] = e[i79];
                        } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                            if (!z) {
                                i16 = i79 + 1;
                                objArr[((i60 / 3) << 1) + 1] = e[i79];
                            }
                        } else if (i71 == 50) {
                            int i80 = i56 + 1;
                            iArr[i56] = i60;
                            int i81 = (i60 / 3) << 1;
                            int i82 = i79 + 1;
                            objArr[i81] = e[i79];
                            if ((charAt24 & 2048) != 0) {
                                objArr[i81 + 1] = e[i82];
                                i16 = i82 + 1;
                            } else {
                                i16 = i82;
                            }
                            i56 = i80;
                        }
                        objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                        if ((charAt24 & 4096) == 4096 || i71 > 17) {
                            c2 = charAt;
                            i17 = 1048575;
                            i18 = i15;
                            i19 = 0;
                        } else {
                            int i83 = i15 + 1;
                            int charAt26 = d.charAt(i15);
                            if (charAt26 >= 55296) {
                                int i84 = charAt26 & 8191;
                                int i85 = 13;
                                while (true) {
                                    i18 = i83 + 1;
                                    charAt12 = d.charAt(i83);
                                    if (charAt12 < 55296) {
                                        break;
                                    }
                                    i84 |= (charAt12 & 8191) << i85;
                                    i85 += 13;
                                    i83 = i18;
                                }
                                charAt26 = i84 | (charAt12 << i85);
                            } else {
                                i18 = i83;
                            }
                            int i86 = (charAt << 1) + (charAt26 / 32);
                            Object obj3 = e[i86];
                            if (obj3 instanceof Field) {
                                a2 = (Field) obj3;
                            } else {
                                a2 = a(cls2, (String) obj3);
                                e[i86] = a2;
                            }
                            c2 = charAt;
                            i17 = (int) unsafe.objectFieldOffset(a2);
                            i19 = charAt26 % 32;
                        }
                        if (i71 >= 18 && i71 <= 49) {
                            iArr[i58] = objectFieldOffset;
                            i58++;
                        }
                        i57 = i16;
                    }
                    i16 = i79;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(a5);
                    if ((charAt24 & 4096) == 4096) {
                    }
                    c2 = charAt;
                    i17 = 1048575;
                    i18 = i15;
                    i19 = 0;
                    if (i71 >= 18) {
                        iArr[i58] = objectFieldOffset;
                        i58++;
                    }
                    i57 = i16;
                }
                int i87 = i60 + 1;
                iArr2[i60] = charAt23;
                int i88 = i87 + 1;
                iArr2[i87] = ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (i71 << 20) | objectFieldOffset;
                i60 = i88 + 1;
                iArr2[i88] = (i19 << 20) | i17;
                i2 = i18;
                length = i66;
                i9 = i70;
                charAt2 = c5;
                i59 = i72;
                iArr3 = iArr2;
                charAt = c2;
            }
            return new auo<>(iArr3, objArr, c, charAt2, auyVar.c(), z, false, iArr, i9, i55, ausVar, atzVar, avwVar, atkVar, auhVar);
        }
        ((avt) aulVar).a();
        int i89 = zzemd.b;
        throw new NoSuchMethodError();
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(40 + String.valueOf(str).length() + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (com.google.android.gms.internal.ads.avf.a(com.google.android.gms.internal.ads.avz.f(r10, r6), com.google.android.gms.internal.ads.avz.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.ads.avz.b(r10, r6) == com.google.android.gms.internal.ads.avz.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (com.google.android.gms.internal.ads.avz.b(r10, r6) == com.google.android.gms.internal.ads.avz.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (com.google.android.gms.internal.ads.avf.a(com.google.android.gms.internal.ads.avz.f(r10, r6), com.google.android.gms.internal.ads.avz.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (com.google.android.gms.internal.ads.avf.a(com.google.android.gms.internal.ads.avz.f(r10, r6), com.google.android.gms.internal.ads.avz.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (com.google.android.gms.internal.ads.avf.a(com.google.android.gms.internal.ads.avz.f(r10, r6), com.google.android.gms.internal.ads.avz.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (com.google.android.gms.internal.ads.avz.c(r10, r6) == com.google.android.gms.internal.ads.avz.c(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (com.google.android.gms.internal.ads.avz.b(r10, r6) == com.google.android.gms.internal.ads.avz.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (com.google.android.gms.internal.ads.avz.a(r10, r6) == com.google.android.gms.internal.ads.avz.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (com.google.android.gms.internal.ads.avz.b(r10, r6) == com.google.android.gms.internal.ads.avz.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (com.google.android.gms.internal.ads.avz.b(r10, r6) == com.google.android.gms.internal.ads.avz.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.avz.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.avz.d(r11, r6))) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.avz.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.avz.e(r11, r6))) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.ads.avf.a(com.google.android.gms.internal.ads.avz.f(r10, r6), com.google.android.gms.internal.ads.avz.f(r11, r6)) != false) goto L223;
     */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int d = d(i2);
            int i3 = this.c[i2];
            long j = 1048575 & d;
            switch ((d & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzekk.a(Double.doubleToLongBits(avz.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(avz.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzekk.a(avz.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzekk.a(avz.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzekk.a(avz.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzekk.a(avz.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) avz.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = avz.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + avz.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzekk.a(avz.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + avz.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzekk.a(avz.b(t, j));
                    break;
                case 17:
                    Object f2 = avz.f(t, j);
                    i = (i * 53) + (f2 != null ? f2.hashCode() : 37);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + avz.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + avz.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(Double.doubleToLongBits(b(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(c(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(f(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + ((String) avz.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + avz.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + avz.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + zzekk.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((auo<T>) t, i3, i2)) {
                        i = (i * 53) + avz.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.q.b(t).hashCode();
        return this.h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.c.length; i += 3) {
            int d = d(i);
            long j = 1048575 & d;
            int i2 = this.c[i];
            switch ((d & 267386880) >>> 20) {
                case 0:
                    if (a((auo<T>) t2, i)) {
                        avz.a(t, j, avz.e(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.d(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.b(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.b(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.b(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((auo<T>) t2, i)) {
                        avz.a(t, j, avz.c(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((auo<T>) t2, i)) {
                        avz.a(t, j, avz.f(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((auo<T>) t2, i)) {
                        avz.a(t, j, avz.f(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.b(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.a(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((auo<T>) t2, i)) {
                        avz.a((Object) t, j, avz.b(t2, j));
                        b((auo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    a(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.a(t, t2, j);
                    break;
                case 50:
                    avf.a(this.s, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (a((auo<T>) t2, i2, i)) {
                        avz.a(t, j, avz.f(t2, j));
                        b((auo<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    b(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (a((auo<T>) t2, i2, i)) {
                        avz.a(t, j, avz.f(t2, j));
                        b((auo<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i);
                    break;
            }
        }
        avf.a(this.q, t, t2);
        if (this.h) {
            avf.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long d = d(i) & 1048575;
        if (a((auo<T>) t2, i)) {
            Object f = avz.f(t, d);
            Object f2 = avz.f(t2, d);
            if (f != null && f2 != null) {
                avz.a(t, d, zzekk.a(f, f2));
                b((auo<T>) t, i);
            } else if (f2 != null) {
                avz.a(t, d, f2);
                b((auo<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int d = d(i);
        int i2 = this.c[i];
        long j = d & 1048575;
        if (a((auo<T>) t2, i2, i)) {
            Object f = avz.f(t, j);
            Object f2 = avz.f(t2, j);
            if (f != null && f2 != null) {
                avz.a(t, j, zzekk.a(f, f2));
                b((auo<T>) t, i2, i);
            } else if (f2 != null) {
                avz.a(t, j, f2);
                b((auo<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.avd
    public final int b(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int i4 = 267386880;
        int i5 = 1048575;
        int i6 = 1;
        int i7 = 0;
        if (this.j) {
            Unsafe unsafe = b;
            int i8 = 0;
            int i9 = 0;
            while (i8 < this.c.length) {
                int d = d(i8);
                int i10 = (d & i4) >>> 20;
                int i11 = this.c[i8];
                long j2 = d & 1048575;
                if (i10 >= zzekc.DOUBLE_LIST_PACKED.a() && i10 <= zzekc.SINT64_LIST_PACKED.a()) {
                    int i12 = this.c[i8 + 2];
                }
                switch (i10) {
                    case 0:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.b(i11, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.b(i11, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.d(i11, avz.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.e(i11, avz.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.f(i11, avz.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.g(i11, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.i(i11, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.b(i11, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (a((auo<T>) t, i8)) {
                            Object f = avz.f(t, j2);
                            if (f instanceof zzeiu) {
                                i9 += zzejo.c(i11, (zzeiu) f);
                                break;
                            } else {
                                i9 += zzejo.b(i11, (String) f);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (a((auo<T>) t, i8)) {
                            i9 += avf.a(i11, avz.f(t, j2), a(i8));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.c(i11, (zzeiu) avz.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.g(i11, avz.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.k(i11, avz.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.j(i11, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.h(i11, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.h(i11, avz.a(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.f(i11, avz.b(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (a((auo<T>) t, i8)) {
                            i9 += zzejo.c(i11, (zzels) avz.f(t, j2), a(i8));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i9 += avf.i(i11, a(t, j2), false);
                        break;
                    case 19:
                        i9 += avf.h(i11, a(t, j2), false);
                        break;
                    case 20:
                        i9 += avf.a(i11, (List<Long>) a(t, j2), false);
                        break;
                    case 21:
                        i9 += avf.b(i11, (List<Long>) a(t, j2), false);
                        break;
                    case 22:
                        i9 += avf.e(i11, a(t, j2), false);
                        break;
                    case 23:
                        i9 += avf.i(i11, a(t, j2), false);
                        break;
                    case 24:
                        i9 += avf.h(i11, a(t, j2), false);
                        break;
                    case 25:
                        i9 += avf.j(i11, a(t, j2), false);
                        break;
                    case 26:
                        i9 += avf.a(i11, a(t, j2));
                        break;
                    case 27:
                        i9 += avf.a(i11, a(t, j2), a(i8));
                        break;
                    case 28:
                        i9 += avf.b(i11, a(t, j2));
                        break;
                    case 29:
                        i9 += avf.f(i11, a(t, j2), false);
                        break;
                    case 30:
                        i9 += avf.d(i11, a(t, j2), false);
                        break;
                    case 31:
                        i9 += avf.h(i11, a(t, j2), false);
                        break;
                    case 32:
                        i9 += avf.i(i11, a(t, j2), false);
                        break;
                    case 33:
                        i9 += avf.g(i11, a(t, j2), false);
                        break;
                    case 34:
                        i9 += avf.c(i11, a(t, j2), false);
                        break;
                    case 35:
                        int i13 = avf.i((List) unsafe.getObject(t, j2));
                        if (i13 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(i13) + i13;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int h = avf.h((List) unsafe.getObject(t, j2));
                        if (h > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(h) + h;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int a2 = avf.a((List<Long>) unsafe.getObject(t, j2));
                        if (a2 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(a2) + a2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int b2 = avf.b((List) unsafe.getObject(t, j2));
                        if (b2 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(b2) + b2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int e = avf.e((List) unsafe.getObject(t, j2));
                        if (e > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(e) + e;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int i14 = avf.i((List) unsafe.getObject(t, j2));
                        if (i14 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(i14) + i14;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int h2 = avf.h((List) unsafe.getObject(t, j2));
                        if (h2 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(h2) + h2;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int j3 = avf.j((List) unsafe.getObject(t, j2));
                        if (j3 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(j3) + j3;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int f2 = avf.f((List) unsafe.getObject(t, j2));
                        if (f2 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(f2) + f2;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        int d2 = avf.d((List) unsafe.getObject(t, j2));
                        if (d2 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(d2) + d2;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int h3 = avf.h((List) unsafe.getObject(t, j2));
                        if (h3 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(h3) + h3;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        int i15 = avf.i((List) unsafe.getObject(t, j2));
                        if (i15 > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(i15) + i15;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int g = avf.g((List) unsafe.getObject(t, j2));
                        if (g > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(g) + g;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int c = avf.c((List) unsafe.getObject(t, j2));
                        if (c > 0) {
                            i9 += zzejo.e(i11) + zzejo.g(c) + c;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i9 += avf.b(i11, (List<zzels>) a(t, j2), a(i8));
                        break;
                    case 50:
                        i9 += this.s.a(i11, avz.f(t, j2), b(i8));
                        break;
                    case 51:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.b(i11, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.b(i11, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.d(i11, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.e(i11, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.f(i11, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.g(i11, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.i(i11, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.b(i11, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (a((auo<T>) t, i11, i8)) {
                            Object f3 = avz.f(t, j2);
                            if (f3 instanceof zzeiu) {
                                i9 += zzejo.c(i11, (zzeiu) f3);
                                break;
                            } else {
                                i9 += zzejo.b(i11, (String) f3);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += avf.a(i11, avz.f(t, j2), a(i8));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.c(i11, (zzeiu) avz.f(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.g(i11, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.k(i11, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.j(i11, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.h(i11, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.h(i11, d(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.f(i11, e(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (a((auo<T>) t, i11, i8)) {
                            i9 += zzejo.c(i11, (zzels) avz.f(t, j2), a(i8));
                            break;
                        } else {
                            break;
                        }
                }
                i8 += 3;
                i4 = 267386880;
            }
            return i9 + a((avw) this.q, (Object) t);
        }
        Unsafe unsafe2 = b;
        int i16 = 1048575;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < this.c.length) {
            int d3 = d(i17);
            int i20 = this.c[i17];
            int i21 = (d3 & 267386880) >>> 20;
            if (i21 <= 17) {
                int i22 = this.c[i17 + 2];
                int i23 = i22 & i5;
                i = i6 << (i22 >>> 20);
                if (i23 != i16) {
                    i19 = unsafe2.getInt(t, i23);
                    i16 = i23;
                }
            } else {
                i = 0;
            }
            long j4 = d3 & i5;
            switch (i21) {
                case 0:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.b(i20, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.b(i20, 0.0f);
                    }
                    break;
                case 2:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.d(i20, unsafe2.getLong(t, j4));
                    }
                    break;
                case 3:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.e(i20, unsafe2.getLong(t, j4));
                    }
                    break;
                case 4:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.f(i20, unsafe2.getInt(t, j4));
                    }
                    break;
                case 5:
                    i2 = 1;
                    i7 = 0;
                    if ((i & i19) != 0) {
                        i18 += zzejo.g(i20, 0L);
                        j = 0;
                        break;
                    }
                    j = 0;
                    break;
                case 6:
                    i2 = 1;
                    if ((i & i19) != 0) {
                        i7 = 0;
                        i18 += zzejo.i(i20, 0);
                    } else {
                        i7 = 0;
                    }
                    j = 0;
                    break;
                case 7:
                    if ((i & i19) != 0) {
                        i2 = 1;
                        i18 += zzejo.b(i20, true);
                    } else {
                        i2 = 1;
                    }
                    i7 = 0;
                    j = 0;
                    break;
                case 8:
                    if ((i & i19) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzeiu) {
                            i18 += zzejo.c(i20, (zzeiu) object);
                        } else {
                            i18 += zzejo.b(i20, (String) object);
                        }
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 9:
                    if ((i & i19) != 0) {
                        i18 += avf.a(i20, unsafe2.getObject(t, j4), a(i17));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 10:
                    if ((i & i19) != 0) {
                        i18 += zzejo.c(i20, (zzeiu) unsafe2.getObject(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 11:
                    if ((i & i19) != 0) {
                        i18 += zzejo.g(i20, unsafe2.getInt(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 12:
                    if ((i & i19) != 0) {
                        i18 += zzejo.k(i20, unsafe2.getInt(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 13:
                    if ((i & i19) != 0) {
                        i18 += zzejo.j(i20, 0);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 14:
                    if ((i & i19) != 0) {
                        i18 += zzejo.h(i20, 0L);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 15:
                    if ((i & i19) != 0) {
                        i18 += zzejo.h(i20, unsafe2.getInt(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 16:
                    if ((i & i19) != 0) {
                        i18 += zzejo.f(i20, unsafe2.getLong(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 17:
                    if ((i & i19) != 0) {
                        i18 += zzejo.c(i20, (zzels) unsafe2.getObject(t, j4), a(i17));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 18:
                    i18 += avf.i(i20, (List) unsafe2.getObject(t, j4), false);
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i18 += avf.h(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i18 += avf.a(i20, (List<Long>) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i18 += avf.b(i20, (List<Long>) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i18 += avf.e(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i18 += avf.i(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i18 += avf.h(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i18 += avf.j(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 26:
                    i18 += avf.a(i20, (List<?>) unsafe2.getObject(t, j4));
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 27:
                    i18 += avf.a(i20, (List<?>) unsafe2.getObject(t, j4), a(i17));
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 28:
                    i18 += avf.b(i20, (List) unsafe2.getObject(t, j4));
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 29:
                    i18 += avf.f(i20, (List) unsafe2.getObject(t, j4), false);
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i18 += avf.d(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i18 += avf.h(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i18 += avf.i(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i18 += avf.g(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i18 += avf.c(i20, (List) unsafe2.getObject(t, j4), false);
                    i7 = i3;
                    i2 = 1;
                    j = 0;
                    break;
                case 35:
                    int i24 = avf.i((List) unsafe2.getObject(t, j4));
                    if (i24 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(i24) + i24;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 36:
                    int h4 = avf.h((List) unsafe2.getObject(t, j4));
                    if (h4 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(h4) + h4;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 37:
                    int a3 = avf.a((List<Long>) unsafe2.getObject(t, j4));
                    if (a3 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(a3) + a3;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 38:
                    int b3 = avf.b((List) unsafe2.getObject(t, j4));
                    if (b3 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(b3) + b3;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 39:
                    int e2 = avf.e((List) unsafe2.getObject(t, j4));
                    if (e2 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(e2) + e2;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 40:
                    int i25 = avf.i((List) unsafe2.getObject(t, j4));
                    if (i25 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(i25) + i25;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 41:
                    int h5 = avf.h((List) unsafe2.getObject(t, j4));
                    if (h5 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(h5) + h5;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 42:
                    int j5 = avf.j((List) unsafe2.getObject(t, j4));
                    if (j5 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(j5) + j5;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 43:
                    int f4 = avf.f((List) unsafe2.getObject(t, j4));
                    if (f4 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(f4) + f4;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 44:
                    int d4 = avf.d((List) unsafe2.getObject(t, j4));
                    if (d4 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(d4) + d4;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 45:
                    int h6 = avf.h((List) unsafe2.getObject(t, j4));
                    if (h6 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(h6) + h6;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 46:
                    int i26 = avf.i((List) unsafe2.getObject(t, j4));
                    if (i26 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(i26) + i26;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 47:
                    int g2 = avf.g((List) unsafe2.getObject(t, j4));
                    if (g2 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(g2) + g2;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 48:
                    int c2 = avf.c((List) unsafe2.getObject(t, j4));
                    if (c2 > 0) {
                        i18 += zzejo.e(i20) + zzejo.g(c2) + c2;
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 49:
                    i18 += avf.b(i20, (List<zzels>) unsafe2.getObject(t, j4), a(i17));
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 50:
                    i18 += this.s.a(i20, unsafe2.getObject(t, j4), b(i17));
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 51:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.b(i20, 0.0d);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 52:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.b(i20, 0.0f);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 53:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.d(i20, e(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 54:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.e(i20, e(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 55:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.f(i20, d(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 56:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.g(i20, 0L);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 57:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.i(i20, 0);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 58:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.b(i20, true);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 59:
                    if (a((auo<T>) t, i20, i17)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzeiu) {
                            i18 += zzejo.c(i20, (zzeiu) object2);
                        } else {
                            i18 += zzejo.b(i20, (String) object2);
                        }
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 60:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += avf.a(i20, unsafe2.getObject(t, j4), a(i17));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 61:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.c(i20, (zzeiu) unsafe2.getObject(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 62:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.g(i20, d(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 63:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.k(i20, d(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 64:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.j(i20, 0);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 65:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.h(i20, 0L);
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 66:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.h(i20, d(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 67:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.f(i20, e(t, j4));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                case 68:
                    if (a((auo<T>) t, i20, i17)) {
                        i18 += zzejo.c(i20, (zzels) unsafe2.getObject(t, j4), a(i17));
                    }
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
                default:
                    i2 = 1;
                    i7 = 0;
                    j = 0;
                    break;
            }
            i17 += 3;
            i6 = i2;
            i5 = 1048575;
        }
        int a4 = i18 + a((avw) this.q, (Object) t);
        if (!this.h) {
            return a4;
        }
        atl<?> a5 = this.r.a(t);
        int i27 = i7;
        while (i7 < a5.a.c()) {
            Map.Entry<?, Object> b4 = a5.a.b(i7);
            i27 += atl.a((zzejz<?>) b4.getKey(), b4.getValue());
            i7++;
        }
        for (Map.Entry<?, Object> entry : a5.a.d()) {
            i27 += atl.a((zzejz<?>) entry.getKey(), entry.getValue());
        }
        return a4 + i27;
    }

    private static <UT, UB> int a(avw<UT, UB> avwVar, T t) {
        return avwVar.f(avwVar.b(t));
    }

    private static List<?> a(Object obj, long j) {
        return (List) avz.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2b  */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r14, com.google.android.gms.internal.ads.awo r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.a(java.lang.Object, com.google.android.gms.internal.ads.awo):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:232:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(T r20, com.google.android.gms.internal.ads.awo r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.b(java.lang.Object, com.google.android.gms.internal.ads.awo):void");
    }

    private final <K, V> void a(awo awoVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            awoVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(avw<UT, UB> avwVar, T t, awo awoVar) throws IOException {
        avwVar.a((avw<UT, UB>) avwVar.b(t), awoVar);
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void a(T t, aux auxVar, zzeju zzejuVar) throws IOException {
        Object a2;
        if (zzejuVar == null) {
            throw new NullPointerException();
        }
        avw avwVar = this.q;
        atk<?> atkVar = this.r;
        atl<?> atlVar = null;
        Object obj = null;
        while (true) {
            try {
                int a3 = auxVar.a();
                int g = g(a3);
                if (g < 0) {
                    if (a3 == Integer.MAX_VALUE) {
                        for (int i = this.m; i < this.n; i++) {
                            obj = a((Object) t, this.l[i], (int) obj, (avw<UT, int>) avwVar);
                        }
                        if (obj != null) {
                            avwVar.b((Object) t, (T) obj);
                            return;
                        }
                        return;
                    }
                    Object a4 = !this.h ? null : atkVar.a(zzejuVar, this.g, a3);
                    if (a4 != null) {
                        if (atlVar == null) {
                            atlVar = atkVar.b(t);
                        }
                        atl<?> atlVar2 = atlVar;
                        obj = atkVar.a(auxVar, a4, zzejuVar, atlVar2, obj, avwVar);
                        atlVar = atlVar2;
                    } else {
                        avwVar.a(auxVar);
                        if (obj == null) {
                            obj = avwVar.c(t);
                        }
                        if (!avwVar.a((avw) obj, auxVar)) {
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                obj = a((Object) t, this.l[i2], (int) obj, (avw<UT, int>) avwVar);
                            }
                            if (obj != null) {
                                avwVar.b((Object) t, (T) obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int d = d(g);
                    switch ((267386880 & d) >>> 20) {
                        case 0:
                            avz.a(t, d & 1048575, auxVar.d());
                            b((auo<T>) t, g);
                            break;
                        case 1:
                            avz.a((Object) t, d & 1048575, auxVar.e());
                            b((auo<T>) t, g);
                            break;
                        case 2:
                            avz.a((Object) t, d & 1048575, auxVar.g());
                            b((auo<T>) t, g);
                            break;
                        case 3:
                            avz.a((Object) t, d & 1048575, auxVar.f());
                            b((auo<T>) t, g);
                            break;
                        case 4:
                            avz.a((Object) t, d & 1048575, auxVar.h());
                            b((auo<T>) t, g);
                            break;
                        case 5:
                            avz.a((Object) t, d & 1048575, auxVar.i());
                            b((auo<T>) t, g);
                            break;
                        case 6:
                            avz.a((Object) t, d & 1048575, auxVar.j());
                            b((auo<T>) t, g);
                            break;
                        case 7:
                            avz.a(t, d & 1048575, auxVar.k());
                            b((auo<T>) t, g);
                            break;
                        case 8:
                            a(t, d, auxVar);
                            b((auo<T>) t, g);
                            break;
                        case 9:
                            if (a((auo<T>) t, g)) {
                                long j = d & 1048575;
                                avz.a(t, j, zzekk.a(avz.f(t, j), auxVar.a(a(g), zzejuVar)));
                                break;
                            } else {
                                avz.a(t, d & 1048575, auxVar.a(a(g), zzejuVar));
                                b((auo<T>) t, g);
                                break;
                            }
                        case 10:
                            avz.a(t, d & 1048575, auxVar.n());
                            b((auo<T>) t, g);
                            break;
                        case 11:
                            avz.a((Object) t, d & 1048575, auxVar.o());
                            b((auo<T>) t, g);
                            break;
                        case 12:
                            int p = auxVar.p();
                            zzekl c = c(g);
                            if (c != null && !c.a(p)) {
                                a2 = avf.a(a3, p, obj, (avw<UT, Object>) avwVar);
                                obj = a2;
                                break;
                            }
                            avz.a((Object) t, d & 1048575, p);
                            b((auo<T>) t, g);
                            break;
                        case 13:
                            avz.a((Object) t, d & 1048575, auxVar.q());
                            b((auo<T>) t, g);
                            break;
                        case 14:
                            avz.a((Object) t, d & 1048575, auxVar.r());
                            b((auo<T>) t, g);
                            break;
                        case 15:
                            avz.a((Object) t, d & 1048575, auxVar.s());
                            b((auo<T>) t, g);
                            break;
                        case 16:
                            avz.a((Object) t, d & 1048575, auxVar.t());
                            b((auo<T>) t, g);
                            break;
                        case 17:
                            if (a((auo<T>) t, g)) {
                                long j2 = d & 1048575;
                                avz.a(t, j2, zzekk.a(avz.f(t, j2), auxVar.b(a(g), zzejuVar)));
                                break;
                            } else {
                                avz.a(t, d & 1048575, auxVar.b(a(g), zzejuVar));
                                b((auo<T>) t, g);
                                break;
                            }
                        case 18:
                            auxVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 19:
                            auxVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 20:
                            auxVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 21:
                            auxVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 22:
                            auxVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 23:
                            auxVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 24:
                            auxVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 25:
                            auxVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 26:
                            if (f(d)) {
                                auxVar.j(this.p.a(t, d & 1048575));
                                break;
                            } else {
                                auxVar.i(this.p.a(t, d & 1048575));
                                break;
                            }
                        case 27:
                            auxVar.a(this.p.a(t, d & 1048575), a(g), zzejuVar);
                            break;
                        case 28:
                            auxVar.k(this.p.a(t, d & 1048575));
                            break;
                        case 29:
                            auxVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 30:
                            List<Integer> a5 = this.p.a(t, d & 1048575);
                            auxVar.m(a5);
                            a2 = avf.a(a3, a5, c(g), obj, avwVar);
                            obj = a2;
                            break;
                        case 31:
                            auxVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 32:
                            auxVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 33:
                            auxVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 34:
                            auxVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 35:
                            auxVar.a(this.p.a(t, d & 1048575));
                            break;
                        case 36:
                            auxVar.b(this.p.a(t, d & 1048575));
                            break;
                        case 37:
                            auxVar.d(this.p.a(t, d & 1048575));
                            break;
                        case 38:
                            auxVar.c(this.p.a(t, d & 1048575));
                            break;
                        case 39:
                            auxVar.e(this.p.a(t, d & 1048575));
                            break;
                        case 40:
                            auxVar.f(this.p.a(t, d & 1048575));
                            break;
                        case 41:
                            auxVar.g(this.p.a(t, d & 1048575));
                            break;
                        case 42:
                            auxVar.h(this.p.a(t, d & 1048575));
                            break;
                        case 43:
                            auxVar.l(this.p.a(t, d & 1048575));
                            break;
                        case 44:
                            List<Integer> a6 = this.p.a(t, d & 1048575);
                            auxVar.m(a6);
                            a2 = avf.a(a3, a6, c(g), obj, avwVar);
                            obj = a2;
                            break;
                        case 45:
                            auxVar.n(this.p.a(t, d & 1048575));
                            break;
                        case 46:
                            auxVar.o(this.p.a(t, d & 1048575));
                            break;
                        case 47:
                            auxVar.p(this.p.a(t, d & 1048575));
                            break;
                        case 48:
                            auxVar.q(this.p.a(t, d & 1048575));
                            break;
                        case 49:
                            auxVar.b(this.p.a(t, d & 1048575), a(g), zzejuVar);
                            break;
                        case 50:
                            Object b2 = b(g);
                            long d2 = d(g) & 1048575;
                            Object f = avz.f(t, d2);
                            if (f == null) {
                                f = this.s.e(b2);
                                avz.a(t, d2, f);
                            } else if (this.s.c(f)) {
                                Object e = this.s.e(b2);
                                this.s.a(e, f);
                                avz.a(t, d2, e);
                                f = e;
                            }
                            auxVar.a(this.s.a(f), this.s.f(b2), zzejuVar);
                            break;
                        case 51:
                            avz.a(t, d & 1048575, Double.valueOf(auxVar.d()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 52:
                            avz.a(t, d & 1048575, Float.valueOf(auxVar.e()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 53:
                            avz.a(t, d & 1048575, Long.valueOf(auxVar.g()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 54:
                            avz.a(t, d & 1048575, Long.valueOf(auxVar.f()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 55:
                            avz.a(t, d & 1048575, Integer.valueOf(auxVar.h()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 56:
                            avz.a(t, d & 1048575, Long.valueOf(auxVar.i()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 57:
                            avz.a(t, d & 1048575, Integer.valueOf(auxVar.j()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 58:
                            avz.a(t, d & 1048575, Boolean.valueOf(auxVar.k()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 59:
                            a(t, d, auxVar);
                            b((auo<T>) t, a3, g);
                            break;
                        case 60:
                            if (a((auo<T>) t, a3, g)) {
                                long j3 = d & 1048575;
                                avz.a(t, j3, zzekk.a(avz.f(t, j3), auxVar.a(a(g), zzejuVar)));
                            } else {
                                avz.a(t, d & 1048575, auxVar.a(a(g), zzejuVar));
                                b((auo<T>) t, g);
                            }
                            b((auo<T>) t, a3, g);
                            break;
                        case 61:
                            avz.a(t, d & 1048575, auxVar.n());
                            b((auo<T>) t, a3, g);
                            break;
                        case 62:
                            avz.a(t, d & 1048575, Integer.valueOf(auxVar.o()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 63:
                            int p2 = auxVar.p();
                            zzekl c2 = c(g);
                            if (c2 != null && !c2.a(p2)) {
                                a2 = avf.a(a3, p2, obj, (avw<UT, Object>) avwVar);
                                obj = a2;
                                break;
                            }
                            avz.a(t, d & 1048575, Integer.valueOf(p2));
                            b((auo<T>) t, a3, g);
                            break;
                        case 64:
                            avz.a(t, d & 1048575, Integer.valueOf(auxVar.q()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 65:
                            avz.a(t, d & 1048575, Long.valueOf(auxVar.r()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 66:
                            avz.a(t, d & 1048575, Integer.valueOf(auxVar.s()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 67:
                            avz.a(t, d & 1048575, Long.valueOf(auxVar.t()));
                            b((auo<T>) t, a3, g);
                            break;
                        case 68:
                            avz.a(t, d & 1048575, auxVar.b(a(g), zzejuVar));
                            b((auo<T>) t, a3, g);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = avwVar.a();
                                } catch (zzekr unused) {
                                    avwVar.a(auxVar);
                                    if (obj == null) {
                                        obj = avwVar.c(t);
                                    }
                                    if (!avwVar.a((avw) obj, auxVar)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            obj = a((Object) t, this.l[i3], (int) obj, (avw<UT, int>) avwVar);
                                        }
                                        if (obj != null) {
                                            avwVar.b((Object) t, (T) obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!avwVar.a((avw) obj, auxVar)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    obj = a((Object) t, this.l[i4], (int) obj, (avw<UT, int>) avwVar);
                                }
                                if (obj != null) {
                                    avwVar.b((Object) t, (T) obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.m; i5 < this.n; i5++) {
                    obj = a((Object) t, this.l[i5], (int) obj, (avw<UT, int>) avwVar);
                }
                if (obj != null) {
                    avwVar.b((Object) t, (T) obj);
                }
                throw th;
            }
        }
    }

    private static zzeni e(Object obj) {
        zzekh zzekhVar = (zzekh) obj;
        zzeni zzeniVar = zzekhVar.zzino;
        if (zzeniVar != zzeni.a()) {
            return zzeniVar;
        }
        zzeni b2 = zzeni.b();
        zzekhVar.zzino = b2;
        return b2;
    }

    private static int a(byte[] bArr, int i, int i2, zzenw zzenwVar, Class<?> cls, asp aspVar) throws IOException {
        switch (aun.a[zzenwVar.ordinal()]) {
            case 1:
                int b2 = asm.b(bArr, i, aspVar);
                aspVar.c = Boolean.valueOf(aspVar.b != 0);
                return b2;
            case 2:
                return asm.e(bArr, i, aspVar);
            case 3:
                aspVar.c = Double.valueOf(asm.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                aspVar.c = Integer.valueOf(asm.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                aspVar.c = Long.valueOf(asm.b(bArr, i));
                return i + 8;
            case 8:
                aspVar.c = Float.valueOf(asm.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int a2 = asm.a(bArr, i, aspVar);
                aspVar.c = Integer.valueOf(aspVar.a);
                return a2;
            case 12:
            case 13:
                int b3 = asm.b(bArr, i, aspVar);
                aspVar.c = Long.valueOf(aspVar.b);
                return b3;
            case 14:
                return asm.a(auw.a().a((Class) cls), bArr, i, i2, aspVar);
            case 15:
                int a3 = asm.a(bArr, i, aspVar);
                aspVar.c = Integer.valueOf(zzejj.e(aspVar.a));
                return a3;
            case 16:
                int b4 = asm.b(bArr, i, aspVar);
                aspVar.c = Long.valueOf(zzejj.a(aspVar.b));
                return b4;
            case 17:
                return asm.d(bArr, i, aspVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, asp aspVar) throws IOException {
        int b2;
        zzekp zzekpVar = (zzekp) b.getObject(t, j2);
        if (!zzekpVar.a()) {
            int size = zzekpVar.size();
            zzekpVar = zzekpVar.a(size == 0 ? 10 : size << 1);
            b.putObject(t, j2, zzekpVar);
        }
        zzekp zzekpVar2 = zzekpVar;
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    ati atiVar = (ati) zzekpVar2;
                    int a2 = asm.a(bArr, i, aspVar);
                    int i8 = aspVar.a + a2;
                    while (a2 < i8) {
                        atiVar.a(asm.c(bArr, a2));
                        a2 += 8;
                    }
                    if (a2 != i8) {
                        throw zzeks.a();
                    }
                    return a2;
                }
                if (i5 == 1) {
                    ati atiVar2 = (ati) zzekpVar2;
                    atiVar2.a(asm.c(bArr, i));
                    int i9 = i + 8;
                    while (i9 < i2) {
                        int a3 = asm.a(bArr, i9, aspVar);
                        if (i3 != aspVar.a) {
                            return i9;
                        }
                        atiVar2.a(asm.c(bArr, a3));
                        i9 = a3 + 8;
                    }
                    return i9;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    atp atpVar = (atp) zzekpVar2;
                    int a4 = asm.a(bArr, i, aspVar);
                    int i10 = aspVar.a + a4;
                    while (a4 < i10) {
                        atpVar.a(asm.d(bArr, a4));
                        a4 += 4;
                    }
                    if (a4 != i10) {
                        throw zzeks.a();
                    }
                    return a4;
                }
                if (i5 == 5) {
                    atp atpVar2 = (atp) zzekpVar2;
                    atpVar2.a(asm.d(bArr, i));
                    int i11 = i + 4;
                    while (i11 < i2) {
                        int a5 = asm.a(bArr, i11, aspVar);
                        if (i3 != aspVar.a) {
                            return i11;
                        }
                        atpVar2.a(asm.d(bArr, a5));
                        i11 = a5 + 4;
                    }
                    return i11;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    aud audVar = (aud) zzekpVar2;
                    int a6 = asm.a(bArr, i, aspVar);
                    int i12 = aspVar.a + a6;
                    while (a6 < i12) {
                        a6 = asm.b(bArr, a6, aspVar);
                        audVar.a(aspVar.b);
                    }
                    if (a6 != i12) {
                        throw zzeks.a();
                    }
                    return a6;
                }
                if (i5 == 0) {
                    aud audVar2 = (aud) zzekpVar2;
                    int b3 = asm.b(bArr, i, aspVar);
                    audVar2.a(aspVar.b);
                    while (b3 < i2) {
                        int a7 = asm.a(bArr, b3, aspVar);
                        if (i3 != aspVar.a) {
                            return b3;
                        }
                        b3 = asm.b(bArr, a7, aspVar);
                        audVar2.a(aspVar.b);
                    }
                    return b3;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return asm.a(bArr, i, (zzekp<?>) zzekpVar2, aspVar);
                }
                if (i5 == 0) {
                    return asm.a(i3, bArr, i, i2, (zzekp<?>) zzekpVar2, aspVar);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    aud audVar3 = (aud) zzekpVar2;
                    int a8 = asm.a(bArr, i, aspVar);
                    int i13 = aspVar.a + a8;
                    while (a8 < i13) {
                        audVar3.a(asm.b(bArr, a8));
                        a8 += 8;
                    }
                    if (a8 != i13) {
                        throw zzeks.a();
                    }
                    return a8;
                }
                if (i5 == 1) {
                    aud audVar4 = (aud) zzekpVar2;
                    audVar4.a(asm.b(bArr, i));
                    int i14 = i + 8;
                    while (i14 < i2) {
                        int a9 = asm.a(bArr, i14, aspVar);
                        if (i3 != aspVar.a) {
                            return i14;
                        }
                        audVar4.a(asm.b(bArr, a9));
                        i14 = a9 + 8;
                    }
                    return i14;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    att attVar = (att) zzekpVar2;
                    int a10 = asm.a(bArr, i, aspVar);
                    int i15 = aspVar.a + a10;
                    while (a10 < i15) {
                        attVar.d(asm.a(bArr, a10));
                        a10 += 4;
                    }
                    if (a10 != i15) {
                        throw zzeks.a();
                    }
                    return a10;
                }
                if (i5 == 5) {
                    att attVar2 = (att) zzekpVar2;
                    attVar2.d(asm.a(bArr, i));
                    int i16 = i + 4;
                    while (i16 < i2) {
                        int a11 = asm.a(bArr, i16, aspVar);
                        if (i3 != aspVar.a) {
                            return i16;
                        }
                        attVar2.d(asm.a(bArr, a11));
                        i16 = a11 + 4;
                    }
                    return i16;
                }
                return i;
            case 25:
            case 42:
                if (i5 != 2) {
                    if (i5 == 0) {
                        aso asoVar = (aso) zzekpVar2;
                        b2 = asm.b(bArr, i, aspVar);
                        asoVar.a(aspVar.b != 0);
                        while (b2 < i2) {
                            int a12 = asm.a(bArr, b2, aspVar);
                            if (i3 != aspVar.a) {
                                break;
                            } else {
                                b2 = asm.b(bArr, a12, aspVar);
                                asoVar.a(aspVar.b != 0);
                            }
                        }
                        break;
                    }
                    return i;
                }
                aso asoVar2 = (aso) zzekpVar2;
                b2 = asm.a(bArr, i, aspVar);
                int i17 = aspVar.a + b2;
                while (b2 < i17) {
                    b2 = asm.b(bArr, b2, aspVar);
                    asoVar2.a(aspVar.b != 0);
                }
                if (b2 != i17) {
                    throw zzeks.a();
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int a13 = asm.a(bArr, i, aspVar);
                        int i18 = aspVar.a;
                        if (i18 < 0) {
                            throw zzeks.b();
                        }
                        if (i18 == 0) {
                            zzekpVar2.add("");
                        } else {
                            zzekpVar2.add(new String(bArr, a13, i18, zzekk.a));
                            a13 += i18;
                        }
                        while (a13 < i2) {
                            int a14 = asm.a(bArr, a13, aspVar);
                            if (i3 != aspVar.a) {
                                return a13;
                            }
                            a13 = asm.a(bArr, a14, aspVar);
                            int i19 = aspVar.a;
                            if (i19 < 0) {
                                throw zzeks.b();
                            }
                            if (i19 == 0) {
                                zzekpVar2.add("");
                            } else {
                                zzekpVar2.add(new String(bArr, a13, i19, zzekk.a));
                                a13 += i19;
                            }
                        }
                        return a13;
                    }
                    int a15 = asm.a(bArr, i, aspVar);
                    int i20 = aspVar.a;
                    if (i20 < 0) {
                        throw zzeks.b();
                    }
                    if (i20 == 0) {
                        zzekpVar2.add("");
                    } else {
                        int i21 = a15 + i20;
                        if (!awc.a(bArr, a15, i21)) {
                            throw zzeks.i();
                        }
                        zzekpVar2.add(new String(bArr, a15, i20, zzekk.a));
                        a15 = i21;
                    }
                    while (a15 < i2) {
                        int a16 = asm.a(bArr, a15, aspVar);
                        if (i3 != aspVar.a) {
                            return a15;
                        }
                        a15 = asm.a(bArr, a16, aspVar);
                        int i22 = aspVar.a;
                        if (i22 < 0) {
                            throw zzeks.b();
                        }
                        if (i22 == 0) {
                            zzekpVar2.add("");
                        } else {
                            int i23 = a15 + i22;
                            if (!awc.a(bArr, a15, i23)) {
                                throw zzeks.i();
                            }
                            zzekpVar2.add(new String(bArr, a15, i22, zzekk.a));
                            a15 = i23;
                        }
                    }
                    return a15;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return asm.a(a(i6), i3, bArr, i, i2, zzekpVar2, aspVar);
                }
                return i;
            case 28:
                if (i5 == 2) {
                    int a17 = asm.a(bArr, i, aspVar);
                    int i24 = aspVar.a;
                    if (i24 < 0) {
                        throw zzeks.b();
                    }
                    if (i24 > bArr.length - a17) {
                        throw zzeks.a();
                    }
                    if (i24 == 0) {
                        zzekpVar2.add(zzeiu.a);
                    } else {
                        zzekpVar2.add(zzeiu.a(bArr, a17, i24));
                        a17 += i24;
                    }
                    while (a17 < i2) {
                        int a18 = asm.a(bArr, a17, aspVar);
                        if (i3 != aspVar.a) {
                            return a17;
                        }
                        a17 = asm.a(bArr, a18, aspVar);
                        int i25 = aspVar.a;
                        if (i25 < 0) {
                            throw zzeks.b();
                        }
                        if (i25 > bArr.length - a17) {
                            throw zzeks.a();
                        }
                        if (i25 == 0) {
                            zzekpVar2.add(zzeiu.a);
                        } else {
                            zzekpVar2.add(zzeiu.a(bArr, a17, i25));
                            a17 += i25;
                        }
                    }
                    return a17;
                }
                return i;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        b2 = asm.a(i3, bArr, i, i2, (zzekp<?>) zzekpVar2, aspVar);
                    }
                    return i;
                }
                b2 = asm.a(bArr, i, (zzekp<?>) zzekpVar2, aspVar);
                zzekh zzekhVar = (zzekh) t;
                zzeni zzeniVar = zzekhVar.zzino;
                if (zzeniVar == zzeni.a()) {
                    zzeniVar = null;
                }
                zzeni zzeniVar2 = (zzeni) avf.a(i4, zzekpVar2, c(i6), zzeniVar, this.q);
                if (zzeniVar2 != null) {
                    zzekhVar.zzino = zzeniVar2;
                    break;
                }
                break;
            case 33:
            case 47:
                if (i5 == 2) {
                    att attVar3 = (att) zzekpVar2;
                    int a19 = asm.a(bArr, i, aspVar);
                    int i26 = aspVar.a + a19;
                    while (a19 < i26) {
                        a19 = asm.a(bArr, a19, aspVar);
                        attVar3.d(zzejj.e(aspVar.a));
                    }
                    if (a19 != i26) {
                        throw zzeks.a();
                    }
                    return a19;
                }
                if (i5 == 0) {
                    att attVar4 = (att) zzekpVar2;
                    int a20 = asm.a(bArr, i, aspVar);
                    attVar4.d(zzejj.e(aspVar.a));
                    while (a20 < i2) {
                        int a21 = asm.a(bArr, a20, aspVar);
                        if (i3 != aspVar.a) {
                            return a20;
                        }
                        a20 = asm.a(bArr, a21, aspVar);
                        attVar4.d(zzejj.e(aspVar.a));
                    }
                    return a20;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    aud audVar5 = (aud) zzekpVar2;
                    int a22 = asm.a(bArr, i, aspVar);
                    int i27 = aspVar.a + a22;
                    while (a22 < i27) {
                        a22 = asm.b(bArr, a22, aspVar);
                        audVar5.a(zzejj.a(aspVar.b));
                    }
                    if (a22 != i27) {
                        throw zzeks.a();
                    }
                    return a22;
                }
                if (i5 == 0) {
                    aud audVar6 = (aud) zzekpVar2;
                    int b4 = asm.b(bArr, i, aspVar);
                    audVar6.a(zzejj.a(aspVar.b));
                    while (b4 < i2) {
                        int a23 = asm.a(bArr, b4, aspVar);
                        if (i3 != aspVar.a) {
                            return b4;
                        }
                        b4 = asm.b(bArr, a23, aspVar);
                        audVar6.a(zzejj.a(aspVar.b));
                    }
                    return b4;
                }
                return i;
            case 49:
                if (i5 == 3) {
                    avd a24 = a(i6);
                    int i28 = (i3 & (-8)) | 4;
                    int a25 = asm.a(a24, bArr, i, i2, i28, aspVar);
                    zzekpVar2.add(aspVar.c);
                    while (a25 < i2) {
                        int a26 = asm.a(bArr, a25, aspVar);
                        if (i3 != aspVar.a) {
                            return a25;
                        }
                        a25 = asm.a(a24, bArr, a26, i2, i28, aspVar);
                        zzekpVar2.add(aspVar.c);
                    }
                    return a25;
                }
                return i;
            default:
                return i;
        }
        return b2;
    }

    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, asp aspVar) throws IOException {
        Unsafe unsafe = b;
        Object b2 = b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.s.c(object)) {
            Object e = this.s.e(b2);
            this.s.a(e, object);
            unsafe.putObject(t, j, e);
            object = e;
        }
        aug<?, ?> f = this.s.f(b2);
        Map<?, ?> a2 = this.s.a(object);
        int a3 = asm.a(bArr, i, aspVar);
        int i4 = aspVar.a;
        if (i4 < 0 || i4 > i2 - a3) {
            throw zzeks.a();
        }
        int i5 = i4 + a3;
        K k = f.b;
        V v = f.d;
        while (a3 < i5) {
            int i6 = a3 + 1;
            int i7 = bArr[a3];
            if (i7 < 0) {
                i6 = asm.a(i7, bArr, i6, aspVar);
                i7 = aspVar.a;
            }
            int i8 = i6;
            int i9 = i7 & 7;
            switch (i7 >>> 3) {
                case 1:
                    if (i9 == f.a.b()) {
                        a3 = a(bArr, i8, i2, f.a, (Class<?>) null, aspVar);
                        k = (K) aspVar.c;
                        break;
                    } else {
                        a3 = asm.a(i7, bArr, i8, i2, aspVar);
                        break;
                    }
                case 2:
                    if (i9 == f.c.b()) {
                        a3 = a(bArr, i8, i2, f.c, f.d.getClass(), aspVar);
                        v = aspVar.c;
                        break;
                    } else {
                        a3 = asm.a(i7, bArr, i8, i2, aspVar);
                        break;
                    }
                default:
                    a3 = asm.a(i7, bArr, i8, i2, aspVar);
                    break;
            }
        }
        if (a3 != i5) {
            throw zzeks.h();
        }
        a2.put(k, v);
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, asp aspVar) throws IOException {
        int i9;
        Unsafe unsafe = b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(asm.c(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(asm.d(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = asm.b(bArr, i, aspVar);
                    unsafe.putObject(t, j, Long.valueOf(aspVar.b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = asm.a(bArr, i, aspVar);
                    unsafe.putObject(t, j, Integer.valueOf(aspVar.a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(asm.b(bArr, i)));
                    i9 = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(asm.a(bArr, i)));
                    i9 = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = asm.b(bArr, i, aspVar);
                    unsafe.putObject(t, j, Boolean.valueOf(aspVar.b != 0));
                    break;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int a2 = asm.a(bArr, i, aspVar);
                    int i10 = aspVar.a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !awc.a(bArr, a2, a2 + i10)) {
                            throw zzeks.i();
                        }
                        unsafe.putObject(t, j, new String(bArr, a2, i10, zzekk.a));
                        a2 += i10;
                    }
                    unsafe.putInt(t, j2, i4);
                    return a2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int a3 = asm.a(a(i8), bArr, i, i2, aspVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, aspVar.c);
                    } else {
                        unsafe.putObject(t, j, zzekk.a(object, aspVar.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return a3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = asm.e(bArr, i, aspVar);
                    unsafe.putObject(t, j, aspVar.c);
                    break;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int a4 = asm.a(bArr, i, aspVar);
                    int i11 = aspVar.a;
                    zzekl c = c(i8);
                    if (c == null || c.a(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = a4;
                        break;
                    } else {
                        e(t).a(i3, Long.valueOf(i11));
                        return a4;
                    }
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = asm.a(bArr, i, aspVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzejj.e(aspVar.a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = asm.b(bArr, i, aspVar);
                    unsafe.putObject(t, j, Long.valueOf(zzejj.a(aspVar.b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = asm.a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, aspVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, aspVar.c);
                        break;
                    } else {
                        unsafe.putObject(t, j, zzekk.a(object2, aspVar.c));
                        break;
                    }
                }
                return i;
            default:
                return i;
        }
        unsafe.putInt(t, j2, i4);
        return i9;
    }

    private final avd a(int i) {
        int i2 = (i / 3) << 1;
        avd avdVar = (avd) this.d[i2];
        if (avdVar != null) {
            return avdVar;
        }
        avd<T> a2 = auw.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final zzekl c(int i) {
        return (zzekl) this.d[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x04d9, code lost:
    
        r1 = r19;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x04e0, code lost:
    
        if (r0 == 1048575) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x04e2, code lost:
    
        r30.putInt(r10, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x04e8, code lost:
    
        r0 = null;
        r1 = r33.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x04ed, code lost:
    
        if (r1 >= r33.n) goto L511;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x04ef, code lost:
    
        r0 = (com.google.android.gms.internal.ads.zzeni) a((java.lang.Object) r10, r33.l[r1], (int) r0, (com.google.android.gms.internal.ads.avw<UT, int>) r33.q);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x04fe, code lost:
    
        if (r0 == null) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0500, code lost:
    
        r33.q.b((java.lang.Object) r10, (T) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0505, code lost:
    
        if (r6 != 0) goto L431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0509, code lost:
    
        if (r2 == r37) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x050f, code lost:
    
        throw com.google.android.gms.internal.ads.zzeks.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0517, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0512, code lost:
    
        if (r2 > r37) goto L436;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0514, code lost:
    
        if (r7 == r6) goto L435;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x051c, code lost:
    
        throw com.google.android.gms.internal.ads.zzeks.h();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int a(T r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.ads.asp r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.asp):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0308, code lost:
    
        if (r0 == r15) goto L299;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0357, code lost:
    
        r15 = r33;
        r14 = r34;
        r12 = r35;
        r13 = r37;
        r11 = r38;
        r10 = -1;
        r1 = r19;
        r2 = r20;
        r6 = r29;
        r7 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x032d, code lost:
    
        if (r0 == r15) goto L299;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:71:0x00a1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r34, byte[] r35, int r36, int r37, com.google.android.gms.internal.ads.asp r38) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.asp):void");
    }

    @Override // com.google.android.gms.internal.ads.avd
    public final void c(T t) {
        for (int i = this.m; i < this.n; i++) {
            long d = d(this.l[i]) & 1048575;
            Object f = avz.f(t, d);
            if (f != null) {
                avz.a(t, d, this.s.d(f));
            }
        }
        int length = this.l.length;
        for (int i2 = this.n; i2 < length; i2++) {
            this.p.b(t, this.l[i2]);
        }
        this.q.d(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, avw<UT, UB> avwVar) {
        zzekl c;
        int i2 = this.c[i];
        Object f = avz.f(obj, d(i) & 1048575);
        return (f == null || (c = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(f), c, (zzekl) ub, (avw<UT, zzekl>) avwVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, zzekl zzeklVar, UB ub, avw<UT, UB> avwVar) {
        aug<?, ?> f = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzeklVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = avwVar.a();
                }
                asw c = zzeiu.c(zzelk.a(f, next.getKey(), next.getValue()));
                try {
                    zzelk.a(c.b(), f, next.getKey(), next.getValue());
                    avwVar.a((avw<UT, UB>) ub, i2, c.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x011e, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.google.android.gms.internal.ads.avd] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.avd] */
    @Override // com.google.android.gms.internal.ads.avd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(T r19) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auo.d(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, avd avdVar) {
        return avdVar.d(avz.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, awo awoVar) throws IOException {
        if (obj instanceof String) {
            awoVar.a(i, (String) obj);
        } else {
            awoVar.a(i, (zzeiu) obj);
        }
    }

    private final void a(Object obj, int i, aux auxVar) throws IOException {
        if (f(i)) {
            avz.a(obj, i & 1048575, auxVar.m());
        } else if (this.i) {
            avz.a(obj, i & 1048575, auxVar.l());
        } else {
            avz.a(obj, i & 1048575, auxVar.n());
        }
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> double b(T t, long j) {
        return ((Double) avz.f(t, j)).doubleValue();
    }

    private static <T> float c(T t, long j) {
        return ((Float) avz.f(t, j)).floatValue();
    }

    private static <T> int d(T t, long j) {
        return ((Integer) avz.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) avz.f(t, j)).longValue();
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) avz.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((auo<T>) t, i) == a((auo<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return a((auo<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean a(T t, int i) {
        int e = e(i);
        long j = e & 1048575;
        if (j != 1048575) {
            return (avz.a(t, j) & (1 << (e >>> 20))) != 0;
        }
        int d = d(i);
        long j2 = d & 1048575;
        switch ((d & 267386880) >>> 20) {
            case 0:
                return avz.e(t, j2) != 0.0d;
            case 1:
                return avz.d(t, j2) != 0.0f;
            case 2:
                return avz.b(t, j2) != 0;
            case 3:
                return avz.b(t, j2) != 0;
            case 4:
                return avz.a(t, j2) != 0;
            case 5:
                return avz.b(t, j2) != 0;
            case 6:
                return avz.a(t, j2) != 0;
            case 7:
                return avz.c(t, j2);
            case 8:
                Object f = avz.f(t, j2);
                if (f instanceof String) {
                    return !((String) f).isEmpty();
                }
                if (f instanceof zzeiu) {
                    return !zzeiu.a.equals(f);
                }
                throw new IllegalArgumentException();
            case 9:
                return avz.f(t, j2) != null;
            case 10:
                return !zzeiu.a.equals(avz.f(t, j2));
            case 11:
                return avz.a(t, j2) != 0;
            case 12:
                return avz.a(t, j2) != 0;
            case 13:
                return avz.a(t, j2) != 0;
            case 14:
                return avz.b(t, j2) != 0;
            case 15:
                return avz.a(t, j2) != 0;
            case 16:
                return avz.b(t, j2) != 0;
            case 17:
                return avz.f(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void b(T t, int i) {
        int e = e(i);
        long j = 1048575 & e;
        if (j == 1048575) {
            return;
        }
        avz.a((Object) t, j, (1 << (e >>> 20)) | avz.a(t, j));
    }

    private final boolean a(T t, int i, int i2) {
        return avz.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        avz.a((Object) t, e(i2) & 1048575, i);
    }

    private final int g(int i) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, 0);
    }

    private final int a(int i, int i2) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, i2);
    }

    private final int b(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
