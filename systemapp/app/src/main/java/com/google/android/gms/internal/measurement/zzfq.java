package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzfq {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdu.class, zzdu.class, zzdu.a),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> k;
    private final Class<?> l;
    private final Object m;

    zzfq(Class cls, Class cls2, Object obj) {
        this.k = cls;
        this.l = cls2;
        this.m = obj;
    }

    public final Class<?> a() {
        return this.l;
    }
}
