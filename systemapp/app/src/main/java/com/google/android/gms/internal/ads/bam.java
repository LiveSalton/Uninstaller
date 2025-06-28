package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class bam implements zzjy, zzmy, zznk, zzoz<bas> {
    private boolean[] A;
    private boolean B;
    private long D;
    private int F;
    private boolean G;
    private boolean H;
    private final Uri a;
    private final zzon b;
    private final int c;
    private final Handler d;
    private final zzmz e;
    private final zznd f;
    private final zzol g;
    private final long i;
    private final bar k;
    private zznb q;
    private zzkf r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private zznq x;
    private long y;
    private boolean[] z;
    private final String h = null;
    private final zzow j = new zzow("Loader:ExtractorMediaPeriod");
    private final zzpe l = new zzpe();
    private final Runnable m = new bao(this);
    private final Runnable n = new ban(this);
    private final Handler o = new Handler();
    private long E = -9223372036854775807L;
    private final SparseArray<zzni> p = new SparseArray<>();
    private long C = -1;

    public bam(Uri uri, zzon zzonVar, zzjw[] zzjwVarArr, int i, Handler handler, zzmz zzmzVar, zznd zzndVar, zzol zzolVar, String str, int i2) {
        this.a = uri;
        this.b = zzonVar;
        this.c = i;
        this.d = handler;
        this.e = zzmzVar;
        this.f = zzndVar;
        this.g = zzolVar;
        this.i = i2;
        this.k = new bar(zzjwVarArr, this);
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void a(long j) {
    }

    public final void b() {
        this.j.a(new baq(this, this.k));
        this.o.removeCallbacksAndMessages(null);
        this.H = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void a(zznb zznbVar, long j) {
        this.q = zznbVar;
        this.l.a();
        j();
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void c() throws IOException {
        this.j.a(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final zznq d() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long a(zzoc[] zzocVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j) {
        int i;
        zzpc.b(this.t);
        for (int i2 = 0; i2 < zzocVarArr.length; i2++) {
            if (zznnVarArr[i2] != null && (zzocVarArr[i2] == null || !zArr[i2])) {
                i = ((bat) zznnVarArr[i2]).a;
                zzpc.b(this.z[i]);
                this.w--;
                this.z[i] = false;
                this.p.valueAt(i).b();
                zznnVarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzocVarArr.length; i3++) {
            if (zznnVarArr[i3] == null && zzocVarArr[i3] != null) {
                zzoc zzocVar = zzocVarArr[i3];
                zzpc.b(zzocVar.b() == 1);
                zzpc.b(zzocVar.b(0) == 0);
                int a = this.x.a(zzocVar.a());
                zzpc.b(!this.z[a]);
                this.w++;
                this.z[a] = true;
                zznnVarArr[i3] = new bat(this, a);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.u) {
            int size = this.p.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.z[i4]) {
                    this.p.valueAt(i4).b();
                }
            }
        }
        if (this.w == 0) {
            this.v = false;
            if (this.j.a()) {
                this.j.b();
            }
        } else if (!this.u ? j != 0 : z) {
            j = c(j);
            for (int i5 = 0; i5 < zznnVarArr.length; i5++) {
                if (zznnVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.u = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzmy, com.google.android.gms.internal.ads.zznm
    public final boolean b(long j) {
        if (this.G) {
            return false;
        }
        if (this.t && this.w == 0) {
            return false;
        }
        boolean a = this.l.a();
        if (this.j.a()) {
            return a;
        }
        j();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzmy, com.google.android.gms.internal.ads.zznm
    public final long e() {
        if (this.w == 0) {
            return Long.MIN_VALUE;
        }
        return g();
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long f() {
        if (!this.v) {
            return -9223372036854775807L;
        }
        this.v = false;
        return this.D;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long g() {
        long l;
        if (this.G) {
            return Long.MIN_VALUE;
        }
        if (m()) {
            return this.E;
        }
        if (this.B) {
            l = Long.MAX_VALUE;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                if (this.A[i]) {
                    l = Math.min(l, this.p.valueAt(i).e());
                }
            }
        } else {
            l = l();
        }
        return l == Long.MIN_VALUE ? this.D : l;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long c(long j) {
        if (!this.r.a()) {
            j = 0;
        }
        this.D = j;
        int size = this.p.size();
        boolean z = !m();
        for (int i = 0; z && i < size; i++) {
            if (this.z[i]) {
                z = this.p.valueAt(i).a(j, false);
            }
        }
        if (!z) {
            this.E = j;
            this.G = false;
            if (this.j.a()) {
                this.j.b();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.p.valueAt(i2).a(this.z[i2]);
                }
            }
        }
        this.v = false;
        return j;
    }

    final boolean a(int i) {
        if (this.G) {
            return true;
        }
        return !m() && this.p.valueAt(i).c();
    }

    final void h() throws IOException {
        this.j.a(Integer.MIN_VALUE);
    }

    final int a(int i, zzhr zzhrVar, zzjl zzjlVar, boolean z) {
        if (this.v || m()) {
            return -3;
        }
        return this.p.valueAt(i).a(zzhrVar, zzjlVar, z, this.G, this.D);
    }

    final void a(int i, long j) {
        zzni valueAt = this.p.valueAt(i);
        if (this.G && j > valueAt.e()) {
            valueAt.f();
        } else {
            valueAt.a(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final zzkh a(int i, int i2) {
        zzni zzniVar = this.p.get(i);
        if (zzniVar != null) {
            return zzniVar;
        }
        zzni zzniVar2 = new zzni(this.g);
        zzniVar2.a(this);
        this.p.put(i, zzniVar2);
        return zzniVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void a() {
        this.s = true;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zzjy
    public final void a(zzkf zzkfVar) {
        this.r = zzkfVar;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zznk
    public final void a(zzhp zzhpVar) {
        this.o.post(this.m);
    }

    public final void i() {
        if (this.H || this.t || this.r == null || !this.s) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (this.p.valueAt(i).d() == null) {
                return;
            }
        }
        this.l.b();
        zznr[] zznrVarArr = new zznr[size];
        this.A = new boolean[size];
        this.z = new boolean[size];
        this.y = this.r.b();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                zzhp d = this.p.valueAt(i2).d();
                zznrVarArr[i2] = new zznr(d);
                String str = d.d;
                if (!zzpj.b(str) && !zzpj.a(str)) {
                    z = false;
                }
                this.A[i2] = z;
                this.B = z | this.B;
                i2++;
            } else {
                this.x = new zznq(zznrVarArr);
                this.t = true;
                this.f.a(new zzno(this.y, this.r.a()), null);
                this.q.a((zzmy) this);
                return;
            }
        }
    }

    private final void a(bas basVar) {
        if (this.C == -1) {
            this.C = basVar.i;
        }
    }

    private final void j() {
        bas basVar = new bas(this, this.a, this.b, this.k, this.l);
        if (this.t) {
            zzpc.b(m());
            if (this.y != -9223372036854775807L && this.E >= this.y) {
                this.G = true;
                this.E = -9223372036854775807L;
                return;
            } else {
                basVar.a(this.r.a(this.E), this.E);
                this.E = -9223372036854775807L;
            }
        }
        this.F = k();
        int i = this.c;
        if (i == -1) {
            i = (this.t && this.C == -1 && (this.r == null || this.r.b() == -9223372036854775807L)) ? 6 : 3;
        }
        this.j.a(basVar, this, i);
    }

    private final int k() {
        int size = this.p.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.p.valueAt(i2).a();
        }
        return i;
    }

    private final long l() {
        int size = this.p.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.p.valueAt(i).e());
        }
        return j;
    }

    private final boolean m() {
        return this.E != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ int a(bas basVar, long j, long j2, IOException iOException) {
        bas basVar2 = basVar;
        a(basVar2);
        if (this.d != null && this.e != null) {
            this.d.post(new bap(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = k() > this.F;
        if (this.C == -1 && (this.r == null || this.r.b() == -9223372036854775807L)) {
            this.D = 0L;
            this.v = this.t;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.valueAt(i).a(!this.t || this.z[i]);
            }
            basVar2.a(0L, 0L);
        }
        this.F = k();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void a(bas basVar, long j, long j2, boolean z) {
        a(basVar);
        if (z || this.w <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            this.p.valueAt(i).a(this.z[i]);
        }
        this.q.a((zznb) this);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void a(bas basVar, long j, long j2) {
        a(basVar);
        this.G = true;
        if (this.y == -9223372036854775807L) {
            long l = l();
            this.y = l == Long.MIN_VALUE ? 0L : l + 10000;
            this.f.a(new zzno(this.y, this.r.a()), null);
        }
        this.q.a((zznb) this);
    }
}
