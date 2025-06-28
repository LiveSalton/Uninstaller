package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaxs extends zzgu implements zzaxq {
    zzaxs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(IObjectWrapper iObjectWrapper, zzaxw zzaxwVar, zzaxp zzaxpVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaxwVar);
        zzgv.a(y, zzaxpVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        Parcel a = a(3, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final IObjectWrapper b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(4, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) throws RemoteException {
        Parcel y = y();
        y.writeTypedList(list);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzasaVar);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void b(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) throws RemoteException {
        Parcel y = y();
        y.writeTypedList(list);
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzasaVar);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void a(zzasl zzaslVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaslVar);
        b(7, y);
    }
}
