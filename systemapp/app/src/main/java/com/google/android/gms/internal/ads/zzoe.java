package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzoe {
    public final int a;
    private final zzoc[] b;
    private int c;

    public zzoe(zzoc... zzocVarArr) {
        this.b = zzocVarArr;
        this.a = zzocVarArr.length;
    }

    public final zzoc a(int i) {
        return this.b[i];
    }

    public final zzoc[] a() {
        return (zzoc[]) this.b.clone();
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = 527 + Arrays.hashCode(this.b);
        }
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((zzoe) obj).b);
    }
}
