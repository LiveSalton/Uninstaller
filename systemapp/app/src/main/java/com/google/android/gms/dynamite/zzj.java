package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzj extends zzb implements zzk {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        s.writeInt(i);
        Parcel a = a(2, s);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        zzd.a(s, z);
        Parcel a = a(3, s);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper b(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        s.writeInt(i);
        Parcel a = a(4, s);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int b(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel s = s();
        zzd.a(s, iObjectWrapper);
        s.writeString(str);
        zzd.a(s, z);
        Parcel a = a(5, s);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final int a() throws RemoteException {
        Parcel a = a(6, s());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
