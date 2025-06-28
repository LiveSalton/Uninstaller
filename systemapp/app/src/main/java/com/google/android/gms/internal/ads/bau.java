package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
final class bau implements zzmy, zznb {
    public final zzmy[] a;
    private final IdentityHashMap<zznn, Integer> b = new IdentityHashMap<>();
    private zznb c;
    private int d;
    private zznq e;
    private zzmy[] f;
    private zznm g;

    public bau(zzmy... zzmyVarArr) {
        this.a = zzmyVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void a(zznb zznbVar, long j) {
        this.c = zznbVar;
        this.d = this.a.length;
        for (zzmy zzmyVar : this.a) {
            zzmyVar.a(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void c() throws IOException {
        for (zzmy zzmyVar : this.a) {
            zzmyVar.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final zznq d() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long a(zzoc[] zzocVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[zzocVarArr.length];
        int[] iArr2 = new int[zzocVarArr.length];
        for (int i = 0; i < zzocVarArr.length; i++) {
            iArr[i] = zznnVarArr[i] == null ? -1 : this.b.get(zznnVarArr[i]).intValue();
            iArr2[i] = -1;
            if (zzocVarArr[i] != null) {
                zznr a = zzocVarArr[i].a();
                int i2 = 0;
                while (true) {
                    if (i2 >= this.a.length) {
                        break;
                    }
                    if (this.a[i2].d().a(a) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.b.clear();
        zznn[] zznnVarArr2 = new zznn[zzocVarArr.length];
        zznn[] zznnVarArr3 = new zznn[zzocVarArr.length];
        zzoc[] zzocVarArr2 = new zzoc[zzocVarArr.length];
        ArrayList arrayList = new ArrayList(this.a.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.a.length) {
            for (int i4 = 0; i4 < zzocVarArr.length; i4++) {
                zzoc zzocVar = null;
                zznnVarArr3[i4] = iArr[i4] == i3 ? zznnVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzocVar = zzocVarArr[i4];
                }
                zzocVarArr2[i4] = zzocVar;
            }
            zzoc[] zzocVarArr3 = zzocVarArr2;
            ArrayList arrayList2 = arrayList;
            zzoc[] zzocVarArr4 = zzocVarArr2;
            int i5 = i3;
            long a2 = this.a[i3].a(zzocVarArr3, zArr, zznnVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = a2;
            } else if (a2 != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzocVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzpc.b(zznnVarArr3[i6] != null);
                    zznnVarArr2[i6] = zznnVarArr3[i6];
                    this.b.put(zznnVarArr3[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzpc.b(zznnVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzocVarArr2 = zzocVarArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnVarArr2, 0, zznnVarArr, 0, zznnVarArr2.length);
        this.f = new zzmy[arrayList3.size()];
        arrayList3.toArray(this.f);
        this.g = new zzmp(this.f);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final void a(long j) {
        for (zzmy zzmyVar : this.f) {
            zzmyVar.a(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmy, com.google.android.gms.internal.ads.zznm
    public final boolean b(long j) {
        return this.g.b(j);
    }

    @Override // com.google.android.gms.internal.ads.zzmy, com.google.android.gms.internal.ads.zznm
    public final long e() {
        return this.g.e();
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long f() {
        long f = this.a[0].f();
        for (int i = 1; i < this.a.length; i++) {
            if (this.a[i].f() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (f != -9223372036854775807L) {
            for (zzmy zzmyVar : this.f) {
                if (zzmyVar != this.a[0] && zzmyVar.c(f) != f) {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long g() {
        long j = Long.MAX_VALUE;
        for (zzmy zzmyVar : this.f) {
            long g = zzmyVar.g();
            if (g != Long.MIN_VALUE) {
                j = Math.min(j, g);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzmy
    public final long c(long j) {
        long c = this.f[0].c(j);
        for (int i = 1; i < this.f.length; i++) {
            if (this.f[i].c(c) != c) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return c;
    }

    @Override // com.google.android.gms.internal.ads.zznb
    public final void a(zzmy zzmyVar) {
        int i = this.d - 1;
        this.d = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zzmy zzmyVar2 : this.a) {
            i2 += zzmyVar2.d().b;
        }
        zznr[] zznrVarArr = new zznr[i2];
        zzmy[] zzmyVarArr = this.a;
        int length = zzmyVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            zznq d = zzmyVarArr[i3].d();
            int i5 = d.b;
            int i6 = i4;
            int i7 = 0;
            while (i7 < i5) {
                zznrVarArr[i6] = d.a(i7);
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        this.e = new zznq(zznrVarArr);
        this.c.a((zzmy) this);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void a(zzmy zzmyVar) {
        if (this.e != null) {
            this.c.a((zznb) this);
        }
    }
}
