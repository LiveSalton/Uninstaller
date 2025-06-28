package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zznr {
    public final int a;
    private final zzhp[] b;
    private int c;

    public zznr(zzhp... zzhpVarArr) {
        zzpc.b(zzhpVarArr.length > 0);
        this.b = zzhpVarArr;
        this.a = zzhpVarArr.length;
    }

    public final zzhp a(int i) {
        return this.b[i];
    }

    public final int a(zzhp zzhpVar) {
        for (int i = 0; i < this.b.length; i++) {
            if (zzhpVar == this.b[i]) {
                return i;
            }
        }
        return -1;
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
        zznr zznrVar = (zznr) obj;
        return this.a == zznrVar.a && Arrays.equals(this.b, zznrVar.b);
    }
}
