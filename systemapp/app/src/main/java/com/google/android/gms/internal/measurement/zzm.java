package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzm extends IInterface {
    void a(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(Bundle bundle, long j) throws RemoteException;

    void a(Bundle bundle, zzn zznVar, long j) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, zzn zznVar, long j) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, zzv zzvVar, long j) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException;

    void a(zzn zznVar) throws RemoteException;

    void a(zzn zznVar, int i) throws RemoteException;

    void a(zzs zzsVar) throws RemoteException;

    void a(zzt zztVar) throws RemoteException;

    void a(String str, long j) throws RemoteException;

    void a(String str, zzn zznVar) throws RemoteException;

    void a(String str, String str2, Bundle bundle) throws RemoteException;

    void a(String str, String str2, Bundle bundle, zzn zznVar, long j) throws RemoteException;

    void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException;

    void a(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException;

    void a(String str, String str2, zzn zznVar) throws RemoteException;

    void a(String str, String str2, boolean z, zzn zznVar) throws RemoteException;

    void a(Map map) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(boolean z, long j) throws RemoteException;

    void b(long j) throws RemoteException;

    void b(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void b(zzn zznVar) throws RemoteException;

    void b(zzs zzsVar) throws RemoteException;

    void b(String str, long j) throws RemoteException;

    void c(long j) throws RemoteException;

    void c(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void c(zzn zznVar) throws RemoteException;

    void c(zzs zzsVar) throws RemoteException;

    void c(String str, long j) throws RemoteException;

    void d(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void d(zzn zznVar) throws RemoteException;

    void e(IObjectWrapper iObjectWrapper, long j) throws RemoteException;

    void e(zzn zznVar) throws RemoteException;

    void f(zzn zznVar) throws RemoteException;

    void g(zzn zznVar) throws RemoteException;
}
