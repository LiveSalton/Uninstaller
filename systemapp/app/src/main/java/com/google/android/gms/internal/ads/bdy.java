package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bdy extends beh<zzarj> {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ zzvx b;

    bdy(zzvx zzvxVar, Activity activity) {
        this.b = zzvxVar;
        this.a = activity;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzarj a() {
        zzvx.b(this.a, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzarj b() throws RemoteException {
        zzarh zzarhVar;
        zzarhVar = this.b.g;
        return zzarhVar.a(this.a);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzarj a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a));
    }
}
