package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzl extends zzb implements zzm {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        s.writeInt(i);
        zzd.a(s, iObjectWrapper2);
        Parcel a = a(2, s);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.dynamite.zzm
    public final IObjectWrapper b(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        s.writeInt(i);
        zzd.a(s, iObjectWrapper2);
        Parcel a = a(3, s);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
