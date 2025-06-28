package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyd implements zzva {

    @GuardedBy("this")
    private zzws a;

    public final synchronized void a(zzws zzwsVar) {
        this.a = zzwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzva
    public final synchronized void e() {
        if (this.a != null) {
            try {
                this.a.a();
            } catch (RemoteException e) {
                zzd.d("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
