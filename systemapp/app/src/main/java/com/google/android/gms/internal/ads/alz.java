package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class alz {
    static void a(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(24 + String.valueOf(valueOf).length());
            sb.append("null key in entry: null=");
            sb.append(valueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(26 + String.valueOf(valueOf2).length());
            sb2.append("null value in entry: ");
            sb2.append(valueOf2);
            sb2.append("=null");
            throw new NullPointerException(sb2.toString());
        }
    }

    static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(40 + String.valueOf(str).length());
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
