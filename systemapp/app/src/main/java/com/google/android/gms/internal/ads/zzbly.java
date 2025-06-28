package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbly extends zzsj {
    private final zzblv a;
    private final zzxg b;
    private final zzdir c;

    public zzbly(zzblv zzblvVar, zzxg zzxgVar, zzdir zzdirVar) {
        this.a = zzblvVar;
        this.b = zzxgVar;
        this.c = zzdirVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void a(zzsm zzsmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzxg a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void a(IObjectWrapper iObjectWrapper, zzsq zzsqVar) {
        try {
            this.c.a(zzsqVar);
            this.a.a((Activity) ObjectWrapper.a(iObjectWrapper), zzsqVar);
        } catch (RemoteException e) {
            zzd.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzyn b() {
        if (((Boolean) zzwq.e().a(zzabf.dT)).booleanValue()) {
            return this.a.k();
        }
        return null;
    }
}
