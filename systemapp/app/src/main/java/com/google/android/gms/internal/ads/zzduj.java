package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzduj {
    private static final HashMap<String, Class<?>> a = new HashMap<>();
    private final Context b;
    private final zzdum c;
    private final zzdsi d;
    private final zzdsg e;
    private alb f;
    private final Object g = new Object();

    public zzduj(Context context, zzdum zzdumVar, zzdsi zzdsiVar, zzdsg zzdsgVar) {
        this.b = context;
        this.c = zzdumVar;
        this.d = zzdsiVar;
        this.e = zzdsgVar;
    }

    private final synchronized Class<?> b(zzdua zzduaVar) throws zzduk {
        if (zzduaVar.a() == null) {
            throw new zzduk(4010, "mc");
        }
        String a2 = zzduaVar.a().a();
        Class<?> cls = a.get(a2);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.e.a(zzduaVar.b())) {
                throw new zzduk(2026, "VM did not pass signature verification");
            }
            try {
                File c = zzduaVar.c();
                if (!c.exists()) {
                    c.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzduaVar.b().getAbsolutePath(), c.getAbsolutePath(), null, this.b.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                a.put(a2, loadClass);
                return loadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e) {
                throw new zzduk(2008, e);
            }
        } catch (GeneralSecurityException e2) {
            throw new zzduk(2026, e2);
        }
    }

    private final Object a(Class<?> cls, zzdua zzduaVar) throws zzduk {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.b, "msa-r", zzduaVar.d(), null, new Bundle(), 2);
        } catch (Exception e) {
            throw new zzduk(2004, e);
        }
    }

    public final void a(zzdua zzduaVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            alb albVar = new alb(a(b(zzduaVar), zzduaVar), zzduaVar, this.c, this.d);
            if (!albVar.b()) {
                throw new zzduk(4000, "init failed");
            }
            int d = albVar.d();
            if (d != 0) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(d);
                throw new zzduk(4001, sb.toString());
            }
            synchronized (this.g) {
                if (this.f != null) {
                    try {
                        this.f.c();
                    } catch (zzduk e) {
                        this.d.a(e.a(), -1L, e);
                    }
                }
                this.f = albVar;
            }
            this.d.a(3000, System.currentTimeMillis() - currentTimeMillis);
        } catch (zzduk e2) {
            this.d.a(e2.a(), System.currentTimeMillis() - currentTimeMillis, e2);
        } catch (Exception e3) {
            this.d.a(4010, System.currentTimeMillis() - currentTimeMillis, e3);
        }
    }

    public final zzdsl a() {
        alb albVar;
        synchronized (this.g) {
            albVar = this.f;
        }
        return albVar;
    }

    public final zzdua b() {
        synchronized (this.g) {
            if (this.f == null) {
                return null;
            }
            return this.f.a();
        }
    }
}
