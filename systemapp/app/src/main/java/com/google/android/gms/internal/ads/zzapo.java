package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzapo extends IInterface {
    zzaqc a() throws RemoteException;

    void a(IObjectWrapper iObjectWrapper) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapt zzaptVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapc zzapcVar, zzano zzanoVar, zzvn zzvnVar) throws RemoteException;

    void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzaph zzaphVar, zzano zzanoVar) throws RemoteException;

    void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapi zzapiVar, zzano zzanoVar) throws RemoteException;

    void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException;

    void a(String[] strArr, Bundle[] bundleArr) throws RemoteException;

    zzaqc b() throws RemoteException;

    void b(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException;

    boolean b(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzys c() throws RemoteException;

    boolean c(IObjectWrapper iObjectWrapper) throws RemoteException;
}
