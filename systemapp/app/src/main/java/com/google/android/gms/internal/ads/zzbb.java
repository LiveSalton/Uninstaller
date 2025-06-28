package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbb {
    private final int a;
    private final List<zzu> b;
    private final int c;
    private final InputStream d;

    public zzbb(int i, List<zzu> list) {
        this(i, list, -1, null);
    }

    public zzbb(int i, List<zzu> list, int i2, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final List<zzu> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        return this.d;
    }
}
