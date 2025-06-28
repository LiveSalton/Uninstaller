package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgy extends VideoController.VideoLifecycleCallbacks {
    private final zzcce a;

    public zzcgy(zzcce zzcceVar) {
        this.a = zzcceVar;
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void a() {
        zzyt a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.a();
        } catch (RemoteException e) {
            zzd.d("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void c() {
        zzyt a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.c();
        } catch (RemoteException e) {
            zzd.d("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void d() {
        zzyt a = a(this.a);
        if (a == null) {
            return;
        }
        try {
            a.d();
        } catch (RemoteException e) {
            zzd.d("Unable to call onVideoEnd()", e);
        }
    }

    private static zzyt a(zzcce zzcceVar) {
        zzys b = zzcceVar.b();
        if (b == null) {
            return null;
        }
        try {
            return b.h();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
