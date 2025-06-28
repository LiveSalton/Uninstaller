package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
final class r extends zzabm {
    r() {
    }

    @Override // com.google.android.gms.internal.ads.zzabm
    public final String a(String str, String str2) {
        String a = a(str);
        String a2 = a(str2);
        if (TextUtils.isEmpty(a)) {
            return a2;
        }
        if (TextUtils.isEmpty(a2)) {
            return a;
        }
        StringBuilder sb = new StringBuilder(1 + String.valueOf(a).length() + String.valueOf(a2).length());
        sb.append(a);
        sb.append(",");
        sb.append(a2);
        return sb.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }
}
