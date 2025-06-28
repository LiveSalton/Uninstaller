package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehx {
    private static final ThreadLocal<SecureRandom> a = new ase();

    public static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        a.get().nextBytes(bArr);
        return bArr;
    }
}
