package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdp implements zzdv {
    private static zzdp a;
    private final Context b;
    private final zzdtz c;
    private final zzdui d;
    private final zzduj e;
    private final axh f;
    private final zzdsi g;
    private final Executor h;
    private final zzgn i;
    private final zzduf j;
    private volatile long k = 0;
    private final Object l = new Object();
    private volatile boolean m;

    public static synchronized zzdp a(String str, Context context, boolean z) {
        zzdp zzdpVar;
        synchronized (zzdp.class) {
            if (a == null) {
                zzdsj a2 = zzdsj.d().a(str).a(z).a();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdp a3 = a(context, zzdsi.a(context, newCachedThreadPool), a2, newCachedThreadPool);
                a = a3;
                a3.a();
                a.d();
            }
            zzdpVar = a;
        }
        return zzdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(int i, int i2, int i3) {
    }

    static zzdp a(Context context, zzdsi zzdsiVar, zzdsj zzdsjVar) {
        return a(context, zzdsiVar, zzdsjVar, Executors.newCachedThreadPool());
    }

    private static zzdp a(Context context, zzdsi zzdsiVar, zzdsj zzdsjVar, Executor executor) {
        zzdsv a2 = zzdsv.a(context, executor, zzdsiVar, zzdsjVar);
        zzey zzeyVar = new zzey(context);
        axh axhVar = new axh(zzdsjVar, a2, new zzfh(context, zzeyVar), zzeyVar);
        zzgn a3 = new zzdtl(context, zzdsiVar).a();
        zzdsg zzdsgVar = new zzdsg();
        return new zzdp(context, zzdsiVar, new zzdtz(context, a3), new zzdui(context, a3, new akd(zzdsiVar)), new zzduj(context, axhVar, zzdsiVar, zzdsgVar), axhVar, executor, zzdsgVar, a3);
    }

    private zzdp(Context context, zzdsi zzdsiVar, zzdtz zzdtzVar, zzdui zzduiVar, zzduj zzdujVar, axh axhVar, Executor executor, zzdsg zzdsgVar, zzgn zzgnVar) {
        this.b = context;
        this.g = zzdsiVar;
        this.c = zzdtzVar;
        this.d = zzduiVar;
        this.e = zzdujVar;
        this.f = axhVar;
        this.h = executor;
        this.i = zzgnVar;
        this.j = new ajq(this, zzdsgVar);
    }

    final synchronized void a() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdua a2 = a(zzduh.a);
        if (a2 != null && !a2.e()) {
            this.e.a(a2);
        } else {
            this.g.a(4013, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void b() {
        if (zzdtl.a(this.i)) {
            this.h.execute(new alc(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa A[Catch: zzeks -> 0x011a, TryCatch #0 {zzeks -> 0x011a, blocks: (B:5:0x0022, B:7:0x0033, B:10:0x003a, B:12:0x0058, B:14:0x0066, B:17:0x0072, B:21:0x00aa, B:24:0x00b7, B:28:0x00d0, B:30:0x00e9, B:32:0x00f6, B:34:0x00fe, B:39:0x00da, B:40:0x00e1, B:41:0x007b, B:44:0x0082, B:46:0x0094, B:50:0x010d), top: B:4:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7 A[Catch: zzeks -> 0x011a, TryCatch #0 {zzeks -> 0x011a, blocks: (B:5:0x0022, B:7:0x0033, B:10:0x003a, B:12:0x0058, B:14:0x0066, B:17:0x0072, B:21:0x00aa, B:24:0x00b7, B:28:0x00d0, B:30:0x00e9, B:32:0x00f6, B:34:0x00fe, B:39:0x00da, B:40:0x00e1, B:41:0x007b, B:44:0x0082, B:46:0x0094, B:50:0x010d), top: B:4:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.c():void");
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(MotionEvent motionEvent) {
        zzdsl a2 = this.e.a();
        if (a2 != null) {
            try {
                a2.a((String) null, motionEvent);
            } catch (zzduk e) {
                this.g.a(e.a(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, String str, View view, Activity activity) {
        d();
        zzdsl a2 = this.e.a();
        if (a2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a3 = a2.a(context, null, str, view, activity);
        this.g.a(5000, System.currentTimeMillis() - currentTimeMillis, a3, null);
        return a3;
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, String str, View view) {
        return a(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(View view) {
        this.f.a(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, View view, Activity activity) {
        d();
        zzdsl a2 = this.e.a();
        if (a2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a3 = a2.a(context, null, view, activity);
        this.g.a(5002, System.currentTimeMillis() - currentTimeMillis, a3, null);
        return a3;
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context) {
        d();
        zzdsl a2 = this.e.a();
        if (a2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a3 = a2.a(context, (String) null);
        this.g.a(5001, System.currentTimeMillis() - currentTimeMillis, a3, null);
        return a3;
    }

    private final void d() {
        if (this.m) {
            return;
        }
        synchronized (this.l) {
            if (!this.m) {
                if ((System.currentTimeMillis() / 1000) - this.k < 3600) {
                    return;
                }
                zzdua b = this.e.b();
                if (b == null || b.a(3600L)) {
                    b();
                }
            }
        }
    }

    private final zzdua a(int i) {
        if (!zzdtl.a(this.i)) {
            return null;
        }
        if (((Boolean) zzwq.e().a(zzabf.ba)).booleanValue()) {
            return this.d.a(i);
        }
        return this.c.a(i);
    }
}
