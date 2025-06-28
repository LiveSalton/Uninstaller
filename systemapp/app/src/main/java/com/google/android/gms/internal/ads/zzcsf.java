package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsf implements zzcrh<zzbme, zzapo, zzcst> {
    private final Context a;
    private final zzbna b;
    private View c;

    public zzcsf(Context context, zzbna zzbnaVar) {
        this.a = context;
        this.b = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr {
        try {
            zzcrbVar.b.a(zzdmuVar.U);
            zzcrbVar.b.a(zzdmuVar.O, zzdmuVar.u.toString(), zzdnjVar.a.a.d, ObjectWrapper.a(this.a), new ym(this, zzcrbVar), zzcrbVar.c, zzdnjVar.a.a.e);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbme b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzapo, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        zzbmd a = this.b.a(new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a), new zzbmh(this.c, null, new zzbnz(zzcrbVar) { // from class: com.google.android.gms.internal.ads.yl
            private final zzcrb a;

            {
                this.a = zzcrbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbnz
            public final zzys a() {
                return zzcsf.a(this.a);
            }
        }, zzdmuVar.t.get(0)));
        a.j().a(this.c);
        zzcrbVar.c.a((zzano) a.g());
        return a.h();
    }

    static final /* synthetic */ zzys a(zzcrb zzcrbVar) throws zzdnr {
        try {
            return ((zzapo) zzcrbVar.b).c();
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }
}
