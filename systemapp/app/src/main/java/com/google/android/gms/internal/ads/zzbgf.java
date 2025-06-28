package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzbgf extends IInterface {
    int a(String str) throws RemoteException;

    String a() throws RemoteException;

    List a(String str, String str2) throws RemoteException;

    Map a(String str, String str2, boolean z) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    void a(String str, String str2, Bundle bundle) throws RemoteException;

    void a(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException;

    Bundle b(Bundle bundle) throws RemoteException;

    String b() throws RemoteException;

    void b(String str) throws RemoteException;

    void b(String str, String str2, Bundle bundle) throws RemoteException;

    long c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void c(String str) throws RemoteException;

    String d() throws RemoteException;

    String e() throws RemoteException;

    String f() throws RemoteException;
}
