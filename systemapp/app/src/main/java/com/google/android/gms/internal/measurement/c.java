package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class c extends zzx.a {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ zzx f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(zzx zzxVar, Activity activity, String str, String str2) {
        super(zzxVar);
        this.f = zzxVar;
        this.c = activity;
        this.d = str;
        this.e = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f.r;
        zzmVar.a(ObjectWrapper.a(this.c), this.d, this.e, this.a);
    }
}
