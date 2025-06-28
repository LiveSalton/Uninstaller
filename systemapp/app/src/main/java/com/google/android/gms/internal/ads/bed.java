package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bed extends beh<zzxg> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzvn b;
    private final /* synthetic */ String c;
    private final /* synthetic */ zzvx d;

    bed(zzvx zzvxVar, Context context, zzvn zzvnVar, String str) {
        this.d = zzvxVar;
        this.a = context;
        this.b = zzvnVar;
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg a() {
        zzvx.b(this.a, "search");
        return new zzzs();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg b() throws RemoteException {
        zzvi zzviVar;
        zzviVar = this.d.a;
        return zzviVar.a(this.a, this.b, this.c, null, 3);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzxg a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a), this.b, this.c, 203404000);
    }
}
