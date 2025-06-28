package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bee extends beh<zzxw> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzvx b;

    bee(zzvx zzvxVar, Context context) {
        this.b = zzvxVar;
        this.a = context;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzxw a() {
        zzvx.b(this.a, "mobile_ads_settings");
        return new zzzu();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxw b() throws RemoteException {
        zzzp zzzpVar;
        zzzpVar = this.b.c;
        return zzzpVar.b(this.a);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxw a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a), 203404000);
    }
}
