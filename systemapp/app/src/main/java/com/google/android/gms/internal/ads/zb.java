package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class zb extends zzapg {
    private zzcrb<zzapo, zzcst> a;

    /* JADX INFO: Access modifiers changed from: private */
    zb(zzcth zzcthVar, zzcrb<zzapo, zzcst> zzcrbVar) {
        this.a = zzcrbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a() throws RemoteException {
        this.a.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a(String str) throws RemoteException {
        this.a.c.a(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a(zzve zzveVar) throws RemoteException {
        this.a.c.a(zzveVar);
    }

    /* synthetic */ zb(zzcth zzcthVar, zzcrb zzcrbVar, zc zcVar) {
        this(zzcthVar, zzcrbVar);
    }
}
