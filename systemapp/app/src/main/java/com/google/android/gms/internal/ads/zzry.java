package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzry {
    final long a;
    final String b;
    final int c;

    zzry(long j, String str, int i) {
        this.a = j;
        this.b = str;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzry)) {
            return false;
        }
        zzry zzryVar = (zzry) obj;
        return zzryVar.a == this.a && zzryVar.c == this.c;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
