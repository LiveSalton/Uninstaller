package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class mj implements zzdyo<Void> {
    private final /* synthetic */ zzboz a;

    mj(zzboz zzbozVar) {
        this.a = zzbozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzbwd zzbwdVar;
        zzbwdVar = this.a.g;
        zzbwdVar.b(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(@NullableDecl Void r2) {
        zzbwd zzbwdVar;
        zzbwdVar = this.a.g;
        zzbwdVar.b(true);
    }
}
