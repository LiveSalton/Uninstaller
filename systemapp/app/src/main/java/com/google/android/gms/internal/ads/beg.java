package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class beg extends beh<zzaen> {
    private final /* synthetic */ FrameLayout a;
    private final /* synthetic */ FrameLayout b;
    private final /* synthetic */ Context c;
    private final /* synthetic */ zzvx d;

    beg(zzvx zzvxVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.d = zzvxVar;
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* synthetic */ zzaen a() {
        zzvx.b(this.c, "native_ad_view_delegate");
        return new zzzw();
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzaen b() throws RemoteException {
        zzagn zzagnVar;
        zzagnVar = this.d.d;
        return zzagnVar.a(this.c, this.a, this.b);
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzaen a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.a(ObjectWrapper.a(this.a), ObjectWrapper.a(this.b));
    }
}
