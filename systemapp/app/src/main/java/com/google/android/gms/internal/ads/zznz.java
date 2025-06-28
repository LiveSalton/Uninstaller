package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zznz {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final int g;
    public final boolean h;
    private final String i;
    private final String j;
    private final boolean k;
    private final boolean l;

    public zznz() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    private zznz(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = true;
        this.a = Integer.MAX_VALUE;
        this.b = Integer.MAX_VALUE;
        this.c = Integer.MAX_VALUE;
        this.d = true;
        this.e = true;
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
        this.h = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zznz zznzVar = (zznz) obj;
        return this.l == zznzVar.l && this.a == zznzVar.a && this.b == zznzVar.b && this.d == zznzVar.d && this.e == zznzVar.e && this.h == zznzVar.h && this.f == zznzVar.f && this.g == zznzVar.g && this.c == zznzVar.c && TextUtils.equals(null, null) && TextUtils.equals(null, null);
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.l ? 1 : 0)) * 31) + this.a) * 31) + this.b) * 31) + this.c) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + this.f) * 31) + this.g;
    }
}
