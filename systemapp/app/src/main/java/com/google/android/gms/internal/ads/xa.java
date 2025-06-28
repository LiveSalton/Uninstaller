package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
final class xa implements zzdyo<ParcelFileDescriptor> {
    private final /* synthetic */ zzatf a;

    xa(zzcou zzcouVar, zzatf zzatfVar) {
        this.a = zzatfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        try {
            this.a.a(com.google.android.gms.ads.internal.util.zzap.a(th));
        } catch (RemoteException e) {
            zzd.a("Service can't call client", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            this.a.a(parcelFileDescriptor);
        } catch (RemoteException e) {
            zzd.a("Service can't call client", e);
        }
    }
}
