package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzrq {
    private static MessageDigest b;
    protected Object a = new Object();

    abstract byte[] a(String str);

    protected final MessageDigest a() {
        synchronized (this.a) {
            if (b != null) {
                return b;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    b = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return b;
        }
    }
}
