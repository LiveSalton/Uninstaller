package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzor implements zzol {
    private final boolean a;
    private final int b;
    private final byte[] c;
    private final zzoi[] d;
    private int e;
    private int f;
    private int g;
    private zzoi[] h;

    public zzor(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzor(boolean z, int i, int i2) {
        zzpc.a(true);
        zzpc.a(true);
        this.a = true;
        this.b = 65536;
        this.g = 0;
        this.h = new zzoi[100];
        this.c = null;
        this.d = new zzoi[1];
    }

    public final synchronized void d() {
        if (this.a) {
            a(0);
        }
    }

    public final synchronized void a(int i) {
        boolean z = i < this.e;
        this.e = i;
        if (z) {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized zzoi a() {
        zzoi zzoiVar;
        this.f++;
        if (this.g > 0) {
            zzoi[] zzoiVarArr = this.h;
            int i = this.g - 1;
            this.g = i;
            zzoiVar = zzoiVarArr[i];
            this.h[this.g] = null;
        } else {
            zzoiVar = new zzoi(new byte[this.b], 0);
        }
        return zzoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void a(zzoi zzoiVar) {
        this.d[0] = zzoiVar;
        a(this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void a(zzoi[] zzoiVarArr) {
        boolean z;
        if (this.g + zzoiVarArr.length >= this.h.length) {
            this.h = (zzoi[]) Arrays.copyOf(this.h, Math.max(this.h.length << 1, this.g + zzoiVarArr.length));
        }
        for (zzoi zzoiVar : zzoiVarArr) {
            if (zzoiVar.a != null && zzoiVar.a.length != this.b) {
                z = false;
                zzpc.a(z);
                zzoi[] zzoiVarArr2 = this.h;
                int i = this.g;
                this.g = i + 1;
                zzoiVarArr2[i] = zzoiVar;
            }
            z = true;
            zzpc.a(z);
            zzoi[] zzoiVarArr22 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            zzoiVarArr22[i2] = zzoiVar;
        }
        this.f -= zzoiVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void b() {
        int max = Math.max(0, zzpt.a(this.e, this.b) - this.f);
        if (max >= this.g) {
            return;
        }
        Arrays.fill(this.h, max, this.g, (Object) null);
        this.g = max;
    }

    public final synchronized int e() {
        return this.f * this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final int c() {
        return this.b;
    }
}
