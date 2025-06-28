package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    /* compiled from: source */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        /* compiled from: source */
        public static class zza extends zzb implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper a() throws RemoteException {
                Parcel a = a(2, s());
                IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final Bundle b() throws RemoteException {
                Parcel a = a(3, s());
                Bundle bundle = (Bundle) zzd.a(a, Bundle.CREATOR);
                a.recycle();
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int c() throws RemoteException {
                Parcel a = a(4, s());
                int readInt = a.readInt();
                a.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper d() throws RemoteException {
                Parcel a = a(5, s());
                IFragmentWrapper a2 = Stub.a(a.readStrongBinder());
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper e() throws RemoteException {
                Parcel a = a(6, s());
                IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean f() throws RemoteException {
                Parcel a = a(7, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final String g() throws RemoteException {
                Parcel a = a(8, s());
                String readString = a.readString();
                a.recycle();
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper h() throws RemoteException {
                Parcel a = a(9, s());
                IFragmentWrapper a2 = Stub.a(a.readStrongBinder());
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int i() throws RemoteException {
                Parcel a = a(10, s());
                int readInt = a.readInt();
                a.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean j() throws RemoteException {
                Parcel a = a(11, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper k() throws RemoteException {
                Parcel a = a(12, s());
                IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean l() throws RemoteException {
                Parcel a = a(13, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean m() throws RemoteException {
                Parcel a = a(14, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean n() throws RemoteException {
                Parcel a = a(15, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean o() throws RemoteException {
                Parcel a = a(16, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean p() throws RemoteException {
                Parcel a = a(17, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean q() throws RemoteException {
                Parcel a = a(18, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean r() throws RemoteException {
                Parcel a = a(19, s());
                boolean a2 = zzd.a(a);
                a.recycle();
                return a2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel s = s();
                zzd.a(s, iObjectWrapper);
                b(20, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void a(boolean z) throws RemoteException {
                Parcel s = s();
                zzd.a(s, z);
                b(21, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void b(boolean z) throws RemoteException {
                Parcel s = s();
                zzd.a(s, z);
                b(22, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void c(boolean z) throws RemoteException {
                Parcel s = s();
                zzd.a(s, z);
                b(23, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void d(boolean z) throws RemoteException {
                Parcel s = s();
                zzd.a(s, z);
                b(24, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void a(Intent intent) throws RemoteException {
                Parcel s = s();
                zzd.a(s, intent);
                b(25, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void a(Intent intent, int i) throws RemoteException {
                Parcel s = s();
                zzd.a(s, intent);
                s.writeInt(i);
                b(26, s);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel s = s();
                zzd.a(s, iObjectWrapper);
                b(27, s);
            }
        }

        public static IFragmentWrapper a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof IFragmentWrapper) {
                return (IFragmentWrapper) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper a = a();
                    parcel2.writeNoException();
                    zzd.a(parcel2, a);
                    return true;
                case 3:
                    Bundle b = b();
                    parcel2.writeNoException();
                    zzd.b(parcel2, b);
                    return true;
                case 4:
                    int c = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c);
                    return true;
                case 5:
                    IFragmentWrapper d = d();
                    parcel2.writeNoException();
                    zzd.a(parcel2, d);
                    return true;
                case 6:
                    IObjectWrapper e = e();
                    parcel2.writeNoException();
                    zzd.a(parcel2, e);
                    return true;
                case 7:
                    boolean f = f();
                    parcel2.writeNoException();
                    zzd.a(parcel2, f);
                    return true;
                case 8:
                    String g = g();
                    parcel2.writeNoException();
                    parcel2.writeString(g);
                    return true;
                case 9:
                    IFragmentWrapper h = h();
                    parcel2.writeNoException();
                    zzd.a(parcel2, h);
                    return true;
                case 10:
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    boolean j = j();
                    parcel2.writeNoException();
                    zzd.a(parcel2, j);
                    return true;
                case 12:
                    IObjectWrapper k = k();
                    parcel2.writeNoException();
                    zzd.a(parcel2, k);
                    return true;
                case 13:
                    boolean l = l();
                    parcel2.writeNoException();
                    zzd.a(parcel2, l);
                    return true;
                case 14:
                    boolean m = m();
                    parcel2.writeNoException();
                    zzd.a(parcel2, m);
                    return true;
                case 15:
                    boolean n = n();
                    parcel2.writeNoException();
                    zzd.a(parcel2, n);
                    return true;
                case 16:
                    boolean o = o();
                    parcel2.writeNoException();
                    zzd.a(parcel2, o);
                    return true;
                case 17:
                    boolean p = p();
                    parcel2.writeNoException();
                    zzd.a(parcel2, p);
                    return true;
                case 18:
                    boolean q = q();
                    parcel2.writeNoException();
                    zzd.a(parcel2, q);
                    return true;
                case 19:
                    boolean r = r();
                    parcel2.writeNoException();
                    zzd.a(parcel2, r);
                    return true;
                case 20:
                    a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    a(zzd.a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    b(zzd.a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    c(zzd.a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    d(zzd.a(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    a((Intent) zzd.a(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    a((Intent) zzd.a(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    IObjectWrapper a() throws RemoteException;

    void a(Intent intent) throws RemoteException;

    void a(Intent intent, int i) throws RemoteException;

    void a(IObjectWrapper iObjectWrapper) throws RemoteException;

    void a(boolean z) throws RemoteException;

    Bundle b() throws RemoteException;

    void b(IObjectWrapper iObjectWrapper) throws RemoteException;

    void b(boolean z) throws RemoteException;

    int c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    IFragmentWrapper d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    IObjectWrapper e() throws RemoteException;

    boolean f() throws RemoteException;

    String g() throws RemoteException;

    IFragmentWrapper h() throws RemoteException;

    int i() throws RemoteException;

    boolean j() throws RemoteException;

    IObjectWrapper k() throws RemoteException;

    boolean l() throws RemoteException;

    boolean m() throws RemoteException;

    boolean n() throws RemoteException;

    boolean o() throws RemoteException;

    boolean p() throws RemoteException;

    boolean q() throws RemoteException;

    boolean r() throws RemoteException;
}
