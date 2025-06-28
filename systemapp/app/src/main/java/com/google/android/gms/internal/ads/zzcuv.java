package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcuv implements zzcrh<zzchc, zzapo, zzcst> {
    private final Context a;
    private final zzchf b;

    public zzcuv(Context context, zzchf zzchfVar) {
        this.a = context;
        this.b = zzchfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr {
        try {
            zzcrbVar.b.a(zzdmuVar.U);
            if (zzdnjVar.a.a.n.a == zzdnf.c) {
                zzcrbVar.b.b(zzdmuVar.O, zzdmuVar.u.toString(), zzdnjVar.a.a.d, ObjectWrapper.a(this.a), new zn(this, zzcrbVar), zzcrbVar.c);
            } else {
                zzcrbVar.b.a(zzdmuVar.O, zzdmuVar.u.toString(), zzdnjVar.a.a.d, ObjectWrapper.a(this.a), new zn(this, zzcrbVar), zzcrbVar.c);
            }
        } catch (RemoteException e) {
            zzd.a("Remote exception loading a rewarded RTB ad", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzchc b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        yz yzVar = new yz(zzdmuVar, zzcrbVar.b, true);
        zzche a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzchd(yzVar));
        yzVar.a(a.d());
        zzcrbVar.c.a((zzano) a.n());
        return a.h();
    }
}
