package com.google.android.gms.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzk extends IInterface {
    int a() throws RemoteException;

    int a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;

    int b(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException;

    IObjectWrapper b(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException;
}
