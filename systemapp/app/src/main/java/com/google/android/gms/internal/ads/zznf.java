package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zznf implements zzna {
    private final zzna[] a;
    private final ArrayList<zzna> b;
    private zznd d;
    private zzhz e;
    private Object f;
    private zznh h;
    private final zzie c = new zzie();
    private int g = -1;

    public zznf(zzna... zznaVarArr) {
        this.a = zznaVarArr;
        this.b = new ArrayList<>(Arrays.asList(zznaVarArr));
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a(zzhd zzhdVar, boolean z, zznd zzndVar) {
        this.d = zzndVar;
        for (int i = 0; i < this.a.length; i++) {
            this.a[i].a(zzhdVar, false, new bav(this, i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a() throws IOException {
        if (this.h != null) {
            throw this.h;
        }
        for (zzna zznaVar : this.a) {
            zznaVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zzmy a(int i, zzol zzolVar) {
        zzmy[] zzmyVarArr = new zzmy[this.a.length];
        for (int i2 = 0; i2 < zzmyVarArr.length; i2++) {
            zzmyVarArr[i2] = this.a[i2].a(i, zzolVar);
        }
        return new bau(zzmyVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a(zzmy zzmyVar) {
        bau bauVar = (bau) zzmyVar;
        for (int i = 0; i < this.a.length; i++) {
            this.a[i].a(bauVar.a[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void b() {
        for (zzna zznaVar : this.a) {
            zznaVar.b();
        }
    }

    public final void a(int i, zzhz zzhzVar, Object obj) {
        zznh zznhVar;
        if (this.h == null) {
            int b = zzhzVar.b();
            for (int i2 = 0; i2 < b; i2++) {
                zzhzVar.a(i2, this.c, false);
            }
            if (this.g == -1) {
                this.g = zzhzVar.c();
            } else if (zzhzVar.c() != this.g) {
                zznhVar = new zznh(1);
                this.h = zznhVar;
            }
            zznhVar = null;
            this.h = zznhVar;
        }
        if (this.h != null) {
            return;
        }
        this.b.remove(this.a[i]);
        if (i == 0) {
            this.e = zzhzVar;
            this.f = obj;
        }
        if (this.b.isEmpty()) {
            this.d.a(this.e, this.f);
        }
    }
}
