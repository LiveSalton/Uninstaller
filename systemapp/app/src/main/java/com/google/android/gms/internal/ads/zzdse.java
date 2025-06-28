package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzdse extends IInterface {
    IObjectWrapper a(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException;

    IObjectWrapper a(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException;

    String a() throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    boolean a(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper b(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException;

    void b(IObjectWrapper iObjectWrapper) throws RemoteException;

    void b(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    void c(IObjectWrapper iObjectWrapper) throws RemoteException;
}
