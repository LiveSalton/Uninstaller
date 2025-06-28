package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxj extends zzwx {
    private final zzcyh a;

    public zzcxj(Context context, zzbgm zzbgmVar, zzdnp zzdnpVar, zzccl zzcclVar, zzwt zzwtVar) {
        zzcyj zzcyjVar = new zzcyj(zzcclVar);
        zzcyjVar.a(zzwtVar);
        this.a = new zzcyh(new zzcyp(zzbgmVar, context, zzcyjVar, zzdnpVar), zzdnpVar.c());
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final synchronized boolean a() throws RemoteException {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final void a(zzvk zzvkVar) throws RemoteException {
        this.a.a(zzvkVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final synchronized void a(zzvk zzvkVar, int i) throws RemoteException {
        this.a.a(zzvkVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final synchronized String b() {
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final synchronized String c() {
        return this.a.c();
    }
}
