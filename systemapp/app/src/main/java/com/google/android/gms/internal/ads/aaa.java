package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
final class aaa extends zzauz {
    private final /* synthetic */ zzbtr a;
    private final /* synthetic */ zzbrt b;
    private final /* synthetic */ zzbsu c;
    private final /* synthetic */ zzbyi d;

    aaa(zzcvo zzcvoVar, zzbtr zzbtrVar, zzbrt zzbrtVar, zzbsu zzbsuVar, zzbyi zzbyiVar) {
        this.a = zzbtrVar;
        this.b = zzbrtVar;
        this.c = zzbsuVar;
        this.d = zzbyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void b(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void b(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void c(IObjectWrapper iObjectWrapper) {
        this.a.e_();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void e(IObjectWrapper iObjectWrapper) {
        this.a.a(com.google.android.gms.ads.internal.overlay.zzl.OTHER);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void f(IObjectWrapper iObjectWrapper) {
        this.b.e();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void g(IObjectWrapper iObjectWrapper) {
        this.c.b();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void a(IObjectWrapper iObjectWrapper, zzava zzavaVar) {
        this.d.a(zzavaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void d(IObjectWrapper iObjectWrapper) {
        this.d.a();
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final void h(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.c.e();
    }
}
