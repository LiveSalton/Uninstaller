package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class t extends zzx.a {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ zzx.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    t(zzx.b bVar, Activity activity) {
        super(zzx.this);
        this.d = bVar;
        this.c = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = zzx.this.r;
        zzmVar.a(ObjectWrapper.a(this.c), this.b);
    }
}
