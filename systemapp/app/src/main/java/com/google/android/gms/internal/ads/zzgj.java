package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzgj {
    private static final String a = "zzgj";
    private final zzfa b;
    private final String c;
    private final String d;
    private final Class<?>[] g;
    private final int e = 2;
    private volatile Method f = null;
    private CountDownLatch h = new CountDownLatch(1);

    public zzgj(zzfa zzfaVar, String str, String str2, Class<?>... clsArr) {
        this.b = zzfaVar;
        this.c = str;
        this.d = str2;
        this.g = clsArr;
        this.b.c().submit(new axs(this));
    }

    public final void b() {
        try {
            Class loadClass = this.b.d().loadClass(a(this.b.f(), this.c));
            if (loadClass == null) {
                return;
            }
            this.f = loadClass.getMethod(a(this.b.f(), this.d), this.g);
            if (this.f == null) {
            }
        } catch (zzek unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.h.countDown();
        }
    }

    private final String a(byte[] bArr, String str) throws zzek, UnsupportedEncodingException {
        return new String(this.b.e().a(bArr, str), "UTF-8");
    }

    public final Method a() {
        if (this.f != null) {
            return this.f;
        }
        try {
            if (this.h.await(2L, TimeUnit.SECONDS)) {
                return this.f;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
