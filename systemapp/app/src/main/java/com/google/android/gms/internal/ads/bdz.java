package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class bdz extends beh<zzaqw> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzani b;

    bdz(zzvx zzvxVar, Context context, zzani zzaniVar) {
        this.a = context;
        this.b = zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.beh
    protected final /* bridge */ /* synthetic */ zzaqw a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.beh
    /* renamed from: c */
    public final zzaqw b() {
        try {
            return ((zzarb) zzazd.a(this.a, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", beb.a)).a(ObjectWrapper.a(this.a), this.b, 203404000);
        } catch (RemoteException | zzazf | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.beh
    public final /* synthetic */ zzaqw a(zzxp zzxpVar) throws RemoteException {
        return zzxpVar.c(ObjectWrapper.a(this.a), this.b, 203404000);
    }
}
