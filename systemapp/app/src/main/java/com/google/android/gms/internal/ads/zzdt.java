package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzdt {
    protected static volatile zztx a;
    private static final ConditionVariable d = new ConditionVariable();
    private static volatile Random e;
    protected volatile Boolean b;
    private zzfa c;

    public zzdt(zzfa zzfaVar) {
        this.c = zzfaVar;
        zzfaVar.c().execute(new alw(this));
    }

    public final void a(int i, int i2, long j) {
        a(i, i2, j, null, null);
    }

    public final void a(int i, int i2, long j, String str) {
        a(i, -1, j, str, null);
    }

    public final void a(int i, int i2, long j, String str, Exception exc) {
        try {
            d.block();
            if (!this.b.booleanValue() || a == null) {
                return;
            }
            zzbw.zza.C0057zza a2 = zzbw.zza.a().a(this.c.a.getPackageName()).a(j);
            if (str != null) {
                a2.d(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzeid.a(exc, new PrintWriter(stringWriter));
                a2.b(stringWriter.toString()).c(exc.getClass().getName());
            }
            zzub a3 = a.a(((zzbw.zza) ((zzekh) a2.g())).l());
            a3.b(i);
            if (i2 != -1) {
                a3.a(i2);
            }
            a3.a();
        } catch (Exception unused) {
        }
    }

    public static int a() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return c().nextInt();
        } catch (RuntimeException unused) {
            return c().nextInt();
        }
    }

    private static Random c() {
        if (e == null) {
            synchronized (zzdt.class) {
                if (e == null) {
                    e = new Random();
                }
            }
        }
        return e;
    }
}
