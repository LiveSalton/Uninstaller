package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class e extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ zzx d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(zzx zzxVar, String str) {
        super(zzxVar);
        this.d = zzxVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.d.r;
        zzmVar.c(this.c, this.b);
    }
}
