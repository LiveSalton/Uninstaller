package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class zn extends zzapm {
    private zzcrb<zzapo, zzcst> a;

    /* JADX INFO: Access modifiers changed from: private */
    zn(zzcuv zzcuvVar, zzcrb<zzapo, zzcst> zzcrbVar) {
        this.a = zzcrbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final void a() throws RemoteException {
        this.a.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final void a(String str) throws RemoteException {
        this.a.c.a(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    public final void a(zzve zzveVar) throws RemoteException {
        this.a.c.a(zzveVar);
    }

    /* synthetic */ zn(zzcuv zzcuvVar, zzcrb zzcrbVar, zo zoVar) {
        this(zzcuvVar, zzcrbVar);
    }
}
