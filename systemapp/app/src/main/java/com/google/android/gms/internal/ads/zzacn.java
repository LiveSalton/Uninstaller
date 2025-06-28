package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzacn<T> {
    private final String a;
    private final T b;
    private final int c;

    public static zzacn<Boolean> a(String str, boolean z) {
        return new zzacn<>(str, Boolean.valueOf(z), v.a);
    }

    public static zzacn<Long> a(String str, long j) {
        return new zzacn<>(str, Long.valueOf(j), v.b);
    }

    public static zzacn<Double> a(String str, double d) {
        return new zzacn<>(str, Double.valueOf(d), v.c);
    }

    public static zzacn<String> a(String str, String str2) {
        return new zzacn<>(str, str2, v.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected zzacn(String str, Object obj, int i) {
        this.a = str;
        this.b = obj;
        this.c = i;
    }

    public T a() {
        zzadp a = zzado.a();
        if (a == null) {
            throw new IllegalStateException("Flag is not initialized.");
        }
        switch (u.a[this.c - 1]) {
            case 1:
                return (T) a.a(this.a, ((Boolean) this.b).booleanValue());
            case 2:
                return (T) a.a(this.a, ((Long) this.b).longValue());
            case 3:
                return (T) a.a(this.a, ((Double) this.b).doubleValue());
            case 4:
                return (T) a.a(this.a, (String) this.b);
            default:
                throw new IllegalStateException();
        }
    }
}
