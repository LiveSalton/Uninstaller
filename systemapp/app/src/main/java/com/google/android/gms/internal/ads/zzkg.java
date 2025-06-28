package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzkg {
    public final int a = 1;
    public final byte[] b;

    public zzkg(int i, byte[] bArr) {
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzkg zzkgVar = (zzkg) obj;
        return this.a == zzkgVar.a && Arrays.equals(this.b, zzkgVar.b);
    }

    public final int hashCode() {
        return (this.a * 31) + Arrays.hashCode(this.b);
    }
}
