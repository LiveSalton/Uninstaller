package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class p extends zzx.a {
    private final /* synthetic */ Long c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ boolean h;
    private final /* synthetic */ zzx i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p(zzx zzxVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzxVar);
        this.i = zzxVar;
        this.c = l;
        this.d = str;
        this.e = str2;
        this.f = bundle;
        this.g = z;
        this.h = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        long longValue = this.c == null ? this.a : this.c.longValue();
        zzmVar = this.i.r;
        zzmVar.a(this.d, this.e, this.f, this.g, this.h, longValue);
    }
}
