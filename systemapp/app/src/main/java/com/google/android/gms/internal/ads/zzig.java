package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

/* compiled from: source */
@TargetApi(21)
/* loaded from: classes.dex */
public final class zzig {
    private static final zzig a = new zzig(new int[]{2}, 2);
    private final int[] b;
    private final int c;

    private zzig(int[] iArr, int i) {
        this.b = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.b);
        this.c = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzig)) {
            return false;
        }
        zzig zzigVar = (zzig) obj;
        return Arrays.equals(this.b, zzigVar.b) && this.c == zzigVar.c;
    }

    public final int hashCode() {
        return this.c + (31 * Arrays.hashCode(this.b));
    }

    public final String toString() {
        int i = this.c;
        String arrays = Arrays.toString(this.b);
        StringBuilder sb = new StringBuilder(67 + String.valueOf(arrays).length());
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
