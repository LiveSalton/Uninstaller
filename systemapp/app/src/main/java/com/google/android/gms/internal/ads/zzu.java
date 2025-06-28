package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzu {
    private final String a;
    private final String b;

    public zzu(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzu zzuVar = (zzu) obj;
        return TextUtils.equals(this.a, zzuVar.a) && TextUtils.equals(this.b, zzuVar.b);
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(20 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
