package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdvd {
    public static zzdvd a(char c) {
        return new alj(';');
    }

    public abstract boolean b(char c);

    protected zzdvd() {
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdvv.a(i, length, "index");
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String d(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
