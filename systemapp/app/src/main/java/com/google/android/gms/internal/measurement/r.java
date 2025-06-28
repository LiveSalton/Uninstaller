package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class r extends zzx.a {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ zzx.b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r(zzx.b bVar, Activity activity, Bundle bundle) {
        super(zzx.this);
        this.e = bVar;
        this.c = activity;
        this.d = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = zzx.this.r;
        zzmVar.a(ObjectWrapper.a(this.c), this.d, this.b);
    }
}
