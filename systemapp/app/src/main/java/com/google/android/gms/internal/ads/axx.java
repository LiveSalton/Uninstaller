package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: source */
/* loaded from: classes.dex */
final class axx implements zzhd {
    private final zzhy[] a;
    private final zzoh b;
    private final zzoe c;
    private final Handler d;
    private final axz e;
    private final CopyOnWriteArraySet<zzhg> f;
    private final zzie g;
    private final zzib h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private zzhz p;
    private Object q;
    private zznq r;
    private zzoe s;
    private zzhv t;
    private zzho u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public axx(zzhy[] zzhyVarArr, zzoh zzohVar, zzht zzhtVar) {
        String str = zzpt.e;
        StringBuilder sb = new StringBuilder(26 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpc.b(zzhyVarArr.length > 0);
        this.a = (zzhy[]) zzpc.a(zzhyVarArr);
        this.b = (zzoh) zzpc.a(zzohVar);
        this.j = false;
        this.k = 0;
        this.l = 1;
        this.f = new CopyOnWriteArraySet<>();
        this.c = new zzoe(new zzoc[zzhyVarArr.length]);
        this.p = zzhz.a;
        this.g = new zzie();
        this.h = new zzib();
        this.r = zznq.a;
        this.s = this.c;
        this.t = zzhv.a;
        this.d = new axw(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.u = new zzho(0, 0L);
        this.e = new axz(zzhyVarArr, zzohVar, zzhtVar, this.j, 0, this.d, this.u, this);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void a(zzhg zzhgVar) {
        this.f.add(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void b(zzhg zzhgVar) {
        this.f.remove(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final int a() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void a(zzna zznaVar) {
        if (!this.p.a() || this.q != null) {
            this.p = zzhz.a;
            this.q = null;
            Iterator<zzhg> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a(this.p, this.q);
            }
        }
        if (this.i) {
            this.i = false;
            this.r = zznq.a;
            this.s = this.c;
            this.b.a((Object) null);
            Iterator<zzhg> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.r, this.s);
            }
        }
        this.n++;
        this.e.a(zznaVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<zzhg> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.l);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final boolean b() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void a(long j) {
        int i = i();
        if (i < 0 || (!this.p.a() && i >= this.p.b())) {
            throw new zzhu(this.p, i, j);
        }
        this.m++;
        this.v = i;
        if (!this.p.a()) {
            this.p.a(i, this.g, false);
            long b = (j == -9223372036854775807L ? 0L : zzhb.b(j)) + 0;
            long j2 = this.p.a(0, this.h, false).b;
            if (j2 != -9223372036854775807L) {
                int i2 = (b > j2 ? 1 : (b == j2 ? 0 : -1));
            }
        }
        this.w = 0;
        if (j == -9223372036854775807L) {
            this.x = 0L;
            this.e.a(this.p, i, -9223372036854775807L);
            return;
        }
        this.x = j;
        this.e.a(this.p, i, zzhb.b(j));
        Iterator<zzhg> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void c() {
        this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void d() {
        this.e.b();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void a(zzhi... zzhiVarArr) {
        this.e.a(zzhiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final void b(zzhi... zzhiVarArr) {
        this.e.b(zzhiVarArr);
    }

    private final int i() {
        if (this.p.a() || this.m > 0) {
            return this.v;
        }
        this.p.a(this.u.a, this.h, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final long f() {
        if (this.p.a()) {
            return -9223372036854775807L;
        }
        return zzhb.a(this.p.a(i(), this.g, false).i);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final long g() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.a(this.u.a, this.h, false);
        return this.h.a() + zzhb.a(this.u.c);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final long h() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.a(this.u.a, this.h, false);
        return this.h.a() + zzhb.a(this.u.d);
    }

    @Override // com.google.android.gms.internal.ads.zzhd
    public final int e() {
        return this.a.length;
    }

    final void a(Message message) {
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<zzhg> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().a(this.j, this.l);
                }
                return;
            case 2:
                this.o = message.arg1 != 0;
                Iterator<zzhg> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    zzoj zzojVar = (zzoj) message.obj;
                    this.i = true;
                    this.r = zzojVar.a;
                    this.s = zzojVar.b;
                    this.b.a(zzojVar.c);
                    Iterator<zzhg> it3 = this.f.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.m - 1;
                this.m = i;
                if (i == 0) {
                    this.u = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.f.iterator();
                        while (it4.hasNext()) {
                            it4.next().k();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.f.iterator();
                    while (it5.hasNext()) {
                        it5.next().k();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhqVar = (zzhq) message.obj;
                this.m -= zzhqVar.d;
                if (this.n == 0) {
                    this.p = zzhqVar.a;
                    this.q = zzhqVar.b;
                    this.u = zzhqVar.c;
                    Iterator<zzhg> it6 = this.f.iterator();
                    while (it6.hasNext()) {
                        it6.next().a(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                zzhv zzhvVar = (zzhv) message.obj;
                if (this.t.equals(zzhvVar)) {
                    return;
                }
                this.t = zzhvVar;
                Iterator<zzhg> it7 = this.f.iterator();
                while (it7.hasNext()) {
                    it7.next().a(zzhvVar);
                }
                return;
            case 8:
                zzhe zzheVar = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.f.iterator();
                while (it8.hasNext()) {
                    it8.next().a(zzheVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
