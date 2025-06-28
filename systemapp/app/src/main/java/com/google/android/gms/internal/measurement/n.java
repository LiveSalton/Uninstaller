package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class n extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ zzk d;
    private final /* synthetic */ zzx e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(zzx zzxVar, String str, zzk zzkVar) {
        super(zzxVar);
        this.e = zzxVar;
        this.c = str;
        this.d = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.e.r;
        zzmVar.a(this.c, this.d);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.d.a((Bundle) null);
    }
}
