package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzoo {
    public final Uri a;
    public final byte[] b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public zzoo(Uri uri) {
        this(uri, 0);
    }

    private zzoo(Uri uri, int i) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzoo(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    private zzoo(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    private zzoo(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, 0);
    }

    public zzoo(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        zzpc.a(j >= 0);
        zzpc.a(j2 >= 0);
        zzpc.a(j3 > 0 || j3 == -1);
        this.a = uri;
        this.b = bArr;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i) {
        return (this.g & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String arrays = Arrays.toString(this.b);
        long j = this.c;
        long j2 = this.d;
        long j3 = this.e;
        String str = this.f;
        int i = this.g;
        StringBuilder sb = new StringBuilder(93 + String.valueOf(valueOf).length() + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
