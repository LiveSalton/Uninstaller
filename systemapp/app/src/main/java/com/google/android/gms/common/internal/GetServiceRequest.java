package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: source */
@KeepForSdk
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();

    @SafeParcelable.Field
    String a;

    @SafeParcelable.Field
    IBinder b;

    @SafeParcelable.Field
    Scope[] c;

    @SafeParcelable.Field
    Bundle d;

    @SafeParcelable.Field
    Account e;

    @SafeParcelable.Field
    Feature[] f;

    @SafeParcelable.Field
    Feature[] g;

    @SafeParcelable.VersionField
    private final int h;

    @SafeParcelable.Field
    private final int i;

    @SafeParcelable.Field
    private int j;

    @SafeParcelable.Field
    private boolean k;

    @SafeParcelable.Field
    private int l;

    public GetServiceRequest(int i) {
        this.h = 4;
        this.j = GoogleApiAvailabilityLight.a;
        this.i = i;
        this.k = true;
    }

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param int i, @SafeParcelable.Param int i2, @SafeParcelable.Param int i3, @SafeParcelable.Param String str, @SafeParcelable.Param IBinder iBinder, @SafeParcelable.Param Scope[] scopeArr, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param Account account, @SafeParcelable.Param Feature[] featureArr, @SafeParcelable.Param Feature[] featureArr2, @SafeParcelable.Param boolean z, @SafeParcelable.Param int i4) {
        this.h = i;
        this.i = i2;
        this.j = i3;
        if ("com.google.android.gms".equals(str)) {
            this.a = "com.google.android.gms";
        } else {
            this.a = str;
        }
        if (i < 2) {
            this.e = iBinder != null ? AccountAccessor.a(IAccountAccessor.Stub.a(iBinder)) : null;
        } else {
            this.b = iBinder;
            this.e = account;
        }
        this.c = scopeArr;
        this.d = bundle;
        this.f = featureArr;
        this.g = featureArr2;
        this.k = z;
        this.l = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.h);
        SafeParcelWriter.a(parcel, 2, this.i);
        SafeParcelWriter.a(parcel, 3, this.j);
        SafeParcelWriter.a(parcel, 4, this.a, false);
        SafeParcelWriter.a(parcel, 5, this.b, false);
        SafeParcelWriter.a(parcel, 6, (Parcelable[]) this.c, i, false);
        SafeParcelWriter.a(parcel, 7, this.d, false);
        SafeParcelWriter.a(parcel, 8, (Parcelable) this.e, i, false);
        SafeParcelWriter.a(parcel, 10, (Parcelable[]) this.f, i, false);
        SafeParcelWriter.a(parcel, 11, (Parcelable[]) this.g, i, false);
        SafeParcelWriter.a(parcel, 12, this.k);
        SafeParcelWriter.a(parcel, 13, this.l);
        SafeParcelWriter.a(parcel, a);
    }
}
