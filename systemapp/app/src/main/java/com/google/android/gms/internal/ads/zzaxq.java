package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzaxq extends IInterface {
    IObjectWrapper a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, zzaxw zzaxwVar, zzaxp zzaxpVar) throws RemoteException;

    void a(zzasl zzaslVar) throws RemoteException;

    void a(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) throws RemoteException;

    IObjectWrapper b(IObjectWrapper iObjectWrapper) throws RemoteException;

    void b(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasaVar) throws RemoteException;
}
