package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbr extends zzaeh {
    private final zzcce a;
    private IObjectWrapper b;

    public zzcbr(zzcce zzcceVar) {
        this.a = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float a() throws RemoteException {
        if (!((Boolean) zzwq.e().a(zzabf.dv)).booleanValue()) {
            return 0.0f;
        }
        if (this.a.z() != 0.0f) {
            return this.a.z();
        }
        if (this.a.b() != null) {
            return g();
        }
        if (this.b != null) {
            return b(this.b);
        }
        zzaej g = this.a.g();
        if (g == null) {
            return 0.0f;
        }
        float d = (g == null || g.d() == -1 || g.e() == -1) ? 0.0f : g.d() / g.e();
        return d != 0.0f ? d : b(g.a());
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float c() throws RemoteException {
        if (((Boolean) zzwq.e().a(zzabf.dw)).booleanValue() && this.a.b() != null) {
            return this.a.b().f();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float d() throws RemoteException {
        if (((Boolean) zzwq.e().a(zzabf.dw)).booleanValue() && this.a.b() != null) {
            return this.a.b().g();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final zzys e() throws RemoteException {
        if (((Boolean) zzwq.e().a(zzabf.dw)).booleanValue()) {
            return this.a.b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final boolean f() throws RemoteException {
        return ((Boolean) zzwq.e().a(zzabf.dw)).booleanValue() && this.a.b() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final void a(zzafv zzafvVar) {
        if (((Boolean) zzwq.e().a(zzabf.dw)).booleanValue() && (this.a.b() instanceof zzbep)) {
            ((zzbep) this.a.b()).a(zzafvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final void a(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwq.e().a(zzabf.bF)).booleanValue()) {
            this.b = iObjectWrapper;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final IObjectWrapper b() throws RemoteException {
        if (this.b != null) {
            return this.b;
        }
        zzaej g = this.a.g();
        if (g == null) {
            return null;
        }
        return g.a();
    }

    private final float g() {
        try {
            return this.a.b().i();
        } catch (RemoteException e) {
            zzd.c("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float b(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.a(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }
}
