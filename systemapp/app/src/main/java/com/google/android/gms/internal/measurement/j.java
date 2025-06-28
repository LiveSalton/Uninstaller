package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class j extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzk f;
    private final /* synthetic */ zzx g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(zzx zzxVar, String str, String str2, boolean z, zzk zzkVar) {
        super(zzxVar);
        this.g = zzxVar;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.g.r;
        zzmVar.a(this.c, this.d, this.e, this.f);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f.a((Bundle) null);
    }
}
