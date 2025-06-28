package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzo extends zza implements zzm {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(IObjectWrapper iObjectWrapper, zzv zzvVar, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        zzb.a(a, zzvVar);
        a.writeLong(j);
        b(1, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, bundle);
        zzb.a(a, z);
        zzb.a(a, z2);
        a.writeLong(j);
        b(2, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, Bundle bundle, zzn zznVar, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, bundle);
        zzb.a(a, zznVar);
        a.writeLong(j);
        b(3, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, iObjectWrapper);
        zzb.a(a, z);
        a.writeLong(j);
        b(4, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, z);
        zzb.a(a, zznVar);
        b(5, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, zzn zznVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        zzb.a(a, zznVar);
        b(6, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeLong(j);
        b(7, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(Bundle bundle, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, bundle);
        a.writeLong(j);
        b(8, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, bundle);
        b(9, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, zznVar);
        b(10, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(boolean z, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, z);
        a.writeLong(j);
        b(11, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(long j) throws RemoteException {
        Parcel a = a();
        a.writeLong(j);
        b(12, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void b(long j) throws RemoteException {
        Parcel a = a();
        a.writeLong(j);
        b(13, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void c(long j) throws RemoteException {
        Parcel a = a();
        a.writeLong(j);
        b(14, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeString(str);
        a.writeString(str2);
        a.writeLong(j);
        b(15, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(16, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void b(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(17, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(zzt zztVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zztVar);
        b(18, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void c(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(19, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void d(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(20, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void e(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(21, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void f(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(22, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void b(String str, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeLong(j);
        b(23, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void c(String str, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeLong(j);
        b(24, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeLong(j);
        b(25, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void b(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeLong(j);
        b(26, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        zzb.a(a, bundle);
        a.writeLong(j);
        b(27, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void c(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeLong(j);
        b(28, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void d(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeLong(j);
        b(29, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void e(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        a.writeLong(j);
        b(30, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(IObjectWrapper iObjectWrapper, zzn zznVar, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, iObjectWrapper);
        zzb.a(a, zznVar);
        a.writeLong(j);
        b(31, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(Bundle bundle, zzn zznVar, long j) throws RemoteException {
        Parcel a = a();
        zzb.a(a, bundle);
        zzb.a(a, zznVar);
        a.writeLong(j);
        b(32, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a = a();
        a.writeInt(i);
        a.writeString(str);
        zzb.a(a, iObjectWrapper);
        zzb.a(a, iObjectWrapper2);
        zzb.a(a, iObjectWrapper3);
        b(33, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(zzs zzsVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zzsVar);
        b(34, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void b(zzs zzsVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zzsVar);
        b(35, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void c(zzs zzsVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zzsVar);
        b(36, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(Map map) throws RemoteException {
        Parcel a = a();
        a.writeMap(map);
        b(37, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(zzn zznVar, int i) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        a.writeInt(i);
        b(38, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void a(boolean z) throws RemoteException {
        Parcel a = a();
        zzb.a(a, z);
        b(39, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void g(zzn zznVar) throws RemoteException {
        Parcel a = a();
        zzb.a(a, zznVar);
        b(40, a);
    }
}
