package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdua {
    private final zzgt a;
    private final File b;
    private final File c;
    private final File d;
    private byte[] e;

    public zzdua(zzgt zzgtVar, File file, File file2, File file3) {
        this.a = zzgtVar;
        this.b = file;
        this.c = file3;
        this.d = file2;
    }

    public final zzgt a() {
        return this.a;
    }

    public final File b() {
        return this.b;
    }

    public final File c() {
        return this.c;
    }

    public final byte[] d() {
        if (this.e == null) {
            this.e = zzduc.b(this.d);
        }
        if (this.e == null) {
            return null;
        }
        return Arrays.copyOf(this.e, this.e.length);
    }

    public final boolean e() {
        return System.currentTimeMillis() / 1000 > this.a.c();
    }

    public final boolean a(long j) {
        return this.a.c() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
