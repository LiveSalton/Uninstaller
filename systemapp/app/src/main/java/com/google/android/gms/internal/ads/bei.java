package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bei extends beh<zzaui> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzani b;
    private final /* synthetic */ zzvx c;

    bei(zzvx zzvxVar, Context context, zzani zzaniVar) {
        this.c = zzvxVar;
        this.a = context;
        this.b = zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzaui a() {
        zzvx.b(this.a, "rewarded_video");
        return new zzaaa();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzaui b() throws RemoteException {
        zzaut zzautVar;
        zzautVar = this.c.e;
        return zzautVar.a(this.a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzaui a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a), this.b, 203404000);
    }
}
