package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdy implements zzdv {
    protected static volatile zzfa b;
    private double a;
    protected MotionEvent c;
    protected double l;
    protected float m;
    protected float n;
    protected float o;
    protected float p;
    protected DisplayMetrics r;
    private double s;
    protected LinkedList<MotionEvent> d = new LinkedList<>();
    protected long e = 0;
    protected long f = 0;
    protected long g = 0;
    protected long h = 0;
    protected long i = 0;
    protected long j = 0;
    protected long k = 0;
    private boolean t = false;
    protected boolean q = false;

    protected zzdy(Context context) {
        try {
            if (((Boolean) zzwq.e().a(zzabf.bn)).booleanValue()) {
                aam.a();
            } else {
                axm.a(b);
            }
            this.r = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr) throws zzet;

    protected abstract zzcf.zza.C0060zza a(Context context, zzby.zza zzaVar);

    @Override // com.google.android.gms.internal.ads.zzdv
    public void a(View view) {
    }

    protected abstract zzcf.zza.C0060zza b(Context context, View view, Activity activity);

    protected abstract zzfg b(MotionEvent motionEvent) throws zzet;

    protected abstract zzcf.zza.C0060zza c(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzdv
    public String a(Context context) {
        if (zzff.a()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return a(context, null, zzcw.d, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public String a(Context context, View view, Activity activity) {
        return a(context, null, zzcw.e, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public final String a(Context context, String str, View view) {
        return a(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public String a(Context context, String str, View view, Activity activity) {
        return a(context, str, zzcw.f, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public void a(MotionEvent motionEvent) {
        boolean z = false;
        if (this.t) {
            a();
            this.t = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.l = 0.0d;
                this.a = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
                break;
            case 1:
            case 2:
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = rawX - this.a;
                double d2 = rawY - this.s;
                this.l += Math.sqrt((d * d) + (d2 * d2));
                this.a = rawX;
                this.s = rawY;
                break;
        }
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    this.m = motionEvent.getX();
                    this.n = motionEvent.getY();
                    this.o = motionEvent.getRawX();
                    this.p = motionEvent.getRawY();
                    this.e++;
                    break;
                case 1:
                    this.c = MotionEvent.obtain(motionEvent);
                    this.d.add(this.c);
                    if (this.d.size() > 6) {
                        this.d.remove().recycle();
                    }
                    this.g++;
                    this.i = a(new Throwable().getStackTrace());
                    break;
                case 2:
                    this.f += motionEvent.getHistorySize() + 1;
                    zzfg b2 = b(motionEvent);
                    if ((b2 == null || b2.d == null || b2.g == null) ? false : true) {
                        this.j += b2.d.longValue() + b2.g.longValue();
                    }
                    if (this.r != null && b2 != null && b2.e != null && b2.h != null) {
                        z = true;
                    }
                    if (z) {
                        this.k += b2.e.longValue() + b2.h.longValue();
                        break;
                    }
                    break;
                case 3:
                    this.h++;
                    break;
            }
        } catch (zzet unused) {
        }
        this.q = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdv
    public void a(int i, int i2, int i3) {
        if (this.c != null) {
            if (((Boolean) zzwq.e().a(zzabf.bc)).booleanValue()) {
                a();
            } else {
                this.c.recycle();
            }
        }
        if (this.r != null) {
            this.c = MotionEvent.obtain(0L, i3, 1, this.r.density * i, this.r.density * i2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.c = null;
        }
        this.q = false;
    }

    private final void a() {
        this.i = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.j = 0L;
        this.k = 0L;
        if (this.d.size() > 0) {
            Iterator<MotionEvent> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.d.clear();
        } else if (this.c != null) {
            this.c.recycle();
        }
        this.c = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String a(android.content.Context r21, java.lang.String r22, int r23, android.view.View r24, android.app.Activity r25, byte[] r26) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdy.a(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }
}
