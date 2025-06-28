package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzmw implements zzna, zznd {
    private final Uri a;
    private final zzom b;
    private final zzkb c;
    private final int d;
    private final Handler e;
    private final zzmz f;
    private final int i;
    private zznd j;
    private zzhz k;
    private boolean l;
    private final String h = null;
    private final zzib g = new zzib();

    public zzmw(Uri uri, zzom zzomVar, zzkb zzkbVar, int i, Handler handler, zzmz zzmzVar, String str, int i2) {
        this.a = uri;
        this.b = zzomVar;
        this.c = zzkbVar;
        this.d = i;
        this.e = handler;
        this.f = zzmzVar;
        this.i = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a(zzhd zzhdVar, boolean z, zznd zzndVar) {
        this.j = zzndVar;
        this.k = new zzno(-9223372036854775807L, false);
        zzndVar.a(this.k, null);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zzmy a(int i, zzol zzolVar) {
        zzpc.a(i == 0);
        return new bam(this.a, this.b.a(), this.c.a(), this.d, this.e, this.f, this, zzolVar, null, this.i);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void a(zzmy zzmyVar) {
        ((bam) zzmyVar).b();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void b() {
        this.j = null;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final void a(zzhz zzhzVar, Object obj) {
        boolean z = zzhzVar.a(0, this.g, false).b != -9223372036854775807L;
        if (!this.l || z) {
            this.k = zzhzVar;
            this.l = z;
            this.j.a(this.k, null);
        }
    }
}
