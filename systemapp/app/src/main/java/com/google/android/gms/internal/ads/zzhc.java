package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzhc implements zzhx, zzhy {
    private final int a;
    private zzia b;
    private int c;
    private int d;
    private zznn e;
    private long f;
    private boolean g = true;
    private boolean h;

    public zzhc(int i) {
        this.a = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhf
    public void a(int i, Object obj) throws zzhe {
    }

    protected void a(long j, boolean z) throws zzhe {
    }

    protected void a(boolean z) throws zzhe {
    }

    protected void a(zzhp[] zzhpVarArr, long j) throws zzhe {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzhx b() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public zzpg c() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public int m() throws zzhe {
        return 0;
    }

    protected void n() throws zzhe {
    }

    protected void o() throws zzhe {
    }

    protected void p() {
    }

    @Override // com.google.android.gms.internal.ads.zzhx, com.google.android.gms.internal.ads.zzhy
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void a(int i) {
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int d() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void a(zzia zziaVar, zzhp[] zzhpVarArr, zznn zznnVar, long j, boolean z, long j2) throws zzhe {
        zzpc.b(this.d == 0);
        this.b = zziaVar;
        this.d = 1;
        a(z);
        a(zzhpVarArr, zznnVar, j2);
        a(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void e() throws zzhe {
        zzpc.b(this.d == 1);
        this.d = 2;
        n();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void a(zzhp[] zzhpVarArr, zznn zznnVar, long j) throws zzhe {
        zzpc.b(!this.h);
        this.e = zznnVar;
        this.g = false;
        this.f = j;
        a(zzhpVarArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zznn f() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean g() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void h() {
        this.h = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final boolean i() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void j() throws IOException {
        this.e.b();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void a(long j) throws zzhe {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void k() throws zzhe {
        zzpc.b(this.d == 2);
        this.d = 1;
        o();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void l() {
        zzpc.b(this.d == 1);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    protected final zzia q() {
        return this.b;
    }

    protected final int r() {
        return this.c;
    }

    protected final int a(zzhr zzhrVar, zzjl zzjlVar, boolean z) {
        int a = this.e.a(zzhrVar, zzjlVar, z);
        if (a == -4) {
            if (zzjlVar.c()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            zzjlVar.c += this.f;
        } else if (a == -5) {
            zzhp zzhpVar = zzhrVar.a;
            if (zzhpVar.p != Long.MAX_VALUE) {
                zzhrVar.a = zzhpVar.a(zzhpVar.p + this.f);
            }
        }
        return a;
    }

    protected final void b(long j) {
        this.e.a(j - this.f);
    }

    protected final boolean s() {
        return this.g ? this.h : this.e.a();
    }
}
