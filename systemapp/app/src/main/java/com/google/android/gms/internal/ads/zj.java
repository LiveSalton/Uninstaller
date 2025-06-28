package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class zj extends zzapl {
    private zzcrb<zzapo, zzcst> a;
    private final /* synthetic */ zzcty b;

    /* JADX INFO: Access modifiers changed from: private */
    zj(zzcty zzctyVar, zzcrb<zzapo, zzcst> zzcrbVar) {
        this.b = zzctyVar;
        this.a = zzcrbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(zzaob zzaobVar) throws RemoteException {
        this.b.c = zzaobVar;
        this.a.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(String str) throws RemoteException {
        this.a.c.a(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapi
    public final void a(zzve zzveVar) throws RemoteException {
        this.a.c.a(zzveVar);
    }

    /* synthetic */ zj(zzcty zzctyVar, zzcrb zzcrbVar, zi ziVar) {
        this(zzctyVar, zzcrbVar);
    }
}
