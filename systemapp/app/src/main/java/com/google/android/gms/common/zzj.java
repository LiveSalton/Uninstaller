package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

/* compiled from: source */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();

    @SafeParcelable.Field
    private final String a;

    @Nullable
    @SafeParcelable.Field
    private final b b;

    @SafeParcelable.Field
    private final boolean c;

    @SafeParcelable.Field
    private final boolean d;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param String str, @SafeParcelable.Param @Nullable IBinder iBinder, @SafeParcelable.Param boolean z, @SafeParcelable.Param boolean z2) {
        this.a = str;
        this.b = a(iBinder);
        this.c = z;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.a, false);
        if (this.b == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = this.b.asBinder();
        }
        SafeParcelWriter.a(parcel, 2, asBinder, false);
        SafeParcelWriter.a(parcel, 3, this.c);
        SafeParcelWriter.a(parcel, 4, this.d);
        SafeParcelWriter.a(parcel, a);
    }

    @Nullable
    private static b a(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper a = zzn.a(iBinder).a();
            byte[] bArr = a == null ? null : (byte[]) ObjectWrapper.a(a);
            if (bArr != null) {
                return new d(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }
}
