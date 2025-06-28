package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
enum au {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);

    private final boolean e;

    au(boolean z) {
        this.e = z;
    }
}
