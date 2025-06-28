package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class ym extends zzapf {
    private zzcrb<zzapo, zzcst> a;
    private final /* synthetic */ zzcsf b;

    /* JADX INFO: Access modifiers changed from: private */
    ym(zzcsf zzcsfVar, zzcrb<zzapo, zzcst> zzcrbVar) {
        this.b = zzcsfVar;
        this.a = zzcrbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.b.c = (View) ObjectWrapper.a(iObjectWrapper);
        this.a.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(String str) throws RemoteException {
        this.a.c.a(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(zzve zzveVar) throws RemoteException {
        this.a.c.a(zzveVar);
    }

    /* synthetic */ ym(zzcsf zzcsfVar, zzcrb zzcrbVar, yk ykVar) {
        this(zzcsfVar, zzcrbVar);
    }
}
