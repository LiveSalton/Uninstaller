package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zznq {
    public static final zznq a = new zznq(new zznr[0]);
    public final int b;
    private final zznr[] c;
    private int d;

    public zznq(zznr... zznrVarArr) {
        this.c = zznrVarArr;
        this.b = zznrVarArr.length;
    }

    public final zznr a(int i) {
        return this.c[i];
    }

    public final int a(zznr zznrVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.c[i] == zznrVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = Arrays.hashCode(this.c);
        }
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zznq zznqVar = (zznq) obj;
        return this.b == zznqVar.b && Arrays.equals(this.c, zznqVar.c);
    }
}
