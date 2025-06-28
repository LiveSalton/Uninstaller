package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: source */
/* loaded from: classes.dex */
final class co {
    static final boolean a;
    private static final Logger b = Logger.getLogger(co.class.getName());
    private static final Unsafe c = c();
    private static final Class<?> d = ad.b();
    private static final boolean e = d(Long.TYPE);
    private static final boolean f = d(Integer.TYPE);
    private static final d g;
    private static final boolean h;
    private static final boolean i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final long w;
    private static final int x;

    private co() {
    }

    /* compiled from: source */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final byte a(Object obj, long j) {
            if (co.a) {
                return co.k(obj, j);
            }
            return co.l(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final boolean b(Object obj, long j) {
            if (co.a) {
                return co.m(obj, j);
            }
            return co.n(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, boolean z) {
            if (co.a) {
                co.d(obj, j, z);
            } else {
                co.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: source */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final byte a(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final boolean b(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final float c(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final double d(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }
    }

    /* compiled from: source */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final byte a(Object obj, long j) {
            if (co.a) {
                return co.k(obj, j);
            }
            return co.l(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final boolean b(Object obj, long j) {
            if (co.a) {
                return co.m(obj, j);
            }
            return co.n(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, boolean z) {
            if (co.a) {
                co.d(obj, j, z);
            } else {
                co.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.co.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean a() {
        return i;
    }

    /* compiled from: source */
    static abstract class d {
        Unsafe a;

        d(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }
    }

    static boolean b() {
        return h;
    }

    static <T> T a(Class<T> cls) {
        try {
            return (T) c.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (i) {
            return g.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (i) {
            return g.a.arrayIndexScale(cls);
        }
        return -1;
    }

    static int a(Object obj, long j2) {
        return g.e(obj, j2);
    }

    static void a(Object obj, long j2, int i2) {
        g.a(obj, j2, i2);
    }

    static long b(Object obj, long j2) {
        return g.f(obj, j2);
    }

    static void a(Object obj, long j2, long j3) {
        g.a(obj, j2, j3);
    }

    static boolean c(Object obj, long j2) {
        return g.b(obj, j2);
    }

    static void a(Object obj, long j2, boolean z) {
        g.a(obj, j2, z);
    }

    static float d(Object obj, long j2) {
        return g.c(obj, j2);
    }

    static void a(Object obj, long j2, float f2) {
        g.a(obj, j2, f2);
    }

    static double e(Object obj, long j2) {
        return g.d(obj, j2);
    }

    static void a(Object obj, long j2, double d2) {
        g.a(obj, j2, d2);
    }

    static Object f(Object obj, long j2) {
        return g.a.getObject(obj, j2);
    }

    static void a(Object obj, long j2, Object obj2) {
        g.a.putObject(obj, j2, obj2);
    }

    static byte a(byte[] bArr, long j2) {
        return g.a(bArr, j + j2);
    }

    static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new cq());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean d() {
        if (c == null) {
            return false;
        }
        try {
            Class<?> cls = c.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (ad.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(71 + String.valueOf(valueOf).length());
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean e() {
        if (c == null) {
            return false;
        }
        try {
            Class<?> cls = c.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (f() == null) {
                return false;
            }
            if (ad.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(71 + String.valueOf(valueOf).length());
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean d(Class<?> cls) {
        if (!ad.a()) {
            return false;
        }
        try {
            Class<?> cls2 = d;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field f() {
        Field a2;
        if (ad.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    private static void a(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int a2 = a(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a2 & (~(255 << i2))));
    }

    private static void b(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & (~(255 << i2))));
    }

    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    public static void d(Object obj, long j2, boolean z) {
        a(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void e(Object obj, long j2, boolean z) {
        b(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static {
        d dVar = null;
        if (c != null) {
            if (ad.a()) {
                if (e) {
                    dVar = new c(c);
                } else if (f) {
                    dVar = new a(c);
                }
            } else {
                dVar = new b(c);
            }
        }
        g = dVar;
        h = e();
        i = d();
        j = b(byte[].class);
        k = b(boolean[].class);
        l = c(boolean[].class);
        m = b(int[].class);
        n = c(int[].class);
        o = b(long[].class);
        p = c(long[].class);
        q = b(float[].class);
        r = c(float[].class);
        s = b(double[].class);
        t = c(double[].class);
        u = b(Object[].class);
        v = c(Object[].class);
        Field f2 = f();
        w = (f2 == null || g == null) ? -1L : g.a.objectFieldOffset(f2);
        x = (int) (j & 7);
        a = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
