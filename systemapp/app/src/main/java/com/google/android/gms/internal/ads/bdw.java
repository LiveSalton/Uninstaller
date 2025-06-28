package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bdw extends beh<zzavh> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzani c;
    private final /* synthetic */ zzvx d;

    bdw(zzvx zzvxVar, Context context, String str, zzani zzaniVar) {
        this.d = zzvxVar;
        this.a = context;
        this.b = str;
        this.c = zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzavh a() {
        zzvx.b(this.a, "rewarded");
        return new zzzy();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzavh b() throws RemoteException {
        return zzavx.a(this.a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzavh a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.b(ObjectWrapper.a(this.a), this.b, this.c, 203404000);
    }
}
