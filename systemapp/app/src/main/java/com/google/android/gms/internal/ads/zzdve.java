package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdve {
    private static int a(char c) {
        return (char) ((c | ' ') - 97);
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int a;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            char charAt2 = charSequence2.charAt(i);
            if (charAt != charAt2 && ((a = a(charAt)) >= 26 || a != a(charAt2))) {
                return false;
            }
        }
        return true;
    }
}
