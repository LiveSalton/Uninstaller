package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: source */
/* loaded from: classes.dex */
final class avf {
    private static final Class<?> a = d();
    private static final avw<?, ?> b = a(false);
    private static final avw<?, ?> c = a(true);
    private static final avw<?, ?> d = new avx();

    public static void a(Class<?> cls) {
        if (!zzekh.class.isAssignableFrom(cls) && a != null && !a.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, awo awoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, awo awoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.a(i, list);
    }

    public static void b(int i, List<zzeiu> list, awo awoVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.b(i, list);
    }

    public static void a(int i, List<?> list, awo awoVar, avd avdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.a(i, list, avdVar);
    }

    public static void b(int i, List<?> list, awo awoVar, avd avdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        awoVar.b(i, list, avdVar);
    }

    static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aud) {
            aud audVar = (aud) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.d(audVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.d(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzejo.e(i));
    }

    static int b(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aud) {
            aud audVar = (aud) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.e(audVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.e(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzejo.e(i));
    }

    static int c(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aud) {
            aud audVar = (aud) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.f(audVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.f(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzejo.e(i));
    }

    static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof att) {
            att attVar = (att) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.k(attVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.k(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzejo.e(i));
    }

    static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof att) {
            att attVar = (att) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.f(attVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.f(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzejo.e(i));
    }

    static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof att) {
            att attVar = (att) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.g(attVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.g(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzejo.e(i));
    }

    static int g(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof att) {
            att attVar = (att) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.h(attVar.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzejo.h(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzejo.e(i));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.i(i, 0);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.g(i, 0L);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.b(i, true);
    }

    static int a(int i, List<?> list) {
        int b2;
        int b3;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int e = zzejo.e(i) * size;
        if (list instanceof zzekz) {
            zzekz zzekzVar = (zzekz) list;
            while (i2 < size) {
                Object b4 = zzekzVar.b(i2);
                if (b4 instanceof zzeiu) {
                    b3 = zzejo.b((zzeiu) b4);
                } else {
                    b3 = zzejo.b((String) b4);
                }
                e += b3;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzeiu) {
                    b2 = zzejo.b((zzeiu) obj);
                } else {
                    b2 = zzejo.b((String) obj);
                }
                e += b2;
                i2++;
            }
        }
        return e;
    }

    static int a(int i, Object obj, avd avdVar) {
        if (obj instanceof zzekx) {
            return zzejo.a(i, (zzekx) obj);
        }
        return zzejo.b(i, (zzels) obj, avdVar);
    }

    static int a(int i, List<?> list, avd avdVar) {
        int a2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = zzejo.e(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzekx) {
                a2 = zzejo.a((zzekx) obj);
            } else {
                a2 = zzejo.a((zzels) obj, avdVar);
            }
            e += a2;
        }
        return e;
    }

    static int b(int i, List<zzeiu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = size * zzejo.e(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            e += zzejo.b(list.get(i2));
        }
        return e;
    }

    static int b(int i, List<zzels> list, avd avdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzejo.c(i, list.get(i3), avdVar);
        }
        return i2;
    }

    public static avw<?, ?> a() {
        return b;
    }

    public static avw<?, ?> b() {
        return c;
    }

    public static avw<?, ?> c() {
        return d;
    }

    private static avw<?, ?> a(boolean z) {
        try {
            Class<?> e = e();
            if (e == null) {
                return null;
            }
            return (avw) e.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void a(auh auhVar, T t, T t2, long j) {
        avz.a(t, j, auhVar.a(avz.f(t, j), avz.f(t2, j)));
    }

    static <T, FT extends zzejz<FT>> void a(atk<FT> atkVar, T t, T t2) {
        atl<FT> a2 = atkVar.a(t2);
        if (a2.a.isEmpty()) {
            return;
        }
        atkVar.b(t).a(a2);
    }

    static <T, UT, UB> void a(avw<UT, UB> avwVar, T t, T t2) {
        avwVar.a(t, avwVar.c(avwVar.b(t), avwVar.b(t2)));
    }

    static <UT, UB> UB a(int i, List<Integer> list, zzekl zzeklVar, UB ub, avw<UT, UB> avwVar) {
        UB ub2;
        int intValue;
        if (zzeklVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzeklVar.a(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, intValue2, ub2, avwVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = it.next().intValue();
                    if (!zzeklVar.a(intValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, intValue, ub2, avwVar);
                it.remove();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i, int i2, UB ub, avw<UT, UB> avwVar) {
        if (ub == null) {
            ub = avwVar.a();
        }
        avwVar.a((avw<UT, UB>) ub, i, i2);
        return ub;
    }
}
