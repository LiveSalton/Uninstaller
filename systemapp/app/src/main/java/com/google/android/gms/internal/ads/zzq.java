package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzq implements zzan {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public zzq() {
        this(2500, 1, 1.0f);
    }

    private zzq(int i, int i2, float f) {
        this.a = 2500;
        this.c = 1;
        this.d = 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzan
    public final void a(zzao zzaoVar) throws zzao {
        this.b++;
        this.a += (int) (this.a * this.d);
        if (!(this.b <= this.c)) {
            throw zzaoVar;
        }
    }
}
