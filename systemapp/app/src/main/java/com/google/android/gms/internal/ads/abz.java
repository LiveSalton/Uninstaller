package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class abz implements zzdyo<zzczx> {
    private final /* synthetic */ zzaxp a;
    private final /* synthetic */ zzcyx b;

    abz(zzcyx zzcyxVar, zzaxp zzaxpVar) {
        this.b = zzcyxVar;
        this.a = zzaxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        try {
            zzaxp zzaxpVar = this.a;
            String valueOf = String.valueOf(th.getMessage());
            zzaxpVar.a(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzczx zzczxVar) {
        zzazh zzazhVar;
        zzczx zzczxVar2 = zzczxVar;
        try {
            if (((Boolean) zzwq.e().a(zzabf.dX)).booleanValue()) {
                zzazhVar = this.b.h;
                if (zzazhVar.c >= ((Integer) zzwq.e().a(zzabf.dZ)).intValue()) {
                    if (zzczxVar2 == null) {
                        this.a.a(null, null, null);
                        return;
                    } else {
                        this.a.a(zzczxVar2.a, zzczxVar2.b, zzczxVar2.c);
                        return;
                    }
                }
            }
            if (zzczxVar2 == null) {
                this.a.a(null, null);
            } else {
                this.a.a(zzczxVar2.a, zzczxVar2.b);
            }
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }
}
