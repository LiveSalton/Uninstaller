package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: source */
/* loaded from: classes.dex */
final class abo implements Runnable {
    /* JADX INFO: Access modifiers changed from: private */
    abo() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MessageDigest unused = aam.c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            aam.a.countDown();
        }
    }

    /* synthetic */ abo(acf acfVar) {
        this();
    }
}
