package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzata extends zzgu implements zzasy {
    zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final zzasu a(zzass zzassVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzassVar);
        Parcel a = a(1, y);
        zzasu zzasuVar = (zzasu) zzgv.a(a, zzasu.CREATOR);
        a.recycle();
        return zzasuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(zzass zzassVar, zzatd zzatdVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzassVar);
        zzgv.a(y, zzatdVar);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(zzatl zzatlVar, zzatf zzatfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzatlVar);
        zzgv.a(y, zzatfVar);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void b(zzatl zzatlVar, zzatf zzatfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzatlVar);
        zzgv.a(y, zzatfVar);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void c(zzatl zzatlVar, zzatf zzatfVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzatlVar);
        zzgv.a(y, zzatfVar);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void a(String str, zzatf zzatfVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, zzatfVar);
        b(7, y);
    }
}
