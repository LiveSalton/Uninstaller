package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class o extends zzx.a {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ boolean f;
    private final /* synthetic */ zzx g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    o(zzx zzxVar, String str, String str2, Object obj, boolean z) {
        super(zzxVar);
        this.g = zzxVar;
        this.c = str;
        this.d = str2;
        this.e = obj;
        this.f = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.g.r;
        zzmVar.a(this.c, this.d, ObjectWrapper.a(this.e), this.f, this.a);
    }
}
