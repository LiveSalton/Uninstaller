package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bea extends beh<zzxg> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzvn b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzani d;
    private final /* synthetic */ zzvx e;

    bea(zzvx zzvxVar, Context context, zzvn zzvnVar, String str, zzani zzaniVar) {
        this.e = zzvxVar;
        this.a = context;
        this.b = zzvnVar;
        this.c = str;
        this.d = zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg a() {
        zzvx.b(this.a, "app_open");
        return new zzzs();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg b() throws RemoteException {
        zzvi zzviVar;
        zzviVar = this.e.a;
        return zzviVar.a(this.a, this.b, this.c, this.d, 4);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.c(ObjectWrapper.a(this.a), this.b, this.c, this.d, 203404000);
    }
}
