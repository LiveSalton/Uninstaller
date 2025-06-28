package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzav {
    public final String a;
    public final double b;
    public final int c;
    private final double d;
    private final double e;

    public zzav(String str, double d, double d2, double d3, int i) {
        this.a = str;
        this.e = d;
        this.d = d2;
        this.b = d3;
        this.c = i;
    }

    public final String toString() {
        return Objects.a(this).a("name", this.a).a("minBound", Double.valueOf(this.e)).a("maxBound", Double.valueOf(this.d)).a("percent", Double.valueOf(this.b)).a("count", Integer.valueOf(this.c)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzavVar = (zzav) obj;
        return Objects.a(this.a, zzavVar.a) && this.d == zzavVar.d && this.e == zzavVar.e && this.c == zzavVar.c && Double.compare(this.b, zzavVar.b) == 0;
    }

    public final int hashCode() {
        return Objects.a(this.a, Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.b), Integer.valueOf(this.c));
    }
}
