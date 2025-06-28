package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class da extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Bundle e;
    private final /* synthetic */ zzx f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    da(zzx zzxVar, String str, String str2, Bundle bundle) {
        super(zzxVar);
        this.f = zzxVar;
        this.c = str;
        this.d = str2;
        this.e = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f.r;
        zzmVar.a(this.c, this.d, this.e);
    }
}
