package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class q extends zzx.a {
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ zzx d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(zzx zzxVar, Bundle bundle) {
        super(zzxVar);
        this.d = zzxVar;
        this.c = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.d.r;
        zzmVar.a(this.c, this.a);
    }
}
