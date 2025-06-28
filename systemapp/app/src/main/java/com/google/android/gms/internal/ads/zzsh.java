package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsh extends zzst {
    private final FullScreenContentCallback a;

    public zzsh(FullScreenContentCallback fullScreenContentCallback) {
        this.a = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void a() throws RemoteException {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void b() throws RemoteException {
        this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void a(zzve zzveVar) throws RemoteException {
        this.a.a(zzveVar.a());
    }
}
