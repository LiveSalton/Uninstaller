package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcth implements zzcrh<zzbyx, zzapo, zzcst> {
    private final Context a;
    private final zzbzx b;

    public zzcth(Context context, zzbzx zzbzxVar) {
        this.a = context;
        this.b = zzbzxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr {
        try {
            zzcrbVar.b.a(zzdmuVar.U);
            zzcrbVar.b.a(zzdmuVar.O, zzdmuVar.u.toString(), zzdnjVar.a.a.d, ObjectWrapper.a(this.a), new zb(this, zzcrbVar), zzcrbVar.c);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbyx b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        yz yzVar = new yz(zzdmuVar, zzcrbVar.b, false);
        zzbyz a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzbzc(yzVar));
        yzVar.a(a.d());
        zzcrbVar.c.a((zzano) a.g());
        return a.h();
    }
}
