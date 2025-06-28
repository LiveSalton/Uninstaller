package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzcuz extends zzcwb {
    private zzbyi a;

    public zzcuz(zzbrt zzbrtVar, zzbsl zzbslVar, zzbsu zzbsuVar, zzbte zzbteVar, zzbsb zzbsbVar, zzbvy zzbvyVar, zzbyn zzbynVar, zzbtr zzbtrVar, zzbyi zzbyiVar, zzbvv zzbvvVar) {
        super(zzbrtVar, zzbslVar, zzbsuVar, zzbteVar, zzbvyVar, zzbtrVar, zzbynVar, zzbvvVar, zzbsbVar);
        this.a = zzbyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwb, com.google.android.gms.internal.ads.zzano
    public final void h() {
        this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzcwb, com.google.android.gms.internal.ads.zzano
    public final void j() throws RemoteException {
        this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzcwb, com.google.android.gms.internal.ads.zzano
    public final void a(zzavc zzavcVar) throws RemoteException {
        super.a(zzavcVar);
        this.a.a(new zzava(zzavcVar.a(), zzavcVar.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzcwb, com.google.android.gms.internal.ads.zzano
    public final void a(zzava zzavaVar) {
        super.a(zzavaVar);
        this.a.a(zzavaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb, com.google.android.gms.internal.ads.zzano
    public final void g() {
        this.a.b();
    }
}
