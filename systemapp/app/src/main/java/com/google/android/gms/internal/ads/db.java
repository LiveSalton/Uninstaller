package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.a;

/* compiled from: source */
/* loaded from: classes.dex */
final class db implements Runnable {
    private final /* synthetic */ a.EnumC0056a a;
    private final /* synthetic */ zzaop b;

    db(zzaop zzaopVar, a.EnumC0056a enumC0056a) {
        this.b = zzaopVar;
        this.a = enumC0056a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzano zzanoVar;
        try {
            zzanoVar = this.b.a;
            zzanoVar.a(zzapb.a(this.a));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }
}
