package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bef extends beh<zzwz> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzani c;
    private final /* synthetic */ zzvx d;

    bef(zzvx zzvxVar, Context context, String str, zzani zzaniVar) {
        this.d = zzvxVar;
        this.a = context;
        this.b = str;
        this.c = zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzwz a() {
        zzvx.b(this.a, "native_ad");
        return new zzzo();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzwz b() throws RemoteException {
        zzvf zzvfVar;
        zzvfVar = this.d.b;
        return zzvfVar.a(this.a, this.b, this.c);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzwz a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a), this.b, this.c, 203404000);
    }
}
