package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* compiled from: source */
/* loaded from: classes.dex */
final class bo<T> implements bw<T> {
    private static final int[] a = new int[0];
    private static final Unsafe b = co.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final zzgo g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final br o;
    private final bb p;
    private final cl<?, ?> q;
    private final ap<?> r;
    private final bi s;

    private bo(int[] iArr, Object[] objArr, int i, int i2, zzgo zzgoVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, br brVar, bb bbVar, cl<?, ?> clVar, ap<?> apVar, bi biVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = zzgoVar instanceof zzfd;
        this.j = z;
        this.h = apVar != null && apVar.a(zzgoVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = brVar;
        this.p = bbVar;
        this.q = clVar;
        this.r = apVar;
        this.g = zzgoVar;
        this.s = biVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.measurement.bo<T> a(java.lang.Class<T> r39, com.google.android.gms.internal.measurement.bm r40, com.google.android.gms.internal.measurement.br r41, com.google.android.gms.internal.measurement.bb r42, com.google.android.gms.internal.measurement.cl<?, ?> r43, com.google.android.gms.internal.measurement.ap<?> r44, com.google.android.gms.internal.measurement.bi r45) {
        /*
            Method dump skipped, instructions count: 1098
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bo.a(java.lang.Class, com.google.android.gms.internal.measurement.bm, com.google.android.gms.internal.measurement.br, com.google.android.gms.internal.measurement.bb, com.google.android.gms.internal.measurement.cl, com.google.android.gms.internal.measurement.ap, com.google.android.gms.internal.measurement.bi):com.google.android.gms.internal.measurement.bo");
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (com.google.android.gms.internal.measurement.bx.a(com.google.android.gms.internal.measurement.co.f(r10, r6), com.google.android.gms.internal.measurement.co.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.measurement.co.b(r10, r6) == com.google.android.gms.internal.measurement.co.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (com.google.android.gms.internal.measurement.co.b(r10, r6) == com.google.android.gms.internal.measurement.co.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (com.google.android.gms.internal.measurement.bx.a(com.google.android.gms.internal.measurement.co.f(r10, r6), com.google.android.gms.internal.measurement.co.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (com.google.android.gms.internal.measurement.bx.a(com.google.android.gms.internal.measurement.co.f(r10, r6), com.google.android.gms.internal.measurement.co.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (com.google.android.gms.internal.measurement.bx.a(com.google.android.gms.internal.measurement.co.f(r10, r6), com.google.android.gms.internal.measurement.co.f(r11, r6)) != false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (com.google.android.gms.internal.measurement.co.c(r10, r6) == com.google.android.gms.internal.measurement.co.c(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (com.google.android.gms.internal.measurement.co.b(r10, r6) == com.google.android.gms.internal.measurement.co.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (com.google.android.gms.internal.measurement.co.a(r10, r6) == com.google.android.gms.internal.measurement.co.a(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (com.google.android.gms.internal.measurement.co.b(r10, r6) == com.google.android.gms.internal.measurement.co.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (com.google.android.gms.internal.measurement.co.b(r10, r6) == com.google.android.gms.internal.measurement.co.b(r11, r6)) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.co.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.co.d(r11, r6))) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.co.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.co.e(r11, r6))) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.bx.a(com.google.android.gms.internal.measurement.co.f(r10, r6), com.google.android.gms.internal.measurement.co.f(r11, r6)) != false) goto L223;
     */
    @Override // com.google.android.gms.internal.measurement.bw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bo.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final int a(T t) {
        int length = this.c.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int c = c(i2);
            int i3 = this.c[i2];
            long j = 1048575 & c;
            switch ((c & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzff.a(Double.doubleToLongBits(co.e(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(co.d(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzff.a(co.b(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzff.a(co.b(t, j));
                    break;
                case 4:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzff.a(co.b(t, j));
                    break;
                case 6:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzff.a(co.c(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) co.f(t, j)).hashCode();
                    break;
                case 9:
                    Object f = co.f(t, j);
                    i = (i * 53) + (f != null ? f.hashCode() : 37);
                    break;
                case 10:
                    i = (i * 53) + co.f(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 12:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 13:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzff.a(co.b(t, j));
                    break;
                case 15:
                    i = (i * 53) + co.a(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzff.a(co.b(t, j));
                    break;
                case 17:
                    Object f2 = co.f(t, j);
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
                    i = (i * 53) + co.f(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + co.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(Double.doubleToLongBits(a(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(b(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(d(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(d(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(d(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + ((String) co.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + co.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + co.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(d(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + c(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + zzff.a(d(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((bo<T>) t, i3, i2)) {
                        i = (i * 53) + co.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.q.a(t).hashCode();
        return this.h ? (hashCode * 53) + this.r.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.c.length; i += 3) {
            int c = c(i);
            long j = 1048575 & c;
            int i2 = this.c[i];
            switch ((c & 267386880) >>> 20) {
                case 0:
                    if (a((bo<T>) t2, i)) {
                        co.a(t, j, co.e(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.d(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.b(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.b(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.b(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((bo<T>) t2, i)) {
                        co.a(t, j, co.c(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((bo<T>) t2, i)) {
                        co.a(t, j, co.f(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((bo<T>) t2, i)) {
                        co.a(t, j, co.f(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.b(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.a(t2, j));
                        b((bo<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((bo<T>) t2, i)) {
                        co.a((Object) t, j, co.b(t2, j));
                        b((bo<T>) t, i);
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
                    bx.a(this.s, t, t2, j);
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
                    if (a((bo<T>) t2, i2, i)) {
                        co.a(t, j, co.f(t2, j));
                        b((bo<T>) t, i2, i);
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
                    if (a((bo<T>) t2, i2, i)) {
                        co.a(t, j, co.f(t2, j));
                        b((bo<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i);
                    break;
            }
        }
        if (this.j) {
            return;
        }
        bx.a(this.q, t, t2);
        if (this.h) {
            bx.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long c = c(i) & 1048575;
        if (a((bo<T>) t2, i)) {
            Object f = co.f(t, c);
            Object f2 = co.f(t2, c);
            if (f != null && f2 != null) {
                co.a(t, c, zzff.a(f, f2));
                b((bo<T>) t, i);
            } else if (f2 != null) {
                co.a(t, c, f2);
                b((bo<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int c = c(i);
        int i2 = this.c[i];
        long j = c & 1048575;
        if (a((bo<T>) t2, i2, i)) {
            Object f = co.f(t, j);
            Object f2 = co.f(t2, j);
            if (f != null && f2 != null) {
                co.a(t, j, zzff.a(f, f2));
                b((bo<T>) t, i2, i);
            } else if (f2 != null) {
                co.a(t, j, f2);
                b((bo<T>) t, i2, i);
            }
        }
    }

    private final bw a(int i) {
        int i2 = (i / 3) << 1;
        bw bwVar = (bw) this.d[i2];
        if (bwVar != null) {
            return bwVar;
        }
        bw<T> a2 = bt.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = a2;
        return a2;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    @Override // com.google.android.gms.internal.measurement.bw
    public final void b(T t) {
        for (int i = this.m; i < this.n; i++) {
            long c = c(this.l[i]) & 1048575;
            Object f = co.f(t, c);
            if (f != null) {
                co.a(t, c, this.s.b(f));
            }
        }
        int length = this.l.length;
        for (int i2 = this.n; i2 < length; i2++) {
            this.p.a(t, this.l[i2]);
        }
        this.q.b(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0104, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.bw] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.bw] */
    @Override // com.google.android.gms.internal.measurement.bw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(T r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.bo.c(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, bw bwVar) {
        return bwVar.c(co.f(obj, i & 1048575));
    }

    private final int c(int i) {
        return this.c[i + 1];
    }

    private final int d(int i) {
        return this.c[i + 2];
    }

    private static <T> double a(T t, long j) {
        return ((Double) co.f(t, j)).doubleValue();
    }

    private static <T> float b(T t, long j) {
        return ((Float) co.f(t, j)).floatValue();
    }

    private static <T> int c(T t, long j) {
        return ((Integer) co.f(t, j)).intValue();
    }

    private static <T> long d(T t, long j) {
        return ((Long) co.f(t, j)).longValue();
    }

    private static <T> boolean e(T t, long j) {
        return ((Boolean) co.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((bo<T>) t, i) == a((bo<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((bo<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int c = c(i);
            long j = c & 1048575;
            switch ((c & 267386880) >>> 20) {
                case 0:
                    return co.e(t, j) != 0.0d;
                case 1:
                    return co.d(t, j) != 0.0f;
                case 2:
                    return co.b(t, j) != 0;
                case 3:
                    return co.b(t, j) != 0;
                case 4:
                    return co.a(t, j) != 0;
                case 5:
                    return co.b(t, j) != 0;
                case 6:
                    return co.a(t, j) != 0;
                case 7:
                    return co.c(t, j);
                case 8:
                    Object f = co.f(t, j);
                    if (f instanceof String) {
                        return !((String) f).isEmpty();
                    }
                    if (f instanceof zzdu) {
                        return !zzdu.a.equals(f);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return co.f(t, j) != null;
                case 10:
                    return !zzdu.a.equals(co.f(t, j));
                case 11:
                    return co.a(t, j) != 0;
                case 12:
                    return co.a(t, j) != 0;
                case 13:
                    return co.a(t, j) != 0;
                case 14:
                    return co.b(t, j) != 0;
                case 15:
                    return co.a(t, j) != 0;
                case 16:
                    return co.b(t, j) != 0;
                case 17:
                    return co.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int d = d(i);
        return (co.a(t, (long) (d & 1048575)) & (1 << (d >>> 20))) != 0;
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int d = d(i);
        long j = d & 1048575;
        co.a((Object) t, j, co.a(t, j) | (1 << (d >>> 20)));
    }

    private final boolean a(T t, int i, int i2) {
        return co.a(t, (long) (d(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        co.a((Object) t, d(i2) & 1048575, i);
    }
}
