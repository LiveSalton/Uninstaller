package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: source */
/* loaded from: classes.dex */
final class m extends zzx.a {
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ zzx h;
    private final /* synthetic */ int c = 5;
    private final /* synthetic */ Object f = null;
    private final /* synthetic */ Object g = null;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(zzx zzxVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.h = zzxVar;
        this.d = str;
        this.e = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.h.r;
        zzmVar.a(this.c, this.d, ObjectWrapper.a(this.e), ObjectWrapper.a(this.f), ObjectWrapper.a(this.g));
    }
}
