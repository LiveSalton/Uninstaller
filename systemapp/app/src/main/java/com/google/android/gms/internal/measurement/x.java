package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class x extends zzx.a {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ zzk d;
    private final /* synthetic */ zzx.b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x(zzx.b bVar, Activity activity, zzk zzkVar) {
        super(zzx.this);
        this.e = bVar;
        this.c = activity;
        this.d = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = zzx.this.r;
        zzmVar.a(ObjectWrapper.a(this.c), this.d, this.b);
    }
}
