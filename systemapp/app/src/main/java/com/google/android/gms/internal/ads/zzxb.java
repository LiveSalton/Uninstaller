package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxb extends zzgu implements zzwz {
    zzxb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final zzwy a() throws RemoteException {
        zzwy zzxaVar;
        Parcel a = a(1, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxaVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzwy) {
                zzxaVar = (zzwy) queryLocalInterface;
            } else {
                zzxaVar = new zzxa(readStrongBinder);
            }
        }
        a.recycle();
        return zzxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzwt zzwtVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzwtVar);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafj zzafjVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafjVar);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafk zzafkVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafkVar);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(String str, zzafq zzafqVar, zzafp zzafpVar) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, zzafqVar);
        zzgv.a(y, zzafpVar);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzadz zzadzVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzadzVar);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzxu zzxuVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzxuVar);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafx zzafxVar, zzvn zzvnVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafxVar);
        zzgv.a(y, zzvnVar);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, publisherAdViewOptions);
        b(9, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzafy zzafyVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafyVar);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzajl zzajlVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzajlVar);
        b(13, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void a(zzajt zzajtVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzajtVar);
        b(14, y);
    }
}
