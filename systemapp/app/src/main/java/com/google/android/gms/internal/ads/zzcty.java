package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcty implements zzcrh<zzcbt, zzapo, zzcst> {
    private final Context a;
    private final zzcat b;
    private zzaob c;

    public zzcty(Context context, zzcat zzcatVar) {
        this.a = context;
        this.b = zzcatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr {
        try {
            zzcrbVar.b.a(zzdmuVar.U);
            zzcrbVar.b.a(zzdmuVar.O, zzdmuVar.u.toString(), zzdnjVar.a.a.d, ObjectWrapper.a(this.a), new zj(this, zzcrbVar), zzcrbVar.c);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzcbt b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        if (!zzdnjVar.a.a.g.contains(Integer.toString(6))) {
            throw new zzcuq(zzdok.INVALID_REQUEST, "Unified must be used for RTB.");
        }
        zzcce a = zzcce.a(this.c);
        if (!zzdnjVar.a.a.g.contains(Integer.toString(a.a()))) {
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzccf a2 = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzccq(a), new zzceb(null, null, this.c));
        zzcrbVar.c.a((zzano) a2.g());
        return a2.h();
    }
}
