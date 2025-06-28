package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcha implements zzaij {
    private final zzbsu a;
    private final zzava b;
    private final String c;
    private final String d;

    public zzcha(zzbsu zzbsuVar, zzdmu zzdmuVar) {
        this.a = zzbsuVar;
        this.b = zzdmuVar.l;
        this.c = zzdmuVar.j;
        this.d = zzdmuVar.k;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void a() {
        this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    @ParametersAreNonnullByDefault
    public final void a(zzava zzavaVar) {
        int i;
        String str = "";
        if (this.b != null) {
            zzavaVar = this.b;
        }
        if (zzavaVar != null) {
            str = zzavaVar.a;
            i = zzavaVar.b;
        } else {
            i = 1;
        }
        this.a.a(new zzaud(str, i), this.c, this.d);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void b() {
        this.a.e();
    }
}
