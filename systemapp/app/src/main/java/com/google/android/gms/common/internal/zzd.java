package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzd implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a)) {
                case 1:
                    i = SafeParcelReader.d(parcel, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.d(parcel, a);
                    break;
                case 3:
                    i3 = SafeParcelReader.d(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.g(parcel, a);
                    break;
                case 5:
                    iBinder = SafeParcelReader.h(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.i(parcel, a);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel, a, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.b(parcel, a);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.b(parcel, a, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.c(parcel, a);
                    break;
                case 13:
                    i4 = SafeParcelReader.d(parcel, a);
                    break;
            }
        }
        SafeParcelReader.n(parcel, b);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4);
    }
}
