package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzcw;
import com.google.android.gms.internal.ads.zzdp;
import com.google.android.gms.internal.ads.zzdv;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzwq;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzf implements zzdv, Runnable {
    private final int d;
    private Context e;
    private zzazh f;
    private final List<Object[]> a = new Vector();
    private final AtomicReference<zzdv> b = new AtomicReference<>();
    private final AtomicReference<zzdv> c = new AtomicReference<>();
    private CountDownLatch g = new CountDownLatch(1);

    public zzf(Context context, zzazh zzazhVar) {
        this.e = context;
        this.f = zzazhVar;
        switch (((Integer) zzwq.e().a(zzabf.bb)).intValue()) {
            case 1:
                this.d = zzcw.b;
                break;
            case 2:
                this.d = zzcw.c;
                break;
            default:
                this.d = zzcw.a;
                break;
        }
        if (((Boolean) zzwq.e().a(zzabf.bp)).booleanValue()) {
            zzazj.a.execute(this);
            return;
        }
        zzwq.a();
        if (zzayr.b()) {
            zzazj.a.execute(this);
        } else {
            run();
        }
    }

    private final boolean a() {
        try {
            this.g.await();
            return true;
        } catch (InterruptedException e) {
            zzd.d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void b() {
        zzdv c = c();
        if (this.a.isEmpty() || c == null) {
            return;
        }
        for (Object[] objArr : this.a) {
            if (objArr.length == 1) {
                c.a((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                c.a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.a.clear();
    }

    private static Context b(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context) {
        zzdv zzdvVar;
        if (!a()) {
            return "";
        }
        if (this.d == zzcw.b || this.d == zzcw.c) {
            zzdvVar = this.c.get();
        } else {
            zzdvVar = this.b.get();
        }
        if (zzdvVar == null) {
            return "";
        }
        b();
        return zzdvVar.a(b(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, View view, Activity activity) {
        zzdv c = c();
        return c != null ? c.a(context, view, activity) : "";
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, String str, View view) {
        return a(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, String str, View view, Activity activity) {
        zzdv c;
        if (!a() || (c = c()) == null) {
            return "";
        }
        b();
        return c.a(b(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(View view) {
        zzdv c = c();
        if (c != null) {
            c.a(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(MotionEvent motionEvent) {
        zzdv c = c();
        if (c != null) {
            b();
            c.a(motionEvent);
        } else {
            this.a.add(new Object[]{motionEvent});
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final void a(int i, int i2, int i3) {
        zzdv c = c();
        if (c != null) {
            b();
            c.a(i, i2, i3);
        } else {
            this.a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.f.d;
            if (!((Boolean) zzwq.e().a(zzabf.au)).booleanValue() && z2) {
                z = true;
            }
            if (this.d != zzcw.b) {
                this.b.set(zzeg.b(this.f.a, b(this.e), z, this.d));
            }
            if (this.d != zzcw.a) {
                this.c.set(zzdp.a(this.f.a, b(this.e), z));
            }
        } finally {
            this.g.countDown();
            this.e = null;
            this.f = null;
        }
    }

    private final zzdv c() {
        if (this.d == zzcw.b) {
            return this.c.get();
        }
        return this.b.get();
    }
}
