package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class alj extends alk {
    private final char a = ';';

    alj(char c) {
    }

    @Override // com.google.android.gms.internal.ads.zzdvd
    public final boolean b(char c) {
        return c == this.a;
    }

    public final String toString() {
        String d;
        d = zzdvd.d(this.a);
        StringBuilder sb = new StringBuilder(18 + String.valueOf(d).length());
        sb.append("CharMatcher.is('");
        sb.append(d);
        sb.append("')");
        return sb.toString();
    }
}
