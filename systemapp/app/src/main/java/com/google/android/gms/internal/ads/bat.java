package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class bat implements zznn {
    private final int a;
    private final /* synthetic */ bam b;

    public bat(bam bamVar, int i) {
        this.b = bamVar;
        this.a = i;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean a() {
        return this.b.a(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void b() throws IOException {
        this.b.h();
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final int a(zzhr zzhrVar, zzjl zzjlVar, boolean z) {
        return this.b.a(this.a, zzhrVar, zzjlVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void a(long j) {
        this.b.a(this.a, j);
    }
}
