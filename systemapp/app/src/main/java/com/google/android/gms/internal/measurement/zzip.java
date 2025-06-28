package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
public enum zzip {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdu.a),
    ENUM(null),
    MESSAGE(null);

    private final Object j;

    zzip(Object obj) {
        this.j = obj;
    }
}
