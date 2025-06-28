package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class i extends zzx.a {
    private final /* synthetic */ zzk c;
    private final /* synthetic */ zzx d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    i(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.d = zzxVar;
        this.c = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.d.r;
        zzmVar.f(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.c.a((Bundle) null);
    }
}
